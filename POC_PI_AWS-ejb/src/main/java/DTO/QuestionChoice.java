package DTO;

import java.io.Serializable;

public class QuestionChoice implements Serializable {
	private int idQuestionChoice;
    private Question question;
    private String choiceIndex;
    private String choiceText;

    public QuestionChoice() {
    }

    public QuestionChoice(int idQuestionChoice, Question question,
            String choiceIndex, String choiceText) {
        this.idQuestionChoice = idQuestionChoice;
        this.question = question;
        this.choiceIndex = choiceIndex;
        this.choiceText = choiceText;
    }

	public int getIdQuestionChoice() {
		return idQuestionChoice;
	}

	public void setIdQuestionChoice(int idQuestionChoice) {
		this.idQuestionChoice = idQuestionChoice;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getChoiceIndex() {
		return choiceIndex;
	}

	public void setChoiceIndex(String choiceIndex) {
		this.choiceIndex = choiceIndex;
	}

	public String getChoiceText() {
		return choiceText;
	}

	public void setChoiceText(String choiceText) {
		this.choiceText = choiceText;
	}
    
}
