# 集成供应链套件

高度可定制零售供应链中台基础系统，一共大约80万行代码(经过重构，从130万行减少到80万行），管理界面通过javascript高阶函数定制，Java后台主要通过增加方法或者重写已经存在的大量方法来灵活定制。

本系统代码是用自研知识图谱和因果网络处理系统自动生成高可维护源代码。


传统开发方式无法开发如此大规模的应用系统并且灵活变更，使用云端开发工具DaaS（Development as a Service）开发了这个平台，目前已经开放试用，10个用户模型对象以下无需注册，请参见[DaaS Start Kit](https://github.com/doublechaintech/daas-start-kit)， 这个项目的模型文件 retailscm.xml 也在里面（运行该模型需要注册）。

智能化开发的简单例子，请参见[医生排班系统](https://github.com/doublechaintech/his-biz-suite)

针对生鲜供应链, 请访问：
* https://demo.doublechaintech.com/admin/freshchain 


| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|
| 平台        | 13900000001           | admin123         |
| 商户1        | 13900000002           | admin123         |
| 商户2        | 13900000003           | admin123         |


## 目录

- [集成供应链套件](#集成供应链套件)
  - [目录](#目录)
  - [核心特性](#核心特性)
    - [架构](#架构)
      - [前端架构](#前端架构)
      - [后端架构](#后端架构)
      - [权限管理](#权限管理)
      - [部署架构](#部署架构)
    - [项目概念 来自于 数据库设计](#项目概念-来自于-数据库设计)
  - [如何使用](#如何使用)
  - [许可](#许可)
  - [技术支持](#技术支持)
  - [兼容性，以下环境测试通过](#兼容性以下环境测试通过)
  - [二次开发](#二次开发)
  - [部署](#部署)
  - [在线演示系统(不支持IE，最好使用Chrome）](#在线演示系统不支持ie最好使用chrome)
    - [总部及分支机构运营](#总部及分支机构运营)
    - [业务扩展](#业务扩展)
    - [落地业务运营](#落地业务运营)
    - [采购和供应商管理](#采购和供应商管理)
    - [仓配一体化管理](#仓配一体化管理)
    - [人力资源管理](#人力资源管理)
    - [用户权限管理](#用户权限管理)
  - [组成部分](#组成部分)
    - [bizcore: 服务器端核心代码项目， Business Core](#bizcore-服务器端核心代码项目-business-core)
    - [bizui：中台集成界面项目， Business UI，不是闭嘴！](#bizui中台集成界面项目-business-ui不是闭嘴)
    - [数据中台（独立产品在本项目应用）](#数据中台独立产品在本项目应用)
    - [配套的数据大屏](#配套的数据大屏)
    - [核心功能](#核心功能)
    - [额外数据库支持](#额外数据库支持)
  - [参与本项目](#参与本项目)
 




## 核心特性
* 本系统包括前端、后端、数据大屏，数据结构和基础数据都是通过自研软件开发开发
* 高度可定制，增加、修改、屏蔽界面和后台功能不必更改生成代码，只是需要在custom层加入代码即可，看后文解释
* 以零售平台为核心开发，集成信息流，商流，物流，资金流，人才流。

### 架构


#### 前端架构
![前端架构](/doc/front-arch.jpg)

#### 后端架构
![后端架构](/doc/backend-arch.jpg)

#### 权限管理
![权限管理](/doc/iam-arch.jpg)
#### 部署架构

![部署架构](/doc/deploy-arch.jpg)


### 项目概念 来自于 [数据库设计](/doc/retailscm-database-design.pdf)

![ScreenShot](/doc/word-cloud.png)

## 如何使用
* 在此基础上定制业务系统，可以在这个系统基础上通过前后台增加代码来定制业务系统
* 建立数据中台，这样源代码几乎不需要改动，本系统提供了大量的接口，可以让业务系统通过API插入数据，可以视作一个独立的微服务
* 用于教学和练习


## 许可

除Logo，登录页和主页图片以外，本系统源代码为Apache 2 License，可以用于商用目的

## 技术支持

本系统提供商业化系统支持和基于Issue的免费的技术支持

## 兼容性，以下环境测试通过

* 硬件环境：Amd64/ARM64/华为鲲鹏服务器
* 操作系统环境：CentOS 6+/Ubuntu 16.04+
* 数据库：MySQL 5.7+， GBase 8s，Informix 11， PostgreSQL 9.3+
* 缓存系统: Redis 3.2+
* 事件流系统: Kafka

## 二次开发
* Java开发手册请参见：https://kdocs.cn/l/sUdwkkyZD?f=130
* 数据库设计文档(共计94页）: [数据库设计](/doc/retailscm-database-design.pdf)
* 包含顺序图的详细设计文档(共计200多页）：[详细设计](/doc/retailscm-detail-design.pdf)


## 部署

如果要自行部署，请参照 [部署指南](/DEPLOYMENT.md)

## 在线演示系统(不支持IE，最好使用Chrome）


系统平台框架天然支持一个用户多个App，下面为18种角色建立了演示账户，每种角色都可以登录，代表不同用户管理的不同资源。
* 最新支持数据搜索
* 功能分组

### 总部及分支机构运营

| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|
|零售商店全国中心|13900000001|admin123|
|零售商店省中心|13900000002|admin123|
|零售商店城市服务中心|13900000003|admin123|

演示地址：https://demo.doublechaintech.com/admin/retailscm/index.html


### 业务扩展

| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|
|城市的合作伙伴|13900000004|admin123|
|潜在客户|13900000005|admin123|


演示地址：https://demo.doublechaintech.com/admin/retailscm/index.html

### 落地业务运营

| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|
|零售商店|13900000006|admin123|
|零售商店的会员|13900000007|admin123|


演示地址：https://demo.doublechaintech.com/admin/retailscm/index.html


### 采购和供应商管理
| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|
|消费者的订单|13900000008|admin123|
|产品供应商|13900000009|admin123|
|供应订单|13900000010|admin123|
|零售商店的订单|13900000011|admin123|


演示地址：https://demo.doublechaintech.com/admin/retailscm/index.html

### 仓配一体化管理
| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|
|仓库|13900000012|admin123|
|货架|13900000013|admin123|
|运输车队|13900000014|admin123|
|运输任务|13900000015|admin123|
|会计凭证|13900000017|admin123|


演示地址：https://demo.doublechaintech.com/admin/retailscm/index.html


### 人力资源管理
| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|
|工资等级|13900000018|admin123|
|员工|13900000020|admin123|


演示地址：https://demo.doublechaintech.com/admin/retailscm/index.html

### 用户权限管理

| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|
|用户域|13900000021|admin123|

演示地址：https://demo.doublechaintech.com/admin/retailscm/index.html

## 组成部分
### bizcore: 服务器端核心代码项目， Business Core

后端 Java/Spring/Redis/MySQL/ArrangoDB/Kafka
Java 源代码在bizcore/WEB-INF/ 下


![ScreenShot](/doc/backend.png)
````
caf_core_src: 通用框架库核心代码，包含技术框架，基础设施
caf_custom_src: 通用框架库，主要包含配置文件
retailscm_core_src: 零售业务核心代码
retailscm_custom_src: 零售业务定制代码，如果要定制，在此处增加类，继承retail_core_src的相应类，可以调用或者重写父类，core里面的类提供大量可以重用的方法。
````

### bizui：中台集成界面项目， Business UI，不是闭嘴！
前端 React/dvajs/antd/echarts/Redux


![ScreenShot](/doc/home-screen.jpg)
![ScreenShot](/doc/root-app.jpg)


### 数据中台（独立产品在本项目应用）

* 新一代图计算实时引擎
* 数据分析结果管理与分享
* 支持客户端通过API调用数据，实现闭环反馈
* 实时推送和订阅
演示地址：https://demo.doublechaintech.com/admin/dmos/ 
* 用户名/密码: 13900000005/admin123
* 浏览任何数据集->菜单选择->常用功能->候选数据集


![ScreenShot](/doc/dmos000.jpg)
![ScreenShot](/doc/dmos001.jpg)
![ScreenShot](/doc/dmos002.jpg)
![ScreenShot](/doc/dmos003.jpg)

### 配套的数据大屏

![ScreenShot](/doc/datascreen.png)


### 核心功能
* 平台管理，平台鸟瞰视图
* 业务开拓管理（CRM），管理联系，销售进度，完成合伙人转化
* 小超会员管理，会员管理订单，支付，邮寄地址等
* 人力资源管理（HRM），可以管理入职，绩效考核，工资发放，经验，教育经历，培训考试记录

### 额外数据库支持

目前已经支持PGSQL9.5+和GBASE 8S

## 参与本项目
<img src="/doc/philip-wechat-qr.jpeg" alt="WechatQRCode" title="WechatQRCode" width="150"  />

* 探讨供应链发展趋势
* 探讨供应链相关技术和产品
* 探讨分享市场机遇
* 验证时请输入任何有关供应链相关的名词

