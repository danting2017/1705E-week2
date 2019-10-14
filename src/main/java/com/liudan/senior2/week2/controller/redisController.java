package com.liudan.senior2.week2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.liudan.senior2.week2.domain.Goods;

@Controller
public class redisController {

	@Autowired
	RedisTemplate redisTemplate;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("findAll")
	public String findAll(Model m,@RequestParam(defaultValue = "1")Integer page,
			@RequestParam(defaultValue = "10")Integer pageSize) {
		List<Goods> list = new ArrayList<Goods>();
		//从redisTemplate中准备移除里面的元素
		List<Goods> leftPop = (List<Goods>) redisTemplate.opsForList().leftPop("goods_list");
		//循环遍历看看里面有什么元素
		for (Goods goods : leftPop) {
			System.out.println(goods);
		}
		//存到model作用域中
		m.addAttribute("leftPop", leftPop);
		//跳转到页面
		return "list";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("findAllByZset")
	public String findAllByZset(Model m,@RequestParam(defaultValue = "1")Integer page,
			@RequestParam(defaultValue = "10")Integer pageSize) {
		//从redisTemplate取出元素
		Set range = redisTemplate.opsForZSet().reverseRange("ZSet", (page-1)*pageSize, (page-1)*pageSize+pageSize-1);
		//循环遍历里面有什么元素
		for (Object object : range) {
			System.out.println(object);
		}
		//跳转到页面
		return "listbyzset";
		
	}
}
