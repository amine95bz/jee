package tn.esprit.test.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import services.ProjectConsommation;
import tn.esprit.terabyte.DTO.*;
import tn.esprit.terabyte.DTO.ProjectDTO;





@ManagedBean
@ViewScoped
public class ProjectBean {
	
	public int ProjectId;
	public String Name;
	public String Image;
	public String Description;
	public Category Category;
	public int Progress;
	public int TeamId;
	
	
	
	private List<ProjectDTO> Projects= new ArrayList<ProjectDTO>();
	
	@EJB
	private ProjectConsommation PC;
	
	
	
	public String DelProject(ProjectDTO p){
		PC.DelProject(p);
		return "/IndexProject?faces-redirect=true";
	}
	
	public String Redirect(){
		
		return "/CreateProject?faces-redirect=true";
	}
	

public String RedirectToIndex(){
		
		return "/IndexProject?faces-redirect=true";
	}

public String RedirectToDetails(){
	return "/DetailsProject?faces-redirect=true";
	
}





	public String AddProject(){
		PC.postRequest(new ProjectDTO(ProjectId,Name,Description,"Capture",Category,TeamId));
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Empty."));

		return "/IndexProject?faces-redirect=true";
	}

	
	
	public List<ProjectDTO> getProjects() {
		return Projects;
	}


	public void setProjects(List<ProjectDTO> projects) {
		Projects = projects;
	}

	
	
	public ProjectConsommation getPC() {
		return PC;
	}



	public void setPC(ProjectConsommation pC) {
		PC = pC;
	}



	@PostConstruct
	public void init(){
		
		Projects = PC.consommation();
		
	}

	public int getProjectId() {
		return ProjectId;
	}

	public void setProjectId(int projectId) {
		ProjectId = projectId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Category getCategory() {
		return Category;
	}

	public void setCategory(Category category) {
		Category = category;
	}

	public int getProgress() {
		return Progress;
	}

	public void setProgress(int progress) {
		Progress = progress;
	}

	public int getTeamId() {
		return TeamId;
	}

	public void setTeamId(int teamId) {
		TeamId = teamId;
	}
	
	
	
	


	
			
	

}
