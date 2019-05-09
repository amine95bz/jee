package tn.esprit.test.presentation.mbeans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import services.PublicationService;
import tn.esprit.terabyte.DTO.PublicationDTO;
import tn.esprit.terabyte.DTO.Visibility;
@ManagedBean

public class PublicationBean {
	private int PublicationId ;
	private String title ;
	private String description ;
	private String image ;
	private Visibility visibility ;
	private PublicationDTO pp;
	private String creationDate ;;
	
	private List<PublicationDTO> pubss;

	@EJB
	PublicationService ps;
	
	//public List<PublicationDTO> getPubs(){
	//	for (PublicationDTO p : ps.GetAll()) {
	//		pubss.add(p);
	//	}
	//	return pubss;
	//}

	@PostConstruct
	public void init(){
		//ps.Update(new PublicationDTO("feres","feres","feresImg"),5);
		//ps.Delete(new PublicationDTO(4,"jee","jee","jeeImg",Visibility.Public,"date"));
		//ps.Create(new PublicationDTO("alpha","alpha","alpha"));
		
		pubss=ps.GetAll();

	}
	public String BackToPub(){
		return "/Publications?faces-redirect=true";
	}
	public String DelPub(PublicationDTO p){
		ps.Delete(p);
		return "/Publications?faces-redirect=true";
	}
	public String AddPub(){
		ps.Create(new PublicationDTO(title,description,image));
		return "/Publications?faces-redirect=true";
	}
	public String modifier(PublicationDTO p){
		this.PublicationId=p.getPublicationId();
		this.title=p.getTitle();
		this.description=p.getDescription();
		this.image=p.getImage();
		this.visibility=p.getVisibility();
		return "/updatePublication?faces-redirect=true";
		
		
	}
	public String UpdatePub(int id){
		
		
		ps.Update(new PublicationDTO(this.getTitle(),this.getDescription(),this.getImage(),this.getVisibility()), id);
		return "/Publications?faces-redirect=true";
	}

	public PublicationBean() {
		// TODO Auto-generated constructor stub
	}

	public int getPublicationId() {
		return PublicationId;
	}



	public void setPublicationId(int publicationId) {
		PublicationId = publicationId;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public Visibility getVisibility() {
		return visibility;
	}



	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}



	public String getCreationDate() {
		return creationDate;
	}



	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}


	public List<PublicationDTO> getPubss() {
		return pubss;
	}


	public void setPubss(List<PublicationDTO> pubss) {
		this.pubss = pubss;
	}
	public PublicationDTO getPp() {
		return pp;
	}
	public void setPp(PublicationDTO pp) {
		this.pp = pp;
	}







}
