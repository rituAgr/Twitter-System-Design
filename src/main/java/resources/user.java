package resources;

import com.Auth.User;
import com.Service.CustomerSerivce;
import com.google.inject.Inject;
import io.dropwizard.auth.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Ritu on 8/28/16.
 */


@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class user {
    private final static Logger logger = LoggerFactory.getLogger(CustomerResource.class);
    private CustomerSerivce customerSerivce;


    @Inject
    public user(CustomerSerivce customerSerivce) {
        this.customerSerivce = customerSerivce;
    }
    @GET
    @Path("/signUp")
    public Response signin() {
        return Response.ok("signUp check").build();
    }
}



