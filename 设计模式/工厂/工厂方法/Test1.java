package com.leo.设计模式.工厂.工厂方法;

import org.junit.Test;

public class Test1 {
	
	@Test
	public void test1(){
		ImageFactory imageFactory = new JpgImageFactory();
		Image image = imageFactory.getImageBean();
		System.out.println(image.print());
	}
	
	/*
	 * 直接使用工厂类调用图像类的业务方法
	 */
	@Test
	public void test2(){
		ImageAbstractFactory imageFactory = new JpgImageFactory2();
		System.out.println(imageFactory.print());
	}

}
