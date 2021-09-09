package com.doublechaintech.retailscm.search;
import com.doublechaintech.retailscm.BaseEntity;

import java.util.List;
import java.util.Set;

public interface IDRefine<T extends BaseEntity> {
    Set<String> refineId(List<T> list);
}

