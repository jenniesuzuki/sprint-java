package br.com.fiap.resource;

import br.com.fiap.bo.CentroAutomotivoBO;
import br.com.fiap.to.CentroAutomotivoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/techmec/centros")
public class CentroAutomotivoResource {
    private CentroAutomotivoBO centroAutomotivoBO = new CentroAutomotivoBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllCentros() {
        ArrayList<CentroAutomotivoTO> resultado = centroAutomotivoBO.findAllCentros();
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
    @Path("/{cep}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCep(@PathParam("cep") String cep) {
        CentroAutomotivoTO resultado = centroAutomotivoBO.findByCep(cep);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(); // 200 - Ok
        } else {
            response = Response.status(404); // 404 - Not Found
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveCentro(@Valid CentroAutomotivoTO centro) {
        CentroAutomotivoTO resultado = centroAutomotivoBO.saveCentro(centro);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null); // 201 - CREATED
        } else {
            response = Response.status(400); // 400 - BAD REQUEST
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("/{cep}")
    public Response deleteCentro(@PathParam("cep") String cep) {
        Response.ResponseBuilder response = null;
        if (centroAutomotivoBO.deleteCentro(cep)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{cep}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCentro(@Valid CentroAutomotivoTO centro, @PathParam("cep") String cep) {
        centro.setCep(cep);
        CentroAutomotivoTO resultado = centroAutomotivoBO.updateCentro(centro);
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
