package com.sin90lzc.vm;

import java.util.ArrayList;
import java.util.List;
/**
 * 测试运行时常量池溢出
 * 由于常量池是在方法区中的，因此通过参数PermSize限制方法区的大小来尽早抛出异常
 * Sting.intern方法会在常量池中创建字符串对象（如果该字符串不存在）
 * 这里会抛出java.lang.OutOfMemoryError: PermGen space
 * VM args:-XX:PermSize=10m -XX:MaxPermSize=10m
 * @author Tim
 *
 */
public class RuntimeConstantPoolOOM {
	public static void main(String[] args) {
		//使用List保持着常量池引用，避免Full GC回收常量池行为
		List<String> list=new ArrayList<String>();
		//10MB的PermSize在integer范围内足够产生OOM
		int i=0;
		while(true){
			list.add(String.valueOf(i++).intern());
		}
	}
}
