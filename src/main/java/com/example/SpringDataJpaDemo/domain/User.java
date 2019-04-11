package com.example.SpringDataJpaDemo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Accessors(chain = true)
@ToString
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * name
     */
    @Column(name = "name", length = 50)
    private String name;

    /**
     * phone
     */
    @Column(name = "phone", length = 50)
    private String phone;

    /**
     * address
     */
    @Column // 省略默认列名就是属性名
    private String address;

    @CreatedDate
    @Column(name = "create_time")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}
