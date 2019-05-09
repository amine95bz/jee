package services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.terabyte.DTO.CommentDTO;
@Local
public interface CommentServiceLocal {
	void Create(CommentDTO l);
	List<CommentDTO> GetAll();
	void Delete(CommentDTO id);

}
