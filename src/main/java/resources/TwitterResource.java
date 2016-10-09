package resources;

import com.Auth.User;
import com.Models.AddFollowerRequest;
import com.Models.CreateUserModel;
import com.Models.TweetUpdateModel;
import com.Service.CustomerSerivce;
import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;



/**
 * Created by Ritu on 9/2/16.
 */
@Path("/twitterUsr")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TwitterResource {
    private final static Logger logger = LoggerFactory.getLogger(CustomerResource.class);
    private CustomerSerivce customerSerivce;


    @Inject
    public TwitterResource(CustomerSerivce customerSerivce) {
        this.customerSerivce = customerSerivce;
    }

    @GET
    @Path("/signin")
    public Response signin(@Auth User user) {
        return Response.ok("Demo check").build();
    }


    @GET
    @UnitOfWork
    @Path("/customerDetails/{name}")//Anythig inside /{} is called path parameter
    @Timed
    public Response readWFMConfig(@PathParam("name") String name)//@PathParam is used to extract path parameter string and send over
    {

        return Response.ok(customerSerivce.getCustomer(name)).build();
    }


    @GET
    @UnitOfWork
    @Path("/customerDetails/{name}/{date}")
    @Timed
    public Response readWFMConfigDate(@PathParam("name") String name,@PathParam("date") String date)
    {

        return Response.ok(customerSerivce.getCustomerDate(name, date)).build();
    }

    @GET
    @UnitOfWork
    @Path("/getAllFollower/{emailId}")
    @Timed
    public Response getAllFollower(@PathParam("emailId") String emailId)
    {
//        logger.info(" checkWFMConfig wfm request :: " + wfmRequest);
//        return Response.status(500).entity("Error Occured").build();
        return Response.ok(customerSerivce.getAllFollower(emailId)).build();


    }


    @POST
    @UnitOfWork
    @Path("/addFollower")
    @Timed
    public void checkWFMConfig(AddFollowerRequest addFollowerRequest)
    {
        System.out.println("check");
        Response.ok(customerSerivce.addFollower(addFollowerRequest)).build();
    }


    @POST
    @UnitOfWork
    @Path("/createUsr")
    @Timed
    public void createUser(CreateUserModel createUserModel)
    {
//        logger.info(" checkWFMConfig wfm request :: " + wfmRequest);

        customerSerivce.createUser(createUserModel);
        //return "done";

    }

    @POST
    @UnitOfWork
    @Timed
    @Path("/tweet")
    public Response createUser(TweetUpdateModel tweetUpdateModel)
    {
//        if(tweetUpdateModel.getTweet().length()>140)
//        {
//            return Response.ok("Status length is greater than 140 char").build();
//        }

        return Response.ok(customerSerivce.tweetUpdate(tweetUpdateModel)).build();
    }




    @GET
    @UnitOfWork
    @Path("/getAllTweets/{emailId}")
    @Timed
    public Response getAllTweets(@PathParam("emailId") String email)
    {
        return Response.ok(customerSerivce.getAllTweets(email)).build();
    }

}
