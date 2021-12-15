package com.example.moneytransferserviceproject.service;

import com.example.moneytransferserviceproject.model.ConfirmOperation;
import com.example.moneytransferserviceproject.model.Transfer;
import com.example.moneytransferserviceproject.model.operations.Operation;
import com.example.moneytransferserviceproject.model.operations.OperationId;
import com.example.moneytransferserviceproject.repository.DebitCardRepository;
import org.springframework.stereotype.Service;



@Service
public class MTS_Service {
    private DebitCardRepository repository;

    public MTS_Service(DebitCardRepository repository){
        this.repository = repository;
    }

    public Operation transferMoneyCardToCard(Transfer transfer){

        return Operation.addOperation(transfer);
    }


    public OperationId checkVerification(ConfirmOperation confirmOperation) {
        return Operation.checkVerification(confirmOperation);
    }
}
