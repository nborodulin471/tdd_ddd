package task1;

public class CreditCalculatorImpl implements CreditCalculator{
    @Override
    public double calculateMonthPayment(double sumCredit, double percent, int period) {
        if (period == 0){
            throw new ArithmeticException("Нельзя делить на ноль");
        }
        return (sumCredit + (sumCredit * percent)) / period;
    }

    @Override
    public double calculateAmountRefunded(double sumCredit, double percent) {
        return sumCredit + (sumCredit * percent);
    }

    @Override
    public double calculateAllOverpayment(double sumCredit, double percent) {
        return sumCredit * percent;
    }
}
