package com.man.consumer.ctrl;

import com.man.common.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yaoyaolei on 2019/10/1 11:49
 */
@RestController
@RequestMapping("/user")
public class UserCtrl {

	private static final Logger logger = LoggerFactory.getLogger(UserCtrl.class);

	/**
	 * 直连 需指定服务地址 端口与服务提供者 一致
	 * 加version = "v1.0.0"报错, "Failed to invoke remote method: sayHello
	 * channel: consumer: /192.168.1.11:54088 --> provider: /192.168.1.11:12345
	 */
	@Reference(url = "dubbo://127.0.0.1:12345")
	private UserService userService;


	@GetMapping("/hello/{name}")
	public String sayHello(@PathVariable String name) {
		logger.info("----------> consumer ----------->");
		return userService.sayHello(name);
	}

}
