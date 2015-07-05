import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.util.Delay;

public class SpeedGunMPH {

	private static final int distance = 32;

	public static void main(String[] args) {

		System.out.print("" + distance + "ft.");
		System.out.println();
		TouchSensor touch = new TouchSensor(SensorPort.S1);
		while (!touch.isPressed()) {
		}
		Sound.setVolume(100);
		Sound.twoBeeps();
		Delay.msDelay(2000);

		Sound.beepSequenceUp();

		long start = System.currentTimeMillis();
		UltrasonicSensor ultrasonic = new UltrasonicSensor(SensorPort.S4);
		double d = ultrasonic.getDistance();
		while (d == ultrasonic.getDistance())
			;
		Sound.beep();
		double time = System.currentTimeMillis() - start;
		double hlong = (time / 1000);
		double distance2 = ((double) distance) / 5280.0;
		double t = time / 3600000.0;

		double mph = distance2 / t;
		System.out.print("Here is your    speed:" + mph + " mph.");
		System.out.println();
		System.out.print("Here is your    time:" + hlong + " s.");
		Button.waitForAnyPress();
	}
}