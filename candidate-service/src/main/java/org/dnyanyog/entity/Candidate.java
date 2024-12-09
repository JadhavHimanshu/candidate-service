package org.dnyanyog.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Candidate_Management")
@Component
public class Candidate {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "resume_id", nullable = false, updatable = false, insertable = false)
	private long resumeMediaId;
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "middlename")
	private String middleName;
	@Column(name = "lastname")
	private String lastName;
	@Column(name = "vacancy")
	private int vacancy;
	@Column(name = "email")
	private String email;
	@Column(name = "mobile")
	private int mobile; 
	   
	 public static Candidate getInstance() {
		  return new Candidate(); 
	 }

	public String getFirstName() {
		return firstName;
	}

	public Candidate setFirstName(String firstName) {
		this.firstName = firstName;  
		 return this ; 
	}

	public String getMiddleName() {
		return middleName;
	}

	public Candidate setMiddleName(String middleName) {
		this.middleName = middleName; 
		 return this ; 
	}

	public String getLastName() {
		return lastName;
	}

	public Candidate setLastName(String lastName) {
		this.lastName = lastName; 
		 return this ; 
	}

	public int getVacancy() {
		return vacancy;
	}

	public Candidate setVacancy(int vacancy) {
		this.vacancy = vacancy; 
		 return this ; 
	}

	public String getEmail() {
		return email;
	}

	public Candidate setEmail(String email) {
		this.email = email; 
		 return this ; 
	}

	public int getMobile() {
		return mobile;
	}

	public Candidate setMobile(int mobile) {
		this.mobile = mobile; 
		 return this ; 
	}

	public long getResumeMediaId() {
		return resumeMediaId;
	}

	public Candidate setResumeMediaId(int resumeMediaId) {
		this.resumeMediaId = resumeMediaId;  
		 return this ; 
	}

}
