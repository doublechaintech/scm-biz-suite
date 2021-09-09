package com.terapico.caf;

@FunctionalInterface
public interface ThrowingBiFunction<T,R,U,E extends Throwable> {
    R apply(T t, U u);
}
