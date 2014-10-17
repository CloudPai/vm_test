package com.sin90lzc.vm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 测试java堆内存溢出
 * 通过观察JvisualVM，可以发现新生代中Eden达到一定数值时，会进行垃圾回收，
 * 并把存活对象推入survior0或survior1，并且在多次（次数由vm参数-XX:MaxTenuringThreshold决定）
 * 回收后，会把存活对象推入老年代，老年代到达一定数值时，会进行一次full gc。
 * VM Args:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author Tim
 *
 */
public class HeapOOM {
	static class OOMObject{
		private long a=new Long(200);

		public long getA() {
			return a;
		}

		public void setA(long a) {
			this.a = a;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		List<OOMObject> list=new ArrayList<OOMObject>();
		int count=0;
		while(count<100000){
			list.add(new OOMObject());
			TimeUnit.MILLISECONDS.sleep(10);
		}
		System.out.println(list.size());
	}
}
