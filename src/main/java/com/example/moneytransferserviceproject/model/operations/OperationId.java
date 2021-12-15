package com.example.moneytransferserviceproject.model.operations;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.UUID;

@Data
public class OperationId {
    @Setter(AccessLevel.NONE)
    private String operationId;


    public OperationId(){
        this.operationId = UUID.randomUUID().toString();
    }
}
