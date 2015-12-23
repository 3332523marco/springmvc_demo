package com.springmvc.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.springmvc.entity.UserEntity;
//这一步肯定少不了，前面有介绍就不再介绍了
@Controller
// 定义访问注册接口的父路径，前面有介绍也不多介绍了
@RequestMapping("RegisteredController")
public class RegisteredController {

	private Map<String, Object> map;
	// 由于是提交数据所以我们这里使用POST请求
	@RequestMapping(value = "/registered_post.json", method = RequestMethod.POST)
	@ResponseBody
// 此处@ModelAttribute 可以吧POST请求所携带的json字符串自动解析成后面所写的实体类
// ，然后就直接可以通过这个UserEntity取到Android端传过来的数据
	public Object registered(@ModelAttribute UserEntity entity) {
		String username = entity.getUsername();
		String password = entity.getPassword();
		String nickname = entity.getNickname();
		String gender = entity.getGender();
		String age = entity.getAge();

		map = new HashMap<>();
		if (username != null && password != null && nickname != null
				&& gender != null && age != null) {
// 成功返回消息告诉客户端
			map.put("msg", "注册成功！");
			return map;
		} else {
// 失败返回消息告诉客户端
			map.put("msg", entity);

			return map;
		}
	}
}