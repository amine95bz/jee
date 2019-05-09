package services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.terabyte.DTO.SigDto;
@Remote
public interface SigServiceRemote {
	void Create(SigDto l);
	List<SigDto> GetAll();
	void Delete(SigDto id);

}
