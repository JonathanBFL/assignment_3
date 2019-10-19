package burkhart_p1_2;

import java.security.SecureRandom;
import java.util.Scanner;

public class burkhart_p1_2 {
    public static void main(String[] args) {
        RandNumGen();  //Navigates to RandNumGen
    }

    //Random number Generator
    public static void RandNumGen() {
        SecureRandom rand = new SecureRandom();

        int num1 = rand.nextInt(9) + 1;
        int num2 = rand.nextInt(9) + 1;

        Question(num1, num2);  //Navigates to Question
    }


    //Asks the question and collects input
    public static void Question(int num1, int num2) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("What is " + num1 + " times " + num2 + "?");
        int input = scnr.nextInt();
        Answer(num1, num2, input); //navigates to the answer output

    }

    //Prints output
    public static void Answer(int num1, int num2, int input) {

        //Correct answer
        if (input == (num1 * num2)) {
            System.out.println("test " + num1 + num2);
            SecureRandom rand = new SecureRandom();
            int randRightAns = rand.nextInt(4);
            switch (randRightAns) { //picks one of four replies
                case 0:
                    System.out.println("Very good!");
                    break;
                case 1:
                    System.out.println("Excellent!");
                    break;
                case 2:
                    System.out.println("Nice work!");
                    break;
                case 3:
                    System.out.println("Keep up the good work!");
                    break;
            }
            RandNumGen();  //Gets new random numbers then runs again

        }

        //Wrong answer
        else {
            SecureRandom rand = new SecureRandom();
            int randWrongAns = rand.nextInt(4);
            switch (randWrongAns) { //picks one of four replies
                case 0:
                    System.out.println("No. Please try again.");
                    break;
                case 1:
                    System.out.println("Wrong. Try once more.");
                    break;
                case 2:
                    System.out.println("Don’t give up!");
                    break;
                case 3:
                    System.out.println("No. Keep trying.");
                    break;
            }
            Question(num1, num2); //Reruns the question
        }
    }
}
