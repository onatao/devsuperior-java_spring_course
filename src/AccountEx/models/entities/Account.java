package AccountEx.models.entities;

import AccountEx.models.exception.DomainException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double limit;
	public Account(Integer number, String holder, Double balance, Double limit) {
		super();
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.limit = limit;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Double getLimit() {
		return limit;
	}
	public void setLimit(Double limit) {
		this.limit = limit;
	}
	
	public void deposit(Double amount) {
		balance += amount;
	}
	
	public void withdraw(Double amount) throws DomainException {
		if (this.getBalance() < amount) {
			throw new DomainException("Saldo insuficiente");
		} else if (this.getBalance() == 0) {
			throw new DomainException("Conta não possui saldo");
		}else if (amount > limit) {
			throw new DomainException("Limite insuficiente.");
		}else {
			System.out.println("Saque realizado com sucesso!");
			setBalance(getBalance() - amount);
		}
	}

}
