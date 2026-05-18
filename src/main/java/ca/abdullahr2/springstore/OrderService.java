package ca.abdullahr2.springstore;

public class OrderService {
    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("OrderService Created");
    }

    public void placeOrder() {
        paymentService.processPayment(10);
    }

    public void setPaymentService() {
        this.paymentService = paymentService;
    }
}
