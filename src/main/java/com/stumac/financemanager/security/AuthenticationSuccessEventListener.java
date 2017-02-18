package com.stumac.financemanager.security;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
class AuthenticationSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent>
{
    private final ModelMapper mapper;
    private final UserRepository repository;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event)
    {
        User principal = (User) event.getAuthentication().getPrincipal();
        Optional<User> maybeUser = repository.findByUsername(principal.getUsername());
        if (maybeUser.isPresent())
        {
            User user = maybeUser.get();
            mapper.map(principal, user);
            repository.save(user);
            principal.setId(user.getId());
        } else
        {
            repository.save(principal);
        }
    }
}
