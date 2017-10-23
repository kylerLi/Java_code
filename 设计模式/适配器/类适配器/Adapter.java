package com.leo.设计模式.适配器.类适配器;

/**
 * 类适配器
 * @author leo
 *
 */
public class Adapter extends Target{
	
	private Adaptee adaptee;  //适配对象的引用
	private Adapter(Adaptee adaptee){
		this.adaptee = adaptee;
	}
	
	public void request(){
		adaptee.request();  // 转发调用
	}

}
