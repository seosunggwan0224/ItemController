package com.apple.shop;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 증가
    private Integer id; //유니크 ID 추가

    @Column(nullable = false, unique = true)
    private String name; //컬럼 추가
    private Integer age; // 컬럼 추가 Int 말고 Integer 강요, 20억까지 저장.

    public void plusAge(Integer age) {

        if (age > 0 && age < 100) {
            this.age = age;
        }
        else {
            this.age = age + 1;
        }
    }

    public void setAge2(Integer age) {
        this.age = age;
    }

}
