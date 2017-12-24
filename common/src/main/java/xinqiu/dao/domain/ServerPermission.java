package xinqiu.dao.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class ServerPermission extends BaseModel {

    private String name;//名称.

    @Column(columnDefinition="enum('menu','button')")
    private String resourceType;//资源类型，[menu|button]

    private String url;//资源路径.

    private String permission; //权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view

    @ManyToMany
    @JoinTable(name="ServerRolePermission",joinColumns={@JoinColumn(name="permissionId")},inverseJoinColumns={@JoinColumn(name="roleId")})
    private List<ServerRole> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public List<ServerRole> getRoles() {
        return roles;
    }

    public void setRoles(List<ServerRole> roles) {
        this.roles = roles;
    }


}