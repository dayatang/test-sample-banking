package org.dayatang.banking.application.impl;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.dayatang.banking.IoCUtils;
import org.dayatang.banking.application.BankApplication;
import org.dayatang.banking.domain.Account;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dayatang.domain.InstanceFactory;

public class BankApplicationImplIntegrationTest {

	private BankApplication instance;
	private Account from;
	private Account to;

	@BeforeClass
	public static void classSetup() throws Exception {
		IoCUtils.init();
	}

	@AfterClass
	public static void classTearDown() throws Exception {
	}
	
	@Before
	public void beforeTest() {
		instance = InstanceFactory.getInstance(BankApplication.class);
	}
	
	@After
	public void afterTest() {
	}
	
	@Test
	public void testGetAccount() {
		assertThat(instance.getAccount(1).getName(), is("张三"));
		assertThat(instance.getAccount(2).getName(), is("李四"));
	}

	@Test
	public void testGetAccountByName() {
		assertThat(instance.getAccountByName("张三").getName(), is("张三"));
		assertThat(instance.getAccountByName("李四").getName(), is("李四"));
	}
	
	@Test
	public void testListAccounts() {
		
	}


	@Test
	public void testCreateAccountWithName() {
		Account account = instance.createAccount("newAccount");
		account = instance.getAccount(account.getId());
		assertNotNull(account);
		assertEquals("newAccount", account.getName());
		assertEquals(0.0, account.getBalance(), 0.0001);
		instance.removeAccount(account);
	}

	@Test
	public void testCreateAccountWithNameAndBalance() {
		Account account = instance.createAccount("newAccount", 250.5);
		account = instance.getAccount(account.getId());
		assertNotNull(account);
		assertEquals("newAccount", account.getName());
		assertEquals(250.5, account.getBalance(), 0.0001);
		instance.removeAccount(account);
	}

	@Test
	public void testRemoveAccount() {
		Account account = instance.createAccount("newAccount", 250.5);
		assertNotNull(instance.getAccount(account.getId()));
		instance.removeAccount(account);
		assertNull(instance.getAccount(account.getId()));
	}

	@Test
	public void testDeposit() {
		from = instance.getAccountByName("张三");
		instance.deposit(from, 20);
		from = instance.getAccount(from.getId());
		assertEquals(1020.0, from.getBalance(), 0.0001);
	}

	@Test
	public void testWithdraw() {
		from = instance.getAccountByName("张三");
		instance.withdraw(from, 20);
		from = instance.getAccount(from.getId());
		assertEquals(980, from.getBalance(), 0.0001);
	}

	@Test
	public void testTransferFund() {
		from = instance.getAccountByName("张三");
		to = instance.getAccountByName("李四");
		instance.transferFund(from, to, 200);
		assertEquals(800, from.getBalance(), 0.0001);
		assertEquals(300, to.getBalance(), 0.0001);
	}

}
