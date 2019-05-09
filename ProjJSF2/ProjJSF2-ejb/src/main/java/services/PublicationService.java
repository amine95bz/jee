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

import tn.esprit.terabyte.DTO.PublicationDTO;
@Stateful
@LocalBean
public class PublicationService implements PublicationServiceRemote{

	@Override
	public void Create(PublicationDTO p) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:63238/api/Pub");
		WebTarget hello =target.path("");
		p.setOwnerId("cafc58b5-fe03-46c5-bd8f-f0f63860912c");
		p.setNomuser("feres");
		p.setImage("Image");
		Response response =hello.request().post(Entity.entity(p, MediaType.APPLICATION_JSON) );
		
		String result=response.readEntity(String.class);
		System.out.println(result);

		response.close();
		
		
	}

	@Override
	public void Update(PublicationDTO p , int id) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:63238/api/PubUp?id="+id);
		WebTarget hello =target.path("");
		
		Response response =hello.request().put(Entity.entity(p, MediaType.APPLICATION_JSON) );
		
		String result=response.readEntity(String.class);
		System.out.println(result);

		response.close();
		
	}

	@Override
	public List<PublicationDTO> GetAll() {
		//Client client = ClientBuilder.newClient();
		//WebTarget target = client.target("http://localhost:31618/api/PubWebApi/");
		//WebTarget hello =target.path("");
		//Response response =hello.request().get();
		
		//String result=response.readEntity(String.class);
		
		//PublicationDTO[] pubs =  response.readEntity(PublicationDTO[].class);

		//response.close();
		//return pubs;
		List<PublicationDTO>  lasp = new ArrayList<PublicationDTO>();
    	Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://localhost:63238/api/PubWebApi"); 
    	
    	Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	//System.out.println(result);
    	JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();
    	SimpleDateFormat sfd = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    	for (int i=0;i<object.size();i++)
    	{
    	 
    		PublicationDTO m = new PublicationDTO();
    	 
    	 m.setPublicationId(object.getJsonObject(i).getInt("PublicationId")); 
    	 m.setTitle(object.getJsonObject(i).getString("title")); 
    	 m.setDescription(object.getJsonObject(i).getString("description"));
    	 m.setImage(object.getJsonObject(i).getString("image"));
    	 m.setCreationDate(object.getJsonObject(i).getString("creationDate"));
    	 m.setNbSig(object.getJsonObject(i).getInt("nbSig"));
    	 lasp.add(m);
    	}
    	

return lasp;    	
	}

	@Override
	public PublicationDTO GetOne(int id) {
		List<PublicationDTO>  lasp = new ArrayList<PublicationDTO>();
    	Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://localhost:63238/api/PubWebApi/"); 
    	
    	Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	//System.out.println(result);
    	JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();
    	SimpleDateFormat sfd = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    	
    	 
    		PublicationDTO m = new PublicationDTO();
    	 
    	 m.setPublicationId(object.getJsonObject(0).getInt("PublicationId")); 
    	 m.setTitle(object.getJsonObject(0).getString("title")); 
    	 m.setDescription(object.getJsonObject(0).getString("description"));
    	 m.setImage(object.getJsonObject(0).getString("image"));
    	 m.setCreationDate(object.getJsonObject(0).getString("creationDate"));
    	 
 return m;   	
	}

	@Override
	public void Delete(PublicationDTO p) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:63238/api/PubWebApi/"+p.getPublicationId());
		WebTarget hello =target.path("");
		
		Response response =hello.request().delete( );
		
		String result=response.readEntity(String.class);
		System.out.println(result);

		response.close();
		
	}

	@Override
	public void Signaler(PublicationDTO p, int id) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:63238/api/Signaler?id="+id);
		WebTarget hello =target.path("");
		
		Response response =hello.request().put(Entity.entity(p, MediaType.APPLICATION_JSON) );
		
		String result=response.readEntity(String.class);
		System.out.println(result);

		response.close();
		
	}

}
