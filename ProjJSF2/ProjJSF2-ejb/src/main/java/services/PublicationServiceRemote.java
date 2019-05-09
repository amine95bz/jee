package services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.terabyte.DTO.PublicationDTO;

@Remote
public interface PublicationServiceRemote {
	void Create(PublicationDTO p);
	void Update(PublicationDTO p , int id);
	void Signaler(PublicationDTO p , int id);
	List<PublicationDTO> GetAll();
	PublicationDTO GetOne(int id);
	void Delete(PublicationDTO id);

}
