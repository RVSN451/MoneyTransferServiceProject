package com.example.moneytransferserviceproject.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MTS_Repository {
    private DebitCardRepository debitCardRepository;

    public MTS_Repository(DebitCardRepository debitCardRepository){
        this.debitCardRepository = debitCardRepository;
    }


}
