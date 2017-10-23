package com.olga.battle;

import java.util.Scanner;

public class Keyboard {
	public String readStringFromKeyboard(String message) {
		System.out.println(message+": ");
		Scanner scan=new Scanner(System.in);
		return scan.next();
	}
	public Integer readIntegerFromKeyboard(String message) {
		String s=readStringFromKeyboard(message);
		return Integer.valueOf(s);
	}

}
