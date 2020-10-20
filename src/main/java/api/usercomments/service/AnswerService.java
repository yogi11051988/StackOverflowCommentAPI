package api.usercomments.service;

/**
 * @author CoolYogi
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.usercomments.repository.IAnswerDaoRepo;
import api.usercomments.repository.ICommentsDaoRepo;
import api.usercomments.resource.UserAnswer;
import api.usercomments.resource.UserComments;
import api.usercomments.resource.UserQuestion;

@Service
public class AnswerService implements IAnswerService {

	@Autowired
	IAnswerDaoRepo repo;

	@Override
	public Object insertAnswerByQID(String answerText, int qid) throws Exception  {
		try {
			return repo.insertAnswerByQID(answerText,qid);
		} catch (Exception ex) {
			throw ex ;
		}
	}
	
	@Override
	public Boolean updateAnswerByQID(String comment, int qid) throws Exception {
		try {
			return repo.updateAnswerByQID(comment, qid);
		} catch (Exception ex) {
			throw ex ;
		}
		
	}

	@Override
	public Boolean deleteAnswerByQID(int qid) throws Exception {
		try {
			return repo.deleteAnswerByQID(qid);
		} catch (Exception ex) {
			throw ex ;
		}
		
	}

	@Override
	public List<UserAnswer> getAllAnswer(int qid) throws Exception {
		// TODO Auto-generated method stub
		return repo.getAllAnswerByQID(qid);
	}
}
