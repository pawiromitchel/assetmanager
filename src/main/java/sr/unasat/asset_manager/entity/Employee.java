package sr.unasat.asset_manager.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private long employeeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "createdByEmployee")
    private List<Asset> createdAssetList;

    @OneToMany(mappedBy = "updatedByEmployee")
    private List<Asset> updatedAssetList;

    public Employee(long employeeId, String firstName, String lastName, String mobile, String username, String password, Role role, List<Asset> createdAssetList, List<Asset> updatedAssetList) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.username = username;
        this.password = password;
        this.role = role;
        this.createdAssetList = createdAssetList;
        this.updatedAssetList = updatedAssetList;
    }

    public Employee() {
    }


    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
