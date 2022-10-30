package com.onlineshop.multistrat.chelariu;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EncodePasswordTest {
    @Test
    public void testEncodePassword(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder ();
        String rawPassword = "nam2020" + "some";
        String encodedPassword = bCryptPasswordEncoder.encode (rawPassword);

        System.out.println (encodedPassword);

        boolean match = bCryptPasswordEncoder.matches (rawPassword, encodedPassword);

        assertThat(match).isTrue();
    }
}
