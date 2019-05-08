package tn.esprit.jsf_app.services;

import java.util.List;

import javax.ejb.Remote;
import javax.ws.rs.core.Response;

import DTO.Pack;
import DTO.Quiz;

@Remote
public interface QuizClientServiceRemote {
	void DelRequest(int id);

	void putRequest(int id, Quiz p);

	void postRequest(Quiz p);

	void Consommation();

	void Consommationbyid(int id);
}
