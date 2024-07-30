package test;

import strategy.CreditCardPayment;
import strategy.PayPalPayment;
import strategy.PaymentContext;
import strategy.PaymentStrategy;

public class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        // Using Credit Card Payment
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432", "John Doe");
        paymentContext.setPaymentStrategy(creditCardPayment);
        paymentContext.executePayment(250.75);

        System.out.println();

        // Using PayPal Payment
        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com");
        paymentContext.setPaymentStrategy(payPalPayment);
        paymentContext.executePayment(125.50);
    }
}