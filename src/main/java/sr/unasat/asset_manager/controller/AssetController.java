package sr.unasat.asset_manager.controller;

import org.modelmapper.ModelMapper;
import sr.unasat.asset_manager.builders.AssetBuilder;
import sr.unasat.asset_manager.config.JPAConfiguration;
import sr.unasat.asset_manager.dto.AssetDTO;
import sr.unasat.asset_manager.entity.Asset;
import sr.unasat.asset_manager.entity.Status;
import sr.unasat.asset_manager.service.AssetService;
import sr.unasat.asset_manager.service.StatusService;
import sr.unasat.asset_manager.states.AssetContext;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("asset")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AssetController {
    private AssetService assetService = new AssetService(JPAConfiguration.getEntityManager());
    private StatusService statusService = new StatusService(JPAConfiguration.getEntityManager());
    private ModelMapper modelMapper = new ModelMapper();

    @Path("/list")
    @GET
    public Response findAll() {
        List<AssetDTO> assetDTOS = new ArrayList<>();
        AssetDTO assetDTO;
        List<Asset> assets = assetService.findAll();
        for (Asset asset : assets) {
            assetDTO = modelMapper.map(asset, AssetDTO.class);
            assetDTOS.add(assetDTO);
        }
        return Response.ok(assetDTOS).build();
    }

    @Path("/{assetId}")
    @GET
    public Response findOne(@PathParam("assetId") Long id) {
        AssetDTO assetDTO = modelMapper.map(assetService.findOne(id), AssetDTO.class);
        return Response.ok(assetDTO).build();
    }

    @Path("/{assetId}")
    @PUT
    public Response update(@PathParam("assetId") Long id, @Valid AssetDTO assetDTO) {
        assetDTO.setAssetId(id);
        Asset asset = modelMapper.map(assetDTO, Asset.class);
        assetService.update(asset);
        return Response.ok(Response.Status.OK).build();
    }

    @Path("/{assetId}")
    @DELETE
    public Response delete(@PathParam("assetId") Long id) {
        Asset asset = assetService.findOne(id);

        AssetContext assetContext = new AssetContext();
        assetContext.setStatus(asset);

        if(assetContext.getState(asset).getStatus().equals("Registered")){
            assetService.delete(id);
            return Response.ok(Response.Status.OK).build();
        } else if(assetContext.getState(asset).getStatus().equals("Written-Off")){
            System.out.println("Not allowed to delete an written off asset");
            return Response.ok(Response.Status.NOT_ACCEPTABLE).build();
        }

        return Response.ok(Response.Status.OK).build();
    }

    @Path("/create")
    @POST
    public Response create(AssetDTO assetDTO) {
        try{
            Asset asset = modelMapper.map(assetDTO, Asset.class);

            // Set status as Registered
            Status status = statusService.findOne(1);

            // Builder Design Pattern
            AssetBuilder assetBuilder = new AssetBuilder();
            assetBuilder.setAssetId(asset.getAssetId());
            assetBuilder.setAssetDescription(asset.getAssetDescription());
            assetBuilder.setMacAddress(asset.getMacAddress());
            assetBuilder.setSerialNumber(asset.getSerialNumber());
            assetBuilder.setEstimatedLifespan(asset.getEstimatedLifespan());
            assetBuilder.setCreatedByEmployee(asset.getCreatedByEmployee());
            assetBuilder.setUpdatedByEmployee(asset.getUpdatedByEmployee());
            assetBuilder.setStatus(status);
            assetBuilder.setCategory(asset.getCategory());

            assetService.create(assetBuilder.getResult());
        } catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(Response.Status.OK).build();
    }
}
