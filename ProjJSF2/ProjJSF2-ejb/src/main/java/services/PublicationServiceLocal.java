package services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.terabyte.DTO.PublicationDTO;

@Local
public interface PublicationServiceLocal {
	void Create(PublicationDTO p);
	void Update(PublicationDTO p , int id);
	void Signaler(PublicationDTO p , int id);
	List<PublicationDTO> GetAll();
	PublicationDTO GetOne(int id);
	void Delete(PublicationDTO id);
}
