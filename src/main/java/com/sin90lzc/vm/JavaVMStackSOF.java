package com.sin90lzc.vm;

/**
 * ���Ե��߳������ջ���
 * ��������ڵ����߳�������ջ֡��ɵ�ջ��������Ǳ�java.lang.StackOverflowError
 * 
 * VM args:-Xss128k
 * @author Tim
 *
 */
public class JavaVMStackSOF {
	private int stackLength=1;
	public void stackLeak(){
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) throws Throwable{
		JavaVMStackSOF oom=new JavaVMStackSOF();
		try{
			oom.stackLeak();
		}catch(Throwable e){
			System.out.println("stack length:"+ oom.stackLength);
			throw e;
		}
	}
}
