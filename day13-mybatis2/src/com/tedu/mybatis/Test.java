package com.tedu.mybatis;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException {
		while(true) {
			Scanner scan = new Scanner(System.in);
			Object obj = Class.forName(scan.nextLine());
			System.out.println(obj);
		}
		
	}
}
