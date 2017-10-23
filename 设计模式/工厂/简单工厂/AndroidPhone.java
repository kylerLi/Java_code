package com.leo.设计模式.工厂.简单工厂;

public class AndroidPhone extends Phone {

	public AndroidPhone() {
		System.out.println("addroid phone...");
	}
	
	@Override
	String app() {
		// TODO Auto-generated method stub
		return "android application";
	}

}
