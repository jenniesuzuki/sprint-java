package br.com.fiap.resource;

import br.com.fiap.bo.ClienteBO;
import br.com.fiap.to.ClienteTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/techmec/clientes")
public class ClienteResource {
    private ClienteBO clienteBO = new ClienteBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllClientes() {
        ArrayList<ClienteTO> resultado = clienteBO.findAllClientes();
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(); // 200
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/{cpf}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCpf(@PathParam("cpf") String cpf) {
        ClienteTO resultado = clienteBO.findByCpf(cpf);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(); // 200
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveCliente(@Valid ClienteTO cliente) {
        ClienteTO resultado = clienteBO.saveCliente(cliente);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null); // 201
        } else {
            response = Response.status(400); // Bad Request
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("/{cpf}")
    public Response deleteCliente(@PathParam("cpf") String cpf) {
        Response.ResponseBuilder response = null;
        if (clienteBO.deleteCliente(cpf)) {
            response = Response.status(204); // No Content
        } else {
            response = Response.status(404); // Not Found
        }
        return response.build();
    }

    @PUT
    @Path("/{cpf}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCliente(@Valid ClienteTO cliente, @PathParam("cpf") String cpf) {
        cliente.setCpf(cpf);
        ClienteTO resultado = clienteBO.updateCliente(cliente);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null); // 201 - CREATED
        } else {
            response = Response.status(400); // 400 - BAD REQUEST
        }
        response.entity(resultado);
        return response.build();
    }
}