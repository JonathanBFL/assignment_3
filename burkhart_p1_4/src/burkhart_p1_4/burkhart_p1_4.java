package burkhart_p1_4;

import java.security.SecureRandom;
import java.util.Scanner;

public class burkhart_p1_4 {
    public static void main(String[] args) {
        int WrongAns = 0;
        int Ans = 0;
        difficulty(WrongAns, Ans);  //Navigates to RandNumGen

    }

    //ask for difficulty
    public static void difficulty(int WrongAns, int Ans) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("What difficulty do you want to try?\n1 = 1 digit\n2 = 2 digits\n3 = 3 digits\n4 = 4 digits");
        int inputDiff = scnr.nextInt();

        RandNumGen(WrongAns, Ans, inputDiff);  //Gets random numbers
    }


    //Random number Generator
    public static void RandNumGen(int WrongAns, int Ans, int inputDiff) {
        SecureRandom rand = new SecureRandom();
        int num1 = 0;
        int num2 = 0;

        if (inputDiff == 1) {
            num1 = rand.nextInt(9) + 1;
            num2 = rand.nextInt(9) + 1;
        } else if (inputDiff == 2) {
            num1 = rand.nextInt(99) + 1;
            num2 = rand.nextInt(99) + 1;
        } else if (inputDiff == 3) {
            num1 = rand.nextInt(999) + 1;
            num2 = rand.nextInt(999) + 1;
        } else if (inputDiff == 4) {
            num1 = rand.nextInt(9999) + 1;
            num2 = rand.nextInt(9999) + 1;
        } else {
            System.out.println("please enter a number 1-4.");
        }

        Question(num1, num2, WrongAns, Ans, inputDiff);  //Navigates to Question
    }

    //Asks the question and collects input
    public static void Question(int num1, int num2, int WrongAns, int Ans, int inputDiff) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("What is " + num1 + " times " + num2 + "?");
        int input = scnr.nextInt();
        Answer(num1, num2, input, WrongAns, Ans, inputDiff); //navigates to the answer output

    }

    //Prints output
    public static void Answer(int num1, int num2, int input, int WrongAns, int Ans, int inputDiff) {

        //10 questions asked
        if (Ans == 9) {
            int percent = (10 - WrongAns); //calculates percentage
            if (percent > 7) {
                System.out.println("Congratulations, you are ready to go to the next level!");
            } else {
                System.out.println("Please ask your teacher for extra help.");
            }
            WrongAns = 0; //Resets amount failed for new user
            Ans = 0; //Resets amount tried for new user
            difficulty(WrongAns, Ans);  //Gets new random numbers then runs again
        }

        //correct answer
        else if (input == (num1 * num2)) {
            SecureRandom rand = new SecureRandom();
            int randRightAns = rand.nextInt(4); //gets random number for reply
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
            Ans++; //Adds number of attempts
            RandNumGen(WrongAns, Ans, inputDiff);  //Gets new random numbers then runs again

        }

        //Wrong answer
        else {
            SecureRandom rand = new SecureRandom();
            int randWrongAns = rand.nextInt(4); //gets random number for reply
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
            Ans++; //Adds number of attempts
            WrongAns++; //Adds number of wrong answers
            RandNumGen(WrongAns, Ans, inputDiff);  //Gets new random numbers then runs again
        }
    }
}
