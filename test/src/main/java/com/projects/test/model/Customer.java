package com.projects.test.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    @Column(name = "firstName")
    private String FirstName;
    @Column(name = "lastName")
    private String LastName;
    @OneToMany(mappedBy = "CustomerID")
    private List<Transaction> transactions;
public Customer(){
        super();
    }
public Customer(Long ID, String FirstName, String LastName) {
        super();
        this.ID = ID;
        this.FirstName = FirstName;
        this.LastName = LastName;
    }

public Long getID() {
	return ID;
}
public void setID(Long iD) {
	ID = iD;
}
public String getFirstName() {
	return FirstName;
}
public void setFirstName(String firstName) {
	FirstName = firstName;
}
public String getLastName() {
	return LastName;
}
public void setLastName(String lastName) {
	LastName = lastName;
}

public List<Transaction> getTransactions() {
	return transactions;
}
public void setTransactions(List<Transaction> transactions) {
	this.transactions = transactions;
}



}
