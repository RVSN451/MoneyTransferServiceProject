package com.example.moneytransferserviceproject.model.paymentCards;

public interface PaymentCard {
    public boolean checkCardCvv(String cardCVV);
    public boolean subtractAmount(int subtract);
    public void addAmount(int add);


}
