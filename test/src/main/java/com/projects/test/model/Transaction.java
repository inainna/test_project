package com.projects.test.model;

import javax.persistence.*;
import com.projects.test.model.Customer;



@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String EffectiveDate;
    private Long Amount;
    private String Currency;
	private Long DebitAccountID;
	private Long CreditAccountID;
    @ManyToOne(targetEntity=Customer.class)
    @JoinColumn(name="customer_id")
	private Customer CustomerID;
public Transaction(){
        super();
    }
public Transaction(Long ID, String EffectiveDate, Long Amount, String Currency, Long DebitAccountID, Long CreditAccountID, Customer CustomerID) {
        super();
        this.ID = ID;
        this.EffectiveDate = EffectiveDate;
        this.Amount = Amount;
        this.Currency=Currency;
        this.DebitAccountID = DebitAccountID;
        this.CreditAccountID = CreditAccountID;
        this.CustomerID=CustomerID;
    }

public Long getID() {
	return ID;
}
public void setID(Long iD) {
	this.ID = iD;
}
public String getEffectiveDate() {
	return EffectiveDate;
}
public void setEffectiveDate(String effectiveDate) {
	this.EffectiveDate = effectiveDate;
}
public Long getAmount() {
	return Amount;
}
public void setAmount(Long amount) {
	this.Amount = amount;
}
public String getCurrency() {
	return Currency;
}
public void setCurrency(String currency) {
	this.Currency = currency;
}
public Long getDebitAccountID() {
	return DebitAccountID;
}
public void setDebitAccountID(Long debitAccountID) {
	this.DebitAccountID = debitAccountID;
}
public Long getCreditAccountID() {
	return CreditAccountID;
}
public void setCreditAccountID(Long creditAccountID) {
	this.CreditAccountID = creditAccountID;
}
public Customer getCustomerID() {
	return CustomerID;
}
public void setCustomerID(Customer customerID) {
	CustomerID = customerID;
}


}