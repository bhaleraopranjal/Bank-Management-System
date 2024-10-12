package com.bank.account;

import java.time.LocalTime;

public class Transaction {
	LocalTime Time;
    String Operation_Perform;
    double amount;

    public Transaction(String description, double amount) {
        this.Time = LocalTime.now();
        this.Operation_Perform = description;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Date Time: " + Time +
                ",   Operation_Perform: '" + Operation_Perform + '\'' +
                ",   Amount: " + amount;
    }
}


