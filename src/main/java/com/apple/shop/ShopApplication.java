package com.apple.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {

		Test Test = new Test();
		System.out.println(Test.hello());
	}
}

class Test {
	String namefirst = "kim";
	String hello() {
		return "kim";
	}

	void namehello() {
		System.out.println(namefirst);
	}
}
