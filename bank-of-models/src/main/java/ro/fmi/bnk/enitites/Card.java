package ro.fmi.bnk.enitites;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CARD")
public class Card {
	private Long id;
	private Date creationDate;
	private Date modificationDate;
	private Boolean active;
	private String cardNumber;
	private String cvc;
	private Date expiryDate;
	private Customer holderName;
	private CardStatus cardStatus;
	private CardType cardType;
	private Account account;

	public Card(Long id, Date creationDate, Date modificationDate, Boolean active, String cardNumber, String cvc, Date expiryDate,
			Customer holderName, CardStatus cardStatus, CardType cardType, Account account) {
		super();
		this.id = id;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		this.active = active;
		this.cardNumber = cardNumber;
		this.setCvc(cvc);
		this.expiryDate = expiryDate;
		this.holderName = holderName;
		this.cardStatus = cardStatus;
		this.cardType = cardType;
		this.account = account;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATIONDATE")
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFICATIONDATE")
	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	@Column(name = "ACTIVE")
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Column(name = "CARDNUMBER")
	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	@Column(name = "CVC")
	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "EXPIRYDATE")
	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID")
	public Customer getHolderName() {
		return holderName;
	}

	public void setHolderName(Customer holderName) {
		this.holderName = holderName;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CARDSTATUS_ID")
	public CardStatus getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(CardStatus cardStatus) {
		this.cardStatus = cardStatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CARDTYPE_ID")
	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_ID")
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}



}
