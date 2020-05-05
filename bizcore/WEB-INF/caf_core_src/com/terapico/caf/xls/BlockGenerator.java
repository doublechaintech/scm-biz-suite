package com.terapico.caf.xls;

import com.terapico.uccaf.BaseUserContext;

import java.util.stream.Stream;

public interface BlockGenerator<T> {
    Stream<Block> toBlockStream(BaseUserContext pBaseUserContext,  T entity) throws Exception;

    Stream<Block> export(BaseUserContext pBaseUserContext,  String entityId) throws Exception;
}
