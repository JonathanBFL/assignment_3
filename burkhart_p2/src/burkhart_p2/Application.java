package burkhart_p2;

public class Application {
    public static void main(String[] arg) {
        SavingsAccount saver1 = new SavingsAccount(2000);
        SavingsAccount saver2 = new SavingsAccount(3000);
        SavingsAccount.modifyInterestRate(0.04);
        System.out.println("Month \t\t Saver1 \t\t Saver2");

        for (int i = 0; i <= 12; i++) {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            if (i < 9) {
                System.out.print("Month " + (i + 1) + "\t\t");
                saver1.display();
                System.out.print("\t\t");
                saver2.display();
                System.out.println();
            } else if (i > 8 && i < 12) {
                System.out.print("Month " + (i + 1) + "\t");
                saver1.display();
                System.out.print("\t\t");
                saver2.display();
                System.out.println();
            } else if (i >= 12) {
                System.out.println("Interest is now 5%");
                SavingsAccount.modifyInterestRate(0.05);
                saver1.calculateMonthlyInterest();
                saver2.calculateMonthlyInterest();
                System.out.print("Month " + (i + 1) + "\t");
                saver1.display();
                System.out.print("\t\t");
                saver2.display();
                System.out.println();
            }
        }

    }
}
