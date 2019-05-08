package tn.esprit.jsf_app.presentation.mbeans;

import java.util.ArrayList;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DTO.Question;
import tn.esprit.jsf_app.services.QuestionClientService;

@ManagedBean
@SessionScoped
public class QuestionBean {	
	Question ques1; 
	Question ques2;
	Question ques3;
	ArrayList<Question> questionList;
	int idQ;
	int QuestionId;
	String questionTextv;
	String domainv;

	public Question getQues1() {
		return ques1;
	}
	public void setQues1(Question ques1) {
		this.ques1 = ques1;
	}
	public Question getQues2() {
		return ques2;
	}
	public void setQues2(Question ques2) {
		this.ques2 = ques2;
	}
	public Question getQues3() {
		return ques3;
	}
	public void setQues3(Question ques3) {
		this.ques3 = ques3;
	}
	public ArrayList<Question> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(ArrayList<Question> questionList) {
		this.questionList = questionList;
	}
	
	

	public int getIdQ() {
		return idQ;
	}
	public void setIdQ(int idQ) {
		this.idQ = idQ;
	}
	public int getQuestionId() {
		return QuestionId;
	}
	public void setQuestionId(int questionId) {
		QuestionId = questionId;
	}
	public String getQuestionTextv() {
		return questionTextv;
	}
	public void setQuestionTextv(String questionTextv) {
		this.questionTextv = questionTextv;
	}
	public String getDomainv() {
		return domainv;
	}
	public void setDomainv(String domainv) {
		this.domainv = domainv;
	}
	
	@EJB	
	QuestionClientService quest;
	
	public List<Question> doGetAll()
	{
		return questionList;
	}
	
	public String doGetQuestion()
	{

		System.out.println("*****"+idQ);
		//ques1 = quest.getClass()(idQ);
		return "listquestion.jsf?faces-redirect=true";
	}
	
	public String IndexGetAll()
	{
		return "listquestion.jsf?faces-redirect=true";
	}
	
	public String RemoveQuestion(int QuestionId)
	{
		quest.DelRequest(QuestionId);
		return "listquestion.jsf?faces-redirect=true";
	}
	
	public String EditQuestion(int QuestionId)
	{
	
		quest.Consommationbyid(QuestionId);
		ques3.setQuestionText(questionTextv.toString());
		ques3.setDomain(domainv.toString());
		quest.putRequest(QuestionId, ques3);
		return "question.jsf?faces-redirect=true";
	}
	
	public String AfficherQuestion(int QuestionId)
	{
		return "listquestion.jsf?faces-redirect=true";
	}
	
	
	public String AjouterQuestion()
	{
		Question question = new Question();
		question.setQuestionText(this.questionTextv);
		question.setDomain(this.domainv);
		quest.postRequest(question);
		return "listquestion.jsf?faces-redirect=true";
	}
	
	
	

}

