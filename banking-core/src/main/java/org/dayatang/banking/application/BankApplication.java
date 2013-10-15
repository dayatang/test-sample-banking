package org.dayatang.banking.application;

import org.dayatang.banking.domain.Account;

public interface BankApplication {
	Account getAccount(long id);
	Account getAccountByName(String name);
	Account createAccount(String name);
	Account createAccount(String name, double balance);
	void removeAccount(Account account);
	void deposit(Account account, double amount);
	void withdraw(Account account, double amount);
	void transferFund(Account fromAccount, Account toAccount, double amount);
}
