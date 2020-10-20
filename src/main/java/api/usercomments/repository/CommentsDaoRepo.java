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
import api.usercomments.resource.UserComments;
import api.usercomments.resource.UserQuestion;
@Repository
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
public class CommentsDaoRepo implements ICommentsDaoRepo {
     /**
      * set Session factory
      */
	@Autowired
	SessionFactory sessionFactory;
	/**
	 * 
	 * @param comments
	 * @param aId
	 * @return
	 * @throws Exception
	 */
	@Override
	public Boolean insertCommentsByAnsId(String comments, int aId) throws Exception{
		Session session=sessionFactory.openSession();
		//check valid quesionId or not
		List<UserAnswerEntity> obj=session.createCriteria(UserAnswerEntity.class)
				.add(Restrictions.eq("id", aId)).list();
		boolean isPresent=obj.size()>0;
		if(isPresent) {
			UserCommentsEntity em=new UserCommentsEntity();
		  	em.setCommentText(comments);
			em.setUserAnswer(obj.get(0));
			session.save(em);
		return true;	
		}else {
			return false;
		}
		
	}
	
	
	/**
	 * insert CommentByCommentID
	 */
	@Override
	public Boolean insertCommentsByCommentId(String comments, int cid) throws Exception{
		Session session=sessionFactory.openSession();
		//check valid quesionId or not
		List<UserCommentsEntity> obj=session.createCriteria(UserCommentsEntity.class).add(Restrictions.eq("id", cid)).list();
		boolean isPresent=obj.size()>0;
		if(!isPresent) {
			throw new Exception("Expected comment id is not present in db");
		}
			UserCommentsEntity em=new UserCommentsEntity();
		 	em.setCommentText(comments);
			em.setUserComments(obj.get(0));
			session.save(em);
		return true;	
	}
	
	@Override
	public Boolean updateComments(String comment, int id) throws Exception {
		Session session=sessionFactory.openSession();
		String hqlUpdateQuesry="update UserCommentsEntity c set c.commentText=:comments where c.id=:id";
		Query query=session.createQuery(hqlUpdateQuesry)
		.setString("comments", comment)
		.setInteger("id", id);		
		return query.executeUpdate()>0?true:false;
	}

	@Override
	public Boolean deleteComment(int commentId) throws Exception {
		Session session=sessionFactory.openSession();
		// TODO Auto-generated method stub
		Query query=session.getNamedQuery("DELETE_COMMENTS_BY_CID").setInteger("id", commentId);
		return query.executeUpdate()>0;
	}


	@Override
	public Object getAllCommentsByAnswerId(int aid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
