package com.onlineshop.multistrat.chelariu;

import com.onlineshop.multistrat.chelariu.entities.Rol;
import com.onlineshop.multistrat.chelariu.entities.User;
import com.onlineshop.multistrat.chelariu.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserTest {

    private final UserRepository userRepository;
    private final TestEntityManager testEntityManager;

    public UserTest(UserRepository userRepository, TestEntityManager testEntityManager) {
        this.userRepository = userRepository;
        this.testEntityManager = testEntityManager;
    }
    @Test
    public void testCreateNewUserWithOneRole() {
        Rol roleAdmin = testEntityManager.find(Rol.class, 14);
        User userWithOneRole = new User("y@a.net", "ya2020", "Yağmur", "Akşaç");
        userWithOneRole.addRole(roleAdmin);

        User savedUser = userRepository.save(userWithOneRole);

        assertThat(savedUser.getId()).isGreaterThan(0);
    }
}
