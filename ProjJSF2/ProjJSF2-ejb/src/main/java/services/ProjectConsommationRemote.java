package services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.terabyte.DTO.ProjectDTO;



@Remote
public interface ProjectConsommationRemote {
	
	void postRequest(ProjectDTO p);
	void putRequest(ProjectDTO p , int id);
	List<ProjectDTO> GetAll();
	
	void DelProject(ProjectDTO id);
	long calcul1();
	long calcul2();
	long calcul3();
	long calcul4();
	long calcul5();

}

