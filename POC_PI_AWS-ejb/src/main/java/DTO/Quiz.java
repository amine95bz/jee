package DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quiz implements Serializable{
	@JsonProperty ("QuizId")
	 public int QuizID;
	@JsonProperty ("QuizName")
     public String QuizName;
	@JsonProperty ("question")
     public  List<Question> Questions;
	private Set<QuizTaken> quizTakens = new HashSet<QuizTaken>(0);
    private Set<Question> questions = new HashSet<Question>(0);
    
    
	public Quiz(int quizID, String quizName, Set<QuizTaken> quizTakens, Set<Question> questions) {
		super();
		QuizID = quizID;
		QuizName = quizName;
		this.quizTakens = quizTakens;
		this.questions = questions;
	}
	public Set<QuizTaken> getQuizTakens() {
		return quizTakens;
	}
	public void setQuizTakens(Set<QuizTaken> quizTakens) {
		this.quizTakens = quizTakens;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	public Quiz() {
		super();
	}
	public Quiz(int quizID, String quizName, List<Question> questions) {
		super();
		QuizID = quizID;
		QuizName = quizName;
		Questions = questions;
	}
	public Quiz(int quizID, String quizName) {
		super();
		QuizID = quizID;
		QuizName = quizName;
	
	}
	public Quiz( String quizName) {
		super();
		
		QuizName = quizName;
	
	}
	public int getQuizID() {
		return QuizID;
	}
	public void setQuizID(int quizID) {
		QuizID = quizID;
	}
	public String getQuizName() {
		return QuizName;
	}
	public void setQuizName(String quizName) {
		QuizName = quizName;
	}
	public List<Question> getQuestions() {
		return Questions;
	}
	public void setQuestions(List<Question> questions) {
		Questions = questions;
	}
	@Override
	public String toString() {
		return "Quiz [QuizID=" + QuizID + ", QuizName=" + QuizName + ", Questions=" + Questions + "]";
	}
	
}

