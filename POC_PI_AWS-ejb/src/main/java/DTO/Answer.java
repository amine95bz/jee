package DTO;


import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Answer implements Serializable {
	
	@JsonProperty("ResonseId")
	public int ResponseId;
	
	@JsonProperty("ResponseText")
	public String ResponseText;
	
	@JsonProperty("QuestionID")
	public int QuestionID;
	
	public int getQuestionID() {
		return QuestionID;
	}

	public void setQuestionID(int questionID) {
		QuestionID = questionID;
	}

	public int getResponseId() {
		return ResponseId;
	}

	public void setResponseId(int responseId) {
		ResponseId = responseId;
	}

	public String getResponseText() {
		return ResponseText;
	}

	public void setResponseText(String responseText) {
		ResponseText = responseText;
	}

	@Override
	public String toString() {
		return "Answer [ResponseId=" + ResponseId + ", ResponseText=" + ResponseText + ", QuestionID" + QuestionID +"]";
	}
	public Answer() {

	}

	public Answer(int responseId, String responseText) {
		super();
		ResponseId = responseId;
		ResponseText = responseText;
		
	}
	public Answer(int responseId, String responseText,int questionID) {
		super();
		ResponseId = responseId;
		ResponseText = responseText;
		QuestionID= questionID;
	}

	
	

}

