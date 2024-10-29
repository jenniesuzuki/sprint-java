package br.com.fiap.resource;

import br.com.fiap.bo.OrcamentoBO;
import br.com.fiap.to.OrcamentoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/techmec/orcamentos")
public class OrcamentoResource {
    private OrcamentoBO orcamentoBO = new OrcamentoBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllOrcamentos() {
        ArrayList<OrcamentoTO> resultado = orcamentoBO.findAllOrcamentos();
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
    public Response findByIdServico(@PathParam("id_servico") Long idServico) {
        OrcamentoTO resultado = orcamentoBO.findByIdServico(idServico);
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
    public Response saveOrcamento(@Valid OrcamentoTO orcamento) {
        OrcamentoTO resultado = orcamentoBO.saveOrcamento(orcamento);
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
    public Response deleteOrcamento(@PathParam("id_servico") Long idServico) {
        Response.ResponseBuilder response = null;
        if (orcamentoBO.deleteOrcamento(idServico)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{id_servico}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateOrcamento(@Valid OrcamentoTO orcamento, @PathParam("id_servico") Long idServico) {
        orcamento.setIdServico(idServico);
        OrcamentoTO resultado = orcamentoBO.updateOrcamento(orcamento);
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
