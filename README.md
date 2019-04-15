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

**a.自定义sql（query by example），注意QueryDSL的框架的使用（暂未引入）；自定义sql的返回结果映射（两种方式，使用自带的entity返回后转换为需要的格式，或直接返回需要的实体？**   
**b.一对多查询）**    
**c.delete方法是逻辑删除还是物理删除，是物理删除，逻辑删除可手动写update语句，如何在spring data中将默认的delete方法修改为逻辑删除待定**

``其中Slice与Page两个接口的区别需要注意，Page功能更强，Page接口继承了Slice接口，注意返回Page与Slice的实现区别``

**存在的问题：**
- 数据库主键如何生成，系统唯一id如何生成
- 如果加了@CreatedDate 等anno，数据库使用日期存储的类型是？需考虑时区问题；如果加了CreatedBy等，如何在子系统中取得当前登录用户信息？
- connection pool使用
- 事务配置及使用
- 多数据源配置（需要连mysql与sybase两个数据库进行测试）
- 复杂场景的sql自定义查询
- spring data jpa中自带的Lock，源码javax.persistence.LockModeType，但是不建议使用该锁，原因如下：  
1、Lock加在数据库层会对数据库造成压力，且日志或debug不好查找  
2、项目若使用多个数据库，可能不同数据库之间的锁行为不一致  
3、若数据库实例为多个，则分布式环境下应使用分布式锁代替，建议在业务层通过distributed Lock组件解决  

- 自定义repository及方法、封装使所有repository都有自定义的公共方法！！
- 框架实现原理及对比Mybatis等框架