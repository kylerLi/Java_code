package com.leo.设计模式.工厂.简单工厂;

public class IPhone extends Phone {

	public IPhone(){
		System.out.println("apple phone...");
	}
	@Override
	String app() {
		// TODO Auto-generated method stub
		return "apple application";
	}

}
