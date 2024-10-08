package com.example.bank.controller;

import com.example.bank.model.Transaction;
import com.example.bank.model.TransactionType;
import com.example.bank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class TransactionSoapService {

    private final TransactionService transactionService;
    private final String NAMESPACE_URI = "https://bank/transactions";

    @Autowired
    public TransactionSoapService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllTransactionsRequest")
    @ResponsePayload
    public GetAllTransactionsResponse getAllTransactions() {
        List<Transaction> transactionList = transactionService.getAllTransactions();

        var response = new GetAllTransactionsResponse();
        response.setTransactionList(transactionList);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTransactionByIdRequest")
    @ResponsePayload
    public GetTransactionByIdResponse getTransactionById(@RequestPayload GetTransactionByIdRequest request) {
        Long id = request.getId();
        var transaction = transactionService.getTransactionById(id).orElse(null);

        var response = new GetTransactionByIdResponse();
        response.setTransaction(transaction);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addTransactionRequest")
    @ResponsePayload
    public AddTransactionResponse addTransaction(@RequestPayload AddTransactionRequest request) {
        if (request.getTransaction() == null) {
            throw new IllegalArgumentException("Transaction is null!");
        }
        var transaction = new Transaction();
        transaction.setAmount(request.getTransaction().getAmount());
        transaction.setDescription(request.getTransaction().getDescription());
        transaction.setType(request.getTransaction().getType());
        transaction.setDateTime(request.getTransaction().getDateTime());

        var savedTransaction = transactionService.addTransaction(transaction);

        var response = new AddTransactionResponse();
        response.setTransaction(savedTransaction);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTransactionsByTypeRequest")
    @ResponsePayload
    public GetTransactionsByTypeResponse getTransactionsByType(@RequestPayload GetTransactionsByTypeRequest request) {
        var transactionType = TransactionType.valueOf(request.getType().toUpperCase());
        List<Transaction> transactionList = transactionService.getTransactionsByType(transactionType);

        var response = new GetTransactionsByTypeResponse();
        response.setTransactionList(transactionList);

        return response;
    }
}
