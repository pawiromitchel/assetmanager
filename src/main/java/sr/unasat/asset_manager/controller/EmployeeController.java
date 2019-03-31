package sr.unasat.asset_manager.controller;

import org.modelmapper.ModelMapper;
import sr.unasat.asset_manager.auth.AuthStrategy;
import sr.unasat.asset_manager.auth.AuthWithMySQL;
import sr.unasat.asset_manager.config.JPAConfiguration;
import sr.unasat.asset_manager.dto.EmployeeDTO;
import sr.unasat.asset_manager.entity.Employee;
import sr.unasat.asset_manager.service.EmployeeService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("employee")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeController {
    private EmployeeService employeeService = new EmployeeService(JPAConfiguration.getEntityManager());
    private ModelMapper modelMapper = new ModelMapper();

    @Path("/list")
    @GET
    public Response findAll() {
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        EmployeeDTO employeeDTO;
        List<Employee> employees = employeeService.findAll();
        for (Employee employee : employees) {
            employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
            employeeDTOS.add(employeeDTO);
        }
        return Response.ok(employeeDTOS).build();
    }

    @Path("/auth")
    @POST
    public Response authenticate(EmployeeDTO employeeDTO){
        EmployeeDTO authenticatedEmployee;
        try{
            // Strategy Pattern
            // This time the user is authenticated with MySQL, later with Facebook or Twitter
            AuthStrategy authStrategy = null;
            authStrategy = new AuthWithMySQL();
            Employee employee = modelMapper.map(employeeDTO, Employee.class);
            authenticatedEmployee = modelMapper.map(authStrategy.auth(employee), EmployeeDTO.class);
        } catch (Exception e){
            JPAConfiguration.getEntityManager().getTransaction().rollback();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(authenticatedEmployee).build();
    }
}
