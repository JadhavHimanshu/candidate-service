package org.dnyanyog.common;

public enum ResponseCode {
  Add_Candidate("Candidate Added Sucessfully", "200"),
  Update_Candidate("Candidate Updated Sucessfully", "200"),
  Search_Candidate("Candidate Found", "200"),
  Delete_Candidate("Candidate Deleted Sucessfully", "200"),
  Candidate_Not_Found("Candidate Added Sucessfully", "200");

  private final String code;
  private final String message;

  private ResponseCode(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
