package com.leo.设计模式.单例;

/**
 * Initialization Demand Holder (IoDH)
 * 通过使用IoDH，我们既可以实现延迟加载，又可以保证线程安全，不影响系统性能
 * @author leo
 *
 */
public class SinglonByIoDH {
	
	private SinglonByIoDH(){}
	
	private static  class Handler{
		private static final SinglonByIoDH singlon = new SinglonByIoDH();
	}
	
	public static SinglonByIoDH getInstance(){
		return Handler.singlon;
	}
	
}
