package services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.terabyte.DTO.DTOTask;
@Remote
public interface TaskServiceRemote1 {
	void Create(DTOTask p);
	void Update(DTOTask p , int id);
	List<DTOTask> GetAll();
	DTOTask GetOne(int id);
	void Delete(DTOTask id);

}
