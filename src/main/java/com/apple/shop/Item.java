package com.apple.shop;

import jakarta.persistence.*;
import lombok.ToString;

@Entity
@ToString
public class Item {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    static String title;
    public Integer price;

}

class 클래스1 extends Item {

}
