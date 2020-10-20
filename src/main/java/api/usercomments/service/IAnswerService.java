package api.usercomments.service;

import java.util.List;

import org.springframework.stereotype.Service;

import api.usercomments.resource.UserAnswer;
import api.usercomments.resource.UserComments;
import api.usercomments.resource.UserQuestion;

public interface IAnswerService {
	
	public Object insertAnswerByQID(String answerText, int qid) throws Exception;
	Boolean deleteAnswerByQID(int commentId) throws Exception;
	Boolean updateAnswerByQID(String comment, int qid) throws Exception;
	public List<UserAnswer> getAllAnswer(int qId)throws Exception;
	
}
