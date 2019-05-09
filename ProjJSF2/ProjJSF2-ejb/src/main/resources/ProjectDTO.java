package tn.esprit.terabyte.DTO;

public class ProjectDTO {
	
	

	public int ProjectId;
	public String Name;
	public String Image;
	public String Description;
	public Category Category;
	public int Progress;
	public int TeamId;
	
	
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
	public void setProgress(int string) {
		Progress = string;
	}
	public int getTeamId() {
		return TeamId;
	}
	public void setTeamId(int teamId) {
		TeamId = teamId;
	}
	@Override
	public String toString() {
		return "ProjectDTO [ProjectId=" + ProjectId + ", Name=" + Name + ", Image=" + Image + ", Description="
				+ Description + ", Category=" + Category + ", Progress=" + Progress + ", TeamId=" + TeamId + "]";
	}
	public ProjectDTO(int projectId, String name, String image, String description,
			Category category, int progress, int teamId) {
		super();
		ProjectId = projectId;
		Name = name;
		Image = image;
		Description = description;
		Category = category;
		Progress = progress;
		TeamId = teamId;
	}
	
	
	
	public ProjectDTO(int projectId, String name, String image, String description,
			tn.esprit.terabyte.DTO.Category category, int teamId) {
		super();
		ProjectId = projectId;
		Name = name;
		Image = image;
		Description = description;
		Category = category;
		TeamId = teamId;
	}
	public ProjectDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	
	
	
	
	


	

	

}