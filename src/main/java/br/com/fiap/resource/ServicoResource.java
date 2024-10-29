package br.com.fiap.resource;

import br.com.fiap.bo.ServicoBO;
import br.com.fiap.to.ServicoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/techmec/servicos")
public class ServicoResource {
    private ServicoBO servicoBO = new ServicoBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllServicos() {
        ArrayList<ServicoTO> resultado = servicoBO.findAllServicos();
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
    @Path("/{id_servico}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findServicoById(@PathParam("id_servico") Long idServico) {
        ServicoTO resultado = servicoBO.findServicoById(idServico);
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
    public Response saveServico(@Valid ServicoTO servico) {
        ServicoTO resultado = servicoBO.saveServico(servico);
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
    @Path("/{id_servico}")
    public Response deleteServico(@PathParam("id_servico") Long idServico) {
        Response.ResponseBuilder response = null;
        if (servicoBO.deleteServico(idServico)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{id_servico}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateServico(@Valid ServicoTO servico, @PathParam("id_servico") Long idServico) {
        servico.setIdServico(idServico);
        ServicoTO resultado = servicoBO.updateServico(servico);
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
