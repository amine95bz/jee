package services;

import java.util.List;

import javax.ejb.Local;


import tn.esprit.terabyte.DTO.DTOTask;


@Local
public interface TaskServiceLocal1 {
	void Create(DTOTask p);
	void Update(DTOTask p , int id);
	List<DTOTask> GetAll();
	DTOTask GetOne(int id);
	void Delete(DTOTask id);

}
