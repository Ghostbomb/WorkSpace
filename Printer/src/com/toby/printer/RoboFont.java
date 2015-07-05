package com.toby.printer;

public class RoboFont extends Font {

	public RoboFont(int size, Printer printer) {
		super(size, printer);
	}

	@Override
	public void drawA() {
		super.drawA();

		Printer printer = getPrinter();
		int size = getSize();

		printer.lowerPen();
		printer.move(size / 2, -size);
		printer.move(size / 2, size);

		int h = (int) (0.4 * (size / 2));
		int v = (int) (0.4 * size);
		int d = (int) (size - 2 * h);

		printer.liftPen();
		printer.move(-h, -v);
		printer.lowerPen();
		printer.move(-d, 0);

		// move to right corner
		printer.liftPen();
		printer.move(0, v);
		int r = size - h;
		printer.move(r, 0);

		// move to next letter
		printer.move(getWidth() - size, 0);

	}

	@Override
	public void drawB() {
		super.drawB();
		Printer printer = getPrinter();
		int size = getSize();
		printer.lowerPen();
		printer.move(0, -size);
		printer.move(size / 2, 0);
		printer.move(-size / 2, size / 2);
		printer.move(size / 2, size / 2);
		printer.move(-size / 2, 0);

		printer.liftPen();
		printer.move(size / 2, 0);
		printer.move(getWidth() - size, 0);
	}

	public void drawC() {
		super.drawC();
		Printer printer = getPrinter();
		int size = getSize();
		printer.lowerPen();
		printer.move(0, -size);
		printer.move(size / 2, 0);
		printer.liftPen();
		printer.move(0, size);
		printer.lowerPen();
		printer.move(-size / 2, 0);
		printer.liftPen();
		printer.move(size / 2, 0);
		printer.move(getWidth() - size, 0);
	}

	public void drawD() {
		super.drawD();
		Printer printer = getPrinter();
		int size = getSize();

		printer.lowerPen();
		printer.move(0, -size);
		printer.move(size / 2, size / 2);
		printer.move(-size / 2, size / 2);
		printer.liftPen();
		printer.move(size / 2, 0);
		printer.move(getWidth() - size, 0);
	}

	public void drawE() {
		super.drawE();
		Printer printer = getPrinter();
		int size = getSize();

		printer.lowerPen();
		printer.move(0, -size);
		printer.move(size / 2, 0);

		printer.liftPen();
		printer.move(0, size / 2);

		printer.lowerPen();
		printer.move(-size / 2, 0);

		printer.liftPen();
		printer.move(size / 2, 0);
		printer.move(0, size / 2);
		printer.lowerPen();
		printer.move(-size / 2, 0);
		printer.liftPen();

		printer.move(size / 2, 0);
		printer.move(getWidth() - size, 0);
	}

	public void drawF() {
		super.drawF();
		Printer printer = getPrinter();
		int size = getSize();

		printer.lowerPen();
		printer.move(0, -size);
		printer.move(size / 2, 0);
		printer.liftPen();
		printer.move(0, size / 2);
		printer.lowerPen();
		printer.move(-size / 2, 0);
		printer.liftPen();
		printer.move(0, size / 2);

		printer.liftPen();
		printer.move(size / 2, 0);
		printer.move(getWidth() - size, 0);
	}

	public void drawG() {
		super.drawG();
		Printer printer = getPrinter();
		int size = getSize();

		printer.lowerPen();
		printer.move(0, -size);
		printer.move(size, 0);
		printer.liftPen();
		printer.move(0, size);
		printer.move(-size, 0);
		printer.lowerPen();
		printer.move(size, 0);
		printer.move(0, -size / 2);
		printer.move(-size / 2, 0);

		printer.liftPen();
		printer.move(size / 2, 0);
		printer.move(0, size / 2);
		printer.move(getWidth() - size, 0);
	}

