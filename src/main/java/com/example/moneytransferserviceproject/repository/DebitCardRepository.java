package com.example.moneytransferserviceproject.repository;

import com.example.moneytransferserviceproject.model.paymentCards.DebitCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebitCardRepository extends JpaRepository<DebitCard, String> {

}
