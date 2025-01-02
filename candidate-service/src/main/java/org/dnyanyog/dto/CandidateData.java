package org.dnyanyog.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CandidateData {
	@NotBlank(message = "Firstname is mandatory")
	public String firstName;
	@NotBlank(message = "Middlename is mandatory")
	public String middleName;
	@NotBlank(message = "Lastname is mandatory")
	public String lastName;
	public int vacancy;
	@NotBlank(message = "Email cannot be balnk")
	@Email(message = "Invalid email format")
	public String email;
	@Digits(message = "Mbile number must be  valid 10 digit number", fraction = 0, integer = 10)
	@NotNull(message = "Mobile number is mandatory")
	public int mobile;
	@Positive(message = "Resume Media Id must be a positive number")
	public Integer resumeMediaId;
	@NotBlank(message = "Tenant is mandatory")
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

	public Integer getResumeMediaId() {
		return resumeMediaId;
	}

	public void setResumeMediaId(Integer resumeMediaId) {
		this.resumeMediaId = resumeMediaId;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

}
