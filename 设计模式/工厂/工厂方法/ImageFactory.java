package com.leo.设计模式.工厂.工厂方法;
/**
 * http://blog.csdn.net/lovelion/article/details/9307561
 * 在以下情况下可以考虑使用工厂方法模式：
       (1) 客户端不知道它所需要的对象的类。在工厂方法模式中，客户端不需要知道具体产品类的类名，只需要知道所对应的工厂即可，
                                具体的产品对象由具体工厂类创建，可将具体工厂类的类名存储在配置文件或数据库中。
       (2) 抽象工厂类通过其子类来指定创建哪个对象。在工厂方法模式中，对于抽象工厂类只需要提供一个创建产品的接口，而由其子类来确定具体要创建的对象，
                                 利用面向对象的多态性和里氏代换原则，在程序运行时，子类对象将覆盖父类对象，从而使得系统更容易扩展
 * @author leo
 *
 */
public  interface ImageFactory {
	
	public Image getImageBean();
}


/**
 * 第二种方式
 * 把图片类的方法放到抽象工厂类中，通过工厂类的getImageBean()获取实际的图片类，并调用图片的print()
 * @author leo
 *
 */
abstract class ImageAbstractFactory{
	
	public String print(){
		Image image = this.getImageBean();
		return image.print();
	}
	
	abstract Image getImageBean();
}
