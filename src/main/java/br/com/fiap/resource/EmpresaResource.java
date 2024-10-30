package br.com.fiap.resource;

import br.com.fiap.bo.EmpresaBO;
import br.com.fiap.to.EmpresaTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/techmec/empresas")
public class EmpresaResource {
    private EmpresaBO empresaBO = new EmpresaBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllInfos() {
        ArrayList<EmpresaTO> resultado = empresaBO.findAllInfos();
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
    @Path("/{id_empresa}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByIdEmpresa(@PathParam("id_empresa") Long idEmpresa) {
        EmpresaTO resultado = empresaBO.findByIdEmpresa(idEmpresa);
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
    public Response saveEmpresa(@Valid EmpresaTO empresa) {
        EmpresaTO resultado = empresaBO.saveEmpresa(empresa);
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
    @Path("/{id_empresa}")
    public Response deleteEmpresa(@PathParam("id_empresa") Long idEmpresa) {
        Response.ResponseBuilder response = null;
        if (empresaBO.deleteEmpresa(idEmpresa)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{id_empresa}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEmpresa(@Valid EmpresaTO empresa, @PathParam("id_empresa") Long idEmpresa) {
        empresa.setIdEmpresa(idEmpresa);
        EmpresaTO resultado = empresaBO.updateEmpresa(empresa);
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
