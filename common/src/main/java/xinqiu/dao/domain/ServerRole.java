package xinqiu.dao.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class ServerRole extends BaseModel{
    private String role; // 角色标识程序中判断使用,如"admin",这个是唯一的:
    private String description; // 角色描述,UI界面显示使用

    //角色 -- 权限关系：多对多关系;
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="ServerRolePermission",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="permissionId")})
    private List<ServerPermission> permissions;

    // 用户 - 角色关系定义;
    @ManyToMany
    @JoinTable(name="ServerUserRole",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="userId")})
    private List<ServerUser> serverUsers;// 一个角色对应多个用户


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ServerPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<ServerPermission> permissions) {
        this.permissions = permissions;
    }

    public List<ServerUser> getServerUsers() {
        return serverUsers;
    }

    public void setServerUsers(List<ServerUser> serverUsers) {
        this.serverUsers = serverUsers;
    }
}