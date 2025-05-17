package ir.digixo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pass, active from members where user_id=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
        return jdbcUserDetailsManager;
    }
/*
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return  NoOpPasswordEncoder.getInstance();
    }*/


    ///
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                authorizationManagerRequestMatcherRegistry -> {
                  //  authorizationManagerRequestMatcherRegistry.anyRequest().authenticated();
                    authorizationManagerRequestMatcherRegistry
                            .requestMatchers("/api/v1/home").hasRole("EMPLOYEE")
                            .requestMatchers(HttpMethod.GET,"/api/v1/config/**").hasAnyRole("MANAGER","ADMIN")
                            .requestMatchers("/api/v1/system/**").hasRole("ADMIN");
                }
        )

                /*.formLogin(httpSecurityFormLoginConfigurer -> {
                    httpSecurityFormLoginConfigurer
                            .loginPage("/showMyLoginform")
                            .loginProcessingUrl("/login2")
                            .permitAll();
                })
                .logout(httpSecurityLogoutConfigurer -> httpSecurityLogoutConfigurer.permitAll())*/
        ;
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
