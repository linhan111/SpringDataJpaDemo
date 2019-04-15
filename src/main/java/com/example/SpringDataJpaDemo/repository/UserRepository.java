package com.example.SpringDataJpaDemo.repository;

import com.example.SpringDataJpaDemo.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 根据姓名查询用户
     *
     * @param name 姓名
     * @return User
     */
    User findByName(String name);

    /**
     * 查询满足条件或排序结果的top条，缺省则为1
     *
     * @return List<User>
     */
    List<User> findTop10ByOrderByIdDesc();

    /**
     * nativeQuery的属性表示是否使用本地sql来执行，比如jpa中未提供的union等操作则需要使用，但是这样jpa就和数据库耦合起来，注意取舍
     * 如果使用了原生sql，则语句中的entity对象则失效，需要修改为表名
     *
     * @param name name
     * @return List<name>
     */
    @Query(value = "select t1 from User as t1 where t1.name like %:name1%", nativeQuery = false)
    List<User> findUserByName(@Param("name1") String name);

    /**
     * 原生sql，分页情况下需要对count sql自定义 jpa暂时未集成
     *
     * @param name     name
     * @param pageable 分页对象
     * @return Page<User>
     */
    @Query(value = "select t1 from user as t1 where t1.name like %?1%", nativeQuery = true,
           countQuery = "select count(*) from user as t1 where t1.name like %?1%")
    Page<User> findPageUserByName(String name, Pageable pageable);
}
