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
import api.usercomments.validator.CustomizedAnnotation;

@Path("/CommentsApi")
@Controller
public class CommentsController{
	
	public static final Logger log=LoggerFactory.getLogger(CommentsController.class);
	/**
	 * autowiring
	 */
	@Autowired
	ICommentsService service; 
	
	
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
	@Path("/getAllCommentsByAnswerId/{aid}")
	@Produces(("application/json"))
	@CustomizedAnnotation  // this is ussed for validation purpose
	@Validated
	public Response getAllCommentsByQuestionId(@PathParam("aid") int aid) {
		log.info("Started receive comments by QuestionID");
		try {
		 return Response.ok(service.getAllCommentsByAnswerId(aid)).build();
		}catch(Exception es) {
			log.error("Error occurred in comments by QuestionID");
			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for getAllCommentsByQuestionId").build();
		}
	}
	
	/**
	 * insert by answer id
	 */
	@POST
	@Path("/insertCommentsByCommentId")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response insertCommentsByCommentId(UserComments comments) {
		try {
			service.insertCommentsByCommentId(comments.getCommentText(), comments.getUserCommentsId());
		return Response.ok().entity("Inserting successfull.").build();
		}catch(Exception es) {
			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for getAllQuestionsComments").build();
		}
	} 
	
	/**
	 * insert comments id
	 */
	@POST
	@Path("/insertCommentsByAnsId")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response insertCommentsByAnsId(UserComments comments) {
		try {
			service.insertCommentsByAnsId(comments.getCommentText(), comments.getAnswerId());
		return Response.ok().entity("insert successfully").build();
		}catch(Exception es) {
			return Response.status(Response.Status.NOT_FOUND).entity("Entity exception for insertCommentsByAnsId").build();
		}
	} 
	
	/**
	 * Delete comments
	 */
	@DELETE
	@Path("/deleteComments/{cid}")
	@Produces({"application/json"})
	public Response deleteComments(@PathParam("cid") int id) {
		try {
		return Response.ok(service.deleteComment(id)).build();
		}catch(Exception es) {
			return Response.status(Response.Status.NOT_FOUND).entity("Entity exception for deleteComments").build();
		}
	}
	
	/**
	 * 
	 * @param commentID
	 * @param newComments
	 * @return
	 */
	@PUT
	@Path("/updateComments")
	@Produces({"application/json"})
	public Response updateComments(UserComments comments) {
		try {
			return Response.ok(service.updateComments(comments.getCommentText(), comments.getId())).build();
			}catch(Exception es) {
				return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for getAllQuestionsComments").build();
			}
	}
}