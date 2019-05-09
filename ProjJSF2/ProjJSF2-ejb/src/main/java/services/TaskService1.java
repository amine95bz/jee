package services;

import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.terabyte.DTO.Complexity;
import tn.esprit.terabyte.DTO.DTOTask;
import tn.esprit.terabyte.DTO.State;

@Stateful
@LocalBean
public class TaskService1 implements TaskServiceRemote1 {

	@Override
	public void Create(DTOTask p) {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:63238/api/Tass");
		WebTarget hello =target.path("");
		
		Response response =hello.request().post(Entity.entity(p, MediaType.APPLICATION_JSON) );
		
		String result=response.readEntity(String.class);
		System.out.println(result);

		response.close();
		
	}

	@Override
	public void Update(DTOTask p, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DTOTask> GetAll() {
		List<DTOTask>  lasp = new ArrayList<DTOTask>();
    	Client client = ClientBuilder.newClient();
    	WebTarget web = client.target("http://localhost:63238/api/TaskWebApi"); 
    	Response response = web.request().get();
    	String result = response.readEntity(String.class); 
    	//System.out.println(result);
    	JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();
    	SimpleDateFormat sfd = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    	
    	
    	
    	
    	for (int i=0;i<object.size();i++)
    	{
    	 
    		DTOTask m = new DTOTask();
    	 
    	 m.setTaskId(object.getJsonObject(i).getInt("TaskId")); 
    	 m.setName(object.getJsonObject(i).getString("name")); 
    	 m.setStart_date(object.getJsonObject(i).getString("start_date"));
    	 m.setEnd_date(object.getJsonObject(i).getString("end_date"));
    	 m.setImageUrl(object.getJsonObject(i).getString("ImageUrl"));
    	 m.setState(State.values()[(object.getJsonObject(i).getInt("state"))]);
    	 m.setComplexity(Complexity.values()[(object.getJsonObject(i).getInt("complexity"))]);
    	 lasp.add(m);
    	}
    	

return lasp;
	}



	@Override
	public DTOTask GetOne(int id) {
		// TODO Auto-generated method stub
		List<DTOTask> task = new ArrayList<DTOTask>();
		Client client = ClientBuilder.newClient();
		WebTarget web = client.target("http://localhost:63238/api/TaskWebApi");
		Response response = web.request().get();
		String result = response.readEntity(String.class);
		JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();	
    	SimpleDateFormat sfd = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    		DTOTask g = new DTOTask();
    		
		 g.setTaskId(object.getJsonObject(0).getInt("TaskId")); 
       	 g.setName(object.getJsonObject(0).getString("name")); 
       	 g.setStart_date(object.getJsonObject(0).getString("start_date"));
       	 g.setEnd_date(object.getJsonObject(0).getString("end_date"));
       	 g.setImageUrl(object.getJsonObject(0).getString("ImageUrl"));
       	 g.setState(State.values()[(object.getJsonObject(0).getInt("state"))]);
       	 g.setComplexity(Complexity.values()[(object.getJsonObject(0).getInt("complexity"))]);
       	 
    		
    	return g;
	}

	@Override
	public void Delete(DTOTask id) {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:63238/api/TaskWebApi?id="+id.getTaskId());
		WebTarget hello =target.path("");
		
		Response response =hello.request().delete( );
		
		String result=response.readEntity(String.class);
		System.out.println(result);

		response.close();
		//EmailAttachmentSender m =new EmailAttachmentSender ();
		
		//m.sendEmailWithAttachments("bz.amine95@gmail.com", "Dexter147*6469",  a.getEmail() , "alerte", "Your task has been deleted ");
		//System.out.println("Email sent.");
	}


}
