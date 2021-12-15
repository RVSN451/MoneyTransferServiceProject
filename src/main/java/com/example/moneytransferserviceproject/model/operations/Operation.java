package com.example.moneytransferserviceproject.model.operations;

import com.example.moneytransferserviceproject.CommandLinApp;
import com.example.moneytransferserviceproject.exceptions.ErrorInputData;
import com.example.moneytransferserviceproject.model.CardAmount;
import com.example.moneytransferserviceproject.model.ConfirmOperation;
import com.example.moneytransferserviceproject.model.Transfer;
import com.example.moneytransferserviceproject.model.paymentCards.PaymentCard;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


@Data
//@Setter(AccessLevel.NONE)

public class Operation implements Serializable {
    private static final String VERIFICATION_CODE = "0000";
    private static final Map<String, PaymentCard> cardMap = CommandLinApp.cardMap;
    private static Map<String, Operation> operationMap = new HashMap<>();


    private OperationId operationId;

    private PaymentCard cardFrom;

    private PaymentCard cardTo;

    private CardAmount amount;


    private boolean checkOperation;


    private Operation(Transfer transfer) {
        try {
            if (cardMap.get(transfer.getCardFromNumber()).checkCardCvv(transfer.getCardFromCVV())) {
                this.cardFrom = cardMap.get(transfer.getCardFromNumber());
                this.cardTo = cardMap.get(transfer.getCardToNumber());
            } else throw new ErrorInputData("CVV incorrect");

        } catch (NullPointerException n) {
            throw new ErrorInputData("PaymentCard number error");
        }
        this.amount = transfer.getCardAmount();
        this.operationId = new OperationId();
        this.checkOperation = false;
    }

    public static Operation addOperation(Transfer transfer) {
        Operation operation = new Operation(transfer);
        if (operation.getCardFrom() != null
                && operation.getCardTo() != null
                && operation.getCardFrom() != operation.getCardTo()) {
            operationMap.put(operation.operationId.getOperationId(), operation);
        } else {
            throw new ErrorInputData("PaymentCard number error");
        }

        return operationMap.get(operation.operationId.getOperationId());
    }

    public static OperationId checkVerification(ConfirmOperation confirmOperation) {

        if (!VERIFICATION_CODE.equals(confirmOperation.getCode())
                || operationMap.get(confirmOperation.getOperationId()).checkOperation) {

            throw new ErrorInputData("CheckVerification false");
        }
        return operationMap.get(confirmOperation.getOperationId()).getOperationId();
    }
}






