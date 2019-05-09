package tn.esprit.test.presentation.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.terabyte.DTO.Visibility;

@ManagedBean
@ApplicationScoped
public class VisibilityData {
	public Visibility[] getVisibilities(){
		return Visibility.values();
	}

}
