package task1;

public interface CreditCalculator {
    public double calculateMonthPayment(double sumCredit, double percent, int period);

    public double calculateAmountRefunded(double sumCredit, double percent);

    public double calculateAllOverpayment(double sumCredit, double percent);
}
