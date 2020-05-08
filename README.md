### 商城项目

```
/document   # 保存文档文件如 sql文件
/forever-mall-common # 工具包
/forever-mall-controller #controller层
/forever-mall-service    # service层
/forever-mall-mapper	# 数据映射层
/forever-mall-pojo		# pojo层
```

### 使用方式

1. 导入idea中 
2. 创建数据库 forever_mall, 并把`/document`下的sql文件导入数据库中
3. 修改`/forever-mall-controller/resource`下的`application.yml`配置文件，重点是数据库名，用户名和密码
4. 因为是maven聚合项目，所以使用maven的install 来编译文件。如果没有报错即编译成功。
5. 运行`controller`下的MallControllerApplication,即可启动项目，可以使用postman调试
6. mapper层用的是tkmapper生成的，自带一些方法可以操作数据库，不需要自己写sql语句了，但是扫描mapper类需要在Application类指定@MapperScan注解，

dsf