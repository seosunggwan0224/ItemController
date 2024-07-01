package com.apple.shop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface ItemRepository extends JpaRepository<Item, Long> {


}

