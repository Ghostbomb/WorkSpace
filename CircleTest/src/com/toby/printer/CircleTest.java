package com.toby.printer;

public class CircleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		drawCircle(25, 25, 25);

	}

	private static void drawCircle(final int centerX, final int centerY, final int radius) {

		int x = 0;
		int y = radius;
		int d = 1 - y;// (5 - radius * 4) / 4;

		int px = centerX + x;
		int py = centerY + y;
		// printer.move(px, py);
		// printer.lowerPen();
		do {
			int newPx = (centerX + x);
			int newPy = (centerY + y);
			// printer.move(newPx, newPy);
			int dpx = newPx - px;
			int dpy = newPy - py;

			px = newPx;
			py = newPy;
			System.out.println(newPx + " " + newPy + " " + dpx + " " + dpy);
			// System.out.print((centerX + x) + " " + (centerY + y));
			// System.out.print("| " + (centerX + x) + " " + (centerY - y));
			// System.out.print("| " + (centerX - x) + " " + (centerY + y));
			// System.out.print("| " + (centerX - x) + " " + (centerY - y));
			// System.out.print("| " + (centerX + y) + " " + (centerY + x));
			// System.out.print("| " + (centerX + y) + " " + (centerY - x));
			// System.out.print("| " + (centerX - y) + " " + (centerY + x));
			// System.out.println("| " + (centerX - y) + " " + (centerY - x));

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
