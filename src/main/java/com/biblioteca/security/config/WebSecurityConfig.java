package com.biblioteca.security.config;

import com.biblioteca.security.JWTAuthenticationFilter;
import com.biblioteca.security.JWTAuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.AllArgsConstructor;


@Configuration
@AllArgsConstructor
public class WebSecurityConfig {

    private final UserDetailsService userDetailsService;
    private final JWTAuthorizationFilter jwtAuthorizationFilter;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception{

        JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
        jwtAuthenticationFilter.setAuthenticationManager(authManager);
        jwtAuthenticationFilter.setFilterProcessesUrl("/login");


        return http
                .cors()
                .and()
                .csrf().disable()
                // ACCEDER A LAS REGLAS DE LAS SOLICITUDES
                .authorizeRequests()
                //aqui van las rutas a las que se quiere acceder para las peticiones
                .antMatchers(HttpMethod.GET, "/api/libros").permitAll()
                .antMatchers(HttpMethod.GET, "/api/libros/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/libros").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/libros").permitAll()
                .antMatchers(HttpMethod.DELETE,"/api/libros/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/estados").permitAll()
                .antMatchers(HttpMethod.GET, "/api/cubiculos").permitAll()
                .antMatchers(HttpMethod.GET, "/api/cubiculos/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/cubiculos").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/cubiculos").permitAll()
                .antMatchers(HttpMethod.DELETE,"/api/cubiculos/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/reservasCubi").permitAll()
                .antMatchers(HttpMethod.GET, "/api/reservasCubi/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/reservasCubi").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/reservasCubi").permitAll()
                .antMatchers(HttpMethod.DELETE,"/api/reservasCubi/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/reservaslibro").permitAll()
                .antMatchers(HttpMethod.GET, "/api/reservaslibro/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/reservaslibro").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/reservaslibro").permitAll()
                .antMatchers(HttpMethod.DELETE,"/api/reservaslibro/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                //.cors()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(jwtAuthenticationFilter)
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception{
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // public static void main(String[] arg){
    //     System.out.println("pass :" + new BCryptPasswordEncoder().encode("jose123"));
    // }



}

