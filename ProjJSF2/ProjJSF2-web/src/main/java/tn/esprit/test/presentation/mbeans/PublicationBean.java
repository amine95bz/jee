package tn.esprit.test.presentation.mbeans;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import services.CommentService;
import services.LikeService;
import services.PublicationService;
import services.SigService;
import tn.esprit.terabyte.DTO.CommentDTO;
import tn.esprit.terabyte.DTO.LikeDTO;
import tn.esprit.terabyte.DTO.PublicationDTO;
import tn.esprit.terabyte.DTO.SigDto;
import tn.esprit.terabyte.DTO.Visibility;

@SessionScoped
@ManagedBean
public class PublicationBean {
	private int PublicationId;
	private String title;
	private String description;
	private String image;
	private Visibility visibility;
	private PublicationDTO pp;
	private String creationDate;;
	private List<PublicationDTO> pubss;
	private List<CommentDTO> comments;
	private String comcom;
	private List<PublicationDTO> pubsigs;
	@EJB
	SigService sc;
	@EJB
	LikeService ls;

	@EJB
	PublicationService ps;
	@EJB
	CommentService cs;

	// public List<PublicationDTO> getPubs(){
	// for (PublicationDTO p : ps.GetAll()) {
	// pubss.add(p);
	// }
	// return pubss;
	// }

	@PostConstruct
	public void init() {
		// ps.Update(new PublicationDTO("feres222","feres","feresImg"),2);
		// ps.Delete(new
		// PublicationDTO(4,"jee","jee","jeeImg",Visibility.Public,"date"));
		// ps.Create(new PublicationDTO("alpha","alpha","alpha"));
		for (LikeDTO l : ls.GetAll()) {
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaa" + l.getIdPub() + "user: " + l.getIdUser());
		}
		System.out.println("teeeeeeeeeeeeeest" + likeExist(2));

		pubss = ps.GetAll();
		comments = cs.GetAll();

	}

	public String BackToPub() {
		return "/Publications?faces-redirect=true";
	}

	public String DelPub(PublicationDTO p) {
		ps.Delete(p);
		return "/Publications?faces-redirect=true";
	}

	public String AddPub() {
		ps.Create(new PublicationDTO(title, description, image));
		return "/Publications?faces-redirect=true";
	}

	public String modifier(PublicationDTO p) {
		this.PublicationId = p.getPublicationId();
		this.title = p.getTitle();
		this.description = p.getDescription();
		this.image = p.getImage();
		this.visibility = p.getVisibility();
		return "/updatePublication?faces-redirect=true";

	}

	public String UpdatePub() {

		ps.Update(new PublicationDTO(title, description, image), PublicationId);
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
	

	public String getComcom() {
		return comcom;
	}

	public void setComcom(String comcom) {
		this.comcom = comcom;
	}

	public String details(PublicationDTO p) {
		this.PublicationId = p.getPublicationId();
		this.title = p.getTitle();
		this.description = p.getDescription();
		this.image = p.getImage();
		return "/DetailsPublication?faces-redirect=true";

	}

	public boolean likeExist(int idp) {

		for (LikeDTO l : ls.GetAll()) {

			if ((l.getIdPub() == idp) && (l.getIdUser().equals("cafc58b5-fe03-46c5-bd8f-f0f63860912c"))) {

				return true;
			}
		}
		return false;

	}

	public String addLike(int id) {

		ls.Create(new LikeDTO("cafc58b5-fe03-46c5-bd8f-f0f63860912c", id));
		return "/Publications?faces-redirect=true";

	}

	public String DelLike(int id) {
		ls.Delete(new LikeDTO("cafc58b5-fe03-46c5-bd8f-f0f63860912c", id));
		return "/Publications?faces-redirect=true";
	}

	public int nbLike(int id) {
		int k = 0;
		for (LikeDTO f : ls.GetAll()) {
			if (f.getIdPub() == id) {
				k++;
			}
		}
		return k;

	}

	public List<CommentDTO> getComments() {

		return comments;
	}

	public String DelComment(CommentDTO c) {
		cs.Delete(c);
		return "/Publications?faces-redirect=true";
	}
	public String AddCom() {
		cs.Create(new CommentDTO(comcom,PublicationId));
		return "/Publications?faces-redirect=true";
	}
	public void printPDR(PublicationDTO pub){
		String File_Name = "C:\\Users\\root\\Desktop\\OutPutJee\\"+pub.getTitle()+".pdf" ;
		Document document=new Document();
		try{
			PdfWriter.getInstance(document, new FileOutputStream(new File(File_Name)));
			document.open();
			Paragraph p=new Paragraph();
			p.add("Post: "+pub.getTitle());
			p.setAlignment(Element.ALIGN_CENTER);
			document.add(p);
			document.add(Image.getInstance("C:\\Users\\root\\Desktop\\OutPutJee\\terabyte.png"));
			Font f =new Font();
			f.setStyle(Font.BOLD);
			f.setSize(12);
			document.add(new Paragraph(pub.getDescription(),f));
			document.close();
			System.out.println("done");
	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		}
	public String Signaler(int id){
		sc.Create(new SigDto("cafc58b5-fe03-46c5-bd8f-f0f63860912c", id));
		ps.Signaler(new PublicationDTO(), id);
		return "/Publications?faces-redirect=true";
	}
	public boolean SigExist(int idp) {

		for (SigDto l : sc.GetAll()) {

			if ((l.getIdPub() == idp) && (l.getIdUser().equals("cafc58b5-fe03-46c5-bd8f-f0f63860912c"))) {

				return true;
			}
		}
		return false;

	}

	public List<PublicationDTO> getPubsigs() {
		for (PublicationDTO p : ps.GetAll()) {
			if (p.getNbSig()>5) {
				pubsigs.add(p);
				
			}
			
		}
		return pubsigs;
	}
	

}
