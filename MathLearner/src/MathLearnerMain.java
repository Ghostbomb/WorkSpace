import java.text.MessageFormat;
import java.util.Random;
import java.util.Scanner;

public class MathLearnerMain {

	public static void main(String[] args) {
		int question = 7;
		int score = 0;

		Random random = new Random();
		Scanner in = new Scanner(System.in);
		for (int i = 1; i <= question; i++) {
			int q1 = random.nextInt(200);
			int q2 = random.nextInt(200);

			int answer = q1 + q2;

			System.out.println("Question #" + i);
			System.out.println(q1 + " + " + q2 + " = ?");// {0} + {1} = ?

			int userAnswer = in.nextInt();

			if (answer == userAnswer) {
				// if answer is correct
				score++; // score = score +1;
				System.out.println("Correct!");
			} else {
				// if answer is incorrect
				System.out.println("Incorrect!");
				System.out.println("The correct answer is: " + answer);
			}
			System.out.println();
		}
		int persent = score * 100 / question;
		System.out.print(MessageFormat.format("Your score is: {0} out of {2}, {1}%", score, persent, question));
		System.out.println();
		System.out.println("Good Job.");
	}
}
