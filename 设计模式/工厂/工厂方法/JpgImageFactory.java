package com.leo.设计模式.工厂.工厂方法;

public class JpgImageFactory implements ImageFactory {

	@Override
	public Image getImageBean() {
		// TODO Auto-generated method stub
		JpgImage jpg = new JpgImage();
		return jpg;
	}

}

class JpgImageFactory2 extends ImageAbstractFactory{

	@Override
	Image getImageBean() {
		// TODO Auto-generated method stub
		JpgImage jpg = new JpgImage();
		return jpg;
	}
	
}
