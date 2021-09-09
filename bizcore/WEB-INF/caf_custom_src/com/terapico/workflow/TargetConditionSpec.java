package com.terapico.workflow;

import java.util.List;

public class TargetConditionSpec {
    String code;
    String title;

    // 变化形式
    String transferType;
    /**
     * go_to: 自己变成新的;
     * copy_to: 赋值一个自己,添加到Process实例中
     * split_to: 自己被拆分成多个新的
     */

    // 目标 node 的类型, 对应 NodeSpec.statusCode 字段的值
    List<String> targetStatusCode;

    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public List<String> getTargetStatusCode() {
        return targetStatusCode;
    }

    public void setTargetStatusCode(List<String> targetStatusCode) {
        this.targetStatusCode = targetStatusCode;
    }
}
