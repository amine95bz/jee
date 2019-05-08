package tn.esprit.jsf_app.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import DTO.Pack;
import tn.esprit.jsf_app.services.PackClientService;

@ManagedBean
public class PackBean {

	public int PackId;
	public float price;
	public String PackName;
	public String Description;
	public String ImagePath;
	public int NbClient;
	public int packIdToBeUpdate;
	Pack packs;
	private List<Pack> packss;

	public PackBean() {
	}
	// TODO Auto-generated constructor stub

	@EJB
	PackClientService pack;

	@Override
	public String toString() {
		return "PackBean [PackId=" + PackId + " price=" + price + ", PackName=" + PackName + ", Description="
				+ Description + ", ImagePath=" + ImagePath + ", NbClient=" + NbClient + "]";
	}

	public int getPackId() {
		return PackId;
	}

	public void setPackId(int packId) {
		PackId = packId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getPackName() {
		return PackName;
	}

	public void setPackName(String packName) {
		PackName = packName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getImagePath() {
		return ImagePath;
	}

	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}

	public int getNbClient() {
		return NbClient;
	}

	public void setNbClient(int nbClient) {
		NbClient = nbClient;
	}

	public Pack getPacks() {
		return packs;
	}

	public void setPacks(Pack packs) {
		this.packs = packs;
	}

	public int getPackIdToBeUpdate() {
		return packIdToBeUpdate;
	}

	public void setPackIdToBeUpdate(int packIdToBeUpdate) {
		this.packIdToBeUpdate = packIdToBeUpdate;
	}
//  *********************************************************************  //
	public List<Pack> getPackss() {
		return packss;
	}

	public void setPackss(List<Pack> packss) {
		this.packss = packss;
	}
//  *********************************************************************  //
	public String addPack() {
		pack.postRequest(new Pack(price, Description, PackName, NbClient, ImagePath));
		return "/listpack?faces-redirect=true";
	}
//  *********************************************************************  //
	@PostConstruct
	public void getPack() {
		pack.putRequest(1009, new Pack(123, "teste", "test", 12, "test"));
		packss = pack.Consommation();
	}
//  *********************************************************************  //
	public String supprimer(Integer packId) {
		pack.DelRequest(packId);
		return "/listpack?faces-redirect=true";
	}
//  *********************************************************************  //
	public void modifier(Pack p) {
		if (p != null) {
			this.setDescription(p.Description);
			this.setImagePath(p.ImagePath);
			this.setNbClient(p.NbClient);
			this.setPackName(p.PackName);
			this.setPrice(p.price);
			this.setPackIdToBeUpdate(p.PackId);
		} else {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("bad credentials"));
		}

	}
//  *********************************************************************  //
	public String mettreAjourPack() {
		pack.putRequest(packIdToBeUpdate, new Pack(price, Description, PackName, NbClient, ImagePath));
		return "/listpack?faces-redirect=true";
	}
}
