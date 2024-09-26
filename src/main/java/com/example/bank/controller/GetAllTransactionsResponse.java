package com.example.bank.controller;

import com.example.bank.model.Transaction;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "getAllTransactionsResponse", namespace = "http://example.com/bank")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetAllTransactionsResponse {
    @XmlElement(name = "transactionList", namespace = "http://example.com/bank")
    private List<Transaction> transactionList;

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}
