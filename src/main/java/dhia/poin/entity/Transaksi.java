package dhia.poin.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaksi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="transaksi_id")
	private Integer transaksiId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="account_id")
	private Nasabah accountId;
	
	@Column(name="transaction_date")
	private Date transactionDate;
	
	@Column(name="description")
	private String description;
	
	@Column(name="debitcreditstatus")
	private String debitCreditStatus;
	
	@Column(name="amount")
	private Double amount;

	public Integer getTransaksiId() {
		return transaksiId;
	}

	public void setTransaksiId(Integer transaksiId) {
		this.transaksiId = transaksiId;
	}

	public Nasabah getAccountId() {
		return accountId;
	}

	public void setAccountId(Nasabah accountId) {
		this.accountId = accountId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDebitCreditStatus() {
		return debitCreditStatus;
	}

	public void setDebitCreditStatus(String debitCreditStatus) {
		this.debitCreditStatus = debitCreditStatus;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
