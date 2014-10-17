package com.sin90lzc.vm;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * ���Է������ڴ����
 * �������������Class�������Ϣ�����������ֶ��������ȵȣ�������ʹ��cglib����������������Ϣ��ʹ�������ڴ����
 * 
 * �쳣��ϢΪ��java.lang.OutOfMemoryError: PermGen space
 * VM args:-XX:PermSize=10m -XX:MaxPermSize=10m
 * @author Tim
 *
 */
public class JavaMethodAreaOOM {
public static void main(String[] args) {
	while(true){
		Enhancer enhancer=new Enhancer();
		enhancer.setSuperclass(OOMObject.class);
		enhancer.setCallback(new MethodInterceptor() {
			
			public Object intercept(Object obj, Method method, Object[] args,
					MethodProxy proxy) throws Throwable {
				return proxy.invokeSuper(obj, args);
			}
		});
		enhancer.create();
	}
}

static class OOMObject{
	
}
}
