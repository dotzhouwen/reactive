package com.zw.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class User {
    private String name;
    private String gender;
    private Integer age;
}
