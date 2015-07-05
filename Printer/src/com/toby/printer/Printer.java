package com.toby.printer;

import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.Motor;
import lejos.nxt.MotorPort;
import lejos.nxt.NXTMotor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.TouchSensor;
import lejos.util.Delay;

public class Printer {

	public enum PrinterOrientation {
		PORTRAIT, LANDSCAPE
	}

	private PrinterOrientation orientation = PrinterOrientation.PORTRAIT;

	final float speed = 58f / 1000f;

	private NXTMotor penMotor = new NXTMotor(MotorPort.C);
	// NXTMotor motorH = new NXTMotor(MotorPort.B);
	// NXTMotor motorV = new NXTMotor(MotorPort.A);

	private NXTRegulatedMotor motorVertical = Motor.A;
	private NXTRegulatedMotor motorHorizontal = Motor.B;

	boolean penDown = false;

	private int maxWidth = 140;
	private int maxHeight = 220;

	private int x = 0;
	private int y = 0;

	/**
	 * Constructor
	 */
	public Printer() {
		super();
		Motor.A.resetTachoCount();
		Motor.B.resetTachoCount();
	}

	public void setOrientation(PrinterOrientation orientation) {
		this.orientation = orientation;
		switch (orientation) {
		case PORTRAIT:
			motorVertical = Motor.A;
			motorHorizontal = Motor.B;
			break;
		case LANDSCAPE:
			motorVertical = Motor.B;
			motorHorizontal = Motor.A;
		default:
			break;
		}
	}

	public int getMaxWidth() {
		switch (orientation) {
		case PORTRAIT:
			return maxWidth;
		case LANDSCAPE:
			return maxHeight;
		default:
			return 0;
		}
	}

	public void setMaxWidth(int maxWidth) {
		this.maxWidth = maxWidth;
	}

