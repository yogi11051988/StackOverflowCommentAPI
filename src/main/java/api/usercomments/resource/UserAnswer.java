package api.usercomments.resource;

import java.io.Serializable;
import java.util.Set;

public class UserAnswer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String answerText;
	private int questionId;
	private Set<UserComments> userComments;
	public UserAnswer() {
		super();
	}
	public UserAnswer(int id, String answerText, int questionId, Set<UserComments> userComments) {
		super();
		this.id = id;
		this.answerText = answerText;
		this.questionId = questionId;
		this.userComments = userComments;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnswerText() {
		return answerText;
	}
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public Set<UserComments> getUserComments() {
		return userComments;
	}
	public void setUserComments(Set<UserComments> userComments) {
		this.userComments = userComments;
	}	
		
}
