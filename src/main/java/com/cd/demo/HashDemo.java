package com.cd.demo;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HashDemo {
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	/**
	 * 新增或修改
	 */
	@Test
	public void addOrUpadate() {
		
		redisTemplate.boundHashOps("zzws_death_icd").put("Y98", "与生活方式有关的情况");
	}
	
	/**
	 * 删除hash中的值
	 */
	@Test
	public void delete() {
		
		redisTemplate.boundHashOps("lmymap").delete("field3");		
	}
	
	/**
	 * 获取hash中的值
	 */
	@Test
	public void get() {
		
		String value = (String)redisTemplate.boundHashOps("zzws_death_icd").get("Y98");
		System.out.println(value);
	}

	/**
	 * 生命周期
	 */
	@Test
	public void expire() {
		
		redisTemplate.boundHashOps("lmymap").expire(2, TimeUnit.MINUTES);
		Long expire = redisTemplate.boundHashOps("lmymap").getExpire();	//查看剩余存活时间
		System.out.println(expire);	
	}
	
	@Test
	public void expire2() {
		
		String object = (String) redisTemplate.boundHashOps("zzws_death_icd").get("Y97");
		System.out.println(object);
	}
}



















