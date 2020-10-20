package api.usercomments.resource;

import java.io.Serializable;
import java.util.Set;

public class UserComments implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String commentText;
	private int answerId;
	private int  userCommentsId;
	
	
	
	
	public UserComments() {
		super();
	}
	public UserComments(int id, String commentText, int answerId, int userCommentsId) {
		super();
		this.id = id;
		this.commentText = commentText;
		this.answerId = answerId;
		this.userCommentsId = userCommentsId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public int getUserCommentsId() {
		return userCommentsId;
	}
	public void setUserCommentsId(int userCommentsId) {
		this.userCommentsId = userCommentsId;
	}
		
}
