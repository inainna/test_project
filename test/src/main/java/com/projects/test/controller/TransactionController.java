package com.projects.test.controller;

import com.projects.test.exception.TransactionNotFoundException;
import com.projects.test.model.Transaction;
import com.projects.test.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import java.util.List;

@RestController
public class TransactionController {

@Autowired
    TransactionRepository transactionRepository;

    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @PostMapping("/transactions")
    public Transaction createTransaction(@Valid @RequestBody Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @GetMapping("/transactions/{id}")
    public Transaction getTransactionById(@PathVariable(value = "id") Long transactionID) throws TransactionNotFoundException {
        return transactionRepository.findById(transactionID)
                .orElseThrow(() -> new TransactionNotFoundException(transactionID));
    }

    @PutMapping("/transactions/{id}")
    public Transaction updateTransaction(@PathVariable(value = "id") Long transactionID,
                           @Valid @RequestBody Transaction transactionDetails) throws TransactionNotFoundException {

Transaction transaction = transactionRepository.findById(transactionID)
                .orElseThrow(() -> new TransactionNotFoundException(transactionID));

transaction.setEffectiveDate(transactionDetails.getEffectiveDate());
transaction.setAmount(transactionDetails.getAmount());
transaction.setCurrency(transactionDetails.getCurrency());
transaction.setDebitAccountID(transactionDetails.getDebitAccountID());
transaction.setCreditAccountID(transactionDetails.getCreditAccountID());
transaction.setCustomerID(transactionDetails.getCustomerID());

Transaction updatedTransaction = transactionRepository.save(transaction);

return updatedTransaction;
    }

    @DeleteMapping("/transactions/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable(value = "id") Long transactionID) throws TransactionNotFoundException {
        Transaction transaction = transactionRepository.findById(transactionID)
                .orElseThrow(() -> new TransactionNotFoundException(transactionID));

transactionRepository.delete(transaction);

return ResponseEntity.ok().build();
    }
}
