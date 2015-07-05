package com.toby.printer;

public class Font {

	private int size;
	private int width;

	private Printer printer;

	/**
	 * Font constructor
	 * 
	 * @param size
	 *            font size in mm
	 */
	public Font(int size, Printer printer) {
		super();
		this.size = size;
		setWidth(size + size / 4);
		this.printer = printer;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Printer getPrinter() {
		return printer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	public void drawLetter(char letter) {
		switch (letter) {
		case 'A':
		case 'a':
			drawA();
			break;
		case 'B':
		case 'b':
			drawB();
			break;

		case 'C':
		case 'c':
			drawC();
			break;

		case 'D':
		case 'd':
			drawD();
			break;
		case 'E':
		case 'e':
			drawE();
			break;

		case 'F':
		case 'f':
			drawF();
			break;

		case 'G':
		case 'g':
			drawG();
			break;

		case 'H':
		case 'h':
			drawH();
			break;

		case 'I':
		case 'i':
			drawI();
			break;

		case 'J':
		case 'j':
			drawJ();
			break;

		case 'K':
		case 'k':
			drawK();
			break;

		case 'L':
		case 'l':
			drawL();
			break;

		case 'M':
		case 'm':
			drawM();
			break;

		case 'N':
		case 'n':
			drawN();
			break;

		case 'O':
		case 'o':
			drawO();
			break;

		case 'P':
		case 'p':
			drawP();
			break;

		case 'Q':
		case 'q':
			drawQ();
			break;

		case 'R':
		case 'r':
			drawR();
			break;

		case 'S':
		case 's':
			drawS();
			break;

		case 'T':
		case 't':
			drawT();
			break;

		case 'U':
		case 'u':
			drawU();
			break;

		case 'V':
		case 'v':
			drawV();
			break;
		case 'W':
		case 'w':
			drawW();
			break;
		case 'X':
		case 'x':
			drawX();
			break;
		case 'Y':
		case 'y':
			drawY();
			break;
		case 'Z':
		case 'z':
			drawZ();
			break;
		case ' ':
			drawSpace();
			break;

		default:
			return;
		}
	}

	public void drawSpace() {
		Printer printer = getPrinter();
		int width = getWidth();
		System.out.println(" ");
		;
		printer.move(width, 0);
	}

	public void drawX() {

	}

	public void drawW() {

	}

	public void drawY() {

	}

	public void drawZ() {

	}

	public void drawT() {

	}

	public void drawU() {

	}

	public void drawV() {

	}

	public void drawP() {

	}

	public void drawQ() {

	}

	public void drawR() {

	}

	public void drawS() {

	}

	public void drawN() {

	}

	public void drawM() {

	}

	public void drawO() {

	}

	public void drawJ() {

	}

	public void drawL() {

	}

	public void drawI() {

	}

	public void drawK() {

	}

	public void drawH() {

	}

	public void drawG() {

	}

	public void drawF() {

	}

	public void drawE() {

	}

	public void drawD() {

	}

	public void drawC() {

	}

	public void drawA() {
	}

	public void drawB() {
	}

}
