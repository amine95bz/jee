package DTO;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pack implements Serializable {
	@JsonProperty("PackId")
	public int PackId;
	@JsonProperty("price")
	public float price;
	@JsonProperty("PackName")
	public String PackName;
	@JsonProperty("Description")
	public String Description;
	@JsonProperty("ImagePath")
	public String ImagePath;
	@JsonProperty("NbClient")
	public int NbClient;
    List<Pack> Packss;
    
	public List<Pack> getPackss() {
		return Packss;
	}

	public void setPackss(List<Pack> packss) {
		Packss = packss;
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

	public Pack() {
		super();
	}

	public Pack(int packId, float price, String packName, String description, String imagePath, int nbClient) {
		super();
		PackId = packId;
		this.price = price;
		PackName = packName;
		Description = description;
		ImagePath = imagePath;
		NbClient = nbClient;
	}

	public Pack(float price, String description, String packName,  int nbClient, String imagePath) {
		super();
		this.price = price;
		PackName = packName;
		Description = description;
		ImagePath = imagePath;
		NbClient = nbClient;
	}

	@Override
	public String toString() {
		return "Pack [PackId=" + PackId + ", price=" + price + ", PackName=" + PackName + ", Description=" + Description
				+ ", ImagePath=" + ImagePath + ", NbClient=" + NbClient + "]";
	}

}

