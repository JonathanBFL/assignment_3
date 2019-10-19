package burkhart_p2;

public class SavingsAccount {
    private static double annualInterestRate;

    private double savingsBalance;

    public void savingsBalance(double Balance) {
        savingsBalance = Balance;
    }

    public void calculateMonthlyInterest() {
        savingsBalance = (savingsBalance + (savingsBalance * annualInterestRate / 12.0));
    }

    public static void modifyInterestRate(double InterestRate) {
        annualInterestRate = InterestRate;
    }

    public void display() {
        System.out.printf("$%.2f", savingsBalance);
    }

    public SavingsAccount(double balance) {
        savingsBalance(balance);
    }
}
