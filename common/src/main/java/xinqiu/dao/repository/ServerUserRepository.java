package xinqiu.dao.repository;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import xinqiu.dao.domain.QServerUser;
import xinqiu.dao.domain.ServerUser;
import xinqiu.enumtype.StateStatus;

@Repository
public interface ServerUserRepository extends PagingAndSortingRepository<ServerUser, Long>,
        QueryDslPredicateExecutor<ServerUser>{
    ServerUser findByIdAndStatus(Long id, StateStatus stateStatus);
    ServerUser findByUsernameAndStatus(String userName, StateStatus stateStatus);

    @Override
    Page<ServerUser> findAll(Pageable pageable);

    @Override
    Page<ServerUser> findAll(Predicate predicate, Pageable pageable);
}
