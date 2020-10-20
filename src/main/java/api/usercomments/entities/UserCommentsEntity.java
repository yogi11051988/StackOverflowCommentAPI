package api.usercomments.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "COMMENTS")
@NamedQuery(name = "DELETE_COMMENTS_BY_CID", query = "DELETE FROM UserCommentsEntity where id=:id")
public class UserCommentsEntity {

	@Id
	@Column(name = "CID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "COMMENTS")
	private String commentText;

	@ManyToOne
	@JoinColumn(name = "UserAnswer_id")
	private UserAnswerEntity userAnswer;

	@ManyToOne
	@JoinColumn(name = "UserComments_id")
	private UserCommentsEntity userComments;

	
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

	public UserAnswerEntity getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(UserAnswerEntity userAnswer) {
		this.userAnswer = userAnswer;
	}

	public UserCommentsEntity getUserComments() {
		return userComments;
	}

	public void setUserComments(UserCommentsEntity userComments) {
		this.userComments = userComments;
	}
		
}
