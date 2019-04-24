package org.lzjay.weixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("org.lzjay")
public class WeixinApplication implements CommonsConfig {

	public static void main(String[] args) {
		SpringApplication.run(WeixinApplication.class, args);
	}
}