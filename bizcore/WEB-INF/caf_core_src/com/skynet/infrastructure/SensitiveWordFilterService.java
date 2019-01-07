package com.skynet.infrastructure;

import com.terapico.utils.TextUtil;

import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.InitializingBean;

import java.util.*;

/**
 * 敏感词过滤服务
 */
public class SensitiveWordFilterService implements InitializingBean {

    static class FilterSet {

        private final long[] elements;


        public FilterSet() {
            elements = new long[1 + (65535 >>> 6)];
        }

        public void add(final int no) {
            elements[no >>> 6] |= (1L << (no & 63));
        }

        public void add(final int... no) {
            for (int currNo : no)
                elements[currNo >>> 6] |= (1L << (currNo & 63));
        }

        public void remove(final int no) {
            elements[no >>> 6] &= ~(1L << (no & 63));
        }

        /**
         * @param no
         * @return true:添加成功	false:原已包含
         */
        public boolean addAndNotify(final int no) {
            int eWordNum = no >>> 6;
            long oldElements = elements[eWordNum];
            elements[eWordNum] |= (1L << (no & 63));
            boolean result = elements[eWordNum] != oldElements;
//		if (result)
//			size++;
            return result;
        }

        /**
         * @param no
         * @return true:移除成功	false:原本就不包含
         */
        public boolean removeAndNotify(final int no) {
            int eWordNum = no >>> 6;
            long oldElements = elements[eWordNum];
            elements[eWordNum] &= ~(1L << (no & 63));
            boolean result = elements[eWordNum] != oldElements;
            return result;
        }

        public boolean contains(final int no) {
            return (elements[no >>> 6] & (1L << (no & 63))) != 0;
        }

        public boolean containsAll(final int... no) {
            if (no.length == 0)
                return true;
            for (int currNo : no)
                if ((elements[currNo >>> 6] & (1L << (currNo & 63))) == 0)
                    return false;
            return true;
        }

        /**
         * 不如直接循环调用contains
         *
         * @param no
         * @return
         */
        public boolean containsAll_ueslessWay(final int... no) {
            long[] elements = new long[this.elements.length];
            for (int currNo : no) {
                elements[currNo >>> 6] |= (1L << (currNo & 63));
            }//这一步执行完跟循环调用contains差不多了

            for (int i = 0; i < elements.length; i++)
                if ((elements[i] & ~this.elements[i]) != 0)
                    return false;
            return true;
        }

        /**
         * 目前没有去维护size，每次都是去计算size
         *
         * @return
         */
        public int size() {
            int size = 0;
            for (long element : elements)
                size += Long.bitCount(element);
            return size;
        }

    }

    private static final FilterSet set = new FilterSet(); // 存储首字
    private static final Map<Integer, WordNode> nodes = new HashMap<>(); // 存储节点
    private static final Set<Integer> stopwdSet = new HashSet<>(); // 停顿词
    private static final char SIGN = '*'; // 敏感词过滤替换
    private SensitiveWordsProvider sensitiveWordsProvider;
    private SensitiveWordsProvider stopWordsProvider;


    public void setSensitiveWordsProvider(SensitiveWordsProvider sensitiveWordsProvider) {
        this.sensitiveWordsProvider = sensitiveWordsProvider;
    }

    public void setStopWordsProvider(SensitiveWordsProvider stopWordsProvider) {
        this.stopWordsProvider = stopWordsProvider;
    }

    /**
     * 增加停顿词
     *
     * @param words
     */
    private void addStopWord(final List<String> words) {
        if (!isEmpty(words)) {
            char[] chs;
            for (String curr : words) {
                chs = curr.toCharArray();
                for (char c : chs) {
                    stopwdSet.add(charConvert(c));
                }
            }
        }
    }

    /**
     * 添加DFA节点
     *
     * @param words
     */
    private void addSensitiveWord(final List<String> words) {
        if (!isEmpty(words)) {
            char[] chs;
            int fchar;
            int lastIndex;
            WordNode fnode; // 首字母节点
            for (String curr : words) {
                if (curr == null || curr.isEmpty()) {
                    continue;
                }
                chs = curr.toCharArray();
                fchar = charConvert(chs[0]);
                if (!set.contains(fchar)) {// 没有首字定义
                    set.add(fchar);// 首字标志位 可重复add,反正判断了，不重复了
                    fnode = new WordNode(fchar, chs.length == 1);
                    nodes.put(fchar, fnode);
                } else {
                    fnode = nodes.get(fchar);
                    if (!fnode.isLast() && chs.length == 1)
                        fnode.setLast(true);
                }
                lastIndex = chs.length - 1;
                for (int i = 1; i < chs.length; i++) {
                    fnode = fnode.addIfNoExist(charConvert(chs[i]), i == lastIndex);
                }
            }
        }
    }

