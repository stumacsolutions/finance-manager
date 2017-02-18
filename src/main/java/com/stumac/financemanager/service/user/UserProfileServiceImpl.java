package com.stumac.financemanager.service.user;

import com.stumac.financemanager.data.user.UserProfileEntity;
import com.stumac.financemanager.data.user.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.stumac.financemanager.security.User.getCurrentUser;
import static java.util.Optional.empty;
import static java.util.Optional.of;

@Component
@RequiredArgsConstructor
class UserProfileServiceImpl implements UserProfileService
{
    private final ModelMapper mapper;
    private final UserProfileRepository repository;

    @Override
    public Optional<UserProfile> get()
    {
        Optional<UserProfileEntity> maybeEntity = repository.findOneByUser(getCurrentUser());
        return maybeEntity.isPresent() ? of(map(maybeEntity.get())) : empty();
    }

    @Override
    public void save(UserProfile userProfile)
    {
        repository.save(map(userProfile));
    }

    private UserProfile map(UserProfileEntity source)
    {
        return mapper.map(source, UserProfile.class);
    }

    private UserProfileEntity map(UserProfile source)
    {
        UserProfileEntity entity = mapper.map(source, UserProfileEntity.class);
        entity.setUser(getCurrentUser());
        return entity;
    }
}
