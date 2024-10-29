package br.com.fiap.resource;

import br.com.fiap.bo.ProblemaBO;
import br.com.fiap.to.ProblemaTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/techmec/problemas")
public class ProblemaResource {
    private ProblemaBO problemaBO = new ProblemaBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllProblemas() {
        ArrayList<ProblemaTO> resultado = problemaBO.findAllProblemas();
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/{placa}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findProblemaByPlaca(@PathParam("placa") String placa) {
        ProblemaTO resultado = problemaBO.findProblemaByPlaca(placa);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveProblema(@Valid ProblemaTO problema) {
        ProblemaTO resultado = problemaBO.saveProblema(problema);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null);
        } else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("/{placa}")
    public Response deleteProblema(@PathParam("placa") String placa) {
        Response.ResponseBuilder response = null;
        if (problemaBO.deleteProblema(placa)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{placa}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProblema(@Valid ProblemaTO problema, @PathParam("placa") String placa) {
        problema.setPlaca(placa);
        ProblemaTO resultado = problemaBO.updateProblema(problema);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null);
        } else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }
}
