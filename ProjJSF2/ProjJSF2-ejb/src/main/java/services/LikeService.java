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

import tn.esprit.terabyte.DTO.LikeDTO;


@Stateful
@LocalBean
public class LikeService implements LikeServiceRemote {

	@Override
	public void Create(LikeDTO l) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:63238/api/Lik");
		WebTarget hello =target.path("");
		
		Response response =hello.request().post(Entity.entity(l, MediaType.APPLICATION_JSON) );
		
		String result=response.readEntity(String.class);
		System.out.println(result);

		response.close();
		
	}

	@Override
	public List<LikeDTO> GetAll() {
		List<LikeDTO>  lasp = new ArrayList<LikeDTO>();
    	Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://localhost:63238/api/LikeWebApi"); 
    	
    	Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	
    	JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();
  
    	for (int i=0;i<object.size();i++)
    	{
    	 
    		LikeDTO m = new LikeDTO();
    	 
    	 m.setIdPub(object.getJsonObject(i).getInt("idPub")); 
    	 m.setIdUser(object.getJsonObject(i).getString("idUser")); 
    	
    	 
    	 lasp.add(m);}
    	return lasp;
	}

	@Override
	public void Delete(LikeDTO l) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:63238/api/LikeWebApi?idUser=cafc58b5-fe03-46c5-bd8f-f0f63860912c&idPub="+l.getIdPub());
		WebTarget hello =target.path("");
		
		Response response =hello.request().delete( );
		
		String result=response.readEntity(String.class);
		System.out.println(result);

		response.close();
		
	}

}
