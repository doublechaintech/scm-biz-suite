# 零售供应链中台基础系统 运行指南

系统分为前端架构和后台两个部分, 以下指令都是基于ubuntu linux 16.04LTS，不支持Tomcat服务器的war部署方式。

## 复制代码到本地

```
git clone https://github.com/doublechaintech/retailscm-biz-suite.git
```


## 前端 

### 安装nodejs
```
curl -sL https://deb.nodesource.com/setup_10.x | sudo -E bash -
sudo apt-get install -y nodejs
```

## 安装yarn 

```
curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | sudo apt-key add -
echo "deb https://dl.yarnpkg.com/debian/ stable main" | sudo tee /etc/apt/sources.list.d/yarn.list
sudo apt-get update && sudo apt-get install yarn
```
## 编译
前端使用yarn编译, 由于项目庞大, 必须设置额外的两个参数nodejs参数
* NODE_OPTIONS=--max-old-space-size=10230，增加编译内容， 或者安装并且下载 increase-memory-limit 
* PUPPETEER_SKIP_CHROMIUM_DOWNLOAD=1，不下载chromium防止下载时间过长

在 ~/.bash_profile 里面加入
export NODE_OPTIONS=--max-old-space-size=10230
export PUPPETEER_SKIP_CHROMIUM_DOWNLOAD=1

新开窗口或者执行 . ~/.bash_profile 生效, 使用 env命令可以验证



然后执行

```
cd retailscm-biz-suite/bizui/ && yarn install && yarn build

```

下载时间随网络情况而定，编译时间大约从300秒到700秒，此步骤需要一颗强劲的CPU

在bizui目录下面的dist目录就会有需要部署的所有的js文件和其他文件，可以部署到任何地方, 使用CDN对响应速度帮助很大，这个步骤是获得基于前后端分离的，基于Ant Design的前端部署包。



## 后端

后端有反向代理服务器ngnix，servlet容器Resin或者Tomcat（后期换成Spring Boot），最小配置需要数据库服务器MySQL，缓存服务器Redis组成。其他如消息服务器kafka，多层次权限管理需要图数据库arrangodb，外部email服务器，阿里云短信服务器，OSS服务器，极光app消息push服务器，区块链超级账本fabric节点。

### 下载并且解压Resin

https://caucho.com/products/resin/download/3-1/gpl

### 安装docker,并且利用国内镜像加速
```
sudo curl -sSL https://get.daocloud.io/docker | sh 
curl -sSL https://get.daocloud.io/daotools/set_mirror.sh | sh -s http://84763bc6.m.daocloud.io 
sudo groupadd docker 
sudo usermod -aG docker $USER 
```

### 安装和运行MYSQL和Redis



基本系统运行需要redis和mysql，均通过docker安装，命令如下

```
docker run -d -e MYSQL_ROOT_PASSWORD=0254891276 -p 3306:3306 --name demo_db mysql:5.7
docker run -d --name  demo_redis -p 6379:6379 redis
 
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

配置文件在bizcore/WEB-INF/retailscm_custom_src/META-INF/infra.properties里面



### 编译

java项目使用gradle来编译，为了快速开发， 我们只是把java文件编译成class，其他的目录结构保持不变，建议把输出目录直接设置为 classes并且使用resin的开发模式，这样，当class发生变更的时候，Resin会自动重新装载新的类，无需重新编译和启动，开发体验和写PHP类似。

使用最新的gradle 5.1， sdk install gradle 5.1

```
cd  retailscm-biz-suite/bizcore && gradle copyJars && gradle classes
```

这个过程大约在10多秒到20秒这样得到编译后的classes，在WEB-INF/classes

然后把执行 
```
ln -s  $PWD/bizcore  ~/resin-3.1.16/webapps/retailscm
```
### 启动Resin

```
cd  resin-3.1.16/ && bin/httpd.sh
```
这样服务器就启动了

### 访问后台

云服务器记得打开端口8080, 此步骤是运行后端，后端除了提供了REST API以外，还提供了基于JSP的操作界面，这个界面主要用于调试的时候显示大量数据用于验证程序逻辑。

```
http://localhost:8080/retailscm/secUserManager/home/
```



### 配置nginx（ 非生产环境的话，不是必要步骤）

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






