package org.dnyanyog.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "Candidate_Management")
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Candidate {
  @Id
  @Column(name = "can_code", nullable = false, updatable = false, insertable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long candidatecode;

  @Column(name = "can_id")
  private String candidateId;

  @Column(name = "resumeMediaID" , nullable = true)
  private Integer resumeMediaId;

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
  private Integer mobile;

  @Column(name = "password")
  private Integer password;

  public static Candidate getInstance() {
    return new Candidate();
  }

  public String getFirstName() {
    return firstName;
  }

  public Candidate setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getMiddleName() {
    return middleName;
  }

  public Candidate setMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public Candidate setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public int getVacancy() {
    return vacancy;
  }

  public Candidate setVacancy(int vacancy) {
    this.vacancy = vacancy;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public Candidate setEmail(String email) {
    this.email = email;
    return this;
  }

  public int getMobile() {
    return mobile;
  }

  public Candidate setMobile(int mobile) {
    this.mobile = mobile;
    return this;
  }

  public Integer getResumeMediaId() {
    return resumeMediaId;
  }

  public Candidate setResumeMediaId(Integer string) {
    this.resumeMediaId = string;
    return this;
  }

  public Integer getPassword() {
    return password;
  }

  public void setPassword(Integer password) {
    this.password = password;
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
