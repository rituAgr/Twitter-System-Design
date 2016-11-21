package resources;

import com.Auth.User;
import com.Service.CustomerSerivce;
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
 * Created by Ritu on 11/12/16.
 */
@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Ritu {
    private final static Logger logger = LoggerFactory.getLogger(CustomerResource.class);
    private CustomerSerivce customerSerivce;

    //@Inject
    public Ritu(CustomerSerivce customerSerivce) {
        this.customerSerivce = customerSerivce;
    }

    @GET
    @Path("/signin")
    public Response signin(@Auth User user) {
        return Response.ok("Demo check").build();
    }
}