	public void drawH() {
		super.drawH();
		Printer printer = getPrinter();
		int size = getSize();

		printer.move(0, -size);
		printer.lowerPen();
		printer.move(0, size);
		printer.liftPen();
		printer.move(size / 2, 0);
		printer.lowerPen();
		printer.move(0, -size);
		printer.liftPen();
		printer.move(0, size / 2);
		printer.lowerPen();
		printer.move(-size / 2, 0);
		printer.liftPen();
		printer.move(size / 2, size / 2);

		// printer.move(0, -size);
		// printer.liftPen();
		// printer.move(0, size / 2);
		// printer.lowerPen();
		// printer.move(size / 2, 0);
		// Delay.msDelay(500);
		// printer.move(0, size / 2);
		// printer.move(0, -size / 2);
		//
		// printer.liftPen();
		// printer.move(0, size / 2);
		printer.move(getWidth() - size, 0);
	}

	public void drawI() {
		super.drawI();
		Printer printer = getPrinter();
		int size = getSize();

		printer.lowerPen();
		printer.move(size / 2, 0);
		printer.move(-size / 4, 0);
		printer.move(0, -size);
		printer.move(-size / 4, 0);
		printer.move(size / 2, 0);
		printer.liftPen();
		printer.move(0, size);
		printer.move(getWidth() - size, 0);
	}

	public void drawJ() {
		super.drawJ();
		Printer printer = getPrinter();
		int size = getSize();

		printer.lowerPen();
		printer.move(0, -size / 2);
		printer.liftPen();
		printer.move(0, size / 2);
		printer.lowerPen();
		printer.move(size / 2, 0);
		printer.move(0, -size);
		printer.move(-size / 4, 0);
		printer.move(size / 2, 0);
		printer.liftPen();
		printer.move(0, size);
		printer.move(getWidth() - size, 0);
	}

	public void drawK() {
		super.drawK();
		Printer printer = getPrinter();
		int size = getSize();

		printer.lowerPen();
		printer.move(0, -size);
		printer.liftPen();
		printer.move(0, size / 2);
		printer.lowerPen();
		printer.move(size / 2, -size / 2);
		printer.liftPen();
		printer.move(-size / 2, size / 2);
		printer.lowerPen();
		printer.move(size / 2, size / 2);
		printer.liftPen();
		printer.move(getWidth() - size, 0);
	}

	public void drawL() {
		super.drawL();
		Printer printer = getPrinter();
		int size = getSize();

		printer.lowerPen();
		printer.move(0, -size);
		printer.liftPen();
		printer.move(0, size);
		printer.lowerPen();
		printer.move(size / 2, 0);
		printer.liftPen();
		printer.move(getWidth() - size, 0);

	}

	public void drawM() {
		super.drawM();
		Printer printer = getPrinter();
		int size = getSize();

		printer.lowerPen();
		printer.move(0, -size);
		printer.move(size / 2, size / 2);
		printer.move(size / 2, -size / 2);
		printer.move(0, size);
		printer.liftPen();
		printer.move(getWidth() - size, 0);

	}

	public void drawN() {
		super.drawN();
		Printer printer = getPrinter();
		int size = getSize();

		printer.lowerPen();
		printer.move(0, -size);
		printer.move(size / 2, size);
		printer.move(0, -size);
		printer.liftPen();
		printer.move(0, size);
		printer.move(getWidth() - size, 0);

	}

	public void drawO() {
		super.drawO();
		Printer printer = getPrinter();
		int size = getSize();

		printer.lowerPen();
		printer.move(0, -size);
		printer.move(size / 2, 0);
		printer.move(0, size);
		printer.move(-size / 2, 0);
		printer.liftPen();
		printer.move(size / 2, 0);
		printer.move(getWidth() - size, 0);
	}

	public void drawP() {
		super.drawP();
		Printer printer = getPrinter();
		int size = getSize();

		printer.lowerPen();
		printer.move(0, -size);
		printer.move(size / 2, 0);
		printer.move(0, size / 2);
		printer.move(-size / 2, 0);
		printer.liftPen();
		printer.move(size / 2, 0);
		printer.move(0, size / 2);
		printer.move(getWidth() - size, 0);
	}

