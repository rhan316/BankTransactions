package com.example.bank.controller;

import com.example.bank.model.Transaction;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "addTransactionResponse", namespace = "https://bank/transactions")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddTransactionResponse {
    @XmlElement(name = "transaction", namespace = "https://bank/transactions", required = true)
    private Transaction transaction;

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
