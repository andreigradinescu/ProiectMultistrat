package com.onlineshop.multistrat.chelariu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new JpaUserDetailsService ();
    }

    @Bean
    public PasswordEncoder passwordEncode() {
         return new
                 BCryptPasswordEncoder ();
    }

    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationP = new DaoAuthenticationProvider ();
        authenticationP.setUserDetailsService (userDetailsService ());
        authenticationP.setPasswordEncoder (passwordEncode ());

        return authenticationP;
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider (authenticationProvider ());
      //  auth.inMemoryAuthentication ().withUser ("andrei@yahoo.com").password (passwordEncode ().encode ("12")).roles ("Admin");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests ()
                .anyRequest ()
                .authenticated ()
                .and ()
                .formLogin ()
                .loginPage ("/login")
                .usernameParameter ("email")
                .permitAll ();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring ().antMatchers ("/js/**","/webjars/**");

    }
}
