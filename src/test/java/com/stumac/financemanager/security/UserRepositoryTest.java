package com.stumac.financemanager.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest
{
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repository;

    @Test
    public void shouldReturnEmptyOptionalIfUsernameIsNotInUse()
    {
        assertFalse(repository.findByUsername("user").isPresent());
    }

    @Test
    public void shouldReturnPopulatedOptionalIfUsernameIsInUse()
    {
        User user = User.builder()
            .avatarUrl("")
            .name("")
            .username("test").build();
        entityManager.persist(user);
        assertTrue(repository.findByUsername("test").isPresent());
    }
}
