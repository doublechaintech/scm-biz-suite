package com.terapico.utils;

import com.terapico.caf.BlobObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageUtil {
    protected static Map<String, List<String>> SAMPLE_ROOM = new HashMap<>();
    protected static String DEFAULT_AVANTAR = "https://doublechain.oss-cn-hangzhou.aliyuncs.com/chainqa/avatar.png";

    static {
        SAMPLE_ROOM.put("animal_small", Arrays.asList(

        ));
        SAMPLE_ROOM.put("girl_small", Arrays.asList(

        ));
        SAMPLE_ROOM.put("boy_small", Arrays.asList(

        ));
        SAMPLE_ROOM.put("plant_small", Arrays.asList(

        ));
        SAMPLE_ROOM.put("scenery_small", Arrays.asList(

        ));
    }

    public static String animal() {
        return getImageFromSampleRoom("animal");
    }

    public static String boy() {
        return getImageFromSampleRoom("boy");
    }

    public static String girl() {
        return getImageFromSampleRoom("girl");
    }

    public static String plant() {
        return getImageFromSampleRoom("plant");
    }

    public static String scenery() {
        return getImageFromSampleRoom("scenery");
    }

    protected static String getImageFromSampleRoom(String style) {
        return getImageFromSampleRoom(style, "small");
    }

    protected static String getImageFromSampleRoom(String style, String size) {
        List<String> list = SAMPLE_ROOM.get(style + "_" + size);
        if (list == null || list.isEmpty()) {
            return DEFAULT_AVANTAR;
        }

        return list.get(RandomUtil.getRandomInRange(0, list.size()));
    }

    private static boolean isBMP(byte[] buf) {
        byte[] markBuf = "BM".getBytes();  //BMP图片文件的前两个字节
        return compare(buf, markBuf);
    }

    private static boolean isICON(byte[] buf) {
        byte[] markBuf = {0, 0, 1, 0, 1, 0, 32, 32};
        return compare(buf, markBuf);
    }

    private static boolean isWEBP(byte[] buf) {
        byte[] markBuf = "RIFF".getBytes(); //WebP图片识别符
        return compare(buf, markBuf);
    }

    private static boolean isGIF(byte[] buf) {

        byte[] markBuf = "GIF89a".getBytes(); //GIF识别符
        if (compare(buf, markBuf)) {
            return true;
        }
        markBuf = "GIF87a".getBytes(); //GIF识别符
        if (compare(buf, markBuf)) {
            return true;
        }
        return false;
    }


    private static boolean isPNG(byte[] buf) {

        byte[] markBuf = {(byte) 0x89, 0x50, 0x4E, 0x47, 0x0D, 0x0A, 0x1A, 0x0A}; //PNG识别符
        // new String(buf).indexOf("PNG")>0 //也可以使用这种方式
        return compare(buf, markBuf);
    }

    private static boolean isJPEGHeader(byte[] buf) {
        byte[] markBuf = {(byte) 0xff, (byte) 0xd8}; //JPEG开始符

        return compare(buf, markBuf);
    }

    private static boolean isJPEGFooter(byte[] buf)//JPEG结束符
    {
        byte[] markBuf = {(byte) 0xff, (byte) 0xd9};
        return compare(buf, markBuf);
    }


    /**
     * 读取文件类型
     *
     * @param filename
     * @return
     * @throws IOException
     */
    public static String readType(byte[] fileBytes) throws IOException {


        byte[] bufHeaders = Arrays.copyOfRange(fileBytes, 0, 8);
        if (isJPEGHeader(bufHeaders)) {
            byte[] bufFooters = Arrays.copyOfRange(fileBytes, fileBytes.length - 2, fileBytes.length);
            if (isJPEGFooter(bufFooters)) {
                return BlobObject.TYPE_JPEG;
            }
        }
        if (isPNG(bufHeaders)) {
            return BlobObject.TYPE_PNG;
        }
        if (isGIF(bufHeaders)) {

            return BlobObject.TYPE_GIF;
        }
        if (isWEBP(bufHeaders)) {
            return BlobObject.TYPE_WEBP;
        }
        if (isBMP(bufHeaders)) {
            return BlobObject.TYPE_BMP;
        }
        if (isICON(bufHeaders)) {
            return BlobObject.TYPE_ICO;
        }
        return BlobObject.TYPE_PNG;


    }


    /**
     * 标示一致性比较
     *
     * @param buf     待检测标示
     * @param markBuf 标识符字节数组
     * @return 返回false标示标示不匹配
     */
    private static boolean compare(byte[] buf, byte[] markBuf) {
        for (int i = 0; i < markBuf.length; i++) {
            byte b = markBuf[i];
            byte a = buf[i];

            if (a != b) {
                return false;
            }
        }
        return true;
    }

	public static String getFileNameFromUrl(String imageUrl, String defaultValue) {
    	int pos1 = imageUrl.lastIndexOf('/')+1;
    	int pos2 = imageUrl.indexOf('?');
    	if (pos2 <= 0) {
    		pos2 = imageUrl.length();
		}else{
    	    pos2 = pos2-1;
        }
    	String name = imageUrl.substring(pos1, pos2);
    	if (TextUtil.isBlank(name)){
    	    return defaultValue;
        }
    	return name;
	}
}
