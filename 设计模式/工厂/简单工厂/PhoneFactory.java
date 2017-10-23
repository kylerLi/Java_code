package com.leo.设计模式.工厂.简单工厂;

/**
 * 简单工厂模式时，首先需要对产品类进行重构，不能设计一个包罗万象的产品类，而需根据实际情况设计一个产品层次结构，
 * 将所有产品类公共的代码移至抽象产品类，并在抽象产品类中声明一些抽象方法，以供不同的具体产品类来实现
 * @author leo
 *
 */
public class PhoneFactory {

	public static Phone getAppForPhone(String type){
		
		Phone phone = null;
		if("ios".equals(type)){
			phone = new IPhone();
		}else if("android".equals(type)){
			phone = new AndroidPhone();
		}
		return phone;
	}
}


/*
 * 根据手机类型返回相应的实例，不需要修改工厂类代码
 * 另一种方式是
 * 
 */
class Factory<T extends Phone> {

	@SuppressWarnings("unchecked")
	public static <T>T getAppForPhone(String type){
		try {
			return  (T) Class.forName(type).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
