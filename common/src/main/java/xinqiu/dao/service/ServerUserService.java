package xinqiu.dao.service;


import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import xinqiu.dao.domain.ServerUser;

public interface ServerUserService {

    ServerUser findOne(Long id);
    ServerUser findByUsername(String username);
    Page<ServerUser> findAll(Predicate predicate, Pageable pageable);
    Page<ServerUser> findAll(Predicate predicate, Integer page, Integer size);

    ServerUser save(ServerUser user);

    void delete(Long id);

}
