package com.eyek.se418.lab02.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()

                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/actuator/prometheus").permitAll()
                .antMatchers("/actuator/*").hasRole("ADMIN")
                .antMatchers("/get-ladder").permitAll()
                .anyRequest().authenticated()
                .and()

                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()

                .logout()
                .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        User.UserBuilder builder = User.withDefaultPasswordEncoder();
        manager.createUser(
                builder
                        .username("root")
                        .password("secret")
                        .roles("ADMIN").build());
        manager.createUser(
                builder
                        .username("tom")
                        .password("secretForTom")
                        .roles("USER").build());
        manager.createUser(
                builder
                        .username("jerry")
                        .password("secretForJerry")
                        .roles("USER").build());

        return manager;
    }
}
