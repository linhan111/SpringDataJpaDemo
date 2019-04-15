package com.example.SpringDataJpaDemo.domain;

import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserDemo {
    private Long id;

    private String name1;

    private String phone1;

    private String address1;

    private LocalDateTime createTime;
}
