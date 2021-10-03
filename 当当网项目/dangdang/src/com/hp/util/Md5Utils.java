package com.hp.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;
 
public class Md5Utils {
	
	//����1:������������
	public static String  getMd5Code(String password){
		StringBuilder sb = null;
		try {
			//�������ܶ���
			//����1: �㷨����
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			//���м���  ���ؼ���֮����Ҳ���ֽ�
			byte[] digest = messageDigest.digest(password.getBytes());
			sb = new StringBuilder();
			for (byte b : digest) {
				//λ����
				int len = b & 0xff;    //0  0x0 0x1 0x2 0x3 0x4 0x9  10  0xa   15  0xf  16 0x10 170x11
				if(len<=15){
					sb.append("0");
				}
				sb.append(Integer.toHexString(len));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
		
	//�����������
	public static  String  getSalt(int n){
		char[] code =  "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(code[new Random().nextInt(code.length)]);
		}
		return sb.toString();
	}
	
	//����
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String salt = getSalt(6);
		System.out.println(salt);
		String md5Code = getMd5Code("123456i8McTl"); 
		System.out.println(md5Code); //111111   96e79218965eb72c92a549dd5a330112
		  
		 //111111(ע��ʱ�û����������)  KvE2su(ע��ʱ���ɵ���)  111111KvE2su   
		  //��:  KvE2su(��)   554278482d8d452eb7bf7aec123ddeb9(�������ݿ������)
		
		  //zhangcn  111111      ȡ����KvE2su      111111KvE2su  111111KvE2su  554278482d8d452eb7bf7aec123ddeb9
		
	}
	
}
