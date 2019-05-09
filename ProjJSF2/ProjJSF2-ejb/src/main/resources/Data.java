package tn.esprit.test.presentation.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.terabyte.DTO.Category;





@ManagedBean
@ApplicationScoped
public class Data {
	
	public Category[]getCategories(){
		
		return Category.values();
	}
}
