package xinqiu.dao.service;

import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xinqiu.dao.domain.ServerUser;
import xinqiu.dao.repository.ServerUserRepository;
import xinqiu.enumtype.StateStatus;

@Service
public class ServerUserServiceImpl implements ServerUserService {

    @Autowired
    private ServerUserRepository serverUserRepository;

    @Override
    public ServerUser findOne(Long id) {
        return serverUserRepository.exists(id) ?
                serverUserRepository.findByIdAndStatus(id,StateStatus.NORMAL) :
                null;
    }

    @Override
    public ServerUser findByUsername(String username) {
        return serverUserRepository.findByUsernameAndStatus(username, StateStatus.NORMAL);
    }

    @Override
    public Page<ServerUser> findAll(Predicate predicate, Pageable pageable) {
        return serverUserRepository.findAll(predicate, pageable);
    }

    @Override
    public Page<ServerUser> findAll(Predicate predicate, Integer page, Integer size) {
        Pageable pageable = new PageRequest(page,size, Sort.Direction.DESC, "createTime");
        return findAll(predicate, pageable);
    }

    @Override
    public ServerUser save(ServerUser user) {
        return serverUserRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        ServerUser user = serverUserRepository.findOne(id);
        user.setStatus(StateStatus.DELETED);
        serverUserRepository.save(user);
    }
}
