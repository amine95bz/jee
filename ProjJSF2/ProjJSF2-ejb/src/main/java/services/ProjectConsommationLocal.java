package services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.terabyte.DTO.ProjectDTO;


@Local
public interface ProjectConsommationLocal {

	
	void postRequest(ProjectDTO p);
	void putRequest(ProjectDTO p , int id);
	List<ProjectDTO> GetAll();
	
	void DelProject(ProjectDTO id);
}



