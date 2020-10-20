package api.usercomments.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import api.usercomments.resource.UserAnswer;
import api.usercomments.resource.UserComments;
import api.usercomments.resource.UserQuestion;

public interface IAnswerDaoRepo {
	public Object insertAnswerByQID(String answerText, int qid) throws Exception;
	public Boolean updateAnswerByQID(String answerText, int qid)throws Exception;
	public Boolean deleteAnswerByQID(int answerId)throws Exception;
	public List<UserAnswer> getAllAnswerByQID(int qid) throws Exception;
}
