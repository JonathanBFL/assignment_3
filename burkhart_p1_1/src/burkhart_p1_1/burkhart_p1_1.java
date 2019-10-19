
package burkhart_p1_1;

import java.security.SecureRandom;
import java.util.Scanner;

public class burkhart_p1_1 {

    public static void main(String[] args) {
        RandNumGen();  //Navigates to RandNumGen
    }

    //Random number Generator
    public static void RandNumGen() {
        SecureRandom rand = new SecureRandom();
        Scanner scnr = new Scanner(System.in);

        int num1 = rand.nextInt(9) + 1;
        int num2 = rand.nextInt(9) + 1;

        Question(num1, num2);  //Navigates to Question
    }

    //Asks the question, collects input, prints answer
    public static void Question(int num1, int num2) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("What is " + num1 + " times " + num2 + "?");
        int input = scnr.nextInt();

        //Correct answer
        if (input == (num1 * num2)) {
            System.out.println("Very good!");
            RandNumGen(); //Gets new random numbers
            Question(num1, num2); //Reruns the question
        }

        //Wrong answer
        else {
            System.out.println("No. Please try again.");
            Question(num1, num2); //Reruns the question
        }
    }

}
