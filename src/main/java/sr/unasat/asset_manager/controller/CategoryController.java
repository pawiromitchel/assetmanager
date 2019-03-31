package sr.unasat.asset_manager.controller;

import org.modelmapper.ModelMapper;
import sr.unasat.asset_manager.config.JPAConfiguration;
import sr.unasat.asset_manager.dto.CategoryDTO;
import sr.unasat.asset_manager.entity.Category;
import sr.unasat.asset_manager.service.CategoryService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("category")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CategoryController {
    private CategoryService assetService = new CategoryService(JPAConfiguration.getEntityManager());
    private ModelMapper modelMapper = new ModelMapper();

    @Path("/list")
    @GET
    public Response findAll() {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        CategoryDTO assetDTO;
        List<Category> assets = assetService.findAll();
        for (Category asset : assets) {
            assetDTO = modelMapper.map(asset, CategoryDTO.class);
            categoryDTOS.add(assetDTO);
        }
        return Response.ok(categoryDTOS).build();
    }
}
