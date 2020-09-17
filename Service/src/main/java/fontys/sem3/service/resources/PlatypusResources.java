package fontys.sem3.service.resources;


import fontys.sem3.service.model.Shelter;
import fontys.sem3.service.model.Tiger;
import fontys.sem3.service.model.Platypus;
import fontys.sem3.service.repository.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Path("/platypuses")
public class PlatypusResources {

    @Context
    private UriInfo uriInfo;
    // this has to be static because the service is stateless:
    private static final FakeDataStore fakeDataStore = new FakeDataStore();

    @GET //GET at http://localhost:XXXX/students/hello
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHello() {
        String msg = " Hello, your resources works!";
        return Response.ok(msg).build();
    }

    @GET //GET at http://localhost:XXXX/students/3
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlatypusPath(@PathParam("id") int animalNumber) {

        Platypus platypus = fakeDataStore.getPlatypus(animalNumber);//studentsRepository.get(stNr);
        if (platypus == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid animal number.").build();
        } else {
            return Response.ok(platypus).build();
        }
    }


    @GET //GET at http://localhost:XXXX/students?
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPlatypuses(@QueryParam("animalNumber") int animalNumber) {
        List<Platypus> platypuses;
        //If query parameter is missing return all students. Otherwise filter students by given countryCode
        if (uriInfo.getQueryParameters().containsKey("animalNumber")) {
            Platypus platypus = fakeDataStore.getPlatypus(animalNumber);
            if (platypus == null) { // if country code invalid, return BAD_REQUEST
                return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid country code.").build();
            } else {
                platypuses = fakeDataStore.getPlatypuses(animalNumber);
            }
        } else {
            platypuses = fakeDataStore.getPlatypuses(animalNumber);
        }
        GenericEntity<List<Platypus>> entity = new GenericEntity<>(platypuses) {
        };
        return Response.ok(entity).build();
    }


    @DELETE //DELETE at http://localhost:XXXX/students/3
    @Path("{id}")
    public Response deletePlatypus(@PathParam("id") int animaNumber) {
        fakeDataStore.deletePlatypus(animaNumber);
        // Idempotent method. Always return the same response (even if the resource has already been deleted before).
        return Response.noContent().build();
    }

    @POST //POST at http://localhost:XXXX/students/
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPlatypus(Platypus platypus) {
        if (!fakeDataStore.addPlatypus(platypus)) {
            String entity = "Animal with animal number " + platypus.getAnimalNumber() + " already exists.";
            return Response.status(Response.Status.CONFLICT).entity(entity).build();
        } else {
            String url = uriInfo.getAbsolutePath() + "/" + platypus.getAnimalNumber(); // url of the created student
            URI uri = URI.create(url);
            return Response.created(uri).build();
        }
    }

    @PUT //PUT at http://localhost:XXXX/students/
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updatePlatypus(Platypus platypus) {
        // Idempotent method. Always update (even if the resource has already been updated before).
        if (fakeDataStore.updatePlatypus(platypus)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Please provide a valid animal number.").build();
        }
    }


    @PUT //PUT at http://localhost:XXXX/students/{id}
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    @Path("{id}")
    public Response updatePlatypus(@PathParam("id") int animalNumber, @FormParam("name") String name, @FormParam("gender") String gender) {
        Platypus platypus = fakeDataStore.getPlatypus(animalNumber);
        if (platypus == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Please provide a valid animal number.").build();
        }
        platypus.setName(name);
        platypus.setGender(gender);


        return Response.noContent().build();
    }

}

