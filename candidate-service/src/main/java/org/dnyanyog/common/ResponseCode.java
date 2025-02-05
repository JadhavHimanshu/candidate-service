package org.dnyanyog.common;

public enum ResponseCode {
  Add_Candidate("200", "Candidate Added Sucessfully"),
  Update_Candidate("200", " Candidate Updated Sucessfully"),
  Search_Candidate("200", " Candidate Found "),
  Delete_Candidate("200", "Candidate Deleted Sucessfully"),
  Candidate_Not_Found("404", "Candidate Not Found");

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
