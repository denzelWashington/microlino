package net.wassim.accountservice.strategy;

public class PaypalPayment implements PaymentService {

    @Override
    public void pay() {
        System.out.println("Payment avec Paypal");
    }
}
