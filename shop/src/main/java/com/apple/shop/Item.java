package com.apple.shop;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // 증가
    private Long id; //유니크 ID 추가

    @Column(nullable = false, unique = true)
    private String title; //컬럼 추가
    private Integer price; // 컬럼 추가 Int 말고 Integer 강요, 20억까지 저장.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}


