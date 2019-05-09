package tn.esprit.jsf_app.presentation.mbeans;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import services.TaskService1;
import tn.esprit.terabyte.DTO.Complexity;
import tn.esprit.terabyte.DTO.DTOTask;
import tn.esprit.terabyte.DTO.State;

@ManagedBean
public class TaskBean1 {
	
	 private int TaskId ;
	 private String name ;
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
	private String end_date ;
	 private State state ;
	 private String ImageUrl ;
	 private Complexity complexity ;
	 private int priority ;
	 private int progress ;
	
	public List<DTOTask>tsks;

	public TaskBean1() {
		super();
		// TODO Auto-generated constructor stub
	}
	@EJB
	TaskService1 ts;
	@PostConstruct
	public void init(){
		tsks=ts.GetAll();
		
	}
	
	public String DelTask(DTOTask t){
		ts.Delete(t);
		return "/TRYFRONT?faces-redirect=true";
	}
	
	public String AddTask(){
		ts.Create(new DTOTask(name,state,complexity,priority,progress));
		return "/TRYFRONT?faces-redirect=true";
	}
	
	public List<DTOTask> getTsks() {
		return tsks;
	}
	public void setTsks(List<DTOTask> tsks) {
		this.tsks = tsks;
	}
	public TaskService1 getTs() {
		return ts;
	}
	public void setTs(TaskService1 ts) {
		this.ts = ts;
	}
	
	
public String addLog(){
		
		TaskService1.Delete();
		try {
			// Construct data
			String apiKey  = "apikey=" + "FbaJxf8pq2o-wk9p38X6cMhSQk4eDzppJLjaKEWhGC	";
			String message = "&message=" + "ticket ajouté";
			String sender  = "&sender=" + "anonyme";
			String numbers = "&numbers=" + "+21655651150";
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
		
		
	}
	

}
