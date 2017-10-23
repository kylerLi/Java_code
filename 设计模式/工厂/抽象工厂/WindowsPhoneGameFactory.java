package com.leo.设计模式.工厂.抽象工厂;

public class WindowsPhoneGameFactory implements PhoneGameFactory{

	@Override
	public InterfaceController createInterface() {
		// TODO Auto-generated method stub
		return new InterfaceController();
	}

	@Override
	public OperationController createOperation() {
		// TODO Auto-generated method stub
		return new OperationController();
	}

}
