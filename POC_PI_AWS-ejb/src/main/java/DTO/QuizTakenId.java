package DTO;

import java.io.Serializable;

public class QuizTakenId implements Serializable {
	private int idUser;
    private int idQuiz;
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdQuiz() {
		return idQuiz;
	}

	public void setIdQuiz(int idQuiz) {
		this.idQuiz = idQuiz;
	}

	public QuizTakenId() {
		super();
	}

	public QuizTakenId(int idUser, int idQuiz) {
		super();
		this.idUser = idUser;
		this.idQuiz = idQuiz;
	}
    
    
}
