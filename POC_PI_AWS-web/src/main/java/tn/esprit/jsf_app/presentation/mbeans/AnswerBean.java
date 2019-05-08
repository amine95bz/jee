package tn.esprit.jsf_app.presentation.mbeans;

import java.util.ArrayList;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DTO.Answer;
import tn.esprit.jsf_app.services.AnswerClientService;



@ManagedBean
@SessionScoped
public class AnswerBean {
	
	Answer answ1;
	Answer answ2;
	Answer answ3;
	ArrayList<Answer> answerList;
	int answerId;
	int ResponseId;
	String responseTextv;
	public Answer getAnsw1() {
		return answ1;
	}
	public void setAnsw1(Answer answ1) {
		this.answ1 = answ1;
	}
	public Answer getAnsw2() {
		return answ2;
	}
	public void setAnsw2(Answer answ2) {
		this.answ2 = answ2;
	}
	public Answer getAnsw3() {
		return answ3;
	}
	public void setAnsw3(Answer answ3) {
		this.answ3 = answ3;
	}
	public ArrayList<Answer> getAnswerList() {
		return answerList;
	}
	public void setAnswerList(ArrayList<Answer> answerList) {
		this.answerList = answerList;
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public int getResponseId() {
		return ResponseId;
	}
	public void setResponseId(int responseId) {
		ResponseId = responseId;
	}
	public String getResponseTextv() {
		return responseTextv;
	}
	public void setResponseTextv(String responseTextv) {
		this.responseTextv = responseTextv;
	}
	@EJB
	AnswerClientService answ;
	
	public List<Answer> doGetAll()
	{
		return answ.getall();
	}
	
	public String doGetAnswer()
	{
		System.out.println("*****"+answerId);
		answ1 = answ.getById(answerId);
		return "answerid.jsf?faces-redirect=true";
	}
	
	public String IndexGetAll()
	{
		return "listanswer.jsf?faces-redirect=true";
	}
	
	public String RemoveAnswer(int ResponseId)
	{
		answ.DeleteById(ResponseId);
		return "listanswer.jsf?faces-redirect=true";
	}
	
	public String EditAnswer(int ResponseId)
	{
	
		answ3 = answ.getById(ResponseId);
		answ3.setResponseText(responseTextv);
		answ.EditById(ResponseId, answ3);
		return "responseedit.jsf?faces-redirect=true";
	}
	
	public String AfficherAnswer(int ResponseId)
	{	
		System.out.println("*****"+answerId);
		answ2 = answ.getById(ResponseId);
		setResponseTextv(answ2.getResponseText());
		return "answerlist.jsf?faces-redirect=true";
	}
	
	public String AjouterAnswer()
	{
		Answer answer = new Answer();
		answer.setResponseText(this.responseTextv);
		answ.addAnswer(answer);
		return "listquestion.jsf?faces-redirect=true";
	}
	
	
	

}
