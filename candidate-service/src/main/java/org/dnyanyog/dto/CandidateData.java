package org.dnyanyog.dto;

public class CandidateData {
	public String firstName;
	public String middleName;
	public String lastName;
	public int vacancy;
	public String email;
	public int mobile;
	public int resumeMediaId;
	public String tenant;

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	

}
