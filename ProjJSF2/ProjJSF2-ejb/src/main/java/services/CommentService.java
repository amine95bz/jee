package services;

import java.io.StringReader;
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

import tn.esprit.terabyte.DTO.CommentDTO;


@Stateful
@LocalBean
public class CommentService implements CommentServiceRemote{

	@Override
	public void Create(CommentDTO l) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:63238/api/Comm");
		WebTarget hello =target.path("");
		
		Response response =hello.request().post(Entity.entity(l, MediaType.APPLICATION_JSON) );
		
		String result=response.readEntity(String.class);
		System.out.println(result);

		response.close();
		
	}

	@Override
	public List<CommentDTO> GetAll() {
		List<CommentDTO>  lasp = new ArrayList<CommentDTO>();
    	Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://localhost:63238/api/CommentWebApi"); 
    	
    	Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	
    	JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();
  
    	for (int i=0;i<object.size();i++)
    	{
    	 
    		CommentDTO m = new CommentDTO();
    	 
    	 m.setCommentId(object.getJsonObject(i).getInt("CommentId")); 
    	 m.setContenu(object.getJsonObject(i).getString("Contenu")); 
    	 m.setPublicationId(object.getJsonObject(i).getInt("PublicationId"));
    	
    	 
    	 lasp.add(m);}
    	return lasp;
	}

	@Override
	public void Delete(CommentDTO l) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:63238/api/CommentWebApi&id="+l.getCommentId());
		WebTarget hello =target.path("");
		
		Response response =hello.request().delete( );
		
		String result=response.readEntity(String.class);
		System.out.println(result);

		response.close();
		
	}
	

}
