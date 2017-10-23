package com.leo.设计模式.工厂.抽象工厂;

public interface PhoneGameFactory {
	
	public InterfaceController createInterface();
	public OperationController createOperation();
	
}
