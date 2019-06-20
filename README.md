# 集成供应链套件

零售供应链中台基础系统，一共大约130万行代码，管理界面通过javascript高阶函数定制，Java后台主要通过增加方法或者重写已经存在的大量方法来灵活定制。

本系统代码是用自研知识图谱和因果网络处理系统自动生成高可维护源代码。


概念和关系请请见：https://demo.doublechaintech.com/admin/retailscm/entities.html , 图比较大，需要拖动

[部署指南 ](/DEPLOYMENT.md)

智能化开发的简单例子，请参见[医生排班系统](https://github.com/doublechaintech/his-biz-suite)

## 核心特性
* 本系统包括前端、后端、数据大屏，数据结构和基础数据都是通过自研软件开发开发
* 高度可定制，增加、修改、屏蔽界面和后台功能不必更改生成代码，只是需要在custom层加入代码即可，看后文解释
* 以零售平台为核心开发，集成信息流，商流，物流，资金流，人才流。


## 如何使用
* 在此基础上定制业务系统，可以在这个系统基础上通过前后台增加代码来定制业务系统
* 建立数据中台，这样源代码几乎不需要改动，本系统提供了大量的接口，可以让业务系统通过API插入数据，可以视作一个独立的微服务
* 用于教学和练习

## 许可

除Logo，登录页和主页图片以外，本系统源代码为Apache 2 License，可以用于商用目的

## 技术支持

本系统提供商业化系统支持和基于Issue的免费的技术支持


## 在线演示系统(不支持IE，最好使用Chrome）


系统平台框架天然支持一个用户多个App，下面为18种角色建立了演示账户，每种角色都可以登录，代表不同用户管理的不同资源。



### 总部及分支机构运营

| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|
|零售商店全国中心|13900000001|admin123|
|零售商店省中心|13900000002|admin123|
|零售商店城市服务中心|13900000003|admin123|

演示地址：https://demo.doublechaintech.com/admin/retailscm/#/home


### 业务扩展

| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|
|城市的合作伙伴|13900000004|admin123|
|潜在客户|13900000005|admin123|


演示地址：https://demo.doublechaintech.com/admin/retailscm/#/home

### 落地业务运营

| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|
|零售商店|13900000006|admin123|
|零售商店的会员|13900000007|admin123|


演示地址：https://demo.doublechaintech.com/admin/retailscm/#/home


### 采购和供应商管理
| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|
|消费者的订单|13900000008|admin123|
|产品供应商|13900000009|admin123|
|供应订单|13900000010|admin123|
|零售商店的订单|13900000011|admin123|


演示地址：https://demo.doublechaintech.com/admin/retailscm/#/home

### 仓配一体化管理
| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|
|仓库|13900000012|admin123|
|货架|13900000013|admin123|
|运输车队|13900000014|admin123|
|运输任务|13900000015|admin123|
|会计凭证|13900000017|admin123|


演示地址：https://demo.doublechaintech.com/admin/retailscm/#/home


### 人力资源管理
| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|
|工资等级|13900000018|admin123|
|员工|13900000020|admin123|


演示地址：https://demo.doublechaintech.com/admin/retailscm/#/home

### 用户权限管理

| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|
|用户域|13900000021|admin123|

演示地址：https://demo.doublechaintech.com/admin/retailscm/#/home

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


![ScreenShot](/doc/home-screen.jpg)
![ScreenShot](/doc/root-app.jpg)

## 配套的数据大屏

![ScreenShot](/doc/datascreen.png)


## 核心功能
* 平台管理，平台鸟瞰视图
* 业务开拓管理（CRM），管理联系，销售进度，完成合伙人转化
* 小超会员管理，会员管理订单，支付，邮寄地址等
* 人力资源管理（HRM），可以管理入职，绩效考核，工资发放，经验，教育经历，培训考试记录

## 额外数据库支持

目前已经支持PGSQL9.5+和GBASE 8S

* PGSQL版本 https://demo.doublechaintech.com/admin/retailscmpgsql/index.html, 密码为: admin123
* GBASE版本 https://demo.doublechaintech.com/admin/retailscmgbase/index.html, 密码为: DoubleChain!y1


## 欢迎加微信，共同学习探讨供应链系统以及相关技术


<img src="/doc/philip-wechat-qr.jpeg" alt="WechatQRCode" title="WechatQRCode" width="150"  />

* 探讨供应链发展趋势
* 探讨供应链相关技术和产品
* 探讨分享市场机遇
* 验证时请输入任何有关供应链相关的名词

