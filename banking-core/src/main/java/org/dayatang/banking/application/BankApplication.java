package org.dayatang.banking.application;

import java.util.List;

import org.dayatang.banking.domain.Account;

public interface BankApplication {
	Account getAccount(long id);
	Account getAccountByName(String name);
	Account createAccount(String name);
	Account createAccount(String name, double balance);
	List<Account> listAccounts();
	void removeAccount(Account account);
	void deposit(Account account, double amount);
	void withdraw(Account account, double amount);
	void transferFund(Account fromAccount, Account toAccount, double amount);
}
