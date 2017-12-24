package xinqiu.dao.respository;

import com.querydsl.core.types.Predicate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;
import xinqiu.dao.domain.QServerUser;
import xinqiu.dao.domain.ServerUser;
import xinqiu.dao.domain.ServerUserProfile;
import xinqiu.dao.repository.ServerUserRepository;
import xinqiu.dao.service.ServerUserService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ServerUserRepositoryTest {

    @Autowired
    private ServerUserRepository serverUserRepository;

    @Test
    public void saveUsers() {
        ServerUser user = new ServerUser();
        user.setUsername("user1");
        user.setEmail("llpin@163.com");
        user.setPassword("123456");

        ServerUserProfile profile = new ServerUserProfile();
        profile.setFirstName("ll");
        profile.setLastName("pin");
        profile.setServerUser(user);

        user.setServerUserProfile(profile);

        serverUserRepository.save(user);
    }


}
