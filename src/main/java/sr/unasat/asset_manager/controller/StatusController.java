package sr.unasat.asset_manager.controller;

import org.modelmapper.ModelMapper;
import sr.unasat.asset_manager.config.JPAConfiguration;
import sr.unasat.asset_manager.dto.StatusDTO;
import sr.unasat.asset_manager.entity.Status;
import sr.unasat.asset_manager.service.StatusService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("status")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StatusController {
    private StatusService assetService = new StatusService(JPAConfiguration.getEntityManager());
    private ModelMapper modelMapper = new ModelMapper();

    @Path("/list")
    @GET
    public Response findAll() {
        List<StatusDTO> categoryDTOS = new ArrayList<>();
        StatusDTO assetDTO;
        List<Status> assets = assetService.findAll();
        for (Status asset : assets) {
            assetDTO = modelMapper.map(asset, StatusDTO.class);
            categoryDTOS.add(assetDTO);
        }
        return Response.ok(categoryDTOS).build();
    }
}
