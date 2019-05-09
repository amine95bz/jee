package services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.terabyte.DTO.LikeDTO;

@Local
public interface LikeServiceLocal {
	void Create(LikeDTO l);
	List<LikeDTO> GetAll();
	void Delete(LikeDTO id);

}
