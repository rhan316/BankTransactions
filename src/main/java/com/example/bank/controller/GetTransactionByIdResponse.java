package com.example.bank.controller;

import com.example.bank.model.Transaction;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "getTransactionByIdResponse", namespace = "https://bank/transactions")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetTransactionByIdResponse {

    @XmlElement(name = "transaction", namespace = "https://bank/transactions")
    private Transaction transaction;

    public Transaction getTransaction() {
        return transaction;
    }
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
