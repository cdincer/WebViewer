package com.bondviewer.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "Bonds" )
public class Bond {
		
		@Id
		@Column(name = "TransactionId")
		@GeneratedValue(strategy=GenerationType.AUTO)
		Integer IdItem;

	    public Integer getIdItem() {
			return IdItem;
		}
		public void setIdItem(Integer idItem) {
			IdItem = idItem;
		}
		
		@Column(name = "Bond_No")
		Integer BondNumber;	
		
		@Column(name = "nextPaymentDate")
	   Date NextPaymentDate;
		
		@Column(name = "bondCurrency")
	   String BondCurrency;
		
		@Column(name = "itemEntered")
	   Date ItemEntered;
		
		@Column(name = "bankBuy")
	   Double BankBuy;
		
		@Column(name = "bankSell")
	   Double BankSell;
		
		@Column(name = "interestRate")
	   Double InterestRate;
		
		@Column(name = "endOfBond")
	   Date EndOfBond;


	    //Other code
	   
	public Date getItemEntered() {
    return ItemEntered;
	}
	public void setItemEntered(Date itemEntered) {
		ItemEntered = itemEntered;
	}
		@Column(name = "Bond_No")
	public Integer getBondNumber() {
		return BondNumber;
	}
	public void setBondNumber(Integer bondNumber) {
		BondNumber = bondNumber;
	}
	public Date getNextPaymentDate() {
		return NextPaymentDate;
	}
	public void setNextPaymentDate(Date nextPaymentDate) {
		NextPaymentDate = nextPaymentDate;
	}
	public String getBondCurrency() {
		return BondCurrency;
	}
	public void setBondCurrency(String bondCurrency) {
		BondCurrency = bondCurrency;
	}
	public Double getBankBuy() {
		return BankBuy;
	}
	public void setBankBuy(Double bankBuy) {
		BankBuy = bankBuy;
	}
	public Double getBankSell() {
		return BankSell;
	}
	public void setBankSell(Double bankSell) {
		BankSell = bankSell;
	}
	public Double getInterestRate() {
		return InterestRate;
	}
	public void setInterestRate(Double interestRate) {
		InterestRate = interestRate;
	}
	public Date getEndOfBond() {
		return EndOfBond;
	}
	public void setEndOfBond(Date endOfBond) {
		EndOfBond = endOfBond;
	}

}
