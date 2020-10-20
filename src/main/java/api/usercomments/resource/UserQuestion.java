package api.usercomments.resource;

import java.io.Serializable;
import java.util.Set;

public class UserQuestion implements Serializable,Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String userQuestion;
	private Set<UserAnswer> userAnswer;
	
	public UserQuestion() {
		super();
	}
	
	public UserQuestion(int id, String userQuestion, Set<UserAnswer> userAnswer) {
		super();
		this.id = id;
		this.userQuestion = userQuestion;
		this.userAnswer = userAnswer;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserQuestion() {
		return userQuestion;
	}

	public void setUserQuestion(String userQuestion) {
		this.userQuestion = userQuestion;
	}

	public Set<UserAnswer> getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(Set<UserAnswer> userAnswer) {
		this.userAnswer = userAnswer;
	}

	public UserQuestion clone() {
		return this;
		
	}	
}
