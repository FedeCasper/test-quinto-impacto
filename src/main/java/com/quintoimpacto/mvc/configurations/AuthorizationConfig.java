package com.quintoimpacto.mvc.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Configuration
@EnableWebSecurity
public class AuthorizationConfig {

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers( "/h2-console/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/administrators/**", "/professors/**", "/students/**", "/courses/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/administrators/**", "/professors", "/courses").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/administrators/**", "/courses/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/administrators/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/administrators/**", "/professors/**", "/courses/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/professors/user_course").hasAuthority("PROFESSOR")
                .antMatchers(HttpMethod.POST, "/students/user_course").hasAuthority("STUDENT")
                .antMatchers(HttpMethod.POST, "/students").hasAnyAuthority("ADMIN", "PROFESSOR")
                .antMatchers(HttpMethod.PUT, "/students/**", "/professors/**").hasAnyAuthority("ADMIN", "PROFESSOR")
                .antMatchers(HttpMethod.PATCH, "/students/**").hasAnyAuthority("ADMIN", "PROFESSOR")
                .antMatchers(HttpMethod.GET, "/students/**", "/professors/**", "/courses/**").hasAnyAuthority("ADMIN", "PROFESSOR")
                .antMatchers(HttpMethod.GET, "/courses/**").permitAll()
                .antMatchers( HttpMethod.POST, "/users/**").permitAll()
                .antMatchers( "/users/**", "/web/**").permitAll();


        http.formLogin()
                .usernameParameter("email")
                .passwordParameter("password")
                .loginPage("/login");

        http.logout().logoutUrl("/logout");

        http.sessionManagement()
            .maximumSessions(3)
            .maxSessionsPreventsLogin(true)
            .expiredUrl("/sessionExpired");

        // desactivar la comprobación de tokens CSRF
        http.csrf().disable();

        // deshabilitar frameOptions para que se pueda acceder a h2-console
        http.headers().frameOptions().disable();

        // si el usuario no está autenticado, simplemente envíe una respuesta de falla de autenticación
        http.exceptionHandling().authenticationEntryPoint((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED));

        //si el inicio de sesión es exitoso, simplemente borre las banderas que solicitan autenticación
        http.formLogin().successHandler((req, res, auth) -> clearAuthenticationAttributes(req));

        // si el inicio de sesión falla, simplemente envíe una respuesta de falla de autenticación
        http.formLogin().failureHandler((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED));

        // si el cierre de sesión es exitoso, simplemente envíe una respuesta exitosa
        http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());

        return http.build();
    }

    private void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        }
    }

}