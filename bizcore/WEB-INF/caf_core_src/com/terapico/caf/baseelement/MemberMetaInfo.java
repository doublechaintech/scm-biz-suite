package com.terapico.caf.baseelement;

/**
 * 成员的原信息
 */
public class MemberMetaInfo {
    protected String nameInModel;   // 成员的名字, 模型中的名字. 如果是被引用(referenced=true),表示在对方模型中,'我'对应的名字
    protected String name;          // 类中的名字
    protected String chineseName;   // 中文名字
    protected String atomicType;    // 原子类型. 如果就是一个普通对象,这个就是java class name;
                                    // 如果是原子类型, 这个就是对应的Type里的name, 例如int(对应Integer.TYPE)
    protected String bizDataType;   // 业务数据类型, 例如: string_email, mobile 之类的,对应reg_type中定义的几个数据类型
    protected String collectionType;    // null 表示不是集合类型, list 表示是列表. 目前不支持其他的
    protected boolean primitive;    // 原子类型是否java原生数据类型
    protected boolean referenced;   // 这个成员是由于被别人引用而建立的

    public String getNameInModel() {
        return nameInModel;
    }

    public void setNameInModel(String nameInModel) {
        this.nameInModel = nameInModel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getAtomicType() {
        return atomicType;
    }

    public void setAtomicType(String atomicType) {
        this.atomicType = atomicType;
    }

    public String getBizDataType() {
        return bizDataType;
    }

    public void setBizDataType(String bizDataType) {
        this.bizDataType = bizDataType;
    }

    public String getCollectionType() {
        return collectionType;
    }

    public void setCollectionType(String collectionType) {
        this.collectionType = collectionType;
    }



    public static MemberMetaInfo defineBy(String name, String nameInModel, String chineseName) {
        MemberMetaInfo rst = new MemberMetaInfo();
        rst.setName(name);
        rst.setNameInModel(nameInModel);
        rst.setChineseName(chineseName);
        return rst;
    }
    public static MemberMetaInfo referBy(String name, String nameInModel, String chineseName) {
        MemberMetaInfo rst = new MemberMetaInfo();
        rst.setName(name);
        rst.setNameInModel(nameInModel);
        rst.setChineseName(chineseName);
        return rst;
    }
    public MemberMetaInfo withType(String bizDataType, Class atomicClass) {
        withType(bizDataType, atomicClass.getName());
        this.primitive = false;
        return this;
    }
    public MemberMetaInfo withType(String bizDataType, String atomicType) {
        this.primitive = true;
        this.setBizDataType(bizDataType);
        this.setAtomicType(atomicType);
        return this;
    }
}
