package com.onlineshop.multistrat.chelariu;

import com.onlineshop.multistrat.chelariu.entities.Rol;
import com.onlineshop.multistrat.chelariu.entities.User;
import com.onlineshop.multistrat.chelariu.repositories.RoleRepository;
import com.onlineshop.multistrat.chelariu.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import javax.persistence.PersistenceContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserTest  {

    @Mock
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @InjectMocks
    private EncodePasswordTest encodePasswordTest;

    @Test
    public void testCreateNewUserWithOneRole() {
        Rol roleAdmin = entityManager.find(Rol.class, 31);
        User userWithOneRole = new User("andaaarei@yahoo.com", "andraaei20222", "Yağmur", "Akşaç");
        userWithOneRole.addRole(roleAdmin);

        User savedUser = userRepository.save(userWithOneRole);
        encodePasswordTest.testEncodePassword ();
        assertThat(savedUser.getId()).isGreaterThan(0);
    }
}
