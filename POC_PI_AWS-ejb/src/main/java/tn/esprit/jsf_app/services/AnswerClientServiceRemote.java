package tn.esprit.jsf_app.services;

import java.util.List;

import javax.ejb.Remote;
import javax.ws.rs.core.Response;

import DTO.Answer;

@Remote
public interface AnswerClientServiceRemote {
	 List<Answer>  getall();
	 Answer getById(int questionId);
	 void DeleteById(int answerId);
	 Response EditById(int answerId, Answer a);
	 void addAnswer(Answer a);
	void postRequest(Answer p);
	void Consommation();
	
}
