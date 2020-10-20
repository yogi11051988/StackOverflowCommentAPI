/**
* @author CoolYogi 
 * Date - 17-oct-2020
 * 
 */
package api.usercomments.controller;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

import com.mysql.jdbc.log.LogFactory;

import api.usercomments.resource.UserComments;
import api.usercomments.resource.UserQuestion;
import api.usercomments.service.ICommentsService;
import api.usercomments.service.IQuestionService;
import api.usercomments.validator.CustomizedAnnotation;
/**
 * 
 * @author CoolYogi
 * insert question 
 * update question
 * delete question
 * select all question
 *  
 */
@Path("/QuestionApi")
@Controller
public class QuestionController{
	

	
	public static final Logger log=LoggerFactory.getLogger(AnswerController.class);
	/**
	 * autowiring
	 */
	@Autowired
	IQuestionService service; 
	
	
	/**
	 * insert comments
	 */
	@POST
	@Path("/addQuestion")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response insertQuestion(UserQuestion question) {
		try {
		return Response.ok(service.insertQuestion(question.getUserQuestion())).build();
		}catch(Exception es) {
			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for getAllQuestionsComments").build();
		}
	}
	
	
	/**
	 * 
	 * @param commentID
	 * @param newComments
	 * @return
	 */
	@PUT
	@Path("/updateQuestion")
	@Produces({"application/json"})
	public Response updateQuestion(UserQuestion question) {
		try {
			return Response.ok(service.updateQuestion(question.getUserQuestion(), question.getId())).build();
			}catch(Exception es) {
				return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for getAllQuestionsComments").build();
			}
	}
	
	
	/**
	 * Delete question - delete child comment too.
	 */
	@DELETE
	@Path("/deleteQuestion/{qid}")
	@Produces({"application/json"})
	public Response deleteQuestion(@PathParam("qid") int id) {
		try {
		return Response.ok(service.deleteQuestion(id)).build();
		}catch(Exception es) {
			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for getAllQuestionsComments").build();
		}
	}

	/**
	 * Get All question
	 */
	@GET
	@Path("/getQuestions")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public Response getAllQuestionsComments(){
		try {
		return Response.ok(service.getAllQuestions(0)).build();
		}catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for getAllQuestionsComments").build();
		}
	}		
		

}