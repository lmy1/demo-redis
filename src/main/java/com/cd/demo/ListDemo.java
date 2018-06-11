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
public class ListDemo {
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	/**
	 * 新增或修改
	 */
	@Test
	public void addOrUpadate() {
		
		redisTemplate.boundListOps("lmylist").rightPush("ccc");
	}

	/**
	 * 删除
	 * 
	COUNT 的值可以是以下几种：
    count > 0 : 从表头开始向表尾搜索，移除与 VALUE 相等的元素，数量为 COUNT 。
    count < 0 : 从表尾开始向表头搜索，移除与 VALUE 相等的元素，数量为 COUNT 的绝对值。
    count = 0 : 移除表中所有与 VALUE 相等的值。
	 */
	@Test
	public void delete() {
		
		redisTemplate.boundListOps("lmylist").remove(1, "aaa");
	}
	
	/**
	 * 获取
	 */
	@Test
	public void get() {

		String result = redisTemplate.boundListOps("lmylist").index(1);		//获取索引为1的元素
		System.out.println(result);
	}
	
	/**
	 * 生命周期
	 */
	@Test
	public void exprire() {
		
		redisTemplate.boundListOps("lmylist").expire(2, TimeUnit.MINUTES);		//设置生命周期
		Long expire = redisTemplate.boundListOps("lmylist").getExpire();	//查看剩余存活时间
		System.out.println(expire);	
	}
}















