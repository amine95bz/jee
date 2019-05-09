package tn.esprit.jsf_app.presentation.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.terabyte.DTO.State;

@ManagedBean
@ApplicationScoped
public class StatBean {
	public State[]getStates(){
		return State.values();
	}

}
