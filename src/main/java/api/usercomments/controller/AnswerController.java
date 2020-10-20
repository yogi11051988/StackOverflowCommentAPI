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
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

import api.usercomments.resource.UserAnswer;
import api.usercomments.resource.UserComments;
import api.usercomments.resource.UserQuestion;
import api.usercomments.service.IAnswerService;
import api.usercomments.validator.CustomizedAnnotation;
/**
 * 
 * @author CoolYogi
 *  insert answer wrt QID
 *  update answer wrt QID
 *  delete answer wrt QID
 *  GETALL answer
 */
@Path("/AnswerApi")
@Controller
public class AnswerController{
	
	public static final Logger log=LoggerFactory.getLogger(AnswerController.class);
	/**
	 * autowiring
	 */
	@Autowired
	IAnswerService service; 
	
	
	/**
	 * insert comments
	 */
	@POST
	@Path("/addAnswer")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response insertAnswer(UserAnswer answer) {
		try {
		return Response.ok(service.insertAnswerByQID(answer.getAnswerText(),answer.getQuestionId() )).build();
		}catch(Exception es) {
			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for getAllQuestionsComments").build();
		}
	} 
	
	
	/**
	 * Delete question - delete child comment too.
	 */
	@DELETE
	@Path("/deleteAnswer/{aid}")
	@Produces({"application/json"})
	public Response deleteAnswer(@PathParam("aid") int id) {
		try {
		return Response.ok(service.deleteAnswerByQID(id)).build();
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
	@Path("/updateAnswerByAnswerId")
	@Produces({"application/json"})
	public Response updateAnswerByAnswerId(UserAnswer answer) {
		try {
			return Response.ok(service.updateAnswerByQID(answer.getAnswerText(), answer.getId())).build();
			}catch(Exception es) {
				return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for getAllQuestionsComments").build();
			}
	}
	
	
	/**Get All comments
	 */
	@GET
	@Path("/getAllComment")
	public String getAllComments() {
		return "Comments-api-by-Yogesh";
	}
	/**Get All comments
	 */
	@GET
	@Path("/getAllComments/{qid}")
	@Produces(("application/json"))
	@CustomizedAnnotation  // this is ussed for validation purpose
	@Validated
	public Response getAllCommentsByQuestionId(@PathParam("qid") int qId) {
		log.info("Started receive comments by QuestionID");
		try {
		 return Response.ok(service.getAllAnswer(qId)).build();
		}catch(Exception es) {
			log.error("Error occurred in comments by QuestionID");
			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for getAllCommentsByQuestionId").build();
		}
	}
		
}