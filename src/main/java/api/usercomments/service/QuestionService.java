package api.usercomments.service;

/**
 * @author CoolYogi
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.usercomments.repository.ICommentsDaoRepo;
import api.usercomments.repository.IQuestionDaoRepo;
import api.usercomments.resource.UserComments;
import api.usercomments.resource.UserQuestion;

@Service
public class QuestionService implements IQuestionService {

	@Autowired
	IQuestionDaoRepo repo;

	@Override
	public Boolean insertQuestion(String question) throws Exception {
		try {
			return repo.insertQuestion(question);
		} catch (Exception ex) {
			throw ex;
		}

	}

	@Override
	public List<UserQuestion> getAllQuestions(int qId) throws Exception {
		try {
			return repo.getAllQuestions(qId);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public Boolean deleteQuestion(int questionId) throws Exception {
		try {
			return repo.deleteQuestion(questionId);
		} catch (Exception ex) {
			throw ex;
		}

	}

	@Override
	public Boolean updateQuestion(String questionText, int id) throws Exception {
		try {
			return repo.updateQuestion(questionText, id);
		} catch (Exception ex) {
			throw ex;
		}
	}
}
