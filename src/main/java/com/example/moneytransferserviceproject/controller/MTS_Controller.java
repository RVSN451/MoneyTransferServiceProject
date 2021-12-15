package com.example.moneytransferserviceproject.controller;

import com.example.moneytransferserviceproject.model.ConfirmOperation;
import com.example.moneytransferserviceproject.model.Transfer;
import com.example.moneytransferserviceproject.model.operations.OperationId;
import com.example.moneytransferserviceproject.service.MTS_Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
public class MTS_Controller {

    private MTS_Service service;

    public MTS_Controller(MTS_Service service) {
        this.service = service;
    }


    @CrossOrigin
    @PostMapping("/transfer")
    public OperationId transferMoneyCardToCard(@Valid @RequestBody Transfer transfer) {
        return service.transferMoneyCardToCard(transfer).getOperationId();
    }

    @CrossOrigin
    @PostMapping("/confirmOperation")
    public OperationId checkVerification(@Valid @RequestBody ConfirmOperation confirmOperation) {
        return service.checkVerification(confirmOperation);
    }
}
