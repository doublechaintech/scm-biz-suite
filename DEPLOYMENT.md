


# 供应链中台基础系统 运行指南

系统分为前端架构和后台两个部分, 以下指令都是基于ubuntu linux 16.04LTS和ubuntu linux 18.04LTS，支持使用resin和SpringBoot来部署，不支持Tomcat服务器的war部署方式。

## 目录

- [供应链中台基础系统 运行指南](#供应链中台基础系统-运行指南)
	- [目录](#目录)
	- [软件兼容性](#软件兼容性)
		- [运行时环境](#运行时环境)
		- [编译时环境](#编译时环境)
	- [复制代码到本地](#复制代码到本地)
	- [编译部署前端](#编译部署前端)
		- [安装nodejs](#安装nodejs)
		- [安装yarn](#安装yarn)
		- [编译前端](#编译前端)
	- [编译和部署后端](#编译和部署后端)
		- [安装基础环境](#安装基础环境)
		- [下载并且解压Resin](#下载并且解压resin)
		- [安装docker](#安装docker)
		- [安装和运行MYSQL和Redis](#安装和运行mysql和redis)
		- [修改MYSQL字符集（非生产环境可以忽略此步骤）](#修改mysql字符集非生产环境可以忽略此步骤)
		- [编译后端](#编译后端)
		- [启动Resin](#启动resin)
		- [访问后台](#访问后台)
	- [体验和优化](#体验和优化)
		- [测试前端](#测试前端)
		- [配置nginx](#配置nginx)
		- [SpringBoot开发指南](#springboot开发指南)

## 软件兼容性

### 运行时环境

|  软件类型   | 版本  |
|  ----  | ----  |
| 硬件架构  | x86_64/AMD64/华为鲲鹏/龙芯 |
| 操作系统  | Ubuntu 16.04LTS/18.04LTS/20.04LTS/ |
| JDK  | Open JDK 8|
| 应用服务器 | Resin3.1.16, 可另选SpringBoot |
| 缓存怒服务器 | Redis3.2+ |
| 数据库  | MySQL 5.7+, Oracle 12.2+ , Postgres 9.5+, 南大通用GBASE 8|
| Nginx  |  1.10+ |
| Docker  |  18+ |
| Browser  |  Chrome 65+/Safari 13+/Microsoft Edge 基于Chromium的最新版 |


### 编译时环境

|  软件类型   | 版本  |
|  ----  | ----  |
| 操作系统  | Ubuntu 16.04LTS/18.04LTS/20.04LTS/Mac/Windows 7+ |
| JDK  | Open JDK 8|
| gradle  | 5.3+ |
| yarn  | 1.10.3+ |
| node  |  8+, LTS |






## 复制代码到本地

```
git clone https://github.com/doublechaintech/retailscm-biz-suite.git
```


## 编译部署前端 



### 安装nodejs
```
curl -sL https://deb.nodesource.com/setup_10.x | sudo -E bash -
sudo apt-get install -y nodejs
```

### 安装yarn 

注意：前端编译涉及到没有移植版本的x64/x86代码无法在在鲲鹏服务器上完成

```
curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | sudo apt-key add -
echo "deb https://dl.yarnpkg.com/debian/ stable main" | sudo tee /etc/apt/sources.list.d/yarn.list
sudo apt-get update && sudo apt-get install yarn
```
### 编译前端
前端使用yarn编译, 由于项目庞大, 编译的计算机至少具有空闲6G~8G内存，而且必须设置额外的两个参数nodejs参数
* NODE_OPTIONS=--max-old-space-size=10230，增加编译内容， 或者安装并且下载 increase-memory-limit 
* PUPPETEER_SKIP_CHROMIUM_DOWNLOAD=1，不下载chromium防止下载时间过长

在 ~/.bash_profile 里面加入
```
export NODE_OPTIONS=--max-old-space-size=10230
export PUPPETEER_SKIP_CHROMIUM_DOWNLOAD=1
```

不设置环境变量会导致

```
==== JS stack trace =========================================

    0: ExitFrame [pc: 0x1b1e8aadbe1d]
    1: StubFrame [pc: 0x1b1e8d56aba2]
Security context: 0x2be87309e6e9 <JSObject>
    2: getOptions(aka getOptions) [0x19d718b916d1] [/home/philip/githome/retailscm-biz-suite/bizui/node_modules/acorn/dist/acorn.js:403] [bytecode=0x19e0b9bbeaa9 offset=85](this=0x1a01d14026f1 <undefined>,opts=0x0b7c125f33f9 <Object map = 0x27e6b3c63c59>)
    3: new constructor(aka Parser) [0x41cc263b091] [/home/philip/g...

FATAL ERROR: Ineffective mark-compacts near heap limit Allocation failed - JavaScript heap out of memory
 1: 0x8fa0c0 node::Abort() [/usr/bin/node]

```


新开窗口或者执行 . ~/.bash_profile 生效, 使用 env命令可以验证, 



然后执行

```
cd retailscm-biz-suite/bizui/ && yarn install && yarn build

```

如何之前使用过旧的版本，可能出现错误，
```
bizui/src/index.js: helpers(...).minVersion is not a function
```
解决办法，清理掉node_modules

```
rm -rf node_modules && yarn install && yarn build
```

下载时间随网络情况而定，编译时间大约从300秒到700秒，此步骤需要一颗强劲的CPU

在bizui目录下面的dist目录就会有需要部署的所有的js文件和其他文件，可以部署到任何地方, 使用CDN对响应速度帮助很大，这个步骤是获得基于前后端分离的，基于Ant Design的前端部署包。



## 编译和部署后端

必须的部分
* servlet容器Resin（Spring Boot），
* 数据库服务器MySQL（必须）
* 缓存服务器Redis（必须）

可选下面组件构成
* ngnix（可选），用于配置HTTPS, 反向代理，压缩，生产环境部署必须
* 消息服务器kafka，用户实时数据流分析
* 多层次权限管理需要图数据库arrangodb，用户实时数据流关联分析和实时大屏，运算
* 外部email服务器，SMTP
* 云服务根据应用阿里云短信服务器，OSS服务器，极光app消息push服务器，区块链超级账本fabric节点


### 安装基础环境


安装sdkman然后安装gradle

```
curl -s "https://get.sdkman.io" | bash
```
使用 Gradle 5.3，可以使用最新版 

```
sdk install gradle 5.3
```



安装Java 8， 一定得Java 8， 我们这里选择Amazon的JDK8其他版本未经测试
```
sdk install java 8.0.242-amzn 
```

提示，可以通过 sdk list java 来查询可以安装的版本, 查询结果如下
```
================================================================================
Available Java Versions
================================================================================
 Vendor        | Use | Version      | Dist    | Status     | Identifier
--------------------------------------------------------------------------------
 AdoptOpenJDK  |     | 14.0.0.j9    | adpt    |            | 14.0.0.j9-adpt      
               |     | 14.0.0.hs    | adpt    |            | 14.0.0.hs-adpt      
               |     | 13.0.2.j9    | adpt    |            | 13.0.2.j9-adpt      
               |     | 13.0.2.hs    | adpt    |            | 13.0.2.hs-adpt      
               |     | 12.0.2.j9    | adpt    |            | 12.0.2.j9-adpt      
               |     | 12.0.2.hs    | adpt    |            | 12.0.2.hs-adpt      
               |     | 11.0.6.j9    | adpt    |            | 11.0.6.j9-adpt      
               |     | 11.0.6.hs    | adpt    |            | 11.0.6.hs-adpt      
               |     | 8.0.242.j9   | adpt    |            | 8.0.242.j9-adpt     
               |     | 8.0.242.hs   | adpt    |            | 8.0.242.hs-adpt     
 Amazon        |     | 11.0.6       | amzn    |            | 11.0.6-amzn         
               |     | 8.0.242      | amzn    |            | 8.0.242-amzn  
	       ...
```


### 下载并且解压Resin

https://caucho.com/products/resin/download/3-1/gpl

### 安装docker

利用国内镜像加速, 登出之后组权限才生效，此后就有以普通用户运行docker

```
sudo curl -sSL https://get.daocloud.io/docker | sh 
curl -sSL https://get.daocloud.io/daotools/set_mirror.sh | sh -s http://84763bc6.m.daocloud.io 
sudo groupadd docker 
sudo usermod -aG docker $USER 
exit
```

### 安装和运行MYSQL和Redis




基本系统运行需要redis和mysql，均通过docker安装，命令如下

```
docker run -d -e MYSQL_ROOT_PASSWORD=0254891276 -p 3306:3306 --name demo_db mysql:5.7
docker run -d --name  demo_redis -p 6379:6379 redis
```

另外，如果需要在鲲鹏服务器上，docker命令有所不同，跟我们常用服务器不同，鲲鹏服务器是ARM64架构

```
docker run --name demo-redis -d arm64v8/redis
docker run --name demo-mariadb -e MYSQL_ROOT_PASSWORD=0254891276 -d arm64v8/mariadb
```



### 修改MYSQL字符集（非生产环境可以忽略此步骤）

请注意，mysql5.7默认的字符集不是utf8mb4, 需求修改相关配置来支持utf8mb4

容器内文件/etc/mysql/my.cnf内容

```

[client]
default-character-set = utf8mb4

[mysql]
default-character-set = utf8mb4

[mysqld]
character-set-client-handshake = FALSE
character-set-server = utf8mb4
collation-server = utf8mb4_unicode_ci
default-time-zone =+08:00


```

MySQL的初始化脚本问题文件在 bizcore/WEB-INF/retailscm_core_src/META-INF/retailscm_mysql.sql下面

```
cd retailscm-biz-suite && mysql -uroot -p0254891276 -h 127.0.0.1 < bizcore/WEB-INF/retailscm_core_src/META-INF/retailscm_mysql.sql
```

配置文件在bizcore/WEB-INF/retailscm_custom_src/META-INF/infra.properties里面



### 编译后端

java项目使用gradle来编译，为了快速开发， 我们只是把java文件编译成class，其他的目录结构保持不变，建议把输出目录直接设置为 classes并且使用resin的开发模式，这样，当class发生变更的时候，Resin会自动重新装载新的类，无需重新编译和启动，开发体验和写PHP类似。



编译后台，gradle copyJars将为你准备好工作环境

```
cd  retailscm-biz-suite/bizcore && gradle copyJars && gradle classes
```

gradle编译过程大约持续10秒到20秒这样得到编译后的classes，生成的位置在WEB-INF/classes目录下

通过执行如下命令，把项目工程连接到Resin下，这样就可以以retailscm名字来启动webapp
```
ln -s  ~/retailscm-biz-suite/bizcore  ~/resin-3.1.16/webapps/retailscm
```
### 启动Resin
准备后了就可以启动后端
```
cd  resin-3.1.16/ && bin/httpd.sh
```
这样服务器就启动了

### 访问后台

此步骤是运行后端，后端除了提供了REST API以外，还提供了基于JSP的操作界面，这个界面主要用于调试的时候显示大量相互关联的数据用于验证程序逻辑。

```
http://localhost:8080/retailscm/secUserManager/home/
```
输入用户名密码：13900000001/admin123登录

云服务器记得打开端口8080, 此时没有文件启用压缩，使用1M的带宽装载速度会比较慢。


## 体验和优化

### 测试前端

```
mkdir -p ~/resin-3.1.16/webapps/ROOT/admin
cd  retailscm-biz-suite/bizui && cp -R dist/* ~/resin-3.1.16/webapps/ROOT/admin
```
访问 http://localhost:8080/admin/index.html



### 配置nginx

非生产环境的话，不是必要步骤

这一步非常简单，拷贝下面内容文件到 ubuntu上 /etc/nginx/sites-enabled/demo, 然后 service ngnix restart
请注意替换服务器名字
server_name demo.doublechaintech.com;

```

server {

	gzip on;
	gzip_disable "msie6";
	
	gzip_comp_level 6;
	gzip_min_length 1100;
	gzip_buffers 16 8k;
	gzip_proxied any;
	gzip_types
	    text/plain
	    text/css
	    text/js
	    text/xml
	    text/javascript
	    application/javascript
	    application/x-javascript
	    application/json
	    application/xml
	    application/rss+xml
	    image/svg+xml;

	root /var/www/html;

	index index.html index.htm index.nginx-debian.html;

	server_name demo.doublechaintech.com;

	location / {

	        proxy_pass http://127.0.0.1:8080;
        	proxy_set_header        Host               $host;
        	proxy_set_header        X-Real-IP          $remote_addr;
        	proxy_set_header        X-Forwarded-For    $proxy_add_x_forwarded_for;
        	proxy_set_header        X-Forwarded-Host   $host;
        	proxy_set_header        X-Forwarded-Server $host;
        	proxy_set_header        X-Forwarded-Port   80;
        	proxy_set_header        X-Forwarded-Proto  http;
       }
}
```



### SpringBoot开发指南

在正式生产环境下，使用SpringBoot部署更容易，源代码的位置在：

com.skynet.bootstrap.AppEntrance

```
public class AppEntrance {
    public static void main(String[] args) {
        SpringApplication.run(AppEntrance.class, args);
    }

    @Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean reg = new ServletRegistrationBean(dispatcherServlet);
        reg.getUrlMappings().clear();
        reg.addUrlMappings("*.css");
        reg.addUrlMappings("*.txt");
        reg.addUrlMappings("*.js");
        reg.addUrlMappings("*.jpg");
        return reg;
    }
}

```
最新的SpringBoot2.1.6配置文件 retailscm_custom_src/application.properties, 确保能够重载已经存在的bean来修改相关行为。

```
server.servlet.context-path=/retailscm
spring.main.allow-bean-definition-overriding=true
```






