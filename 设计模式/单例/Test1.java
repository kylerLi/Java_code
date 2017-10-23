package com.leo.设计模式.单例;

import org.junit.Test;

public class Test1 {
	/*
	 * 对IoDH 单例模式的测试
	 */
	@Test
	public void test(){
		SinglonByIoDH s1 = SinglonByIoDH.getInstance();
		SinglonByIoDH s2 = SinglonByIoDH.getInstance();
		System.out.println(s1==s2);
	}
	

}
