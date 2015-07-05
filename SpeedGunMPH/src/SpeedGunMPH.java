import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.UltrasonicSensor;
import lejos.util.Delay;

public class SpeedGunMPH {

	private static final int distance = 20;

	public static void main(String[] args) {

		Sound.beep();
		Delay.msDelay(500);
		Sound.beep();
		Delay.msDelay(500);
		Sound.beep();

		long start = System.currentTimeMillis();
		UltrasonicSensor ultrasonic = new UltrasonicSensor(SensorPort.S4);

		double d = ultrasonic.getDistance();
		while (d == ultrasonic.getDistance())
			;
		long time = System.currentTimeMillis() - start;

		time = time / 3600000;
		Sound.beep();
		long mph = distance / time;

		// System.out.println("Here is your time");
		// System.out.println(time);
		// System.out.println();
		System.out.println("Here is your speed");
		System.out.println(mph);

	}
}