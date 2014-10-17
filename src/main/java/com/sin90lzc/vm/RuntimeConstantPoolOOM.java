package com.sin90lzc.vm;

import java.util.ArrayList;
import java.util.List;
/**
 * ��������ʱ���������
 * ���ڳ��������ڷ������еģ����ͨ������PermSize���Ʒ������Ĵ�С�������׳��쳣
 * Sting.intern�������ڳ������д����ַ�������������ַ��������ڣ�
 * ������׳�java.lang.OutOfMemoryError: PermGen space
 * VM args:-XX:PermSize=10m -XX:MaxPermSize=10m
 * @author Tim
 *
 */
public class RuntimeConstantPoolOOM {
	public static void main(String[] args) {
		//ʹ��List�����ų��������ã�����Full GC���ճ�������Ϊ
		List<String> list=new ArrayList<String>();
		//10MB��PermSize��integer��Χ���㹻����OOM
		int i=0;
		while(true){
			list.add(String.valueOf(i++).intern());
		}
	}
}
