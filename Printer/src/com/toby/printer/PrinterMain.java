package com.toby.printer;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.MotorPort;
import lejos.nxt.NXTMotor;
import lejos.util.Delay;

import com.toby.printer.Printer.PrinterOrientation;

public class PrinterMain {

	public static void main(String[] args) {
		Printer printer = new Printer();

		printer.liftPen();

		printer.resetHorizontal();

		printer.resetVertical();

		printer.move(30, 0);

		printer.setOrientation(PrinterOrientation.LANDSCAPE);

		RoboFont font = new RoboFont(30, printer);
		printer.print("ABCDEFGHIJKLMNOPQRSTUVWXYZ", font);

		// printer.move(0, 50);
		// testDiagonal(printer);

		// printer.print("ABCE", font);
		// printer.print("ABCEFGHIJKLMNOPQRSTUVWXYZ", font);

		// printer.move(50, 0);
		// printer.lowerPen();
		// test(printer);

		// printer.motorHorizontal.stop(true);
		// printer.motorVertical.stop();
		System.out.println();
		System.out.println(" Waiting For Any      Press");

		Button.waitForAnyPress();

		printer.eject();
	}

	private static void testDiagonal(Printer printer) {

		printer.lowerPen();
		NXTMotor motorH = new NXTMotor(MotorPort.B);
		NXTMotor motorV = new NXTMotor(MotorPort.A);
		Motor.B.suspendRegulation();
		Motor.A.suspendRegulation();

		motorH.setPower(50);
		motorV.setPower(50);

		motorH.forward();
		motorV.forward();

		Delay.msDelay(1000);
		motorH.stop();
		motorV.stop();

		printer.liftPen();
	}

	private static void drawCircle(Printer printer, final int centerX, final int centerY, final int radius) {
		// int d = (5 - radius * 4) / 4;
		int x = 0;
		int y = radius;
		int d = 1 - y;

		int px = centerX + x;
		int py = centerY + y;
		printer.move(px, py);
		printer.lowerPen();
		do {
			int newPx = (centerX + x);
			int newPy = (centerY + y);

			int dpx = newPx - px;
			int dpy = newPy - py;
			printer.move(dpx, dpy);
			px = newPx;
			py = newPy;

			System.out.println(newPx + " " + newPy + " " + dpx + " " + dpy);
			// System.out.println(px + " " + py);
			// image.setPixel(centerX + x, centerY + y, circleColor);
			// image.setPixel(centerX + x, centerY - y, circleColor);
			// image.setPixel(centerX - x, centerY + y, circleColor);
			// image.setPixel(centerX - x, centerY - y, circleColor);
			// image.setPixel(centerX + y, centerY + x, circleColor);
			// image.setPixel(centerX + y, centerY - x, circleColor);
			// image.setPixel(centerX - y, centerY + x, circleColor);
			// image.setPixel(centerX - y, centerY - x, circleColor);
			if (d < 0) {
				d += 2 * x + 1;
			} else {
				d += 2 * (x - y + 1);
				y--;
			}
			x++;

			// if (Button.ENTER.isDown()) {
			// break;
			// }
		} while (x <= y);

	}
}
