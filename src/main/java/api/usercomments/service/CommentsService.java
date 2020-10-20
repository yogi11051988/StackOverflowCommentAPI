package api.usercomments.service;

/**
 * @author CoolYogi
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.usercomments.repository.ICommentsDaoRepo;
import api.usercomments.resource.UserComments;
import api.usercomments.resource.UserQuestion;

@Service
public class CommentsService implements ICommentsService {

	@Autowired
	ICommentsDaoRepo repo;
	
	@Override
	public Object insertCommentsByCommentId(String commentText, int cid) throws Exception {
		try {
			return repo.insertCommentsByCommentId(commentText,cid);
		} catch (Exception ex) {
			throw ex ;
		}
	}

	@Override
	public Object insertCommentsByAnsId(String commentText, int answerId) throws Exception {
		try {
			return repo.insertCommentsByAnsId(commentText,answerId);
		} catch (Exception ex) {
			throw ex ;
		}
	}
	
	@Override
	public List<UserComments> getAllCommentsByAnswerId(int aid) throws Exception {
		try {
			return null;
		} catch (Exception ex) {
			throw ex ;
		}
		
	}
	
	@Override
	public Boolean updateComments(String comment, int id) throws Exception {
		try {
			return repo.updateComments(comment, id);
		} catch (Exception ex) {
			throw ex ;
		}
		
	}

	@Override
	public Boolean deleteComment(int commentId) throws Exception {
		try {
			return repo.deleteComment(commentId);
		} catch (Exception ex) {
			throw ex ;
		}
		
	}
	
}
