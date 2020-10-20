package api.usercomments.entities;

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
import javax.persistence.Table;

@Entity
@Table(name = "question")
@NamedQueries(value = { @NamedQuery(name = "getQuestionList", query = "from UserQuestionEntity e") })
public class UserQuestionEntity{
    
	@Column(name="QID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="QUESTION")
	private String userQuestion;
	
	@OneToMany(mappedBy="userQuestion",targetEntity=UserAnswerEntity.class,cascade=CascadeType.ALL)
	private Set<UserAnswerEntity> userAnswers;

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

	public Set<UserAnswerEntity> getUserAnswers() {
		return userAnswers;
	}

	public void setUserAnswers(Set<UserAnswerEntity> userAnswers) {
		this.userAnswers = userAnswers;
	}

		
}
