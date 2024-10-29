package br.com.fiap.resource;

import br.com.fiap.bo.PecasBO;
import br.com.fiap.to.PecasTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/techmec/pecas")
public class PecasResource {
    private PecasBO pecasBO = new PecasBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllPecas() {
        ArrayList<PecasTO> resultado = pecasBO.findAllPecas();
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
    @Path("/{id_peca}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByIdPeca(@PathParam("id_peca") Long idPeca) {
        PecasTO resultado = pecasBO.findByIdPeca(idPeca);
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
    public Response savePeca(@Valid PecasTO peca) {
        PecasTO resultado = pecasBO.savePeca(peca);
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
    @Path("/{id_peca}")
    public Response deletePeca(@PathParam("id_peca") Long idPeca) {
        Response.ResponseBuilder response = null;
        if (pecasBO.deletePeca(idPeca)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{id_peca}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePeca(@Valid PecasTO peca, @PathParam("id_peca") Long idPeca) {
        peca.setIdPeca(idPeca);
        PecasTO resultado = pecasBO.updatePeca(peca);
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
