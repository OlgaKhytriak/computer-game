package com.epam.lab.task2.io;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.epam.lab.task2.StartGame;
/** Ñlass for reading from a keyboard different types of data
 * @author Olga Khytriak
 * @version 1.0 
  */
public class Keyboard {
	private static final Logger LOG = Logger.getLogger(Keyboard.class);
	/** Reads string from keyboard and return it
	 * @param message
	 *   will be written on the console before user starts to input data   
	 * @return
	 */
	public String readStringFromKeyboard(String message) {
		LOG.info(String.format("%s  ", message));
		Scanner scan = new Scanner(System.in);
		return scan.next();
	}

	/** Reads string from keyboard and converts it into <b> int </b>
	 * @param message
	 *   will be written on the console before user starts to input data   
	 * @return
	 */
	public int readIntegerFromKeyboard(String message) {
		String s = readStringFromKeyboard(message);
		try {
			Integer.parseInt(s);
			return Integer.valueOf(s);
		} catch (Exception e) {
			return readIntegerFromKeyboard("It isn't integer! Try again ");
		}
	}
	/** Reads string from keyboard and converts it into <b> long </b>
	 * @param message
	 *   will be written on the console before user starts to input data   
	 * @return
	 */
	public long readLongFromKeyboard(String message) {
		String s = readStringFromKeyboard(message);
		try {
			Long.parseLong(s);
			return Long.valueOf(s);
		} catch (Exception e) {
			return readLongFromKeyboard("It isn't long!  Try again");
		}
	}
}
