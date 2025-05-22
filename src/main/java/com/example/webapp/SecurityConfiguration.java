package com.example.webapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Class to configure AWS Cognito as an OAuth 2.0 authorizer with Spring Security.
 * In this configuration, we specify our OAuth Client.
 * We also declare that all requests must come from an authenticated user.
 * Finally, we configure our logout handler.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        CognitoLogoutHandler cognitoLogoutHandler = new CognitoLogoutHandler();

//        http.csrf(Customizer.withDefaults())
//                .authorizeHttpRequests(authz -> authz
//                        .requestMatchers("/**").permitAll()
//                        .anyRequest()
//                        .authenticated())
//
//                .oauth2Login(Customizer.withDefaults())
//                .cors(withDefaults())
//                .logout(logout -> logout.logoutSuccessHandler(cognitoLogoutHandler));
//              //  .oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()));

        http.csrf(Customizer.withDefaults())
                .cors(withDefaults())
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/").permitAll()
                        .anyRequest()
                        .authenticated())
                .oauth2Login(Customizer.withDefaults())
                .logout(logout -> logout.logoutSuccessHandler(cognitoLogoutHandler));
        return http.build();


    }


//    @Bean
//    public JwtDecoder jwtDecoder() {
//        return JwtDecoders.fromIssuerLocation("https://cognito-idp.eu-west-1.amazonaws.com/eu-west-1_9o9th8r4u");
//    }
}