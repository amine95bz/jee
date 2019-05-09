package tn.esprit.terabyte.DTO;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;



public class PublicationDTO  implements Serializable{

	private int PublicationId ;
	private String title ;
	private String description ;
	private String image ;
	private Visibility visibility ;
	
	private String creationDate ;
	private String ownerimg;
	private String nomuser;
	private String OwnerId;

	public PublicationDTO() {
		super();
	}
	

	public PublicationDTO(String title, String description, String image) {
		super();
		this.title = title;
		this.description = description;
		this.image = image;
	}


	public PublicationDTO(String title, String description, String image, Visibility visibility, String creationDate
			) {
		super();
		this.title = title;
		this.description = description;
		this.image = image;
		this.visibility = visibility;
		this.creationDate = creationDate;
		
	}
	public PublicationDTO(String title, String description, String image, Visibility visibility
			) {
		super();
		this.title = title;
		this.description = description;
		this.image = image;
		this.visibility = visibility;
		
	}

	public PublicationDTO(int publicationId, String title, String description, String image, Visibility visibility,
			String creationDate) {
		super();
		PublicationId = publicationId;
		this.title = title;
		this.description = description;
		this.image = image;
		this.visibility = visibility;
		this.creationDate = creationDate;
		
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


	public String getOwnerimg() {
		return ownerimg;
	}


	public void setOwnerimg(String ownerimg) {
		this.ownerimg = ownerimg;
	}


	public String getNomuser() {
		return nomuser;
	}


	public void setNomuser(String nomuser) {
		this.nomuser = nomuser;
	}


	public String getOwnerId() {
		return OwnerId;
	}


	public void setOwnerId(String ownerId) {
		OwnerId = ownerId;
	}

	
	

}
