package com.terapico.caf.xls;

import java.io.Closeable;
import java.util.stream.Stream;

public interface BlockWriter extends Closeable {
    void write(Stream<Block> pBlockStream) throws Exception;

    void write(Block pBl);
}
