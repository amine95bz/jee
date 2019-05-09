package tn.esprit.jsf_app.presentation.mbeans;

import java.io.InputStream;

import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

public class FileDown {

	 private StreamedContent file;
     
	    public void FileDownloadView() {        
	        InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/demo/images/boromir.jpg");
	        file = new DefaultStreamedContent(stream, "image/jpg", "downloaded_boromir.jpg");
	    }
	 
	    public StreamedContent getFile() {
	        return file;
	    }
	
}
