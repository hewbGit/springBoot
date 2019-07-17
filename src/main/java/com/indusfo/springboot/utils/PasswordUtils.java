package com.indusfo.springboootdemo_user.utils;


import java.util.UUID;

/**
 * 密码工具类
 * @author Louis
 * @date Sep 1, 2018
 */
public class PasswordUtils {
	  //e2e945517d5e434585b4
	/**
	 * 匹配密码
	 * @param salt 盐
	 * @param rawPass 明文 
	 * @param encPass 密文
	 * @return
	 */
	public static boolean matches(String salt, String rawPass, String encPass) {
		return new PasswordEncoder(salt).matches(encPass, rawPass);
	}
	
	/**
	 * 明文密码加密
	 * @param rawPass 明文
	 * @param salt
	 * @return
	 */
	public static String encode(String rawPass, String salt) {
		return new PasswordEncoder(salt).encode(rawPass);
	}

	/**
	 * 获取加密盐
	 * @return
	 */
	public static String getSalt() {
		return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
	}

	public static void main(String[] args) {
		String salt = PasswordUtils.getSalt();
		System.out.println(salt);
		String encode = PasswordUtils.encode("admin", "e2e945517d5e434585b4");
		System.out.println(encode);
	}
}
