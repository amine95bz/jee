package services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.terabyte.DTO.LikeDTO;
@Remote
public interface LikeServiceRemote {
	
		void Create(LikeDTO l);
		List<LikeDTO> GetAll();
		void Delete(LikeDTO id);

	
}
