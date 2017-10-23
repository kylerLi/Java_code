package com.leo.设计模式.适配器.对象适配器;

/**
 *  操作适配器
 *  两个类之间的转换桥梁
 *  使用了对象适配器模式，同时引入了配置文件，将适配器类的类名存储在配置文件中。
 *  如果需要使用其他排序算法类和查找算法类，可以增加一个新的适配器类，使用新的适配器来适配新的算法，原有代码无须修改。通过引入配置文件和反射机制，
 *  可以在不修改客户端代码的情况下使用新的适配器，无须修改源代码，符合“开闭原则”
 * @author leo
 *
 */
public class OperationAdapter implements ScoreOperation {
	private QuickSort sortObj; // 定义适配者QuickSort对象
	private BinarySearch searchObj; // 定义适配者BinarySearch对象

	public OperationAdapter() {
		sortObj = new QuickSort();
		searchObj = new BinarySearch();
	}

	public int[] sort(int array[]) {
		return sortObj.quickSort(array); // 调用适配者类QuickSort的排序方法
	}

	public int search(int array[], int key) {
		return searchObj.binarySearch(array, key); // 调用适配者类BinarySearch的查找方法
	}
}
