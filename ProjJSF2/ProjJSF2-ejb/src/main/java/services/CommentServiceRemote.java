package services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.terabyte.DTO.CommentDTO;
@Remote
public interface CommentServiceRemote {
	void Create(CommentDTO l);
	List<CommentDTO> GetAll();
	void Delete(CommentDTO id);

}
