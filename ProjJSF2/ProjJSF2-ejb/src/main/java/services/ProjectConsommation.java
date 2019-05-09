package services;

import java.io.StringReader;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;

import javax.json.JsonReader;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.terabyte.DTO.Category;
import tn.esprit.terabyte.DTO.ProjectDTO;









/**
 * Session Bean implementation class DemandeurConsom
 * @param <Meeting>
 */
@Stateless
@LocalBean
public class ProjectConsommation implements ProjectConsommationRemote {

	//post : http://localhost:63238/api/Proj
	//delete http://localhost:63238/api/ProjectWebApi?id=2
	//update http://localhost:63238/api/ProjectUp?id=2
	//getById
	
	@PersistenceContext
	EntityManager em;
	ProjectDTO p;

	    /**
	     * Default constructor. 
	     */
	    public ProjectConsommation() {
	        // TODO Auto-generated constructor stub
	    }

	    public List<ProjectDTO> consommation()
	    {
	    	List<ProjectDTO>  lasp = new ArrayList<ProjectDTO>();
	    	Client client = ClientBuilder.newClient();
	    	
	    	WebTarget web = client.target("http://localhost:63238/api/ProjectWebApi"); 
	    	
	    	Response response = web.request().get();
	    	
	    	String result = response.readEntity(String.class); 
	    	
	    	//System.out.println(result);
	    	JsonReader jsonReader = Json.createReader(new StringReader(result));
	    	JsonArray object =  jsonReader.readArray();
	    	System.out.println("erreuuur");
	   
	    	
	    	for (int i=0;i<object.size();i++)
	    	{
	    	 
	    		ProjectDTO p = new ProjectDTO();
	    		String Name=object.getJsonObject(i).get("Name").toString();
	    		Name= Name.replaceAll("\"", "");
	    	    p.setName(Name);
	    	    
	    	    
	    	    String Description=object.getJsonObject(i).get("Description").toString();
	    	    Description= Description.replaceAll("\"", "");
	    	    p.setDescription(Description);
	    	 
	    	 System.out.println("teeeeessst"); 
	    	 
	    	 p.setCategory(Category.values()[Integer.parseInt(object.getJsonObject(i).get("Category").toString())] );
	    	
	    	 System.out.println(Integer.parseInt(object.getJsonObject(i).get("Category").toString()));
	    	 
	    	 p.setProjectId(Integer.parseInt(object.getJsonObject(i).get("ProjectId").toString()));
	    	 p.setTeamId(Integer.parseInt(object.getJsonObject(i).get("TeamId").toString()));
	    	
	    	
	    	 

	    	 lasp.add(p);
	    	 
	    	}
	    	System.out.println("test");

	return lasp;    	
	    }
	    
	    public static final String baseUri = "http://localhost:63238/api/Proj";
		
	    private Client client = null;
	    private WebTarget target = null;

	   
	    
	    public void reloadUri() {
	        target = null;
	        target = client.target(baseUri);
	    }
	    
	    
	    @Override
	    public void postRequest(ProjectDTO p) {
			
	    	Client client = ClientBuilder.newClient();
			WebTarget target = client.target("http://localhost:63238/api/Proj");
			WebTarget hello =target.path("");
			Response response =hello.request().post(Entity.entity(p, MediaType.APPLICATION_JSON) );
			
			String result=response.readEntity(String.class);
			System.out.println(result);

			response.close();
			
	    }
	    
	
		
		
		
		@Override
		public void DelProject(ProjectDTO p) {
			// TODO Auto-generated method stub
			Client client = ClientBuilder.newClient();
			WebTarget target = client.target("http://localhost:63238/api/ProjectWebApi?id="+p.getProjectId());
			WebTarget hello =target.path("");
			
			Response response =hello.request().delete( );
			
			String result=response.readEntity(String.class);
			System.out.println(result);

			response.close();
			
		}
		
		
		
		
		public void putRequest(int id, ProjectDTO p) {
			ProjectDTO pack = new ProjectDTO();
	        pack.setDescription(p.Description);
	        pack.setName(p.Name);
	        
	      

			Client client = ClientBuilder.newClient();
			WebTarget target = client.target("http://jeedep-env.p9ijm22fnf.eu-west-1.elasticbeanstalk.com/api/Up?id="+id);
			Response response = target
			                 .request()
			                 .put(Entity.entity(pack, MediaType.APPLICATION_JSON));
			   System.out.println(response);
			
			
		}

		@Override
		public void putRequest(ProjectDTO p, int id) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<ProjectDTO> GetAll() {
			// TODO Auto-generated method stub
			return null;
		}

		
		
		@Override
		public long calcul1() {
			String sql = "SELECT COUNT(p.Category) FROM ProjectDTO p WHERE p.Category='Cloud'";
			Query q = em.createQuery(sql);
			long count = (long) q.getSingleResult();

			return count;
		}
		
		@Override
		public long calcul2() {
			String sql = "SELECT COUNT(p.Category) FROM ProjectDTO p WHERE p.Category='Securite'";
			Query q = em.createQuery(sql);
			long count = (long) q.getSingleResult();

			return count;
		}
		
		@Override
		public long calcul3() {
			String sql = "SELECT COUNT(p.Category) FROM ProjectDTO p WHERE p.Category='Dev'";
			Query q = em.createQuery(sql);
			long count = (long) q.getSingleResult();

			return count;
		}
		
		@Override
		public long calcul4() {
			String sql = "SELECT COUNT(p.Category) FROM ProjectDTO p WHERE p.Category='BI'";
			Query q = em.createQuery(sql);
			long count = (long) q.getSingleResult();

			return count;
		}
		
		@Override
		public long calcul5() {
			String sql = "SELECT COUNT(p.Category) FROM ProjectDTO p WHERE p.Category='other'";
			Query q = em.createQuery(sql);
			long count = (long) q.getSingleResult();

			return count;
		}
		
		
		
	  
		
	}

