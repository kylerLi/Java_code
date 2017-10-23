package com.leo.设计模式.工厂.工厂方法;

public class PngImageFactory implements ImageFactory {

	@Override
	public Image getImageBean() {
		PngImage p = new PngImage();
		return p;
	}
	
	

}
