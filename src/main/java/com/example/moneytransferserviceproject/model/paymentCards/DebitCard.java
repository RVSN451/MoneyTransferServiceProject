package com.example.moneytransferserviceproject.model.paymentCards;

import com.example.moneytransferserviceproject.CommandLinApp;
import com.example.moneytransferserviceproject.model.CardAmount;
import com.example.moneytransferserviceproject.model.paymentCards.PaymentCard;
import lombok.*;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)

@Validated

@Entity
@Table
public class DebitCard implements Serializable, PaymentCard {
    @Column(nullable = false)
    @Pattern(regexp = "^[A-Z]{1}\\.[a-z]{1,20}$")
    String holderName;
    @Column(nullable = false)
    @Pattern(regexp = "^[A-Z]{1}\\.[a-z]{1,20}$")
    String holderSurname;
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    @Pattern(regexp = "^[0-9]{16}$")
    @Id
    String cardNumber;
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    //@ToString.Exclude
    @Pattern(regexp = "^[0-9]{3}$")
    String cardCVV;
    @Column(nullable = false)
    String cardValidTill;
    @Column(nullable = false)
    @Embedded
    CardAmount amount;

    @Override
    public boolean checkCardCvv(String cardCVV) {
        System.out.println("BD - " + this.cardCVV + " CARD -" + cardCVV + "EQ - " + this.cardCVV.equals(cardCVV));
        return this.cardCVV.equals(cardCVV);
    }

    @Override
    public boolean subtractAmount(int subtract) {

        int subtractSum = subtract + (int)Math.ceil(((CommandLinApp.percent * subtract) / 100));
        if (this.amount.getValue() >= subtractSum) {
            this.amount.subtractAmount(subtractSum);
            return  true;
        } else {
            return false;
        }
    }

    @Override
    public void addAmount(int add) {
        this.amount.addAmount(add);
    }

}
