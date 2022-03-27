package task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CreditCalculatorTest {
    private CreditCalculator sut;
    private double sumCredit;
    private double percent;
    private int period;


    @BeforeEach
    public void init() {
        sut = new CreditCalculatorImpl();
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
    @DisplayName("Ошибка деления на ноль при расчете ежемечесного платежа")
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