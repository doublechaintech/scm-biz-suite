package com.terapico.caf.xls;

import java.util.stream.Stream;

public abstract class AbstractBlockGenerator<T> implements BlockGenerator<T> {

    public BlockBuildContext appendProperty(Stream.Builder<Block> pBuilder, BlockBuildContext pContext, String propertyName, Object propertyValue) {
        pContext = append(pBuilder, pContext, propertyName);
        pContext = append(pBuilder, pContext, propertyValue);
        return pContext.newLine();
    }

    public BlockBuildContext appendValues(Stream.Builder<Block> pBuilder, BlockBuildContext pContext, Object... values) {
        if (values == null) {
            return pContext;
        }
        for (Object o : values) {
            pContext = append(pBuilder, pContext, o);
        }
        return pContext;
    }


    public BlockBuildContext append(Stream.Builder<Block> pBuilder, BlockBuildContext pContext, Object pValue) {
        pBuilder.add(pContext.toBlock(pValue));
        return pContext.next();
    }
}
