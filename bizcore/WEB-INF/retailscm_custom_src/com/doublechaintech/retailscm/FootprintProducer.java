package com.doublechaintech.retailscm;

public interface FootprintProducer {

    boolean canReplaceFootPrint(Footprint fp, Footprint item);

    boolean clearTop();

    String getBeanName();
}

