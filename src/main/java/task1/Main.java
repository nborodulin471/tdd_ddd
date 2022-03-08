package task1;

public class Main {
    public static void main(String[] args) {
        CreditCalculator calculator = new CreditCalculatorImpl();
        double sumCredit = 100000;
        double percent = 0.2;
        int period = 12;

        System.out.println(calculator.calculateMonthPayment(sumCredit, percent, period));
        System.out.println(calculator.calculateAmountRefunded(sumCredit, percent));
        System.out.println(calculator.calculateAllOverpayment(sumCredit, percent));
    }
}
