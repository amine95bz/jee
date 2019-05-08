package tn.esprit.jsf_app.services;

import java.util.List;

import javax.ejb.Remote;

import DTO.Pack;

@Remote
public interface PackClientServiceRemote {
	
	void DelRequest(int id);
	void Consommationbyid(int id);
	void putRequest(int id, Pack p);
	void postRequest(Pack p);
	public List<Pack> Consommation();
	List<Pack> GetAll();
}
