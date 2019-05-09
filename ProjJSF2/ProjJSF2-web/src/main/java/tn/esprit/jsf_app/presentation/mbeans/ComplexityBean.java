package tn.esprit.jsf_app.presentation.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.terabyte.DTO.Complexity;

@ManagedBean
@ApplicationScoped
public class ComplexityBean {
	public Complexity[]getComplexity(){
		return Complexity.values();
	}

}
