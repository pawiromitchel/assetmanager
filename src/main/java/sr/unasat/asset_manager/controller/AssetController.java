package sr.unasat.asset_manager.controller;

import org.modelmapper.ModelMapper;
import sr.unasat.asset_manager.config.JPAConfiguration;
import sr.unasat.asset_manager.dto.AssetDTO;
import sr.unasat.asset_manager.entity.Asset;
import sr.unasat.asset_manager.service.AssetService;

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
        AssetDTO assetDTO = modelMapper.map(assetService.delete(id), AssetDTO.class);
        return Response.ok(assetDTO).build();
    }

    @Path("/create")
    @POST
    public Response create(AssetDTO assetDTO) {
        try{
            Asset asset = modelMapper.map(assetDTO, Asset.class);
            assetService.create(asset);
        } catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(Response.Status.OK).build();
    }
}
