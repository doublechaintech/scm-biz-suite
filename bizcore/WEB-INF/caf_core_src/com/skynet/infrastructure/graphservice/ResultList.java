package com.skynet.infrastructure.graphservice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class ResultList<T> extends ArrayList<T> {
    private int total;

    public String getTimeConsume() {
        return timeConsume;
    }

    public void setTimeConsume(String pTimeConsume) {
        timeConsume = pTimeConsume;
    }

    private String timeConsume;


    public ResultList(int initialCapacity) {
        super(initialCapacity);
    }

    public ResultList() {
    }

    public ResultList(Collection<? extends T> c) {
        super(c);
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int pTotal) {
        total = pTotal;
    }

    @Override
    public boolean equals(Object pO) {
        if (this == pO) return true;
        if (!(pO instanceof ResultList)) return false;
        if (!super.equals(pO)) return false;
        ResultList<?> that = (ResultList<?>) pO;
        return getTotal() == that.getTotal();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTotal());
    }


    @Override
    public String toString() {
        return "ResultList{" +
                "total=" + total +
                "} " + super.toString();
    }
}
