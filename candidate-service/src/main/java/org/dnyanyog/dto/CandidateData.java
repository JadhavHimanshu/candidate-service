package org.dnyanyog.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CandidateData {

  private Long candidatecode;

  //@NotBlank //(message = "Candidate ID is Mandatory")
  private String candidateId;

  @NotBlank(message = "Firstname is mandatory")
  private String firstName;

  @NotBlank(message = "Middlename is mandatory")
  private String middleName;

  @NotBlank(message = "Lastname is mandatory")
  private String lastName;

  private Integer vacancy;

  @NotBlank(message = "Email cannot be balnk")
  @Email(message = "Invalid email format")
  private String email;

  @Digits(message = "Mobile number must be  valid 10 digit number", fraction = 0, integer = 10)
  @NotNull(message = "Mobile number is mandatory")
  private Integer mobile;

  @NotNull(message = "Resume Media Id must be a positive number") //@postive
  private Integer resumeMediaId;

  @NotBlank(message = "Tenant is mandatory")
  private String tenant;

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

  public Integer getVacancy() {
    return vacancy;
  }

  public void setVacancy(Integer vacancy) {
    this.vacancy = vacancy;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getMobile() {
    return mobile;
  }

  public void setMobile(Integer mobile) {
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

  public Long getCandidatecode() {
    return candidatecode;
  }

  public void setCandidatecode(Long candidatecode) {
    this.candidatecode = candidatecode;
  }

public String getCandidateId() {
	return candidateId;
}

public void setCandidateId(String candidateId) {
	this.candidateId = candidateId;
}
}
