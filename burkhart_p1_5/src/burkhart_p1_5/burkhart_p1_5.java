package burkhart_p1_5;

import java.security.SecureRandom;
import java.util.Scanner;
import java.text.DecimalFormat;

public class burkhart_p1_5 {

    private static DecimalFormat df2 = new DecimalFormat("#");

    public static void main(String[] args) {
        int WrongAns = 0;
        int Ans = 0;
        int rand1 = 0;

        difficulty(WrongAns, Ans, rand1);  //Navigates to RandNumGen

    }

    //ask for difficulty
    public static void difficulty(int WrongAns, int Ans, int rand1) {
        Scanner scnr = new Scanner(System.in);

        System.out.println("What difficulty do you want to try?\n1 = 1 digit\n2 = 2 digits\n3 = 3 digits\n4 = 4 digits");
        int inputDiff = scnr.nextInt();

        System.out.println("What type of type of arithmetic problem do you want to practice.\n1 - addition\n2 - multiplication\n3 - subtraction\n4 - division\n5 - mixture");
        int InputArith = scnr.nextInt();

        RandNumGen(WrongAns, Ans, InputArith, inputDiff, rand1);  //Gets random numbers
    }


    //Random number Generator
    public static void RandNumGen(int WrongAns, int Ans, int InputArith, int inputDiff, int rand1) {
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
        }

        //invalid input
        else {
            System.out.println("Invalid input");
            difficulty(WrongAns, Ans, rand1);  //Goes back to input
        }

        Question(num1, num2, WrongAns, Ans, InputArith, inputDiff, rand1);  //Navigates to Question
    }

    //Asks the question and collects input
    public static void Question(double num1, double num2, int WrongAns, int Ans, int InputArith, int inputDiff, int rand1) {
        Scanner scnr = new Scanner(System.in);
        SecureRandom rand = new SecureRandom();

        //System.out.println("What is " + num1 + " times " + num2 + "?");
        double input = 0;
        int flag = 0;

        //Addition problem
        if (InputArith == 1) {
            System.out.println("What is " + df2.format(num1) + " plus " + df2.format(num2) + "?");
            input = scnr.nextDouble();
            if (input == (num1 + num2)) {
                flag = 1;
            } else {
                flag = 0;
            }
            randomizer(num1, num2, WrongAns, Ans, InputArith, inputDiff, rand1);
        }

        //Multiplication problem
        else if (InputArith == 2) {
            System.out.println("What is " + df2.format(num1) + " times " + df2.format(num2) + "?");
            input = scnr.nextDouble();
            if (input == (num1 * num2)) {
                flag = 1;
            } else {
                flag = 0;
            }
            randomizer(num1, num2, WrongAns, Ans, InputArith, inputDiff, rand1);
        }

        //Subtraction problem
        else if (InputArith == 3) {
            System.out.println("What is " + df2.format(num1) + " minus " + df2.format(num2) + "?");
            input = scnr.nextDouble();
            if (input == (num1 - num2)) {
                flag = 1;
            } else {
                flag = 0;
            }
            randomizer(num1, num2, WrongAns, Ans, InputArith, inputDiff, rand1);
        }

        //Division problem
        else if (InputArith == 4) {
            System.out.println("What is " + df2.format(num1) + " divided " + df2.format(num2) + "?");
            input = scnr.nextDouble();
            if (input == (num1 / num2)) {
                flag = 1;
            } else {
                flag = 0;
            }
            randomizer(num1, num2, WrongAns, Ans, InputArith, inputDiff, rand1);
        }

        //Random problem
        else if (InputArith == 5) {
            randomizer(num1, num2, WrongAns, Ans, InputArith, inputDiff, rand1);
        }

        //Invalid input
        else {
            System.out.println("please enter a value of 1-4");
            Question(num1, num2, WrongAns, Ans, InputArith, inputDiff, rand1);  //Navigates to Question
        }

        Answer(num1, num2, input, WrongAns, Ans, InputArith, inputDiff, flag, rand1); //navigates to the answer output

    }

    //Randomizes which arithmetic to use
    public static void randomizer(double num1, double num2, int WrongAns, int Ans, int InputArith, int inputDiff, int rand1) {
        SecureRandom rand = new SecureRandom();
        InputArith = rand.nextInt(4) + 1; //Picks a method of math to use randomly

        //Sets flag to call back to this class
        rand1 = 1;

        Question(num1, num2, WrongAns, Ans, InputArith, inputDiff, rand1);  //Navigates to Question
    }

    //Prints output
    public static void Answer(double num1, double num2, double input, int WrongAns, int Ans, int InputArith, int inputDiff, int flag, int rand1) {

        //10 questions asked
        if (Ans == 9) {
            int percent = (10 - WrongAns); //calculates percentage

            //if above 75%
            if (percent > 7) {
                System.out.println("Congratulations, you are ready to go to the next level!");
            }
            //if below 75%
            else {
                System.out.println("Please ask your teacher for extra help.");
            }

            WrongAns = 0; //Resets amount failed for new user
            Ans = 0; //Resets amount tried for new user

            //Asks to run another test
            Scanner scnr = new Scanner(System.in);
            System.out.println("Do you want to run another test?\n1 - yes \n2 - no");
            int end = scnr.nextInt();

            //Ends or repeats the program
            if (end == 2) {
                return; //ends program when done
            } else {
                difficulty(WrongAns, Ans, rand1);  //Gets new random numbers then runs again
            }
        }

        //correct answer
        else if (flag == 1) {
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
            RandNumGen(WrongAns, Ans, InputArith, inputDiff, rand1);  //Gets new random numbers then runs again
        }

        //Wrong answer
        else if (flag == 0) {
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
            RandNumGen(WrongAns, Ans, InputArith, inputDiff, rand1);  //Gets new random numbers then runs again
        }
    }
}
