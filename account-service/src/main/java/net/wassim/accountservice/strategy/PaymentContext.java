package net.wassim.accountservice.strategy;

public class PaymentContext {
    private PaymentService strategy;

    public void setPayment(PaymentService paymentService) {
        strategy = paymentService;
    }

    public void executePayment() {
        strategy.pay();
    }
}
