package api.usercomments.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import api.usercomments.resource.UserComments;
import api.usercomments.resource.UserQuestion;

public interface ICommentsDaoRepo {
	public Object getAllCommentsByAnswerId(int aid)  throws Exception;
	public Boolean insertCommentsByAnsId(String comments, int aId) throws Exception;
	public Boolean insertCommentsByCommentId(String comments, int cid) throws Exception;
	public Boolean updateComments(String comment,int id) throws Exception;
	public Boolean deleteComment(int commentId) throws Exception;
}
