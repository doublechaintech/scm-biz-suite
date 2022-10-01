package com.doublechaintech.retailscm.expression;

public interface Expression<E, T> {
  T eval(E e);

  default E $getRoot() {
    return null;
  }

  default T eval() {
    return eval($getRoot());
  }

  default boolean isNull() {
    return null == eval();
  }

  default boolean isNotNull() {
    return null != eval();
  }

  default boolean isEmpty() {
    return cn.hutool.core.util.ObjectUtil.isEmpty(eval());
  }

  default boolean isNotEmpty() {
    return !cn.hutool.core.util.ObjectUtil.isEmpty(eval());
  }
}
