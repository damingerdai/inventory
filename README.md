# inventory
一个基于Spring WebFlux的礼品库存管理系统Demo

# 运行
## 下载：
```
git clone https://github.com/damingerdai/inventory.git
```

## 数据库
打开sql目录，按照需要执行对应的sql文件
1. 数据库和表结构: ds.sql
2. 初始数据: data.sql

## 编译angular
1. 进入src/main/angular目录下，执行：
```
npm install && ng build --prod
```

## 执行
```
mvn spring-boot:run
```
然后在浏览器中打开：http://127.0.0.1:8080/index.html

## 截图
![主页面](https://raw.githubusercontent.com/damingerdai/inventory/master/screenshots/home.PNG)