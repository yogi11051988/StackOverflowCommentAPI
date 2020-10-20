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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "ANSWER")
@NamedQuery(name="DELETE_ANSWER_BY_CID",query="DELETE FROM UserAnswerEntity where id=:id")
public class UserAnswerEntity {

	@Id
	@Column(name = "AID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int aid;
	
	@Column(name = "AnswerText")
	private String answerText;
	
	@ManyToOne
	@JoinColumn(name="UserQuestion_id")
	private UserQuestionEntity userQuestion;

	@OneToMany(mappedBy="userAnswer",targetEntity=UserCommentsEntity.class,cascade=CascadeType.ALL)
	private Set<UserCommentsEntity> commentsEntity;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	public UserQuestionEntity getUserQuestion() {
		return userQuestion;
	}

	public void setUserQuestion(UserQuestionEntity userQuestion) {
		this.userQuestion = userQuestion;
	}

	public Set<UserCommentsEntity> getCommentsEntity() {
		return commentsEntity;
	}

	public void setCommentsEntity(Set<UserCommentsEntity> commentsEntity) {
		this.commentsEntity = commentsEntity;
	}
	
	
	
	}
