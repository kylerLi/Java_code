package com.leo.设计模式.适配器.缺省适配器;

/**
 * 缺省适配器模式的核心类，使用空方法的形式实现了在Application接口中声明的方法。
 * 通常将它定义为抽象类，因为对它进行实例化没有任何意义
 * @author leo
 *
 */
public abstract class AbstractAdapter implements Application{

	public void publish(){
		System.out.println("默认实现");
	};
	public void restore(){
		System.out.println("默认实现");
	};
}
