package com.doublechaintech.retailscm;

import cn.hutool.core.util.StrUtil;
import com.terapico.caf.DateTime;
import org.springframework.jdbc.core.namedparam.NamedParameterUtils;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class SQLLogger {
  protected static <T> String showResult(List<T> result) {
    if (result.isEmpty()) {
      return String.format("NO ROWS");
    }
    String className = result.get(0).getClass().getSimpleName();
    if (result.size() > 1) {
      return String.format("%d*%s", result.size(), className);
    }
    String body =
        result.stream()
            .map(
                t -> {
                  if (t instanceof BaseEntity) {
                    return ((BaseEntity) t).getId();
                  }
                  return t.toString();
                })
            .collect(Collectors.joining(","));
    return String.join("", className, "(", body, ")");
  }

  private static final char SINGLE_QUOTE = '\'';

  static class Counter {
    int count = 0;

    public void onChar(char ch) {
      if (ch == SINGLE_QUOTE) {
        count++;
      }
    }

    public boolean outOfQuote() {
      return count % 2 == 0;
    }
  }

  protected static Object[] flattenParameters(Object[] params) {
    List<Object> result = new ArrayList<>();

    Arrays.asList(params)
        .forEach(
            t -> {
              if (t instanceof Set) {
                Set setT = (Set) t;
                setT.forEach(
                    eV -> {
                      result.add(eV);
                    });
                return;
              }

              if (t.getClass().isArray()) {
                Object[] array = (Object[]) t;
                Arrays.asList(array)
                    .forEach(
                        eV -> {
                          result.add(eV);
                        });
                return;
              }

              result.add(t);
            });

    return result.toArray();
  }

  protected static String methodNameOf(StackTraceElement ste) {
    return join(ste.getFileName().replace(".java", ""), ".", ste.getMethodName() + "()");
  }

  protected static String getStackTrace() {
    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    List<StackTraceElement> stackList = Arrays.asList(stackTrace);
    Collections.reverse(stackList);
    return stackList.stream()
        .filter(st -> st.getClassName().contains(".doublechaintech."))
        .filter(st -> !st.getClassName().contains(SQLLogger.class.getSimpleName()))
        .map(st -> methodNameOf(st))
        .collect(Collectors.joining(" -> "));
  }

  public static <T> void logNamedSQL(String sql, Map<String, ?> paramMap, List<T> result) {
    String finalSQL = NamedParameterUtils.substituteNamedParameters(sql, null);
    logSQLAndParameters(
        finalSQL, NamedParameterUtils.buildValueArray(sql, paramMap), showResult(result));
  }

  public static void logSQLAndParameters(String sql, Object[] parameters, String result) {

    StringBuilder finalSQL = new StringBuilder();

    char[] sqlChars = sql.toCharArray();
    int index = 0;

    Counter counter = new Counter();

    for (char ch : sqlChars) {
      counter.onChar(ch);

      if (ch == '?' && counter.outOfQuote()) {
        finalSQL.append(wrapValueInSQL(parameters[index]));
        index++;
        continue;
      }
      finalSQL.append(ch);
    }
    String newMethod = getStackTrace();
    logDebug(timeExpr() + "\t" + alignWithTabSpace(result, 4) + finalSQL.toString() + ";\n");
  }

  public static void logDebug(String message) {
    System.out.println(message);
  }

  protected static String timeExpr() {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd'T'HH:mm:ss.SSS");
    // It is not thread safe, how silly the JDK is!!!
    return simpleDateFormat.format(new java.util.Date());
  }

  protected static String join(Object... objs) {
    StringBuilder internalPresentBuffer = new StringBuilder();

    for (Object o : objs) {
      if (o == null) {
        continue;
      }
      internalPresentBuffer.append(o);
    }

    return internalPresentBuffer.toString();
  }

  protected static String sqlTimeExpr(DateTime dateTimeValue) {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // It is not thread safe, how silly the JDK is!!!
    return simpleDateFormat.format(dateTimeValue);
  }

  protected static String wrapValueInSQL(Object value) {
    if (value == null) {
      return "NULL";
    }

    if (value.getClass().isArray()) {
      Object[] array = (Object[]) value;
      return Arrays.asList(array).stream()
          .limit(20)
          .map(v -> wrapValueInSQL(v))
          .collect(Collectors.joining(","));
    }

    if (value instanceof DateTime) {
      DateTime dateTimeValue = (DateTime) value;
      return join("'", sqlTimeExpr(dateTimeValue), "'");
    }
    if (value instanceof Date) {
      Date dateValue = (Date) value;
      return join("'", sqlDateExpr(dateValue), "'");
    }
    if (value instanceof Number) {
      return value.toString();
    }
    if (value instanceof Boolean) {
      return (Boolean) value ? "1" : "0";
    }
    if (value instanceof String) {
      String strValue = (String) value;
      String escapedValue = StrUtil.sub(strValue, 0, 100).replace("\'", "''");
      return join("'", escapedValue, "'");
    }
    if (value instanceof Set) {

      Set setValue = (Set) value;
      // setValue.
      // return setValue.stream().map(v->wrapValueInSQL(v)).collect(Collectors.joining(","));
      return (String)
          setValue.stream().limit(50).map(v -> wrapValueInSQL(v)).collect(Collectors.joining(","));
    }
    if (value instanceof List) {

      List setValue = (List) value;
      // setValue.
      // return setValue.stream().map(v->wrapValueInSQL(v)).collect(Collectors.joining(","));
      return (String)
          setValue.stream().limit(10).map(v -> wrapValueInSQL(v)).collect(Collectors.joining(","));
    }

    return join("'", value.getClass(), "'");
  }

  protected static String sqlDateExpr(Date dateValue) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    // It is not thread safe, how silly the JDK is!!!
    return simpleDateFormat.format(dateValue);
  }

  public static String alignWithTabSpace(String value, int tabWidth) {
    if (tabWidth <= 0) {
      return value;
    }
    int length = value.length();
    if (length >= tabWidth * 8) {
      // 超过了
      return value.substring(0, tabWidth * 8 - 2) + ".\t";
    }

    int count = tabWidth - (length / 8);

    return value + repeatTab(count);
  }

  protected static String repeatTab(int length) {
    if (length <= 0) {
      return "";
    }
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < length; i++) {

      stringBuilder.append('\t');
    }

    return stringBuilder.toString();
  }
}
