package br.com.fiap.resource;

import br.com.fiap.bo.AgendamentoBO;
import br.com.fiap.to.AgendamentoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/techmec/agendamentos")
public class AgendamentoResource {
    private AgendamentoBO agendamentoBO = new AgendamentoBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllAgendamentos() {
        ArrayList<AgendamentoTO> resultado = agendamentoBO.findAllAgendamentos();
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
    @Path("/{id_agendamento}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id_agendamento") Long idAgendamento) {
        AgendamentoTO resultado = agendamentoBO.findById(idAgendamento);
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
    public Response saveAgendamento(@Valid AgendamentoTO agendamento) {
        AgendamentoTO resultado = agendamentoBO.saveAgendamento(agendamento);
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
    @Path("/{id_agendamento}")
    public Response deleteAgendamento(@PathParam("id_agendamento") Long idAgendamento) {
        Response.ResponseBuilder response = null;
        if (agendamentoBO.deleteAgendamento(idAgendamento)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{id_agendamento}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAgendamento(@Valid AgendamentoTO agendamento, @PathParam("id_agendamento") Long idAgendamento) {
        agendamento.setIdAgendamento(idAgendamento);
        AgendamentoTO resultado= agendamentoBO.updateAgendamento(agendamento);
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
