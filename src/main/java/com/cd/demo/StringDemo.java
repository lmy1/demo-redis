package com.cd.demo;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StringDemo {
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	/**
	 * 新增或修改
	 */
	@Test
	public void addOrUpadate() {
		
		redisTemplate.boundValueOps("age").set("6666667777");
	}

    public static void main(String[] args) {
		System.out.println("我是git-test远程代码");
    }

	/**
	 * 删除
	 */
	@Test
	public void delete() {
		
		redisTemplate.delete("age");	
	}
	
	/**
	 * 获取
	 */
	@Test
	public void get() {

		String age = redisTemplate.boundValueOps("access:f7d4044b-080c-4101-9a7a-5c554d55f2c6").get();
		Long expire = redisTemplate.boundValueOps("access:f7d4044b-080c-4101-9a7a-5c554d55f2c6").getExpire();
		System.out.println(age);
		System.out.println(expire);
	}
	
	/**
	 * 生命周期
	 */
	@Test
	public void exprire() {
		
		redisTemplate.boundValueOps("age").expire(2, TimeUnit.MINUTES);		//设置生命周期
		Long expire = redisTemplate.boundValueOps("age").getExpire();	//查看剩余存活时间
		System.out.println(expire);	
	}
}















