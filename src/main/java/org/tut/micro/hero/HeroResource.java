package org.tut.micro.hero;

import org.jboss.logging.Logger;
import org.tut.micro.hero.data.Hero;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hero")
@Produces(MediaType.APPLICATION_JSON)
public class HeroResource {

    private static final Logger LOGGER = Logger.getLogger(HeroResource.class);

    @Inject
    HeroService service;

    @GET
    @Path("/random")
    public Response getRandomHero() {
        Hero hero = service.findRamdomHero();
        LOGGER.info("Found random hero " + hero);
        return Response.ok(hero).build();
    }

    @GET
    public Response getAllHeros() {
        return Response.ok(service.getAllHeros()).build();
    }

    @GET
    @Path("/{id}")
    public Response getHero(@PathParam("id") Long id) {
        Hero hero = service.findById(id);
        if(hero == null) {
            LOGGER.debug("No hero found with id "+id);
            return Response.noContent().build();
        } else {
            LOGGER.info("Found hero "+hero.toString());
            return Response.ok(hero).build();
        }
    }
}