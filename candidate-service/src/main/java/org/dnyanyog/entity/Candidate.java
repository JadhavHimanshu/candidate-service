package org.dnyanyog.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = " Candidate_Management")
@Component
public class Candidate {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
    public int resumeMediaId;
	public String firstName;
	public String middleName;
	public String lastName;
	public int vacancy;
	public String email;
	public int mobile; 
	 

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getVacancy() {
		return vacancy;
	}

	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public int getResumeMediaId() {
		return resumeMediaId;
	}

	public void setResumeMediaId(int resumeMediaId) {
		this.resumeMediaId = resumeMediaId;
	}

}
