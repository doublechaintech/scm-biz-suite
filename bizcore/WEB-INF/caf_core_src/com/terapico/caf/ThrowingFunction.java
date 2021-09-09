package com.terapico.caf;

@FunctionalInterface
public interface ThrowingFunction<T,R,E extends Throwable> {
    R apply(T t) throws E;
}