    /**
     * 过滤判断 将敏感词转化为成屏蔽词
     *
     * @param src
     * @return
     */
    public final String doFilter(final String inputSrc) {
        if (set != null && nodes != null && !TextUtil.isBlank(inputSrc)) {
        	String src = internalReplacement(inputSrc);
            char[] chs = src.toCharArray();
            int length = chs.length;
            int currc; // 当前检查的字符
            int cpcurrc; // 当前检查字符的备份
            int k;
            WordNode node;
            for (int i = 0; i < length; i++) {
                currc = charConvert(chs[i]);
                if (!set.contains(currc)) {
                    continue;
                }
                node = nodes.get(currc);// 日 2
                if (node == null)// 其实不会发生，习惯性写上了
                    continue;
                boolean couldMark = false;
                int markNum = -1;
                if (node.isLast()) {// 单字匹配（日）
                    couldMark = true;
                    markNum = 0;
                }
                // 继续匹配（日你/日你妹），以长的优先
                // 你-3 妹-4 夫-5
                k = i;
                cpcurrc = currc; // 当前字符的拷贝
                for (; ++k < length; ) {
                    int temp = charConvert(chs[k]);
                    if (temp == cpcurrc)
                        continue;
                    if (stopwdSet != null && stopwdSet.contains(temp))
                        continue;
                    node = node.querySub(temp);
                    if (node == null)// 没有了
                        break;
                    if (node.isLast()) {
                        couldMark = true;
                        markNum = k - i;// 3-2
                    }
                    cpcurrc = temp;
                }
                if (couldMark) {
                    for (k = 0; k <= markNum; k++) {
                        chs[k + i] = SIGN;
                    }
                    i = i + markNum;
                }
            }
            return new String(chs);
        }

        return inputSrc;
    }

    private String internalReplacement(String src) {
		if (TextUtil.isBlank(src)) {
			return "";
		}
		
		// 以下为例子
		return src.replaceAll("傻逼", "笨笨").replaceAll("傻B", "笨笨")
				.replaceAll("傻缺", "笨笨").replaceAll("煞笔", "笨笨")
				.replaceAll("煞逼", "笨笨").replaceAll("傻笔", "笨笨")
				.replaceAll("傻x", "笨笨").replaceAll("傻\\*", "笨笨");
	}

	/**
     * 是否包含敏感词
     *
     * @param src
     * @return
     */
    public final boolean isContains(final String src) {
        if (set != null && nodes != null) {
            char[] chs = src.toCharArray();
            int length = chs.length;
            int currc; // 当前检查的字符
            int cpcurrc; // 当前检查字符的备份
            int k;
            WordNode node;
            for (int i = 0; i < length; i++) {
                currc = charConvert(chs[i]);
                if (!set.contains(currc)) {
                    continue;
                }
                node = nodes.get(currc);// 日 2
                if (node == null)// 其实不会发生，习惯性写上了
                    continue;
                boolean couldMark = false;
                if (node.isLast()) {// 单字匹配（日）
                    couldMark = true;
                }
                // 继续匹配（日你/日你妹），以长的优先
                // 你-3 妹-4 夫-5
                k = i;
                cpcurrc = currc;
                for (; ++k < length; ) {
                    int temp = charConvert(chs[k]);
                    if (temp == cpcurrc)
                        continue;
                    if (stopwdSet != null && stopwdSet.contains(temp))
                        continue;
                    node = node.querySub(temp);
                    if (node == null)// 没有了
                        break;
                    if (node.isLast()) {
                        couldMark = true;
                    }
                    cpcurrc = temp;
                }
                if (couldMark) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 大写转化为小写 全角转化为半角
     *
     * @param src
     * @return
     */
    private int charConvert(char src) {
        int r = TextUtil.qj2bj(src);
        return (r >= 'A' && r <= 'Z') ? r + 32 : r;
    }

    /**
     * 判断一个集合是否为空
     *
     * @param col
     * @return
     */
    public static <T> boolean isEmpty(final Collection<T> col) {
        if (col == null || col.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        addSensitiveWord(sensitiveWordsProvider.provide());
        addStopWord(stopWordsProvider.provide());
    }

    private class WordNode {


        private int value; // 节点名称

        private List<WordNode> subNodes; // 子节点

        private boolean isLast;// 默认false

        public WordNode(int value) {
            this.value = value;
        }

        public WordNode(int value, boolean isLast) {
            this.value = value;
            this.isLast = isLast;
        }

        /**
         * @param subNode
         * @return 就是传入的subNode
         */
        private WordNode addSubNode(final WordNode subNode) {
            if (subNodes == null)
                subNodes = new LinkedList<WordNode>();
            subNodes.add(subNode);
            return subNode;
        }

        /**
         * 有就直接返回该子节点， 没有就创建添加并返回该子节点
         *
         * @param value
         * @return
         */
        public WordNode addIfNoExist(final int value, final boolean isLast) {
            if (subNodes == null) {
                return addSubNode(new WordNode(value, isLast));
            }
            for (WordNode subNode : subNodes) {
                if (subNode.value == value) {
                    if (!subNode.isLast && isLast)
                        subNode.isLast = true;
                    return subNode;
                }
            }
            return addSubNode(new WordNode(value, isLast));
        }

        public WordNode querySub(final int value) {
            if (subNodes == null) {
                return null;
            }
            for (WordNode subNode : subNodes) {
                if (subNode.value == value)
                    return subNode;
            }
            return null;
        }

        public boolean isLast() {
            return isLast;
        }

        public void setLast(boolean isLast) {
            this.isLast = isLast;
        }

        @Override
        public int hashCode() {
            return value;
        }
    }
}
