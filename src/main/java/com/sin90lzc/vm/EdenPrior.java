package com.sin90lzc.vm;

import java.util.concurrent.TimeUnit;

/**
 * 测试虚拟机Eden优先分配的规则
 * 需要虚拟机参数：
 * -verbose:gc 打印垃圾收集日志
 * -Xms20M 堆heap的初始化内存大小
 * -Xmx20M 堆heap的最大内存大小
 * -Xmn10M 堆heap中的新生代内存大小,由于现今使用的是分代算法，因此，老年代的内存大小就是10M
 * -XX:SurvivorRatio=8 Eden与survivor的比率是8:1，在该例子中，Eden就是8M,survivor就是1M,Eden用于保存新生代，survivor用于保存老年代
 * @author Tim
 *
 */
public class EdenPrior {
	private static final int _1MB=1024*1024;
	public static void main(String[] args) throws Exception {
		
		testEdenPrior();
	}
	
	public static void testEdenPrior(){
		byte[] a1,a2,a3,a4;
		a1=new byte[_1MB*2];
		a2=new byte[_1MB*2];
		a3=new byte[_1MB*2];
		a4=new byte[_1MB*4];
	}
	
}
