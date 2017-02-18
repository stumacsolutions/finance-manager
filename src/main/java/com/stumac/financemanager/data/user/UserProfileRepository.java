package com.stumac.financemanager.data.user;

import com.stumac.financemanager.security.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfileRepository extends PagingAndSortingRepository<UserProfileEntity, Long>
{

    Optional<UserProfileEntity> findOneByUser(User user);
}
