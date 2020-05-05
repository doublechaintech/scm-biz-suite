

/*

这里面放置你需要定制的行为，可以增加方法，也可以重写原来的方法，主要是增加新的约束和关联。
注意，在同名方法里面一定要使用super来调用，不然将会出现缓冲出溢出的问题Stack Overflow。
这个类讲在第一次生成，此后这些文件不会被覆盖，如果名字发生了变更，则需要手动删除，修改本类来适应新的模型变更，
这个类已经被配置到了相应的Spring配置文件 WEB-INF/retailscm_custom_src/META-INF/retailscm_custom.xml 中，
所以直接在里面重写或者增加新的方法将会修改客户的行为

*/


package com.doublechaintech.retailscm.view;
import java.util.Date;
import com.doublechaintech.retailscm.RetailscmUserContext;

public class ViewCustomManagerImpl extends ViewManagerImpl{





}

