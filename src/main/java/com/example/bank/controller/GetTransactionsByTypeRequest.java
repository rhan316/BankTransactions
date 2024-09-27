package com.example.bank.controller;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "getTransactionsByTypeRequest", namespace = "https://bank/transactions")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetTransactionsByTypeRequest {

    @XmlElement(name = "type", namespace = "https://bank/transactions", required = true)
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
