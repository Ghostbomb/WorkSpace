package org.lejos.example;

import lejos.nxt.Button;
import lejos.nxt.Sound;

/**
 * Example leJOS Project with an ant build file
 *
 */
public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello World");
		Sound.beep();
		Button.waitForAnyPress();
	}
}

