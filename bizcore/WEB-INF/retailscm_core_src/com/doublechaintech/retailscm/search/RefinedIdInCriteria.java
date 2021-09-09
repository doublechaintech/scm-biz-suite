package com.doublechaintech.retailscm.search;

import com.doublechaintech.retailscm.BaseEntity;
import com.terapico.utils.TextUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class RefinedIdInCriteria<T extends BaseEntity> implements SearchCriteria {
    private BaseRequest<T> mDependsOn;
    private String mProperty;
    private IDRefine<T> mIdRefine;

    public RefinedIdInCriteria(BaseRequest<T> pDependsOn, String pProperty, IDRefine<T> pIdRefine) {
        mDependsOn = pDependsOn;
        mProperty = pProperty;
        mIdRefine = pIdRefine;
    }

    @Override
    public String prepareParameterAndSql(Map<String, Object> parameters) {
        List<T> results = Searcher.search(parameters.get("userContext"), mDependsOn);
        Set<String> refineIds = mIdRefine.refineId(results);
        String columnName = TextUtil.propertyToColumnName(mProperty);
        String parameterName = refineParameterName(parameters, mProperty);
        if (refineIds == null || refineIds.isEmpty()) {
            return "false";
        } else if (refineIds.size() == 1) {
            parameters.put(parameterName, refineIds.iterator().next());
            return String.format("(%s = :%s)", columnName, parameterName);
        } else {
            parameters.put(parameterName, refineIds);
            return String.format("(%s in (:%s))", columnName, parameterName);
        }
    }
}

