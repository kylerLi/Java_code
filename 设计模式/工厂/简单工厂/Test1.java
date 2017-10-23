package com.leo.设计模式.工厂.简单工厂;

import org.junit.Test;

public class Test1 {
	
	@Test
	public void test1(){
		Phone p = PhoneFactory.getAppForPhone("com.leo.设计模式.工厂.简单工厂.IPhone");
		System.out.println(p.app());
	}

}
