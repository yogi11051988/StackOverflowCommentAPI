package api.usercomments.service;

import java.util.List;

import org.springframework.stereotype.Service;

import api.usercomments.resource.UserComments;
import api.usercomments.resource.UserQuestion;

public interface IQuestionService {

	public Boolean insertQuestion(String question)throws Exception;
	public Boolean updateQuestion(String comment,int id)throws Exception;
	public Boolean deleteQuestion(int questionId)throws Exception;
	public List<UserQuestion> getAllQuestions(int qId)throws Exception;
	
}
