# retailscm-biz-suite
Retail Supply Chain Management Suite




##演示地址

https://demo.doublechaintech.com/admin/retailscm/#/home

用户名：SU000002
密码：DoubleChain!y1

## bizcore: 服务器端核心代码项目， Business Core

后端 Java/Spring/Redis/MySQL/ArrangoDB/Kafka
Java 源代码在bizcore/WEB-INF/ 下


![ScreenShot](/doc/backend.png)

caf_core_src: 通用框架库核心代码，包含技术框架，基础设施
caf_custom_src: 通用框架库，主要包含配置文件
retail_core_src: 零售业务核心代码
retail_custom_src: 零售业务定制代码，如果要定制，在此处增加类，继承retail_core_src的相应类，可以调用或者重写父类，core里面的类提供大量可以重用的方法。

## bizui：中台集成界面项目， Business UI，不是闭嘴！
前端 React/dvajs/antd/echarts/Redux


![ScreenShot](/doc/homescreen.png)
![ScreenShot](/doc/rootapp.png)

