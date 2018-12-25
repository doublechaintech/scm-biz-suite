# retailscm-biz-suite
零售供应链中台基础系统，一共大约130万行代码，管理界面通过javascript高阶函数定制，Java后台主要通过增加方法或者重写已经存在的大量方法来灵活定制。


## 演示地址

https://demo.doublechaintech.com/admin/retailscm/#/home

下面为16种角色建立了演示账户，每种角色都可以登录。

| 角色        | 用户名                            | 密码                                |
| ------------- |:-------------------------------------------:|:-----------------------------------------:|
|双链小超全国运营中心|13900000001|DoubleChain!y1|
|双链小超省中心|13900000002|DoubleChain!y1|
|双链小超城市服务中心|13900000003|DoubleChain!y1|
|城市合伙人|13900000004|DoubleChain!y1|
|潜在的客户|13900000005|DoubleChain!y1|
|双链小超|13900000006|DoubleChain!y1|
|生超会员|13900000007|DoubleChain!y1|
|产品供应商|13900000009|DoubleChain!y1|
|仓库|13900000017|DoubleChain!y1|
|货架|13900000018|DoubleChain!y1|
|运输车队|13900000019|DoubleChain!y1|
|账套|13900000021|DoubleChain!y1|
|会计凭证|13900000022|DoubleChain!y1|
|工资等级|13900000023|DoubleChain!y1|
|员工|13900000024|DoubleChain!y1|
|用户域|13900000025|DoubleChain!y1|


## bizcore: 服务器端核心代码项目， Business Core

后端 Java/Spring/Redis/MySQL/ArrangoDB/Kafka
Java 源代码在bizcore/WEB-INF/ 下


![ScreenShot](/doc/backend.png)
````
caf_core_src: 通用框架库核心代码，包含技术框架，基础设施
caf_custom_src: 通用框架库，主要包含配置文件
retail_core_src: 零售业务核心代码
retail_custom_src: 零售业务定制代码，如果要定制，在此处增加类，继承retail_core_src的相应类，可以调用或者重写父类，core里面的类提供大量可以重用的方法。
````

## bizui：中台集成界面项目， Business UI，不是闭嘴！
前端 React/dvajs/antd/echarts/Redux


![ScreenShot](/doc/homescreen.png)
![ScreenShot](/doc/rootapp.png)

