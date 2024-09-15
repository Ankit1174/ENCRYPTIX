import java.util.Random;
import java.util.Scanner;

public class Main {

    int genNum, guessNum, count = 0, maxAttempts = 10, score = 0, roundsWon = 0;
    boolean b = false;

    public void generateNum() {
        Random rd = new Random();
        genNum = rd.nextInt(100) + 1;
    }

    public void guessNum() {
        Scanner sc = new Scanner(System.in);
        System.out.println("GUESS THE NUMBER (ATTEMPTS LEFT : " + (maxAttempts - count) + "): ");
        guessNum = sc.nextInt();
        count++;
    }

    public void logic() {
        if (genNum > guessNum) {
            System.out.println("GUESS LARGER...");
        } else if (genNum < guessNum) {
            System.out.println("GUESS SMALLER...");
        } else {
            System.out.println("YOU GUESSED THE RIGHT NUMBER IN " + count + " ATTEMPTS!");
            score += (maxAttempts - count + 1);
            roundsWon++;
            b = true;
        }
    }

    public boolean playAgain() {
        Scanner sc = new Scanner(System.in);
        System.out.println("PLAY AGAIN ? (yes/no): ");
        String choice = sc.next();
        return choice.equalsIgnoreCase("yes");
    }

    public static void main(String[] args) {

        System.out.println("___________WELCOME TO GUESS THE NUMBER GAME___________");
        Main obj = new Main();
        boolean play = true;

        while (play) {
            obj.generateNum();
            obj.count = 0;
            obj.b = false;

            while (!obj.b && obj.count < obj.maxAttempts) {
                obj.guessNum();
                obj.logic();
            }

            if (!obj.b) {
                System.out.println("SORRY! YOU HAVE USED ALL YOUR ATTEMPTS, THE NUMBER WAS  : " + obj.genNum);
            }

            play = obj.playAgain();

            if (!play) {
                System.out.println("TOTAL ROUNDS WON : " + obj.roundsWon);
                System.out.println("YOUR FINAL SCORE : " + obj.score);
                System.out.println("THANKS FOR PLAYING!");
            }
        }
    }
}