	public void drawQ() {
		super.drawQ();
		Printer printer = getPrinter();
		int size = getSize();

		printer.lowerPen();
		printer.move(0, -size);
		printer.move(size / 2, 0);
		printer.move(0, size);
		printer.move(-size / 2, 0);
		printer.liftPen();
		printer.move(size / 3, 0);
		printer.lowerPen();
		printer.move(size / 4, size / 4);
		printer.liftPen();
		printer.move(-size / 4, -size / 4);
		printer.move(getWidth() - size, 0);
	}

	public void drawR() {
		super.drawR();
		Printer printer = getPrinter();
		int size = getSize();

		printer.lowerPen();
		printer.move(0, -size);
		printer.move(size / 2, 0);
		printer.move(0, size / 2);
		printer.move(-size / 2, 0);
		printer.move(size / 2, size / 2);
		printer.liftPen();
		printer.move(getWidth() - size, 0);
	}

	public void drawS() {
		super.drawS();
		Printer printer = getPrinter();
		int size = getSize();

		printer.lowerPen();
		printer.move(size / 2, 0);
		printer.move(0, -size / 2);
		printer.move(-size / 2, 0);
		printer.move(0, -size / 2);
		printer.move(size / 2, 0);
		printer.liftPen();
		printer.move(0, size);
		printer.move(getWidth() - size, 0);
	}

	public void drawT() {
		super.drawT();
		Printer printer = getPrinter();
		int size = getSize();

		printer.move(size / 2, 0);
		printer.lowerPen();
		printer.move(0, -size);
		printer.move(-size / 2, 0);
		printer.move(size, 0);
		printer.liftPen();
		printer.move(0, size);
		printer.move(getWidth() - size, 0);
	}

	public void drawU() {
		super.drawU();
		Printer printer = getPrinter();
		int size = getSize();

		printer.lowerPen();
		printer.move(0, -size);
		printer.liftPen();
		printer.move(0, size);
		printer.lowerPen();
		printer.move(size / 2, 0);
		printer.move(0, -size);
		printer.liftPen();
		printer.move(0, size);
		printer.lowerPen();
		printer.move(size / 4, size / 4);
		printer.liftPen();
		printer.move(-size / 4, -size / 4);
		printer.move(getWidth() - size, 0);
	}

	public void drawV() {
		super.drawV();
		Printer printer = getPrinter();
		int size = getSize();

		printer.move(0, -size);
		printer.lowerPen();
		printer.move(size / 2, size);
		printer.move(size / 2, -size);
		printer.liftPen();
		printer.move(0, size);
		printer.move(getWidth() - size, 0);
	}

	public void drawW() {
		super.drawW();
		Printer printer = getPrinter();
		int size = getSize();

		printer.move(0, -size);
		printer.lowerPen();
		printer.move(size / 2, size);
		printer.move(size / 2, -size);
		printer.move(size / 2, size);
		printer.move(0, -size);
		printer.liftPen();
		printer.move(0, size);
		printer.move(getWidth() - size, 0);
	}

	public void drawX() {
		super.drawX();
		Printer printer = getPrinter();
		int size = getSize();

		printer.move(0, -size);
		printer.lowerPen();
		printer.move(size / 2, size);
		printer.liftPen();
		printer.move(0, -size);
		printer.lowerPen();
		printer.move(-size / 2, size);
		printer.liftPen();
		printer.move(size / 2, 0);
		printer.move(getWidth() - size, 0);
	}

	public void drawY() {
		super.drawY();
		Printer printer = getPrinter();
		int size = getSize();

		printer.move(size / 2, 0);
		printer.lowerPen();
		printer.move(0, -size / 2);
		printer.move(-size / 2, -size / 2);
		printer.move(size / 2, size / 2);
		printer.move(size / 2, -size / 2);
		printer.liftPen();
		printer.move(0, size);
		printer.move(getWidth() - size, 0);

	}

	public void drawZ() {
		super.drawZ();
		Printer printer = getPrinter();
		int size = getSize();

		printer.move(size / 2, 0);
		printer.lowerPen();
		printer.move(-size / 2, 0);
		printer.move(size / 2, -size);
		printer.move(-size / 2, 0);
		printer.liftPen();
		printer.move(size / 2, size);
		printer.move(getWidth() - size, 0);
	}

}