package rest;

import java.util.List;

import data.Prey;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hunterservice")
public class HunterService {

  @GET
  @Path("/jello")
  @Produces(MediaType.TEXT_PLAIN)
  public String sayJello() {
    return "Jello";
  }

  // Reading all the rows from table prey.
  @GET
  @Path("/all")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Prey> readAllPrey() {
    // Create an EntityManagerFactory with the settings from persistence.xml file
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hunterapp");
    // And then EntityManager, which can manage the entities.
    EntityManager em = emf.createEntityManager();

    // Read all the rows from table prey. Here the Prey must start with capital,
    // because class's name starts. This returns a List of Prey objects.
    List<Prey> list = em.createQuery("select a from Prey a").getResultList();
    return list;
  }

  // Adding one prey object into the table prey
  @POST
  @Path("/addpreyjson")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Prey postPrey(Prey prey) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hunterapp");
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(prey);// The actual insertion line
    em.getTransaction().commit();
    return prey;
  }

  // This method uses FormParams, but does the same as previous
  @POST
  @Path("/addprey")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public Prey postPreyByParams(
      @FormParam("breed") String breed,
      @FormParam("weight") float weight,
      @FormParam("purebred") int purebred) // if you want to handle purebred too
  {
    Prey prey = new Prey(breed, weight, purebred);
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hunterapp");
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(prey);
    em.getTransaction().commit();
    return prey;
  }

}
