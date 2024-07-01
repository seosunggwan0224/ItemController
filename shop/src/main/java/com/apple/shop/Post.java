package com.apple.shop;

import jakarta.persistence.*;
import lombok.ToString;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@Entity
@ToString
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(nullable = false, unique = true)
    public String title;
    public LocalDate date;
}


