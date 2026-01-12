package net.wassim.accountservice.strategy;

public class CreditCardPayment implements PaymentService {

    @Override
    public void pay() {
        System.out.println("Payment par carte bancaire");
    }
}
