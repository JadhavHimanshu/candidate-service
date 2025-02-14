package org.dnyanyog.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CandidateResponse {

  private String message;
  private String  Code;
  private String firstName;
  private String middleName;
  private String lastName;
  private Integer vacancy;
  private String email;
  private Integer mobile;
  private Integer resumeMediaId;
  private String tenant;
  private Long candidatecode;
  private String candidateId;
public String getMessage() {
	return message;                       
}
public void setMessage(String message) {
	this.message = message;
}
public String getCode() {
	return Code;
}
public void setCode(String code) {
	Code = code;
}
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
public String getTenant() {
	return tenant;
}
public void setTenant(String tenant) {
	this.tenant = tenant;
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