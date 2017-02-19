package com.stumac.financemanager.security;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;

import java.util.Optional;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationSuccessEventListenerTest
{
    @Mock
    private Authentication mockAuthentication;

    @Mock
    private User mockUser;

    @Mock
    private ModelMapper mockMapper;

    @Mock
    private UserRepository mockRepository;

    @InjectMocks
    private AuthenticationSuccessEventListener listener;

    @Before
    public void setUp()
    {
        when(mockAuthentication.getPrincipal()).thenReturn(mockUser);
        when(mockUser.getUsername()).thenReturn("user");
    }

    @Test
    public void shouldUpdateExistingUsers()
    {
        User existingUser = User.builder().id(1).build();
        when(mockRepository.findByUsername("user")).thenReturn(Optional.of(existingUser));

        listener.onApplicationEvent(new AuthenticationSuccessEvent(mockAuthentication));

        InOrder inOrder = inOrder(mockMapper, mockRepository, mockUser);
        inOrder.verify(mockMapper).map(mockUser, existingUser);
        inOrder.verify(mockRepository).save(existingUser);
        inOrder.verify(mockUser).setId(existingUser.getId());
    }

    @Test
    public void shouldSaveNewUsersToTheSystem()
    {
        when(mockRepository.findByUsername("user")).thenReturn(Optional.empty());
        listener.onApplicationEvent(new AuthenticationSuccessEvent(mockAuthentication));
        verify(mockRepository).save(mockUser);
    }
}
