package com.example.moneytransferserviceproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class Transfer {
    @Pattern(regexp = "^[0-9]{16}$")
    private String cardFromNumber;

    @Pattern(regexp = ("^[0-9][0-2]+/[2-3][0-9]$"))
    private String cardFromValidTill;

    @Pattern(regexp = "^[0-9]{3}$")
    private String cardFromCVV;

    @Pattern(regexp = "^[0-9]{16}$")
    private String cardToNumber;

    CardAmount cardAmount;


    @JsonCreator
    public Transfer(@JsonProperty("cardFromNumber") String cardFromNumber,
                    @JsonProperty("cardFromValidTill") String cardFromValidTill,
                    @JsonProperty("cardFromCVV") String cardFromCVV,
                    @JsonProperty("cardToNumber") String cardToNumber,
                    @JsonProperty("amount") CardAmount amount) {

        this.cardFromNumber = cardFromNumber;
        this.cardFromValidTill = cardFromValidTill;
        this.cardFromCVV = cardFromCVV;
        this.cardToNumber = cardToNumber;
        this.cardAmount = amount;
    }
}
