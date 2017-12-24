package xinqiu.dao.domain;


import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class ServerUser extends BaseModel {

    @NotNull
    @Size(max = 32,min = 3)
    private String username;

    @NotNull
    @Size(max = 32,min = 3)
    private String password;

    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    @Generated(GenerationTime.INSERT)
    private Date createTime;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
    mappedBy = "serverUser")
    private ServerUserProfile serverUserProfile;


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
}
