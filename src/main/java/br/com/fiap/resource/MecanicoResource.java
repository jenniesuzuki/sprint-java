package br.com.fiap.resource;

import br.com.fiap.bo.MecanicoBO;
import br.com.fiap.to.MecanicoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/techmec/mecanicos")
public class MecanicoResource {
    private MecanicoBO mecanicoBO = new MecanicoBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllMecanicos() {
        ArrayList<MecanicoTO> resultado = mecanicoBO.findAllMecanicos();
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
    @Path("/{id_mecanico}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findMecanicoById(@PathParam("id_mecanico") Long idMecanico) {
        MecanicoTO resultado = mecanicoBO.findMecanicoById(idMecanico);
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
    public Response saveMecanico(@Valid MecanicoTO mecanico) {
        MecanicoTO resultado = mecanicoBO.saveMecanico(mecanico);
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
    @Path("/{id_mecanico}")
    public Response deleteMecanico(@PathParam("id_mecanico") Long idMecanico) {
        Response.ResponseBuilder response = null;
        if (mecanicoBO.deleteMecanico(idMecanico)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{id_mecanico}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMecanico(@Valid MecanicoTO mecanico, @PathParam("id_mecanico") Long idMecanico) {
        mecanico.setIdMecanico(idMecanico);
        MecanicoTO resultado = mecanicoBO.updateMecanico(mecanico);
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
