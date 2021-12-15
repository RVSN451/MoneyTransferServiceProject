package com.example.moneytransferserviceproject;

import com.example.moneytransferserviceproject.model.CardAmount;
import com.example.moneytransferserviceproject.model.operations.Operation;
import com.example.moneytransferserviceproject.model.paymentCards.DebitCard;
import com.example.moneytransferserviceproject.model.paymentCards.PaymentCard;
import com.example.moneytransferserviceproject.repository.DebitCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CommandLinApp implements CommandLineRunner {

    public static final Currency RUB = Currency.getInstance("RUB");
    public static final Currency EUR = Currency.getInstance("EUR");
    public static final Currency USD = Currency.getInstance("USD");

    public static final Map<String, PaymentCard> cardMap = new HashMap();
    //public static final Map<String, Operation> operationMap = new HashMap<>();
    public static final int percent = 1;

    @Autowired
    private DebitCardRepository repository;
    public CommandLinApp(DebitCardRepository repository) {
        this.repository = repository;
    }

    @Override

    public void run(String... args) throws Exception {


        DebitCard dk1 = new DebitCard("Vasiliy", "Kostakov",
                "1111111111111111", "111", "11/22",
                new CardAmount(100000, "RUB"));

        DebitCard dk2 = new DebitCard("Sergey", "Ivanov",
                "2222222222222222", "222", "11/22",
                new CardAmount(100000, "RUB"));

        cardMap.put(dk1.getCardNumber(), dk1);
        cardMap.put(dk2.getCardNumber(), dk2);
    }
}
