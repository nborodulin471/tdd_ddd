package task1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

class CreditCalculatorTest {
    private CreditCalculator sut;
    private double sumCredit;
    private double percent;
    private int period;


    @Before
    public void init() {
        sut = null;
        sumCredit = 100000;
        percent = 0.2;
        period = 12;
    }

    @Test
    public void calculateMonthPaymentTest_succes() {
        double except = 10000;

        double actual = sut.calculateMonthPayment(sumCredit, percent, period);

        assertEquals(except, actual);
    }

    @Test
    // ArithmeticException
    public void calculateMonthPaymentTest_err() {
        assertThrows(ArithmeticException.class, () -> sut.calculateMonthPayment(sumCredit, percent, 0));
    }

    @Test
    public void calculateAmountRefundedTest_succes() {
        double except = 120000;

        double actual = sut.calculateAmountRefunded(sumCredit, percent);

        assertEquals(except, actual);

    }

    @Test
    // Ежемесячный платеж × Срок кредита в месяцах − Сумма основного долга = Проценты по кредиту
    public void calculateAllOverpaymentTest_succes() {
        double except = 20000;

        double actual = sut.calculateAllOverpayment(sumCredit, percent);

        assertEquals(except, actual);
    }
}