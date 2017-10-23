/**
 * 
 * @author leo
 *
 */
package com.leo.设计模式.工厂.简单工厂;

public abstract class Phone{
	
	void call(){
		System.out.println("打电话");
	}
	
	abstract String app();
	
}