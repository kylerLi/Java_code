package com.leo.设计模式.工厂.抽象工厂;

import org.junit.Test;

public class Test1 {
	@Test
	public void test(){
		PhoneGameFactory pgameFactory = new IosPhoneGameFactory();
		OperationController operationController = pgameFactory.createOperation();
		operationController.action();
	}
}
