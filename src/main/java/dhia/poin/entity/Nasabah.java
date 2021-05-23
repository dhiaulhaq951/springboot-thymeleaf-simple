package dhia.poin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nasabah {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="account_id")
	private Integer accountId;
	
	@Column(name="account_name", length = 255, nullable = false, unique = true)
	private String accountName;
	
	public Nasabah() {
		// TODO Auto-generated constructor stub
	}
	
	public Nasabah(Integer accountId, String accountName) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
	}



	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

}
