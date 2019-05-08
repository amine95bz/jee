package DTO;

import java.io.Serializable;

public class QuizTaken implements Serializable {
	 private QuizTakenId id;
     private User user;
     private Quiz quiz;
     private int score;
	public QuizTakenId getId() {
		return id;
	}
	public void setId(QuizTakenId id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Quiz getQuiz() {
		return quiz;
	}
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public QuizTaken(User user, Quiz quiz, int score) {
		super();
		this.user = user;
		this.quiz = quiz;
		this.score = score;
	}
	public QuizTaken() {
		super();
	}
     
}
