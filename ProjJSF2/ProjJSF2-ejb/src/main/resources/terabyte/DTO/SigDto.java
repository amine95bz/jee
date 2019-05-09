package tn.esprit.terabyte.DTO;

public class SigDto {
	private String idUser ;
    private int idPub ;
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public int getIdPub() {
		return idPub;
	}
	public void setIdPub(int idPub) {
		this.idPub = idPub;
	}
	public SigDto(String idUser, int idPub) {
		super();
		this.idUser = idUser;
		this.idPub = idPub;
	}
	public SigDto() {
		super();
	}
	

}
