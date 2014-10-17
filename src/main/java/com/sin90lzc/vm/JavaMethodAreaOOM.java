package com.sin90lzc.vm;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 测试方法区内存溢出
 * 方法区保存的是Class的相关信息，如类名，字段描述符等等，在这里使用cglib来创建大量的类信息来使方法区内存溢出
 * 
 * 异常信息为：java.lang.OutOfMemoryError: PermGen space
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
