package com.sin90lzc.vm;

import java.util.concurrent.TimeUnit;

/**
 * ���������Eden���ȷ���Ĺ���
 * ��Ҫ�����������
 * -verbose:gc ��ӡ�����ռ���־
 * -Xms20M ��heap�ĳ�ʼ���ڴ��С
 * -Xmx20M ��heap������ڴ��С
 * -Xmn10M ��heap�е��������ڴ��С,�����ֽ�ʹ�õ��Ƿִ��㷨����ˣ���������ڴ��С����10M
 * -XX:SurvivorRatio=8 Eden��survivor�ı�����8:1���ڸ������У�Eden����8M,survivor����1M,Eden���ڱ�����������survivor���ڱ��������
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
