package xinqiu.dao.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class ServerUser extends BaseModel {

    @NotNull
    @Size(max = 32,min = 3)
    @NaturalId
    private String username;

    @NotNull
    @Size(max = 32,min = 3)
    @JsonIgnore
    private String password;

    private String email;

    private String salt;//加密密码的盐

    @Temporal(TemporalType.TIMESTAMP)
    @Generated(GenerationTime.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createTime;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
    mappedBy = "serverUser")
    private ServerUserProfile serverUserProfile;

    @ManyToMany(fetch= FetchType.EAGER)//立即从数据库中进行加载数据;
    @JoinTable(name = "ServerUserRole", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
    private List<ServerRole> roleList;// 一个用户具有多个角色


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ServerUserProfile getServerUserProfile() {
        return serverUserProfile;
    }

    public void setServerUserProfile(ServerUserProfile serverUserProfile) {
        this.serverUserProfile = serverUserProfile;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<ServerRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<ServerRole> roleList) {
        this.roleList = roleList;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }


    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.username+this.salt;
    }
    //重新对盐重新进行了定义，用户名+salt，这样就更加不容易被破解
}
