package tn.esprit.jsf_app.services;

import java.util.List;
import javax.ejb.Remote;
import javax.ws.rs.core.Response;

import DTO.Pack;
import DTO.Question;

@Remote
public interface QuestionClientServiceRemote {
	void DelRequest(int id);
	void putRequest(int id, Question p);
	void postRequest(Question p);
	void Consommation();
	void Consommationbyid(int id);
}
