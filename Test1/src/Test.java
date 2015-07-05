import lejos.util.Delay;

public class Test {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Delay.msDelay(1000);
		long time = System.currentTimeMillis();
		long time3 = time - start;
		long time2 = time3 / 3600000;

		System.out.println(time2);

	}
}
