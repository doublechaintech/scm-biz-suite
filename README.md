# 集成供应链套件
零售供应链中台基础系统，一共大约130万行代码，管理界面通过javascript高阶函数定制，Java后台主要通过增加方法或者重写已经存在的大量方法来灵活定制。

本系统目前大约有130万行代码，是用自研知识图谱和因果网络处理系统生成高可维护源代码。集成了阿里云OSS服务和短信服务。


概念和关系请请见：https://demo.doublechaintech.com/admin/retailscm/entities.html , 图比较大，需要拖动


# 如何使用

* 建立数据中台，这样源代码几乎不需要改动，本系统提供了大量的接口，可以让业务系统通过API插入数据，可以视作一个独立的微服务
* 定制业务系统，可以在这个系统基础上通过前后台增加代码来定制业务系统
* 用于教学和练习

# 许可

除了Logo以外，本系统源代码为Apache 2 License，可以用于商用目的

# 技术支持

本系统提供商业的系统支持和基于Issue的免费的技术支持

[部署指南 ](/DEPLOYMENT.md)

## 演示地址

https://demo.doublechaintech.com/admin/retailscm/#/home

下面为18种角色建立了演示账户，每种角色都可以登录，代表不同客户需要的不同资源。

| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|
|零售商店国家中心|13900000001|DoubleChain!y1|
|零售商店省中心|13900000002|DoubleChain!y1|
|零售商店城市服务中心|13900000003|DoubleChain!y1|
|城市的合作伙伴|13900000004|DoubleChain!y1|
|潜在客户|13900000005|DoubleChain!y1|
|零售商店|13900000006|DoubleChain!y1|
|零售商店的会员|13900000007|DoubleChain!y1|
|消费者的订单|13900000008|DoubleChain!y1|
|产品供应商|13900000009|DoubleChain!y1|
|供应订单|13900000010|DoubleChain!y1|
|零售商店的订单|13900000011|DoubleChain!y1|
|仓库|13900000012|DoubleChain!y1|
|货架|13900000013|DoubleChain!y1|
|运输车队|13900000014|DoubleChain!y1|
|运输任务|13900000015|DoubleChain!y1|
|会计凭证|13900000017|DoubleChain!y1|
|工资等级|13900000018|DoubleChain!y1|
|员工|13900000020|DoubleChain!y1|
|用户域|13900000021|DoubleChain!y1|



## bizcore: 服务器端核心代码项目， Business Core

后端 Java/Spring/Redis/MySQL/ArrangoDB/Kafka
Java 源代码在bizcore/WEB-INF/ 下


![ScreenShot](/doc/backend.png)
````
caf_core_src: 通用框架库核心代码，包含技术框架，基础设施
caf_custom_src: 通用框架库，主要包含配置文件
retailscm_core_src: 零售业务核心代码
retailscm_custom_src: 零售业务定制代码，如果要定制，在此处增加类，继承retail_core_src的相应类，可以调用或者重写父类，core里面的类提供大量可以重用的方法。
````

## bizui：中台集成界面项目， Business UI，不是闭嘴！
前端 React/dvajs/antd/echarts/Redux


![ScreenShot](/doc/homescreen.png)
![ScreenShot](/doc/rootapp.png)

## 配套的数据大屏

![ScreenShot](/doc/datascreen.png)

## 核心特性

* 高度可定制，增加、修改、屏蔽界面和后台功能不必更改生成代码，只是需要在custom层加入代码即可
* 模型完整，管理多个对象的整个生命周期

## 核心功能
* 平台管理，平台鸟瞰视图
* 业务开拓管理（CRM），管理联系，销售进度，完成合伙人转化
* 小超会员管理，会员管理订单，支付，邮寄地址等
* 人力资源管理（HRM），可以管理入职，绩效考核，工资发放，经验，教育经历，培训考试记录

## 欢迎加微信，共同学习探讨供应链系统以及相关技术


<img src="/doc/philip-wechat-qr.jpeg" alt="WechatQRCode" title="WechatQRCode" width="150"  />

* 探讨供应链发展趋势
* 探讨供应链相关技术和产品
* 探讨分享市场机遇
* 验证时请输入任何有关供应链相关的名词

