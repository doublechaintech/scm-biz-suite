package com.terapico.changerequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.appview.*;
import com.terapico.caf.form.ImageInfo;
import com.terapico.uccaf.CafEntity;
import com.terapico.utils.*;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public abstract class BaseChangeRequestHelper {
    public static final String STATUS_OPENING = "OPENING";
    public static final String STATUS_COMMITTED = "COMMITTED";
    public static final String STATUS_PRESET = "PRESET";

    protected static final Map<String, Object> EO = new HashMap<>();
    protected static final Pattern ptnCandidateQueryExpr = Pattern.compile("Query\\(([:,\\w]+)\\)");
    protected static Map<String, CRGroupSpec> groupSpecMap = new HashMap<>();
    protected static Map<String, CRFieldSpec> fieldSpecMap = new HashMap<>();
    protected Spec spec;

    protected static void error(String message) throws Exception {
        throw new Exception(message);
    }

    protected static void BUG(String message) {
        throw new RuntimeException(message);
    }

    public static CRSceneSpec SCENE(CRSpec crSpec, String sceneCode) {
        CRSceneSpec sceneSpec =
                crSpec.getSceneList().stream()
                        .filter(scene -> scene.getName().equals(sceneCode))
                        .findFirst()
                        .orElse(null);
        return sceneSpec;
    }

    public static List<CRGroupSpec> GROUPS(CRSpec crSpec, String sceneCode) throws Exception {
        CRSceneSpec sceneSpec = SCENE(crSpec, sceneCode);
        if (sceneSpec == null) {
            error("场景代码" + sceneCode + "未在 CR " + crSpec.getTitle() + "中定义");
        }
        return sceneSpec.getGroups();
    }

    public static String GROUP_NAME(CRFieldSpec fieldSpec) {
        String[] namePieces = fieldSpec.getName().split("_");
        if (namePieces.length != 3) {
            BUG("字段名" + fieldSpec.getName() + "不符合规范.");
        }
        return fieldSpec.getName().substring(0, fieldSpec.getName().lastIndexOf('_'));
    }

    public static String FIELD_NAME(CRFieldSpec fieldSpec) {
        String[] namePieces = fieldSpec.getName().split("_");
        if (namePieces.length != 3) {
            BUG("字段名" + fieldSpec.getName() + "不符合规范.");
        }
        return namePieces[2];
    }

    public Spec getSpec() {
        return spec;
    }

    protected void loadCrSpecFromJar(String fileName) throws Exception {
        InputStream fileStream = getClass().getResourceAsStream(fileName);
        spec = DebugUtil.getObjectMapper().readValue(fileStream, Spec.class);
        fileStream.close();
    }

    protected CRSpec CR(String crTypeName) {
        CRSpec crSpec = getSpec().getCrSpecs().get(crTypeName);
        return crSpec;
    }

    protected boolean isFieldInGroup(CRFieldSpec fieldSpec, CRGroupSpec groupSpec) {
        return GROUP_NAME(fieldSpec).equals(groupSpec.getName());
    }

    protected void updateFieldCandidateValueSelected(CRFieldData fieldData, CRFieldSpec fieldSpec) {
        if (fieldData.getCandidateValues() == null) {
            return;
        }
        if (fieldSpec.getSelectable().equals(CRFieldSpec.MULTI_SELECTABLE)) {
            if (fieldData.getValue() == null) {
                return;
            }
            markMultipleSelectedCandiateValues(fieldData, fieldSpec);
            return;
        }
        if (fieldData.getValue() == null) {
            List<Map<String, Object>> vals = (List<Map<String, Object>>) fieldData.getCandidateValues();
            if (vals.size() == 1) {
                fieldData.setValue(vals.get(0).get("value"));
                vals.get(0).put("selected", true);
            }
            return;
        }
        markSelectedCandiateValue(
                (List<Map<String, Object>>) fieldData.getCandidateValues(), fieldData.getValue());
    }

    /**
     * 对 多选 的字段, 将被选的value 和 候选值对应起来
     */
    protected void markMultipleSelectedCandiateValues(CRFieldData fieldData, CRFieldSpec fieldSpec) {
        Objects.requireNonNull(fieldData.getValue());
        Objects.requireNonNull(fieldData.getCandidateValues());
        List<String> values = DataTypeUtil.getStringList(fieldData.getValue());
        if (values == null || values.isEmpty()) {
            return;
        }
        List<Map<String, Object>> candidateValues =
                (List<Map<String, Object>>) fieldData.getCandidateValues();
        for (String value : values) {
            markSelectedCandiateValue(candidateValues, value);
        }
    }

    protected void markSelectedCandiateValue(
            List<Map<String, Object>> candidateValues, Object value) {
        if (value == null) {
            return;
        }
        String val = null;
        if (value instanceof Boolean) {
            val = ((Boolean) value).booleanValue() ? "true" : "false";
        } else {
            val = String.valueOf(value);
        }
        for (Map<String, Object> cv : candidateValues) {
            if (val.equals(cv.get("value"))) {
                cv.put("selected", true);
            }
        }
    }

    protected Object makeFieldCandidateValues(
            CRGroupData groupData, CRFieldData fieldData, CRFieldSpec fieldSpec) {
        if (!("query".equals(getFieldNeedQueryForCandidates(fieldSpec)))) {
            return fieldSpec.getCandidateValues();
        }
        return queryCandidatesForModel(groupData, fieldData, fieldSpec);
    }

    protected boolean isFieldNeedQueryForCandidates(CRFieldSpec fieldSpec) {
        return getFieldNeedQueryForCandidates(fieldSpec) != null;
    }

    protected String getFieldNeedQueryForCandidates(CRFieldSpec fieldSpec) {
        if (fieldSpec.getValuesRetrieveApi() == null) {
            return null;
        }
        Matcher m = this.ptnCandidateQueryExpr.matcher(fieldSpec.getValuesRetrieveApi());
        if (m.matches()) {
            return "query";
        }
        if (fieldSpec.getValuesRetrieveApi().startsWith("Query(")) {
            return "picker";
        }
        return null;
    }

    protected Object convertToUiCandidateValues(CRFieldSpec fieldSpec, Object candidateValues) {
        if (candidateValues == null) {
            return null;
        }
        if (candidateValues instanceof Map) {
            Map<String, Object> inputMap = (Map<String, Object>) candidateValues;
            return inputMap.entrySet().stream()
                    .map(it -> MapUtil.put("id", it.getKey()).put("title", it.getValue()).put("value", it.getKey()).into_map())
                    .collect(Collectors.toList());
        }
        if (candidateValues instanceof List) {
            if (isUiCandidateList((List<Object>) candidateValues)) {
                return candidateValues;
            }
            List list = (List) candidateValues;
            return list.stream()
                    .map(it -> MapUtil.put("title", getCandidateDataTitle(fieldSpec, it))
                            .put("id", getCandidateDataValue(fieldSpec, it))
                            .put("value", getCandidateDataValue(fieldSpec, it))
                            .into_map())
                    .collect(Collectors.toList());
        }
        return null;
    }

    protected boolean isUiCandidateList(List<Object> candidateValues) {
        if (candidateValues == null || candidateValues.isEmpty()) {
            return true;
        }
        for (Object val : candidateValues) {
            if (val instanceof Map) {
                Map map = (Map) val;
                if (map.containsKey("title") && map.containsKey("id")) {
                    continue;
                }
            }
            return false;
        }
        return true;
    }

    protected List<Map<String, Object>> getFiledRules(CRFieldSpec fieldSpec) {
        List<Map<String, Object>> rules = new ArrayList<>();
        addRequiredRule(rules, fieldSpec);
        addRangeRule(rules, fieldSpec);
        addRegExpRule(rules, fieldSpec);
        return rules;
    }

    protected void addRegExpRule(List<Map<String, Object>> rules, CRFieldSpec fieldSpec) {
        if (fieldSpec.getRegExp() == null) {
            return;
        }
        rules.add(
                MapUtil.put("regex", fieldSpec.getRegExp())
                        .put("message", "请输入正确格式的" + fieldSpec.getLabel())
                        .into_map());
    }

    protected void addRangeRule(List<Map<String, Object>> rules, CRFieldSpec fieldSpec) {
        String maxStr = fieldSpec.getMaximum();
        String minStr = fieldSpec.getMinimum();
        if (fieldSpec.getType().equals("image") || fieldSpec.getType().equals("images")) {
            //            Map<String, Object> imageRangeRule =
            //                    MapUtil.put("min", fieldSpec.getRequired() ? 1 : 0)
            //                            .put("max", 1)
            //                            .put("type", "array")
            //                            .put("message", fieldSpec.getLabel() + "只能选择一张")
            //                            .into_map();
            //            rules.add(imageRangeRule);
            return;
        }
        if (maxStr == null && minStr == null) {
            return;
        }
        Map<String, String> params = new HashMap<>();
        switch (fieldSpec.getType()) {
            case "integer":
            case "decimal":
                params.put("dim", "的值");
                params.put("unit", "");
                params.put("lowWord", "小于");
                params.put("hiWord", "大于");
                params.put("type", "number");
                break;
            case "money":
                params.put("dim", "");
                params.put("unit", "");
                params.put("lowWord", "小于");
                params.put("hiWord", "大于");
                params.put("type", "number");
                break;
            case "date":
            case "datetime":
            case "time":
                //                params.put("dim", "");
                //                params.put("unit", "");
                //                params.put("lowWord", "早于");
                //                params.put("hiWord", "晚于");
                //                params.put("type", "date");
                //                break;
                return;
            case "images":
                params.put("dim", "");
                params.put("unit", "张");
                params.put("lowWord", "少于");
                params.put("hiWord", "多于");
                params.put("type", "array");
                break;
            case "video":
                params.put("dim", "");
                params.put("unit", "部");
                params.put("lowWord", "少于");
                params.put("hiWord", "多于");
                params.put("type", "string");
                break;
            case "file":
                params.put("dim", "");
                params.put("unit", "个");
                params.put("lowWord", "少于");
                params.put("hiWord", "多于");
                params.put("type", "file");
                break;
            case "string":
            case "longtext":
            case "rich_text":
            case "article":
                params.put("dim", "的长度");
                params.put("unit", "字");
                params.put("lowWord", "少于");
                params.put("hiWord", "多于");
                params.put("type", "string");
                break;
            default: {
                if (fieldSpec.getModelName() != null) {
                    params.put("dim", "的选择");
                    params.put("unit", "项");
                    params.put("lowWord", "少于");
                    params.put("hiWord", "多于");
                    params.put("type", "array");
                } else {
                    BUG(fieldSpec.getType() + "的addRangeRule()还没处理");
                }
            }
        }

        if (maxStr != null && minStr != null) {
            Map<String, Object> rule =
                    MapUtil.put("min", minStr)
                            .put("max", maxStr)
                            .put("type", params.get("type"))
                            .put(
                                    "message",
                                    String.format(
                                            "%s%s不能%s%s%s,也不能%s%s%s",
                                            fieldSpec.getLabel(),
                                            params.get("dim"),
                                            params.get("lowWord"),
                                            minStr,
                                            params.get("unit"),
                                            params.get("hiWord"),
                                            maxStr,
                                            params.get("unit")))
                            .into_map();
            rules.add(rule);
            return;
        }

        if (maxStr != null) {
            Map<String, Object> rule =
                    MapUtil.put("max", maxStr)
                            .put("type", params.get("type"))
                            .put(
                                    "message",
                                    String.format(
                                            "%s%s不能%s%s%s",
                                            fieldSpec.getLabel(),
                                            params.get("dim"),
                                            params.get("hiWord"),
                                            maxStr,
                                            params.get("unit")))
                            .into_map();
            rules.add(rule);
            return;
        }

        Map<String, Object> rule =
                MapUtil.put("min", minStr)
                        .put("type", params.get("type"))
                        .put(
                                "message",
                                String.format(
                                        "%s%s不能%s%s%s",
                                        fieldSpec.getLabel(),
                                        params.get("dim"),
                                        params.get("lowWord"),
                                        minStr,
                                        params.get("unit")))
                        .into_map();
        rules.add(rule);
    }

    protected void addRequiredRule(List<Map<String, Object>> rules, CRFieldSpec fieldSpec) {
        if (!fieldSpec.getRequired()) {
            return;
        }
        rules.add(
                MapUtil.put("required", true).put("message", fieldSpec.getLabel() + "不能为空").into_map());
    }

    protected Object TO_VALUE(Object value, CRFieldSpec fieldSpec) {
        if (value == null) {
            return null;
        }
        if (value instanceof Images) {
            return value;
        }
        if (value instanceof String) {
            if (fieldSpec.getSelectable().equals(CRFieldSpec.MULTI_SELECTABLE)) {
                return DataTypeUtil.getStringList(value);
            }
            return (String) value;
        }
        if (value instanceof Date) {
            return DateTimeUtil.formatDate((Date) value, "yyyy-MM-dd HH:mm:ss");
        }
        if (value instanceof CafEntity) {
            return ((CafEntity) value).getId();
        }
        if (value instanceof List) {
            return value;
        }
        return String.valueOf(value);
    }

    protected void fulfillChangeRequestActions(
            String crId,
            ChangeRequestData reuestData,
            CRSpec crSpec,
            String sceneCode,
            String processUrl) {
        if (crSpec.isOnlyOneScence(sceneCode)) {
            addCommitAction(reuestData, crSpec, processUrl, sceneCode);
            return;
        }
        if (crSpec.isFirstScence(sceneCode)) {
            addNextStepAction(reuestData, crSpec, processUrl, sceneCode);
            return;
        }
        if (crSpec.isLastScence(sceneCode)) {
            addPrevStepAction(crId, reuestData, crSpec, processUrl, sceneCode);
            addCommitAction(reuestData, crSpec, processUrl, sceneCode);
            return;
        }
        addPrevStepAction(crId, reuestData, crSpec, processUrl, sceneCode);
        addNextStepAction(reuestData, crSpec, processUrl, sceneCode);
    }

    protected void addNextStepAction(
            ChangeRequestData reuestData, CRSpec crSpec, String processUrl, String sceneCode) {
        reuestData.addAction(
                crSpec,
                BaseCrConst.ACTION_NEXT_STEP,
                "下一步",
                makeActionUrl(
                        processUrl == null ? crSpec.getRequestPrefix() : processUrl,
                        null,
                        crSpec.getChangeRequestType(),
                        sceneCode,
                        "nextStep",
                        "",
                        0));
    }

    protected String makeFieldChangeUrl(
            ChangeRequestProcessingContext crContext, String processUrl, String fieldName) {
        CRSpec crSpec = crContext.getCrSpec();
        ChangeRequestPostData postData = crContext.getPostData();
        String url =
                makeActionUrl(
                        processUrl == null ? crSpec.getRequestPrefix() : processUrl,
                        crContext.getCrId(),
                        crSpec.getChangeRequestType(),
                        crContext.getSceneCode(),
                        BaseCrConst.ACTION_REFRESH_ON_CHANGE,
                        postData == null ? "" : postData.getActionGroup(),
                        postData == null ? 0 : postData.getActionIndex());
        try {
            url += "&f=" + URLEncoder.encode(fieldName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return url;
    }

    protected CRAction addCommitAction(
            ChangeRequestData requestData, CRSpec crSpec, String processUrl, String sceneCode) {
        return requestData.addAction(
                crSpec,
                BaseCrConst.ACTION_COMMIT,
                "提交",
                makeActionUrl(
                        processUrl == null ? crSpec.getRequestPrefix() : processUrl,
                        null,
                        crSpec.getChangeRequestType(),
                        sceneCode,
                        BaseCrConst.ACTION_COMMIT,
                        "",
                        0));
    }

    protected void addPrevStepAction(
            String crId,
            ChangeRequestData reuestData,
            CRSpec crSpec,
            String processUrl,
            String sceneCode) {
        reuestData.addAction(
                crSpec,
                BaseCrConst.ACTION_PREV_STEP,
                "上一步",
                makeActionUrl(
                        processUrl == null ? crSpec.getRequestPrefix() : processUrl,
                        crId,
                        crSpec.getChangeRequestType(),
                        sceneCode,
                        "prevStep",
                        "",
                        0));
    }

    protected CRFieldSpec findCorrespondingSpec(List<CRFieldSpec> fieldSpecList, String fieldName) {
        return fieldSpecList.stream()
                .filter(fs -> fieldName.startsWith(fs.getFieldGroup() + "_"))
                .findFirst()
                .orElse(null);
    }

    protected String getRecordIdFromFieldName(String fieldName, CRFieldSpec fieldSpec) {
        String idStr = fieldName.substring(fieldSpec.getName().length() + 1);
        return idStr.equals("new") ? null : idStr;
    }

    protected String makeActionUrl(
            String prefix,
            String crId,
            String crType,
            String sceneCode,
            String actionCode,
            String groupName,
            int recordIndex) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(prefix) // .append("x/")
                    .append("?t=")
                    .append(URLEncoder.encode(crType, "UTF-8"));
            if (crId != null) {
                sb.append("&c=").append(URLEncoder.encode(crId, "UTF-8"));
            }
            sb.append("&s=").append(URLEncoder.encode(sceneCode, "UTF-8"));
            sb.append("&a=").append(URLEncoder.encode(actionCode, "UTF-8"));
            sb.append("&g=").append(URLEncoder.encode(groupName, "UTF-8"));
            sb.append("&i=").append(URLEncoder.encode(String.valueOf(recordIndex), "UTF-8"));
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException("URL编码也会错", e);
        }
    }

    /**
     * 将提交的数据组装成标准格式: <code>
     * {
     * "changeRequestType" : "POST_DEMAND",
     * "changeRequestId" : "CR000017",
     * "sceneCode" : "postDemand",
     * "actionCode" : "commit",
     * "actionIndex" : 0,
     * "fieldData" : {
     * "pdPostDemand_postDemand" : [ {
     * "unitType" : "ENTERPRISE",
     * "contactMobile" : "13388998899",
     * "unitName" : "测试原",
     * "contactName" : "外地人",
     * "type" : "DT000001",
     * "researchGroup" : "大号不",
     * "content" : "阿斯蒂芬"
     * } ]
     * },
     * "groupIds" : {
     * "pdPostDemand_postDemand" : 1
     * }
     * }
     * </code>
     *
     * @param requestParameters
     * @return
     * @throws Exception
     */
    public ChangeRequestPostData parsePostedData(Map<String, Object> requestParameters)
            throws Exception {
        String crType = RequestUtil.getStringInput(requestParameters, "t", null);
        String action = RequestUtil.getStringInput(requestParameters, "a", null);
        String group = RequestUtil.getStringInput(requestParameters, "g", null);
        Integer index = RequestUtil.getIntegerInput(requestParameters, "i", 1);
        String sceneCode = RequestUtil.getStringInput(requestParameters, "s", null);
        String rcdId = RequestUtil.getStringInput(requestParameters, "r", null);
        String updatingField = RequestUtil.getStringInput(requestParameters, "f", null);

        String postedFormDataStr = RequestUtil.getStringInput(requestParameters, "formData", "{}");
        Map<String, Object> postedFormData = new HashMap<>();
        if (!TextUtil.isBlank(postedFormDataStr)) {
            postedFormData = DebugUtil.getObjectMapper().readValue(postedFormDataStr, Map.class);
        }
        // System.out.println(DebugUtil.dumpAsJson(postedFormData, true));
        //        String sceneCode =
        //                RequestUtil.getStringInput(
        //                        postedFormData, BaseCrConst.GROUP_HIDDEN + "_" +
        // BaseCrConst.FIELD_SCENE_CODE, null);
        if (sceneCode == null) {
            sceneCode = CR(crType).getSceneList().get(0).getName();
        }
        String crId = RequestUtil.getStringInput(requestParameters, "c", null);
        crId =
                RequestUtil.getStringInput(
                        postedFormData, BaseCrConst.GROUP_HIDDEN + "_" + BaseCrConst.FIELD_CR_ID, crId);
        // 基本参数
        ChangeRequestPostData postedData = new ChangeRequestPostData();
        postedData.setChangeRequestType(crType);
        postedData.setActionCode(action);
        postedData.setActionGroup(group);
        postedData.setActionIndex(index);
        postedData.setSceneCode(sceneCode);
        postedData.setChangeRequestId(crId);
        postedData.setRecordId(rcdId);
        postedData.setUpdatingField(updatingField);

        boolean needVerifyFormData = true;
        switch (action) {
            case BaseCrConst.ACTION_DELETE_RECORD:
            case BaseCrConst.ACTION_PREV_RECORD:
            case BaseCrConst.ACTION_PREV_STEP:
            case BaseCrConst.ACTION_REFRESH_ON_CHANGE:
                needVerifyFormData = false;
            default:
                break;
        }
        // spec
        CRSpec crSpec = CR(crType);
        List<CRGroupSpec> groupSpecList = GROUPS(crSpec, sceneCode);
        // group id
        Map<String, Integer> groupIds = new HashMap<>();
        for (CRGroupSpec groupSpec : groupSpecList) {
            String name = BaseCrConst.GROUP_HIDDEN + "_indexof_" + groupSpec.getName();
            if (postedFormData.containsKey(name)) {
                groupIds.put(groupSpec.getName(), this.getIntegerValue(postedFormData.get(name)));
            } else {
                groupIds.put(groupSpec.getName(), 1);
            }
        }
        ;
        postedData.setGroupIds(groupIds);

        // 开始拼装数据
        for (CRGroupSpec groupSpec : groupSpecList) {
            String groupName = groupSpec.getName();
            List<CRFieldSpec> fieldSpecList =
                    crSpec.getFieldList().stream()
                            .filter(f -> GROUP_NAME(f).equals(groupName))
                            .collect(Collectors.toList());
            for (CRFieldSpec fieldSpec : fieldSpecList) {
                if (fieldSpec.getInteractionMode().equals("display")) {
                    continue;
                }

                String fieldName =
                        postedFormData.keySet().stream()
                                .filter(it -> it.startsWith(fieldSpec.getName() + "_"))
                                .findFirst()
                                .orElse(null);
                // System.out.println(" now find field " + fieldName+", use SPEC " +
                // fieldSpec.getName());
                // 顺便把字段校验做了
                if (fieldName == null) {
                    if (needVerifyFormData) {
                        doFieldChecking(postedData, fieldSpec, null, null);
                    }
                    // 没在提交的数据里找到对应的值
                    continue;
                }
                Object fieldValue = postedFormData.get(fieldName);
                if (fieldValue instanceof String && ((String) fieldValue).isEmpty()) {
                    if (needVerifyFormData) {
                        doFieldChecking(postedData, fieldSpec, fieldName, null);
                    }
                    // 提交的数据里是空值
                    continue;
                }
                if (needVerifyFormData) {
                    doFieldChecking(postedData, fieldSpec, fieldName, fieldValue);
                }
                String recordId = getRecordIdFromFieldName(fieldName, fieldSpec);
                postedData.addFieldValue(groupName, fieldSpec, recordId, fieldValue);
            }
        }
        if (!inProductEnv()) {
            System.out.println("[ CR DEBUG ]: 收到请求数据\r\n" + DebugUtil.dumpAsJson(postedData, true));
        }
        verifyPostedData(postedData);
        return postedData;
    }

    protected void verifyPostedData(ChangeRequestPostData postedData) throws Exception {
        // add your special data-verification logic here
    }

    protected abstract boolean inProductEnv();

    protected abstract void doFieldChecking(
            ChangeRequestPostData postedData, CRFieldSpec fieldSpec, String fieldName, Object fieldValue);

    protected String toJsonString(Object value) throws JsonProcessingException {
        if (value == null) {
            return null;
        }
        return DebugUtil.getObjectMapper().writeValueAsString(value);
    }

    protected Map<String, EventInfo> getEventInfoMapFrom(String eventsInfoStr)
            throws java.io.IOException {
        return DebugUtil.getObjectMapper()
                .readValue(eventsInfoStr, new TypeReference<Map<String, EventInfo>>() {
                });
    }

    protected abstract Object queryCandidatesForModel(
            CRGroupData groupData, CRFieldData fieldData, CRFieldSpec fieldSpec);

    protected abstract String getCandidateDataTitle(CRFieldSpec fieldSpec, Object val);

    protected abstract String getCandidateDataValue(CRFieldSpec fieldSpec, Object val);

    protected void doStringFieldChecking(
            ChangeRequestPostData postedData, CRFieldSpec fieldSpec, String fieldName, Object value) {
        String val = getStringValue(value);
        if (val == null) {
            postedData.addVerifyErrorMessage(
                    fieldName, fieldSpec.getLabel(), String.format("%s的输入不正确", fieldSpec.getLabel()));
            return;
        }
        if (fieldSpec.getMinimum() != null) {
            if (val.length() < Integer.parseInt(fieldSpec.getMinimum())) {
                postedData.addVerifyErrorMessage(
                        fieldName,
                        fieldSpec.getLabel(),
                        String.format("%s最少需要%s个字符", fieldSpec.getLabel(), fieldSpec.getMinimum()));
            }
        }
        if (fieldSpec.getMaximum() != null) {
            if (val.length() > Integer.parseInt(fieldSpec.getMaximum())) {
                postedData.addVerifyErrorMessage(
                        fieldName,
                        fieldSpec.getLabel(),
                        String.format("%s最长不能超过%s个字符", fieldSpec.getLabel(), fieldSpec.getMaximum()));
            }
        }
        if (fieldSpec.getRegExp() != null) {
            if (!val.matches(fieldSpec.getRegExp())) {
                postedData.addVerifyErrorMessage(
                        fieldName,
                        fieldSpec.getLabel(),
                        String.format("%s的格式不正确%s", fieldSpec.getLabel(), fieldSpec.getRegExp()));
            }
        }
    }

    protected void doFileFieldChecking(
            ChangeRequestPostData postedData, CRFieldSpec fieldSpec, String fieldName, Object value) {
        doStringFieldChecking(postedData, fieldSpec, fieldName, value);
    }

    protected void doVideoFieldChecking(
            ChangeRequestPostData postedData, CRFieldSpec fieldSpec, String fieldName, Object value) {
        doStringFieldChecking(postedData, fieldSpec, fieldName, value);
    }

    protected void doMobileFieldChecking(
            ChangeRequestPostData postedData, CRFieldSpec fieldSpec, String fieldName, Object value) {
        String val = getStringValue(value);
        if (val == null) {
            postedData.addVerifyErrorMessage(
                    fieldName, fieldSpec.getLabel(), String.format("%s的输入不正确", fieldSpec.getLabel()));
            return;
        }
        val = TextUtil.onlyNumber(val);
        if (val.length() != 11) {
            postedData.addVerifyErrorMessage(
                    fieldName,
                    fieldSpec.getLabel(),
                    String.format("%s的长度不正确:%d", fieldSpec.getLabel(), val.length()));
            return;
        }
        if (TextUtil.formatChinaMobile(val) == null) {
            if (!val.matches(fieldSpec.getRegExp())) {
                postedData.addVerifyErrorMessage(
                        fieldName,
                        fieldSpec.getLabel(),
                        String.format("%s的格式不正确", fieldSpec.getLabel(), fieldSpec.getRegExp()));
            }
        }
    }

    protected void doDatetimeFieldChecking(
            ChangeRequestPostData postedData, CRFieldSpec fieldSpec, String fieldName, Object value) {
        Date val = this.getDatetimeValue(value);
        if (val == null) {
            postedData.addVerifyErrorMessage(
                    fieldName, fieldSpec.getLabel(), String.format("%s的输入不正确", fieldSpec.getLabel()));
            return;
        }
        //        if (fieldSpec.getMinimum() != null) {
        //            Date minVal = this.getDatetimeValue(fieldSpec.getMinimum());
        //            if (val.before(minVal)) {
        //                postedData.addVerifyErrorMessage(
        //                        fieldName,
        //                        fieldSpec.getLabel(),
        //                        String.format("%s不能早于%s", fieldSpec.getLabel(),
        // fieldSpec.getMinimum()));
        //            }
        //        }
        //        if (fieldSpec.getMaximum() != null) {
        //            Date maxVal = this.getDatetimeValue(fieldSpec.getMaximum());
        //            if (val.after(maxVal)) {
        //                postedData.addVerifyErrorMessage(
        //                        fieldName,
        //                        fieldSpec.getLabel(),
        //                        String.format("%s不能晚于%s", fieldSpec.getLabel(),
        // fieldSpec.getMaximum()));
        //            }
        //        }
    }

    protected void doRichTextFieldChecking(
            ChangeRequestPostData postedData, CRFieldSpec fieldSpec, String fieldName, Object value) {
        doLongtextFieldChecking(postedData, fieldSpec, fieldName, value);
    }

    protected void doLongtextFieldChecking(
            ChangeRequestPostData postedData, CRFieldSpec fieldSpec, String fieldName, Object value) {
        String val = getStringValue(value);
        if (val == null) {
            postedData.addVerifyErrorMessage(
                    fieldName, fieldSpec.getLabel(), String.format("%s的输入不正确", fieldSpec.getLabel()));
            return;
        }
        if (fieldSpec.getMinimum() != null) {
            if (val.length() < Integer.parseInt(fieldSpec.getMinimum())) {
                postedData.addVerifyErrorMessage(
                        fieldName,
                        fieldSpec.getLabel(),
                        String.format("%s最少需要%s个字符", fieldSpec.getLabel(), fieldSpec.getMinimum()));
            }
        }
        if (fieldSpec.getMaximum() != null) {
            if (val.length() > Integer.parseInt(fieldSpec.getMaximum())) {
                postedData.addVerifyErrorMessage(
                        fieldName,
                        fieldSpec.getLabel(),
                        String.format("%s最长不能超过%s个字符", fieldSpec.getLabel(), fieldSpec.getMaximum()));
            }
        }
    }

    protected void doArticleFieldChecking(
            ChangeRequestPostData postedData, CRFieldSpec fieldSpec, String fieldName, Object value) {
        doLongtextFieldChecking(postedData, fieldSpec, fieldName, value);
    }

    protected void doBooleanFieldChecking(
            ChangeRequestPostData postedData, CRFieldSpec fieldSpec, String fieldName, Object value) {
        Boolean val = getBooleanValue(value);
        if (val == null) {
            postedData.addVerifyErrorMessage(
                    fieldName, fieldSpec.getLabel(), String.format("%s的输入不正确", fieldSpec.getLabel()));
            return;
        }
        if (fieldSpec.getValue() == null) {
            return;
        }
        Boolean forceVal = getBooleanValue(fieldSpec.getValue());
        if (!val.equals(forceVal)) {
            postedData.addVerifyErrorMessage(
                    fieldName,
                    fieldSpec.getLabel(),
                    String.format("%s应该为%s", fieldSpec.getLabel(), fieldSpec.getValue()));
        }
    }

    protected void doTimeFieldChecking(
            ChangeRequestPostData postedData, CRFieldSpec fieldSpec, String fieldName, Object value) {
        Date val = this.getTimeValue(value);
        if (val == null) {
            postedData.addVerifyErrorMessage(
                    fieldName, fieldSpec.getLabel(), String.format("%s的输入不正确", fieldSpec.getLabel()));
            return;
        }
        //        if (fieldSpec.getMinimum() != null) {
        //            Date minVal = this.getTimeValue(fieldSpec.getMinimum());
        //            if (val.before(minVal)) {
        //                postedData.addVerifyErrorMessage(
        //                        fieldName,
        //                        fieldSpec.getLabel(),
        //                        String.format("%s不能早于%s", fieldSpec.getLabel(),
        // fieldSpec.getMinimum()));
        //            }
        //        }
        //        if (fieldSpec.getMaximum() != null) {
        //            Date maxVal = this.getTimeValue(fieldSpec.getMaximum());
        //            if (val.after(maxVal)) {
        //                postedData.addVerifyErrorMessage(
        //                        fieldName,
        //                        fieldSpec.getLabel(),
        //                        String.format("%s不能晚于%s", fieldSpec.getLabel(),
        // fieldSpec.getMaximum()));
        //            }
        //        }
    }

    protected void doIntegerFieldChecking(
            ChangeRequestPostData postedData, CRFieldSpec fieldSpec, String fieldName, Object value) {
        Integer val = getIntegerValue(value);
        if (val == null) {
            postedData.addVerifyErrorMessage(
                    fieldName, fieldSpec.getLabel(), String.format("%s的输入不正确", fieldSpec.getLabel()));
            return;
        }
        if (fieldSpec.getMinimum() != null) {
            Integer minVal = getIntegerValue(fieldSpec.getMinimum());
            if (val < minVal) {
                postedData.addVerifyErrorMessage(
                        fieldName,
                        fieldSpec.getLabel(),
                        String.format("%s不能小于%s", fieldSpec.getLabel(), fieldSpec.getMinimum()));
            }
        }
        if (fieldSpec.getMaximum() != null) {
            Integer maxVal = getIntegerValue(fieldSpec.getMaximum());
            if (val > maxVal) {
                postedData.addVerifyErrorMessage(
                        fieldName,
                        fieldSpec.getLabel(),
                        String.format("%s不能大于%s", fieldSpec.getLabel(), fieldSpec.getMaximum()));
            }
        }
    }

    protected void doMoneyFieldChecking(
            ChangeRequestPostData postedData, CRFieldSpec fieldSpec, String fieldName, Object value) {
        BigDecimal val = getMoneyValue(value);
        if (val == null) {
            postedData.addVerifyErrorMessage(
                    fieldName, fieldSpec.getLabel(), String.format("%s的输入不正确", fieldSpec.getLabel()));
            return;
        }
        if (fieldSpec.getMinimum() != null) {
            BigDecimal minVal = getMoneyValue(fieldSpec.getMinimum());
            if (val.compareTo(minVal) < 0) {
                postedData.addVerifyErrorMessage(
                        fieldName,
                        fieldSpec.getLabel(),
                        String.format("%s不能小于%s", fieldSpec.getLabel(), fieldSpec.getMinimum()));
            }
        }
        if (fieldSpec.getMaximum() != null) {
            BigDecimal maxVal = getMoneyValue(fieldSpec.getMaximum());
            if (val.compareTo(maxVal) > 0) {
                postedData.addVerifyErrorMessage(
                        fieldName,
                        fieldSpec.getLabel(),
                        String.format("%s不能大于%s", fieldSpec.getLabel(), fieldSpec.getMaximum()));
            }
        }
    }

    protected void doDecimalFieldChecking(
            ChangeRequestPostData postedData, CRFieldSpec fieldSpec, String fieldName, Object value) {
        BigDecimal val = getDecimalValue(value);
        if (val == null) {
            postedData.addVerifyErrorMessage(
                    fieldName, fieldSpec.getLabel(), String.format("%s的输入不正确", fieldSpec.getLabel()));
            return;
        }
        if (fieldSpec.getMinimum() != null) {
            BigDecimal minVal = getDecimalValue(fieldSpec.getMinimum());
            if (val.compareTo(minVal) < 0) {
                postedData.addVerifyErrorMessage(
                        fieldName,
                        fieldSpec.getLabel(),
                        String.format("%s不能小于%s", fieldSpec.getLabel(), fieldSpec.getMinimum()));
            }
        }
        if (fieldSpec.getMaximum() != null) {
            BigDecimal maxVal = getDecimalValue(fieldSpec.getMaximum());
            if (val.compareTo(maxVal) > 0) {
                postedData.addVerifyErrorMessage(
                        fieldName,
                        fieldSpec.getLabel(),
                        String.format("%s不能大于%s", fieldSpec.getLabel(), fieldSpec.getMaximum()));
            }
        }
    }

    protected void doImagesFieldChecking(
            ChangeRequestPostData postedData, CRFieldSpec fieldSpec, String fieldName, Object value) {
        Images val = this.getImagesValue(value);
        if (val == null) {
            postedData.addVerifyErrorMessage(
                    fieldName, fieldSpec.getLabel(), String.format("%s的输入不正确", fieldSpec.getLabel()));
            return;
        }
        if (fieldSpec.getMinimum() != null) {
            if (val.size() < Integer.parseInt(fieldSpec.getMinimum())) {
                postedData.addVerifyErrorMessage(
                        fieldName,
                        fieldSpec.getLabel(),
                        String.format("%s不少于%s张", fieldSpec.getLabel(), fieldSpec.getMinimum()));
            }
        }
        if (fieldSpec.getMaximum() != null) {
            if (val.size() > Integer.parseInt(fieldSpec.getMaximum())) {
                postedData.addVerifyErrorMessage(
                        fieldName,
                        fieldSpec.getLabel(),
                        String.format("%s不多于%s张", fieldSpec.getLabel(), fieldSpec.getMaximum()));
            }
        }
    }

    protected void doDateFieldChecking(
            ChangeRequestPostData postedData, CRFieldSpec fieldSpec, String fieldName, Object value) {
        Date val = this.getDatetimeValue(value);
        if (val == null) {
            postedData.addVerifyErrorMessage(
                    fieldName, fieldSpec.getLabel(), String.format("%s的输入不正确", fieldSpec.getLabel()));
            return;
        }
        //        if (fieldSpec.getMinimum() != null) {
        //            Date minVal = this.getDatetimeValue(fieldSpec.getMinimum());
        //            if (val.before(minVal)) {
        //                postedData.addVerifyErrorMessage(
        //                        fieldName,
        //                        fieldSpec.getLabel(),
        //                        String.format("%s不能早于%s", fieldSpec.getLabel(),
        // fieldSpec.getMinimum()));
        //            }
        //        }
        //        if (fieldSpec.getMaximum() != null) {
        //            Date maxVal = this.getDatetimeValue(fieldSpec.getMaximum());
        //            if (val.after(maxVal)) {
        //                postedData.addVerifyErrorMessage(
        //                        fieldName,
        //                        fieldSpec.getLabel(),
        //                        String.format("%s不能晚于%s", fieldSpec.getLabel(),
        // fieldSpec.getMaximum()));
        //            }
        //        }
    }

    protected void doImageFieldChecking(
            ChangeRequestPostData postedData, CRFieldSpec fieldSpec, String fieldName, Object value) {
        String val = this.getImageValue(value);
        if (val == null) {
            postedData.addVerifyErrorMessage(
                    fieldName, fieldSpec.getLabel(), String.format("%s的输入不正确", fieldSpec.getLabel()));
            return;
        }
    }

    protected String calcSceneCode(ChangeRequestPostData postedData) throws Exception {

        String crType = postedData.getChangeRequestType();
        String sceneCode = postedData.getSceneCode();
        String actionCode = postedData.getActionCode();
        String groupName = postedData.getActionGroup();
        Integer actionIndex = postedData.getActionIndex();
        CRSpec crSpec = CR(crType);
        CRSceneSpec sceneSpec =
                crSpec.getSceneList().stream()
                        .filter(it -> it.getName().equals(sceneCode))
                        .findFirst()
                        .orElse(null);
        if (sceneSpec == null) {
            error("在" + crSpec.getTitle() + "中没有" + sceneCode + "场景的定义,无法理解您的请求,请联系客服处理异常.");
        }
        switch (actionCode) {
            case BaseCrConst.ACTION_COMMIT:
                return BaseCrConst.NEXT_COMMIT;
            case BaseCrConst.ACTION_PREV_STEP: {
                int allScene = crSpec.getSceneList().size();
                int curScene = crSpec.getSceneList().indexOf(sceneSpec);
                int newScene = Math.max(0, Math.min(allScene - 1, curScene - 1));
                return crSpec.getSceneList().get(newScene).getName();
            }
            case BaseCrConst.ACTION_NEXT_STEP: {
                int allScene = crSpec.getSceneList().size();
                int curScene = crSpec.getSceneList().indexOf(sceneSpec);
                int newScene = Math.max(0, Math.min(allScene, curScene + 1));
                if (newScene == allScene) {
                    return BaseCrConst.NEXT_COMMIT;
                }
                return crSpec.getSceneList().get(newScene).getName();
            }
            case BaseCrConst.ACTION_PREV_RECORD:
            case BaseCrConst.ACTION_DELETE_RECORD:
            case BaseCrConst.ACTION_NEXT_RECORD:
                return sceneSpec.getName();
            default:
                error(
                        "您的请求有异常,目前不支持"
                                + crSpec.getTitle()
                                + "."
                                + sceneSpec.getTitle()
                                + "的"
                                + actionCode
                                + "操作");
        }
        return null;
    }

    protected boolean isFieldMissing(
            ChangeRequestPostData postedData, CRFieldSpec fieldSpec, String fieldName, Object value) {
        if (value instanceof Collection) {
            if (!((Collection<?>) value).isEmpty()) {
                return false;
            }
            if (fieldSpec.getRequired()) {
                postedData.addVerifyErrorMessage(
                        fieldName, fieldSpec.getLabel(), String.format("请输入'%s'", fieldSpec.getLabel()));
            }
            return true;
        }
        if (value != null) {
            return false;
        }
        // value missing, is it wrong?
        if (fieldSpec.getRequired()) {
            postedData.addVerifyErrorMessage(
                    fieldName, fieldSpec.getLabel(), String.format("请输入'%s'", fieldSpec.getLabel()));
        }
        return true;
    }

    protected String getLongtextValue(Object value) {
        return DataTypeUtil.getString(value);
    }

    protected String getRichTextValue(Object value) {
        return DataTypeUtil.getString(value);
    }

    protected String getArticleValue(Object value) {
        return DataTypeUtil.getString(value);
    }

    protected DateTime getDatetimeValue(Object value) {
        return DataTypeUtil.getDateTime(value);
    }

    protected String getStringValue(Object value) {
        if (value instanceof List) {
            Object val = ((List<?>) value).get(((List<?>) value).size()-1);
            return getStringFromListItem(val);
        }
        return DataTypeUtil.getString(value);
    }

    protected List<String> getStringList(Object value) {
        if (value instanceof List) {
            return ((List<?>) value)
                    .stream().map(this::getStringFromListItem)
                    .filter(it->!TextUtil.isBlank(it))
                    .collect(Collectors.toList());
        }
        return DataTypeUtil.getStringList(value);
    }

    protected String getStringFromListItem(Object it) {
        if (it instanceof String) {
            return (String) it;
        }
        if (it instanceof Map) {
            Object val = ((Map) it).get("id");
            if (val instanceof String) {
                return (String) val;
            }
            val = ((Map) it).get("key");
            if (val instanceof String) {
                return (String) val;
            }
            val = ((Map) it).get("value");
            if (val instanceof String) {
                return (String) val;
            }
            throw new RuntimeException("数据" + it + "中没有KEY");
        }
        return String.valueOf(it);
    }

    protected String getMobileValue(Object value) {
        return DataTypeUtil.getString(value);
    }

    protected Integer getIntegerValue(Object value) {
        return DataTypeUtil.getInt(value);
    }

    protected BigDecimal getMoneyValue(Object value) {
        return DataTypeUtil.getBigDecimal(value);
    }

    protected Boolean getBooleanValue(Object value) {
        return DataTypeUtil.getBoolean(value);
    }

    protected Date getTimeValue(Object value) {
        return DataTypeUtil.getTime(value);
    }

    protected BigDecimal getDecimalValue(Object value) {
        return DataTypeUtil.getBigDecimal(value);
    }

    protected String getImageValue(Object value) {
        ImageInfo imgInfo = DataTypeUtil.getImageInfo(value);
        if (imgInfo != null) {
            return imgInfo.getImageUrl();
        }

        String imgContent = DataTypeUtil.getString(value);
        if (imgContent == null || imgContent.isEmpty()) {
            return imgContent;
        }

        try {
            List<ImageInfo> imgList =
                    DebugUtil.getObjectMapper()
                            .readValue(imgContent, new TypeReference<List<ImageInfo>>() {
                            });
            if (imgList == null || imgList.isEmpty()) {
                return null;
            }
            return imgList.get(0).getImageUrl();
        } catch (Exception e) {
            return imgContent;
        }
    }

    protected DateTime getDateValue(Object value) {
        return DataTypeUtil.getDateTime(value);
    }

    protected Images getImagesValue(Object value) {
        return DataTypeUtil.getImages(value);
    }

    protected String getFileValue(Object value) {
        return getStringValue(value);
    }

    protected String getVideoValue(Object value) {
        return getStringValue(value);
    }

    protected CRGroupData HIDDEN_GROUP(ChangeRequestData reuestData) {
        if (reuestData == null || reuestData.getGroupList() == null) {
            BUG("你不应该把未准备好的数据交给用户来添加隐藏字段");
        }
        if (reuestData.getGroupList().size() < 1
                || !reuestData.getGroupList().get(0).getName().equals(BaseCrConst.GROUP_HIDDEN)) {
            BUG("你应该先准备hidden group, 再交给用户来添加隐藏字段");
        }
        return reuestData.getGroupList().get(0);
    }

    protected int getIndexOfGroup(ChangeRequestData reuestData, CRGroupSpec groupSpec) {
        if (!groupSpec.isMultiple()) {
            return 1;
        }
        String gName = BaseCrConst.GROUP_HIDDEN + "_indexof_" + groupSpec.getName();
        CRFieldData f =
                HIDDEN_GROUP(reuestData).getFieldList().stream()
                        .filter(it -> it.getName().equals(gName))
                        .findFirst()
                        .orElse(null);
        if (f == null) {
            return 1;
        }
        return Math.max(
                1, Math.min(Integer.valueOf((String) f.getValue()), groupSpec.getMaximumNumber()));
    }

    protected void fulfillGroupActions(
            ChangeRequestProcessingContext crContext,
            String crId,
            CRGroupData groupData,
            int groupRecordIndex,
            String processUrl) {
        CRSpec crSpec = crContext.getCrSpec();
        CRGroupSpec groupSpec = crContext.getGroupSpec();
        String scenceCode = crContext.getSceneCode();

        if (!groupSpec.isMultiple()) {
            return;
        }
        if (groupSpec.getMaximumNumber() <= 1) {
            return;
        }
        if (groupRecordIndex > 1) {
            this.addPrevRecordAction(crId, groupData, crSpec, groupRecordIndex, processUrl, scenceCode);
        }

        Optional<CRFieldData> firstField =
                groupData.getFieldList().stream()
                        .filter(
                                fd -> !(fd.isHidden() || fd.isDisabled() || fd.getType().equals("display-field")))
                        .findFirst();
        if (firstField.isPresent() && !firstField.get().getName().endsWith("_new")) {
            String fieldName = firstField.get().getName();
            String rcdId = fieldName.substring(fieldName.lastIndexOf("_") + 1);
            this.addDeleteRecordAction(
                    crId, groupData, crSpec, groupRecordIndex, processUrl, scenceCode, rcdId);
        }
        if (groupRecordIndex < groupSpec.getMaximumNumber()) {
            this.addNextRecordAction(groupData, crSpec, groupRecordIndex, processUrl, scenceCode);
        }
    }

    protected void addNextRecordAction(
            CRGroupData groupData,
            CRSpec crSpec,
            int groupRecordIndex,
            String processUrl,
            String sceneCode) {
        groupData.addAction(
                crSpec,
                BaseCrConst.ACTION_NEXT_RECORD,
                "下一条",
                makeActionUrl(
                        processUrl == null ? crSpec.getChangeRequestType() : processUrl,
                        null,
                        crSpec.getChangeRequestType(),
                        sceneCode,
                        BaseCrConst.ACTION_NEXT_RECORD,
                        groupData.getName(),
                        groupRecordIndex));
    }

    protected void addPrevRecordAction(
            String crId,
            CRGroupData groupData,
            CRSpec crSpec,
            int groupRecordIndex,
            String processUrl,
            String sceneCode) {
        groupData.addAction(
                crSpec,
                BaseCrConst.ACTION_PREV_RECORD,
                "上一条",
                makeActionUrl(
                        processUrl == null ? crSpec.getChangeRequestType() : processUrl,
                        crId,
                        crSpec.getChangeRequestType(),
                        sceneCode,
                        BaseCrConst.ACTION_PREV_RECORD,
                        groupData.getName(),
                        groupRecordIndex));
    }

    protected void addDeleteRecordAction(
            String crId,
            CRGroupData groupData,
            CRSpec crSpec,
            int groupRecordIndex,
            String processUrl,
            String sceneCode,
            String rcdId) {
        groupData.addAction(
                crSpec,
                BaseCrConst.ACTION_DELETE_RECORD,
                "删除",
                makeActionUrl(
                        processUrl == null ? crSpec.getChangeRequestType() : processUrl,
                        crId,
                        crSpec.getChangeRequestType(),
                        sceneCode,
                        BaseCrConst.ACTION_DELETE_RECORD,
                        groupData.getName(),
                        groupRecordIndex)
                        + "&r="
                        + rcdId);
    }

    protected Map<String, Integer> calcNewGroupIds(ChangeRequestPostData postedData)
            throws Exception {
        String actionGroup = postedData.getActionGroup();
        CRSpec crSpec = CR(postedData.getChangeRequestType());
        List<CRGroupSpec> groups = GROUPS(crSpec, postedData.getSceneCode());

        Map<String, Integer> result = new HashMap<>();
        groups.forEach(
                gSpec -> {
                    Integer idx = postedData.getGroupIds().get(gSpec.getName());
                    if (!gSpec.getName().equals(actionGroup)) {
                        result.put(gSpec.getName(), postedData.getGroupIds().get(gSpec.getName()));
                        return;
                    } else {
                        idx = postedData.getActionIndex();
                    }
                    switch (postedData.getActionCode()) {
                        case BaseCrConst.ACTION_PREV_RECORD:
                            idx = Math.max(1, idx == null ? 1 : idx - 1);
                            result.put(gSpec.getName(), idx);
                            return;
                        case BaseCrConst.ACTION_DELETE_RECORD:
                            result.put(gSpec.getName(), idx);
                            return;
                        case BaseCrConst.ACTION_NEXT_RECORD:
                            idx = idx == null ? 1 : idx + 1;
                            result.put(gSpec.getName(), idx);
                            return;
                        default:
                            result.put(gSpec.getName(), postedData.getGroupIds().get(gSpec.getName()));
                    }
                });
        return result;
    }

    protected List<Map<String, Object>> hiddenFieldRules(String fieldShortName) {
        return CollectionUtils.toList(
                MapUtil.put("required", true).put("message", fieldShortName + "不能为空").into_map());
    }

    protected List<CRSceneData> prepareSceneList(CRSpec crSpec, String sceneCode) {
        if (crSpec.getSceneList() == null || crSpec.getSceneList().size() < 1) {
            return null;
        }
        List<CRSceneData> stepList = new ArrayList<>();
        boolean matched = false;
        for (int i = 0; i < crSpec.getSceneList().size(); i++) {
            CRSceneSpec stepInfo = crSpec.getSceneList().get(i);
            CRSceneData sceneData = new CRSceneData();
            sceneData.setId(String.valueOf(i));
            if (stepInfo.getName().equals(sceneCode)) {
                // is current
                matched = true;
                sceneData.setTitle(stepInfo.getTitle());
                sceneData.setSelected(true);
            } else if (matched) {
                sceneData.setBrief(stepInfo.getTitle());
            } else {
                sceneData.setBrief(stepInfo.getTitle());
                sceneData.setStatus("success");
            }

            stepList.add(sceneData);
        }
        return stepList;
    }

    protected boolean mustFillSomeField(CRSpec crSpec, List<CRGroupSpec> groupSpecList) {
        if (groupSpecList == null) {
            return false;
        }
        List<CRGroupSpec> gsList =
                groupSpecList.stream().filter(it -> it.isMustHave()).collect(Collectors.toList());
        if (gsList == null || gsList.isEmpty()) {
            return false;
        }
        List<CRFieldSpec> fsList =
                crSpec.getFieldList().stream()
                        .filter(it -> it.getRequired() != null && it.getRequired().booleanValue())
                        .collect(Collectors.toList());
        if (fsList == null || fsList.isEmpty()) {
            return false;
        }

        Set<String> gNames = fsList.stream().map(it -> it.getFieldGroup()).collect(Collectors.toSet());
        Iterator<CRGroupSpec> it = gsList.iterator();
        while (it.hasNext()) {
            CRGroupSpec gs = it.next();
            if (gNames.contains(gs.getName())) {
                // 这个组必须要填字段
            } else {
                gs.setMustHave(false);
                it.remove();
            }
        }
        return !gsList.isEmpty();
    }

    protected List<Object> prepareParamsForQueryCandidatesBySpec(
            CRGroupData groupData, CRFieldData fieldData, CRFieldSpec fieldSpec) {
        String apiStr = fieldSpec.getValuesRetrieveApi();
        Matcher m = ptnCandidateQueryExpr.matcher(apiStr);
        if (!m.matches()) {
            return new ArrayList<>();
        }
        String[] paramStrs = m.group(1).split("\\s*,\\s*");
        List<Object> params = new ArrayList<>(paramStrs.length);
        for (String paramStr : paramStrs) {
            if (paramStr.startsWith(":")) {
                params.add(getValueFromFieldData(groupData, fieldData, paramStr.substring(1)));
            }
        }
        return params;
    }

    protected Object getValueFromFieldData(
            CRGroupData groupData, CRFieldData fieldData, String fieldName) {
        String[] curName = fieldData.getName().split("_");
        if (curName.length != 4) {
            return null;
        }
        String fieldKey = groupData.getName() + "_" + fieldName + "_" + curName[3];
        CRFieldData srcField =
                groupData.getFieldList().stream()
                        .filter(it -> it.getName().equals(fieldKey))
                        .findFirst()
                        .orElse(null);
        if (srcField == null) {
            return null;
        }
        return srcField.getValue();
    }

    public CRFieldSpec FIELD_SPEC(String groupName, String fieldName) {
        String fullName = groupName + "_" + TextUtil.uncapFirstChar(TextUtil.toCamelCase(fieldName));
        return FIELD_SPEC(fullName);
    }

    public CRFieldSpec FIELD_SPEC(String fieldName) {
        String fullFieldName = toFieldSpecName(fieldName);
        CRFieldSpec fSpec = fieldSpecMap.get(fullFieldName);
        if (fSpec != null) {
            return fSpec;
        }
        fSpec =
                getSpec().getCrSpecs().values().stream()
                        .flatMap(crSpec -> crSpec.getFieldList().stream())
                        .filter(fieldSpec -> fieldSpec.getName().equals(fullFieldName))
                        .findFirst()
                        .orElse(null);
        if (fSpec != null) {
            fieldSpecMap.put(fullFieldName, fSpec);
        }
        return fSpec;
    }

    protected String toFieldSpecName(String fullFieldName) {
        Objects.requireNonNull(fullFieldName, "调用此方法，请使用有效的CR字段名，或者CR数据的name属性");
        int cnt = 0;
        int pos = 0;
        char[] chars = fullFieldName.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '_') {
                pos = i;
                cnt++;
            }
        }
        if (cnt <= 2) {
            return fullFieldName;
        }
        return fullFieldName.substring(0, pos);
    }

    public CRGroupSpec GROUP_SPEC(String groupName) {
        CRGroupSpec gSpec = groupSpecMap.get(groupName);
        if (gSpec != null) {
            return gSpec;
        }

        gSpec =
                getSpec().getCrSpecs().values().stream()
                        .flatMap(crSpec -> crSpec.getSceneList().stream())
                        .flatMap(scSpec -> scSpec.getGroups().stream())
                        .filter(groupSpec -> groupSpec.getName().equals(groupName))
                        .findFirst()
                        .orElse(null);
        if (gSpec != null) {
            groupSpecMap.put(groupName, gSpec);
        }
        return gSpec;
    }

    protected Object getValueFromPostedData(
            ChangeRequestPostData postedData, String groupName, String fieldName) {
        if (postedData == null || groupName == null || fieldName == null) {
            return null;
        }
        List<Map<String, Object>> groupData = postedData.tryGetGroupData(groupName);
        if (groupData == null || groupData.isEmpty()) {
            return null;
        }
        Map<String, Object> fieldData = groupData.get(0);
        return fieldData.get(fieldName);
    }

    protected boolean shouldShowPreviousRecord(
            int rcdIndex, int groupRecordIndex, int showRecordCnt) {
        if (rcdIndex >= groupRecordIndex) {
            return false;
        }
        if (showRecordCnt == -1) {
            return true;
        }
        return Math.abs(groupRecordIndex - rcdIndex) <= showRecordCnt;
    }

    protected boolean shouldShowNextRecord(int rcdIndex, int groupRecordIndex, int showRecordCnt) {
        if (rcdIndex <= groupRecordIndex) {
            return false;
        }
        if (showRecordCnt == -1) {
            return true;
        }
        return Math.abs(groupRecordIndex - rcdIndex) <= showRecordCnt;
    }

    protected List<String> getEventIdsFromByGroupName(
            Map<String, EventInfo> eventsInfo, String groupName) {
        if (eventsInfo == null || eventsInfo.isEmpty()) {
            return new ArrayList<>();
        }
        return eventsInfo.values().stream()
                .filter(ei -> ei.getFieldGroup().equalsIgnoreCase(groupName))
                .map(ei -> ei.getEventId())
                .collect(Collectors.toList());
    }

    protected String getFieldGroupOfEvent(Map<String, EventInfo> eventsInfo, String eventId) {
        EventInfo eventInfo = eventsInfo.get(eventId);
        if (eventInfo == null) {
            return null;
        }
        return eventInfo.getFieldGroup();
    }

    protected String formatApiUrl(String valuesRetrieveApi) {
        if (valuesRetrieveApi == null) {
            return null;
        }
        Matcher m = this.ptnCandidateQueryExpr.matcher(valuesRetrieveApi);
        if (m.matches()) {
            return valuesRetrieveApi;
        }
        if (valuesRetrieveApi.startsWith("Query(")) {
            return valuesRetrieveApi.substring("Query(".length(), valuesRetrieveApi.length() - 1);
        }
        if (valuesRetrieveApi.startsWith("Action://")) {
            return valuesRetrieveApi.substring("Action://".length());
        }
        return valuesRetrieveApi;
    }

    protected String fillRequestParameters(
            ChangeRequestProcessingContext crContext,
            CRFieldSpec fieldSpec,
            CRGroupData groupData,
            CRFieldData fieldData) {
        // String url = fieldSpec.getValuesRetrieveApi();
        String url = fieldData.getLinkToUrl();
        if (url == null || url.isEmpty()) {
            return url;
        }
        // url = url.substring("Query(".length(), url.length()-1);
        String[] params = url.split("/");
        for (String param : params) {
            if (param.startsWith(":")) {
                Object value = getValueFromFieldData(groupData, fieldData, param.substring(1));
                if (value instanceof String) {
                    url = url.replace(param, value.toString());
                }
            }
        }
        return url;
    }

    protected Object makePromptValue(String value) {
        return MapUtil.put(
                "kids",
                CollectionUtils.toList(
                        MapUtil.put("id", "1")
                                .put("type", "text")
                                .put("text", value)
                                .put(
                                        "customStyle",
                                        MapUtil.put("color", "#4CAF50")
                                                .put("padding", "5px 0px")
                                                .put("fontStyle", "italic")
                                                .put("fontSize", "80%")
                                                .into_map())
                                .into_map()))
                .into_map();
    }
}
