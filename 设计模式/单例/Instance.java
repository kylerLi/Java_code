package com.leo.设计模式.单例;

/**
 * 单例模式
 * 使用时机：
 * 
 * 懒汉模式
 * @author leo
 *
 */
public class Instance {
	
	private static  Instance instance = null;
	private Instance(){}
	/*
	 * 避免多个线程同时调用getInstance()方法，可以使用关键字synchronized添加线程锁
	 */
	public  static Instance getInstance(){
		if(instance == null){
			synchronized (Instance.class) {
				instance = new Instance();
			} 
		}
		return instance;
	}

}

/**
 * 单例模式
 * 饿汉模式
 * @author leo
 *
 */
class Resource {
	
	private static final Resource res = new Resource();
	private Resource(){}
	public static Resource getRessource(){
		return res;
	}

}
