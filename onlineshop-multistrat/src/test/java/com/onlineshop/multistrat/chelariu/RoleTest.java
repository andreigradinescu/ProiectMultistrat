package com.onlineshop.multistrat.chelariu;

import com.onlineshop.multistrat.chelariu.entities.Rol;
import com.onlineshop.multistrat.chelariu.repositories.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
@ComponentScan("roleRepository")
@Qualifier(value = "roleRepository")
public class RoleTest {

    @Autowired
    @Qualifier("roleRepository")
    private RoleRepository roleRepository;

    @Test
    public void testCreateFirstRole() {
        Rol roleAdmin = new Rol ("Admin", "manage everything");
        Rol saveRole = roleRepository.save(roleAdmin);
        assertThat(saveRole.getId()).isGreaterThan(0);
    }

    @Test
    public void testCreateSecondRole() {
        Rol roleSalesPerson = new Rol ("SalesPerson", "manage product price," + " customers, shipping, orders and sales report");
        Rol roleEditor = new Rol ("Editor", "manage categories, brands" + " products, articles and menus");
        Rol rolUser = new Rol("User","view articles");
        roleRepository.saveAll (List.of (roleSalesPerson, roleEditor, rolUser));
    }
}
