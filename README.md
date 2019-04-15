`以下是基本的使用场景：`   

**insert**  
- 新增一条
- 批量新增

**select**
- 查询一条
- 查询多条
- 分页查询
- 分页查询且排序
- 根据条件查询（条件entity的是否赋值代表是否加入sql执行语句中？）

**delete**
- 根据主键删除
- 根据其他条件或组合条件删除所有满足条件的项

**update**
- 根据条件更新所有满足条件的项

**自定义sql**   
**自定义条件分页sql(important!!)**    
**delete方法是逻辑删除还是物理删除**

``其中Slice与Page两个接口的区别需要注意，Slice功能更强，Page接口继承了Slice接口``

**存在的问题：**
- connection pool使用
- 事务配置及使用
- 多数据源配置（需要连mysql与sybase两个数据库进行测试）
- 复杂场景的sql自定义查询
- 自定义repository及方法、封装使所有repository都有自定义的公共方法
- 框架实现原理及对比Mybatis等框架