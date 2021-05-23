package dhia.poin.model;

import java.util.Date;

public class TransaksiModel {
	
	private Integer transaksiId;
	private NasabahModel accountId;
	private Date transactionDate;
	private String description;
	private String debitCreditStatus;
	private Double amount;
	public Integer getTransaksiId() {
		return transaksiId;
	}
	public void setTransaksiId(Integer transaksiId) {
		this.transaksiId = transaksiId;
	}
	public NasabahModel getAccountId() {
		return accountId;
	}
	public void setAccountId(NasabahModel accountId) {
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
