package api.usercomments.service;

import java.util.List;

import org.springframework.stereotype.Service;

import api.usercomments.resource.UserComments;
import api.usercomments.resource.UserQuestion;

public interface ICommentsService {

	public List<UserComments> getAllCommentsByAnswerId(int aid)throws Exception;
	public Object insertCommentsByCommentId(String commentText, int answerId) throws Exception;
	public Object insertCommentsByAnsId(String commentText, int answerId)  throws Exception;
	public Boolean updateComments(String comment,int id)throws Exception;
	public Boolean deleteComment(int commentId)throws Exception;
}
