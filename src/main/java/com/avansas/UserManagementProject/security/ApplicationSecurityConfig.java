package com.avansas.UserManagementProject.security;

import com.avansas.UserManagementProject.security.jwt.JwtConfig;
import com.avansas.UserManagementProject.security.jwt.JwtTokenVerifier;
import com.avansas.UserManagementProject.security.jwt.JwtUsernamePasswordAuthenticationFilter;
import com.avansas.UserManagementProject.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsServiceImpl userDetailsServiceImpl;
    private final JwtConfig jwtConfig;
    private final SecretKey secretKey;


    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder,
                                     UserDetailsServiceImpl userDetailsServiceImpl, JwtConfig jwtConfig, SecretKey secretKey) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.jwtConfig = jwtConfig;
        this.secretKey = secretKey;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                    .sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .addFilter(new JwtUsernamePasswordAuthenticationFilter(authenticationManager(), jwtConfig, secretKey))
                    .addFilterAfter(new JwtTokenVerifier(jwtConfig, secretKey), JwtUsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers("/", "index", "/css/*", "/js/*", "/signup*", "/login*",
                        "/users", "api/v1/user**", "/update-view.jsp", "/update-view/**").permitAll()
                .antMatchers(HttpMethod.POST, "/signup").permitAll()
                .anyRequest()
                .authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userDetailsServiceImpl);
        return provider;
    }
}