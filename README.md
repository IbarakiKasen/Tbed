# Hellohao图床 - 全新响应式UI


![https://img.shields.io/badge/license-LGPL-blue.svg?style=flat-square](https://img.shields.io/badge/license-LGPL-blue.svg?longCache=true&style=flat-square)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/3b39480c887b42f1875c0210817b500f)](https://www.codacy.com/app/hello-hao/Tbed?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=hello-hao/Tbed&amp;utm_campaign=Badge_Grade)
![https://img.shields.io/badge/springboot-2.0.6-orange.svg?style=flat-square](https://img.shields.io/badge/springboot-2.0.4-yellow.svg?longCache=true&style=popout-square)


> 这是一个基于多家对象存储源的Spring Boot开源图床项目。
> 本项目使用 Spring Boot 搭建, 针对用户更方便的管理自己的图片管理拓展功能, 支持对接`本地`、`网易`，`阿里`，`又拍`，`七牛`、`腾讯`、`FTP`等多家对象存储.
> 后台对用户管理。
> 支持配置多家存储源。
> 用户注册邮箱验证，以及后台配置邮箱服务器。
> 以及图片鉴黄配置等操作。

## 主要功能支持：
 - 支持 图片拖拽、截图软件直接(Ctrl+V)和图片URL地址上传。
 - 对接本地、网易、阿里、又拍、七牛、腾讯、FTP等各大对象存储平台。
 - 图片定期暂存（到期自动删除）
 - 支持链接生成二维码。
 - 支持开启/关闭API接口。
 - URL列表、缩略图。查看原图等功能。
 - 图片鉴黄配置（开启后，每天固定时间进行非法图片监测）
 - 游客、用户的上传管理
 - 邮箱注册激活。
 - 站点样式设置和上传规则配置等。

主站地址: [http://tc.hellohao.cn/](http://tc.hellohao.cn/)

体验地址（用户名/密码均为admin）：[http://129.28.173.126:8088/](http://129.28.173.126:8088/)

文档地址: [http://doc.wwery.com/](http://doc.wwery.com/)

编译包下载: [https://github.com/Hello-hao/Tbed/releases/](https://github.com/Hello-hao/Tbed/releases/)

捐赠列表：[http://doc.wwery.com/#/reward?id=捐赠者名单](http://doc.wwery.com/#/reward?id=捐赠者名单)

## 系统预览

![Hellohao.png](http://cdn.wwery.com/Hellohao/6071c0825062730.png)

![Hellohao2.png](http://cdn.wwery.com/Hellohao/eeeed0825062727.png)

![图床后台管理.png](http://cdn.wwery.com/Hellohao/c208e0825054822.png)
![图床后台管理2.png](http://cdn.wwery.com/Hellohao/6c7690825054822.png)
![图床后台管理3.png](http://cdn.wwery.com/Hellohao/2a79b0825054822.png)
![图床后台管理4.png](http://cdn.wwery.com/Hellohao/5c1800825054824.png)

## 更新日志

**2019-11-7**

**√ 增加上传者ip记录** 

**√ 增加临时期限照片显示。**

**√ 加固系统安全性验证，防止一些非法操作。**

**√ 优化后台上传图片算法。**



## 运行环境
* JDK 1.8
* MySQL

## 项目编译
(如果你的目的是为了部署自己的图床项目，可以下滑直接用编译包按照部署教程，直接可以部署。)

### 下载项目

```git
git clone https://github.com/Hello-hao/Tbed.git
```

### 导入项目

使用自己的 Intellij IDEA 或者 Eclipse 均可.

### 导入数据库

创建数据库`picturebed`, 字符集选择 `utf8`, 排序规则选择 `utf8_general_ci`.
导入picturebed.sql

### 配置文件

打开 `application.properties` 修改 `MySQL` 和 `服务器端口` 等连接信息.

```properties
#数据库账号
spring.datasource.username=root
#数据库密码
spring.datasource.password=root
#数据库链接地址
spring.datasource.url=jdbc:mysql://localhost:3306/picturebed?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8
#端口
server.port=8088
#鉴黄周期表达式 下方表达式为每天七点半执行
#不懂请勿乱修改。具体可以参考官方文档http://doc.wwery.com
Expression=0 30 04 * * ?


#下边的配置项不需要修改。
mybatis.configuration.map-underscore-to-camel-case=true
mybatis.mapper-locations=classpath:mapper/*.xml
logging.level.cn.hellohao.dao=debug
spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
spring.jackson.time-zone=GMT+8
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
spring.thymeleaf.cache=false
multipart.maxFileSize=10240KB
multipart.maxRequestSize=10240KB
spring.thymeleaf.mode = LEGACYHTML5
spring.http.multipart.location=/data/upload_tmp

```

### 启动项目
在完成了上述步骤后，找到 TbedApplication 启动类, 启动即可.

初始用户名：admin
初始邮箱：admin
初始密码`admin`

启动后访问地址为：http://localhost:8088 , `8088`就是你配置`server.port=8088`的端口.



## 也可以直接下载编译包部署到你的服务器


> **项目搭建部署教程：**  [**http://www.hellohao.cn/?p=201**](http://www.hellohao.cn/?p=201 "点击查看搭建文档")


### 部署
前提是你的服务器必须要有`JDK1.8`环境，和`mysql`数据库。如果你是宝塔环境，就会方便一些，在应用商店安装一个`Tomcat8`因该是自带JDK1.8环境。
把`Tbed.jar`和`application.properties`放到服务器你想存放的目录比如`/home`，注意这两个文件必须要在同一目录下不能分开。
依次运行如下命令：
```shell
cd /home

java -jar Tbed.jar
```

然后访问`http://服务器IP:8088/`即可。
注意：上边的`/home`是你的jar包和application.properties文件放的目录。
项目运行起来不要关闭xshell窗口，否则项目将不能访问。可以使用一些后台命令把项目锁定后台。如`nohup`或`screen`


### PC客户端

![khd.gif](http://cdn.wwery.com/Hellohao/b1bb70927045346.gif)

如果你想让自己的图床拥有自己的客户端，可以加下方群，联系群主帮你对接（前提是你使用的是Hellohao图床程序搭建的网站。）

### 声明
本程序依照LGPL，免费提供给用户使用。


### 反馈交流
 **如果你遇到BUG可以去我的博客反馈**
Hellohao博客: [http://www.hellohao.cn/](http://www.hellohao.cn/)

欢迎加入Hellohao开发者交流群，群聊号码：**864800972**

### 捐赠开发者
**如果你也支持Hellohao图床，可以请我喝杯咖啡。我会持续更新Hellohao图床**

![](http://cdn.wwery.com/Hellohao/df2710722111702.jpg)
