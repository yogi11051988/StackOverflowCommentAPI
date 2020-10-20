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

import api.usercomments.entities.UserAnswerEntity;
import api.usercomments.entities.UserCommentsEntity;
import api.usercomments.entities.UserQuestionEntity;
import api.usercomments.resource.UserAnswer;
import api.usercomments.resource.UserComments;
import api.usercomments.resource.UserQuestion;

@Repository
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class AnswerDaoRepo implements IAnswerDaoRepo {
	/**
	 * set Session factory
	 */
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Boolean insertAnswerByQID(String answerText, int qId) throws Exception {
		Session session = sessionFactory.openSession();
		// check valid quesionId or not
		List<UserQuestionEntity> obj = session.createCriteria(UserQuestionEntity.class).add(Restrictions.eq("id", qId))
				.list();
		boolean isPresent = obj.size() > 0;
		if (!isPresent) {
			throw new Exception("Question id should be correct.");
		}

		UserAnswerEntity em = new UserAnswerEntity();
		em.setAnswerText(answerText);
		em.setUserQuestion(obj.get(0));
		session.save(em);
        return true;
	}

	@Override
	public Boolean updateAnswerByQID(String answerText, int qid) throws Exception {
		Session session = sessionFactory.openSession();
		String hqlUpdateQuesry = "update UserAnswerEntity c set c.answerText=:answerText where c.id=:id";
		Query query = session.createQuery(hqlUpdateQuesry).setString("answerText", answerText).setInteger("id", qid);
		return query.executeUpdate() > 0 ? true : false;
	}

	@Override
	public Boolean deleteAnswerByQID(int answerId) throws Exception {
		Session session = sessionFactory.openSession();
		// TODO Auto-generated method stub
		Query query = session.getNamedQuery("DELETE_COMMENTS_BY_CID").setInteger("id", answerId);
		return query.executeUpdate() > 0;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<UserAnswer> getAllAnswerByQID(int answerId) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		return session.createCriteria(UserAnswerEntity.class).setFetchMode("userQuestion", FetchMode.EAGER)
				.add(Restrictions.idEq(answerId)).list();
	}

}
