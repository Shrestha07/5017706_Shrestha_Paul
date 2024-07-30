package test;

import payment.*;

public class PaymentProcessorTest {
    public static void main(String[] args) {
        PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPal());
        PaymentProcessor razorPayProcessor = new RazorPayAdapter(new RazorPay());

        payPalProcessor.processPayment(100.00);
        razorPayProcessor.processPayment(200.00);
    }
}