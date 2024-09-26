package com.example.bank.controller;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "getTransactionByIdRequest", namespace = "http://example.com/bank")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetTransactionByIdRequest {

    @XmlElement(name = "id", namespace = "http://example.com/bank", required = true)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
