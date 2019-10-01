package com.man.provider.service;

import com.man.common.service.UserService;
import org.apache.dubbo.config.annotation.Service;

/**
 * Created by yaoyaolei on 2019/10/1 11:47
 */
@Service
//		(version = "v1.0.0") 加版本号报错
public class UserServiceImpl implements UserService {

	@Override
	public String sayHello(String name) {
		return "Hello " + name;
	}

}
