package com.skynet.infrastructure.graphservice;

import org.springframework.util.LinkedMultiValueMap;

import java.util.List;
import java.util.Map;

public interface Query {
    String getStartType();

    List<String> getStartIds();

    List<String> getRelations();

    String getFilter();

    Map<String, Object> getParameters();

    String getTargetType();

    List<String> getEnhancements();

    LinkedMultiValueMap getPaths();

    String getSort();

    int getStartNo();

    int getSize();
}
