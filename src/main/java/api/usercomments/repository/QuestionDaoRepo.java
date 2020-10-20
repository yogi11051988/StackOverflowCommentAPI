package api.usercomments.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import api.usercomments.entities.UserCommentsEntity;
import api.usercomments.entities.UserQuestionEntity;
import api.usercomments.resource.UserAnswer;
import api.usercomments.resource.UserComments;
import api.usercomments.resource.UserQuestion;
@Repository
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
public class QuestionDaoRepo implements IQuestionDaoRepo {
     /**
      * set Session factory
      */
	@Autowired
	SessionFactory sessionFactory;
	

	@Override
	public Boolean insertQuestion(String question) throws Exception{
		Session session=sessionFactory.openSession();
		UserQuestionEntity userQuestion=new UserQuestionEntity();
		userQuestion.setUserQuestion(question);
		session.save(userQuestion);
		return true;
	}

	@Override
	public Boolean updateQuestion(String questionText, int id) throws Exception {
		Session session=sessionFactory.openSession();
		String hqlUpdateQuesry="update UserQuestionEntity c set c.userQuestion=:userQuestion where c.id=:id";
		Query query=session.createQuery(hqlUpdateQuesry)
		.setString("userQuestion", questionText)
		.setInteger("id", id);		
		return query.executeUpdate()>0?true:false;
	}

	@Override
	public Boolean deleteQuestion(int questionId) throws Exception{
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		String deleteQuery="DELETE from UserQuestionEntity where id=:id";
		Query query=session.createSQLQuery(deleteQuery).setInteger("id", questionId);
		
		return query.executeUpdate()>0?true:false;
	}

	@Override
	public List<UserQuestion> getAllQuestions(int qId) throws Exception {
		List<UserQuestion> list=new ArrayList<UserQuestion>();
		Session session=sessionFactory.openSession();
		List<UserQuestionEntity> listEntity=session.createCriteria(UserQuestionEntity.class).list();
		
		List<UserQuestion> userQuestionList=new ArrayList<UserQuestion>();
		listEntity.stream().forEach(x->{
			Set<UserAnswer> userAnserSet=new HashSet<>();
			x.getUserAnswers().forEach(y->{
				Set<UserComments> userCommentSet=new HashSet<>();
				y.getCommentsEntity().forEach(z->{
					UserComments UserComments=new UserComments(z.getId(),z.getCommentText(),z.getUserAnswer().getAid(),z.getUserComments().getId());
					userCommentSet.add(UserComments);
				});
				UserAnswer UserAnswer=new UserAnswer(y.getAid(),y.getAnswerText(),y.getUserQuestion().getId(),userCommentSet);
				userAnserSet.add(UserAnswer);
			});
			UserQuestion c=new UserQuestion(x.getId(),x.getUserQuestion(),userAnserSet);
			userQuestionList.add(c);});
		return userQuestionList;
	}

}
