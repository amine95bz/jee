package tn.esprit.terabyte.DTO;


public class DTOTask {
	 private int TaskId ;
	 private String name ;
	 private String start_date ;
	 private String end_date ;
	 private State state ;
	 private String ImageUrl ;
	 private Complexity complexity ;
	 private int priority ;
	 private int progress ;
	 private String UserId ;
     public int ProjectId ;
	public int getTaskId() {
		return TaskId;
	}
	public void setTaskId(int taskId) {
		TaskId = taskId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public String getImageUrl() {
		return ImageUrl;
	}
	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}
	public Complexity getComplexity() {
		return complexity;
	}
	public void setComplexity(Complexity complexity) {
		this.complexity = complexity;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public int getProjectId() {
		return ProjectId;
	}
	public void setProjectId(int projectId) {
		ProjectId = projectId;
	}
	public DTOTask(int taskId, String name, String start_date, String end_date, State state, String imageUrl,
			Complexity complexity, int priority, int progress, String userId, int projectId) {
		super();
		TaskId = taskId;
		this.name = name;
		this.start_date = start_date;
		this.end_date = end_date;
		this.state = state;
		ImageUrl = imageUrl;
		this.complexity = complexity;
		this.priority = priority;
		this.progress = progress;
		UserId = userId;
		ProjectId = projectId;
	}
	public DTOTask(String name, String start_date, String end_date, State state, String imageUrl, Complexity complexity,
			int priority, int progress, String userId, int projectId) {
		super();
		this.name = name;
		this.start_date = start_date;
		this.end_date = end_date;
		this.state = state;
		ImageUrl = imageUrl;
		this.complexity = complexity;
		this.priority = priority;
		this.progress = progress;
		UserId = userId;
		ProjectId = projectId;
	}
	
	
	
	public DTOTask(String name,  State state, Complexity complexity, int priority, int progress) {
		super();
		this.name = name;
	
		this.state = state;
		this.complexity = complexity;
		this.priority = priority;
		this.progress = progress;
	}
	public DTOTask() {
		super();
	}
	
     
     
     
	

}