	public int getMaxHeight() {
		switch (orientation) {
		case PORTRAIT:
			return maxHeight;
		case LANDSCAPE:
			return maxWidth;
		default:
			return 0;
		}
	}

	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}

	/**
	 * Lifts pen
	 */
	public void liftPen() {
		if (penDown) {

			penMotor.setPower(20);
			penMotor.forward();
			Delay.msDelay(450);
			penMotor.stop();

			penDown = false;
		}
	}

	/**
	 * Lower pen
	 */
	public void lowerPen() {
		if (!penDown) {
			penMotor.setPower(20);
			penMotor.backward();
			Delay.msDelay(450);
			penMotor.stop();
			penMotor.forward();
			Delay.msDelay(30);
			penMotor.stop();

			penDown = true;
		}
	}

	/**
	 * Resets horizontal position
	 */
	public void resetHorizontal() {
		Motor.B.backward();
		TouchSensor touch = new TouchSensor(SensorPort.S1);
		while (!touch.isPressed()) {
		}
		Motor.B.stop();
		Motor.B.rotate(90);
		Motor.B.resetTachoCount();
	}

	// public void resetHorizontal() {
	// Motor.B.suspendRegulation();
	// motorH.setPower(40);
	// motorH.backward();
	// TouchSensor touch = new TouchSensor(SensorPort.S1);
	// while (!touch.isPressed()) {
	// }
	// motorH.stop();
	// motorH.forward();
	// Delay.msDelay(300);
	// motorH.stop();
	// motorH.resetTachoCount();
	// }

	/**
	 * Resets vertical position. Basically, loads paper.
	 */
	public void resetVertical() {
		Motor.A.setSpeed(200);
		Motor.A.forward();

		ColorSensor color = new ColorSensor(SensorPort.S3);
		while (color.getColor().getColor() != ColorSensor.WHITE)
			;
		Sound.beep();

		Delay.msDelay(500);

		Motor.A.backward();

		while (color.getColor().getColor() == ColorSensor.WHITE)
			;
		Motor.A.stop();
		Motor.A.setSpeed(400);
		Motor.A.rotate(30);
		Motor.A.resetTachoCount();
	}

	// public void resetVertical() {
	// motorV.setPower(40);
	// motorV.forward();
	//
	// ColorSensor color = new ColorSensor(SensorPort.S3);
	// while (color.getColor().getColor() != ColorSensor.WHITE)
	// ;
	// Sound.beep();
	//
	// Delay.msDelay(500);
	//
	// motorV.backward();
	//
	// while (color.getColor().getColor() == ColorSensor.WHITE)
	// ;
	// motorV.stop();
	//
	// motorV.forward();
	// Delay.msDelay(100);
	// motorV.stop();
	// // motorV.resetTachoCount();
	// }

	/**
	 * Ejects paper
	 */
	public void eject() {
		liftPen();
		Motor.A.setSpeed(1000);
		Motor.A.backward();

		ColorSensor color = new ColorSensor(SensorPort.S3);

		while (color.getColor().getColor() == ColorSensor.WHITE) {
		}

		Delay.msDelay(1000);
		Motor.A.stop();
	}

	// public void eject() {
	// liftPen();
	// Motor.A.suspendRegulation();
	// motorV.setPower(100);
	// motorV.backward();
	//
	// ColorSensor color = new ColorSensor(SensorPort.S3);
	//
	// while (color.getColor().getColor() == ColorSensor.WHITE) {
	// }
	//
	// Delay.msDelay(1000);
	// motorV.stop();
	// }

	/**
	 * Moves pen horizontally
	 * 
	 * @param distance
	 *            distance in mm
	 */
	public void horizontal(int distance) {
		if (distance == 0) {
			return;
		}

		x += distance;

		int delay = (int) (Math.abs((float) distance) / speed);
		Motor.B.setSpeed(500);

		if (distance > 0) {
			Motor.B.forward();
		} else {
			Motor.B.backward();
		}
		// System.out.println(speed);
		// System.out.println(delay);
		Delay.msDelay(delay);
		Motor.B.stop();

	}

	/**
	 * Moves pen vertically
	 * 
	 * @param distance
	 *            - distance in mm
	 */
	public void vertical(int distance) {
		if (distance == 0) {
			return;
		}

		y += distance;

		int delay = (int) (Math.abs((float) distance) / speed);

		Motor.A.setSpeed(500);

		if (distance > 0) {
			Motor.A.forward();
		} else {
			Motor.A.backward();
		}

		Delay.msDelay(delay);
		Motor.A.stop();
	}

	public void move(int dH, int dV) {
		if (dH == 0 && dV == 0) {
			return;
		}

		// if (Math.abs(dH) != Math.abs(dV)) {
		// return;
		// }
		if (orientation == PrinterOrientation.LANDSCAPE) {
			dV = dV * -1;
		}

		x += dH;
		y += dV;

		int delay = (int) (Math.abs((float) dH) / speed);

		motorVertical.setSpeed(500);
		motorHorizontal.setSpeed(500);

		if (Math.abs(dH) > Math.abs(dV)) {
			float newSpeed = 500f * (Math.abs((float) dV) / Math.abs((float) dH));
			motorVertical.setSpeed(newSpeed);
		}

		if (Math.abs(dV) > Math.abs(dH)) {
			delay = (int) (Math.abs((float) dV) / speed);
			float newSpeed = 500f * (Math.abs((float) dH) / Math.abs((float) dV));
			motorHorizontal.setSpeed(newSpeed);
		}

		if (dV > 0) {
			motorVertical.forward();
		} else {
			motorVertical.backward();
		}
		if (dH > 0) {
			motorHorizontal.forward();
		} else {
			motorHorizontal.backward();
		}

		Delay.msDelay(delay);

		motorVertical.stop(true);
		motorHorizontal.stop();

		motorVertical.suspendRegulation();
		motorHorizontal.suspendRegulation();

	}

	public void _diagonal(int distanceH, int distanceV) {
		if (distanceH == 0 && distanceV == 0) {
			return;
		}

		if (Math.abs(distanceH) != Math.abs(distanceV)) {
			return;
		}

		int delay = (int) (Math.sqrt(Math.abs(distanceH * distanceH) / 2.0) * 10.0);

		Motor.A.setSpeed(1000);
		Motor.B.setSpeed(1000);

		if (distanceV > 0) {

		} else {
			Motor.A.backward();
		}

		if (distanceH > 0) {
		} else {
			Motor.B.backward();
		}

		Motor.A.rotate(delay, true);
		Motor.B.rotate(delay, true);

		// while (Motor.A.isMoving() || Motor.B.isMoving())
		// ;

		Delay.msDelay(delay);

		Motor.A.stop(true);
		Motor.B.stop();

	}

	public void print(String text, Font font) {
		int s = font.getSize();
		int howManyCharactersInLine = getMaxWidth() / s;
		int howManyPrintedInLine = 0;
		int vertical_pos = 0;
		move(0, s);
		vertical_pos = y;

		for (int i = 0; i < text.length(); i++) {
			if (howManyPrintedInLine == howManyCharactersInLine) {
				// go to new line
				move(-x, s);
				howManyPrintedInLine = 0;
				vertical_pos = y;
			}
			char c = text.charAt(i);

			System.out.print(c);
			// System.out.println(", x: " + x + ", y: " + y);

			font.drawLetter(c);

			// if (y != vertical_pos) {
			// int adj = vertical_pos - y;
			// System.out.println("adj: " + adj);
			// move(0, adj);
			// }

			howManyPrintedInLine++;

			if (Button.ENTER.isDown()) {
				break;
			}
		}

	}

	public void circle() {

		int speed = 250;
		// printer.motorVertical.setSpeed(speed);
		// printer.motorVertical.forward();

		// printer.motorHorizontal.setSpeed(0);
		// printer.motorHorizontal.forward();
		for (int deg = 0; deg <= 360; deg++) {
			float speedH = (float) (speed * Math.cos(Math.toRadians(deg)));
			float speedV = (float) (speed * Math.sin(Math.toRadians(deg)));
			// System.out.println(speed);
			motorHorizontal.setSpeed(speedH);
			motorVertical.setSpeed(speedV);
			if (speedH > 0) {
				motorHorizontal.forward();
			}
			if (speedH < 0) {
				motorHorizontal.backward();
			}
			// if (deg >= 270 && deg <= 360) {
			// printer.motorHorizontal.forward();
			// }
			if (speedV > 0) {
				motorVertical.forward();
			}
			if (speedV < 0) {
				motorVertical.backward();
			}
			Delay.msDelay(25);
			if (Button.ENTER.isDown()) {
				break;
			}
		}

	}
}
