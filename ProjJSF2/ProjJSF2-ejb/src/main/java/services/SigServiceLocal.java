package services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.terabyte.DTO.SigDto;


@Local
public interface SigServiceLocal {
	void Create(SigDto l);
	List<SigDto> GetAll();
	void Delete(SigDto id);
}
