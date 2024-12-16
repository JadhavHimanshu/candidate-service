package org.dnyanyog.common;

public enum ErrorCode {
	Add_Candidate("0000", "Candidate Added Sucessfully"), Update_Candidate("0000", " Candidate Updated Sucessfully"),
	Search_Candidate("0000", " Candidate Found "), Delete_Candidate("0000", "Candidate Deleted Sucessfully"),
	Candidate_Not_Found("911" ,"Candidate Not Found" );
	private final String code ;
 	private final String message;
	private ErrorCode(String code, String message) {
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
