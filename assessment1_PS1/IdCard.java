package org.assignment.assignment_first;


import jakarta.persistence.*;

@Entity
public class IdCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "cardNumber")
	private String cardNumber;
	
	@Column(name = "issueDate")
	private String issueDate;
	
	@OneToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public IdCard() {}

	public IdCard(String cardNumber, String issueDate) {
		super();
		this.cardNumber = cardNumber;
		this.issueDate = issueDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
}
