package DTO;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Question implements Serializable{
	@JsonProperty ("QuestionId")
	public int QuestionId;
	@JsonProperty ("QuestionText")
	public String QuestionText;
	@JsonProperty ("Domain")
	public String Domain;
	@JsonProperty ("ResponseId")
	public int ResponseId;

	
	
	public int getQuestionId() {
		return QuestionId;
	}
	public void setQuestionId(int questionId) {
		QuestionId = questionId;
	}
	public String getQuestionText() {
		return QuestionText;
	}
	public void setQuestionText(String questionText) {
		QuestionText = questionText;
	}
	public String getDomain() {
		return Domain;
	}
	public void setDomain(String domain) {
		Domain = domain;
	}
	

	public int getResponseId() {
		return ResponseId;
	}
	public void setResponseId(int responseId) {
		ResponseId = responseId;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Question [QuestionId=" + QuestionId + ", QuestionText=" + QuestionText + ", Domain=" + Domain + "]";
	}
	
	
	public Question()
	{
		
	}
	
	public Question(int questionId, String questionText, String domain)
	{
		
		QuestionId = questionId;
		QuestionText = questionText;
		Domain = domain; 

		
	}
	
	
	

}

