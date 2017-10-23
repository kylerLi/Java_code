package com.leo.设计模式.适配器.缺省适配器;

/**
 * 缺省适配器类的子类，在没有引入适配器之前，它需要实现适配者接口，因此需要实现在适配者接口中定义的所有方法，而对于一些无须使用的方法也不得不提供空实现。
 * 在有了缺省适配器之后，可以直接继承该适配器类，根据需要有选择性地覆盖在适配器类中定义的方法
 * @author leo
 *
 */
public class DevOpsAdapter extends AbstractAdapter {

	@Override
	public void backup() {
		// TODO Auto-generated method stub
		System.out.println("应用发布实现类");
		
	}
	
	

}
