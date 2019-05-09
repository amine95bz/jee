package tn.esprit.terabyte.DTO;

public class CommentDTO {
	private int CommentId ;
	private String Contenu ;
	private int PublicationId ;
	public int getCommentId() {
		return CommentId;
	}
	public void setCommentId(int commentId) {
		CommentId = commentId;
	}
	public String getContenu() {
		return Contenu;
	}
	public void setContenu(String contenu) {
		Contenu = contenu;
	}
	public int getPublicationId() {
		return PublicationId;
	}
	public void setPublicationId(int publicationId) {
		PublicationId = publicationId;
	}
	public CommentDTO(int commentId, String contenu, int publicationId) {
		super();
		CommentId = commentId;
		Contenu = contenu;
		PublicationId = publicationId;
	}
	public CommentDTO(String contenu, int publicationId) {
		super();
		Contenu = contenu;
		PublicationId = publicationId;
	}
	public CommentDTO() {
		super();
	}
	

}
