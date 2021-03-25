package ch.fhnw.webec.Todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


// Codes in dieser Klasse wurden vom Contat List Projekt kopiert und ein wenig angepasst.
// EXTERNAL: https://github.com/WebEngineering-FHNW/contact-list-security-netopyr-1/tree/master/src/main/java/ch/fhnw/webec/contactlistsecurity/config

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login", "style.css").permitAll()
                .antMatchers(HttpMethod.GET, "/").authenticated()
                .antMatchers("/index.ftlh").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/alltodos.ftlh").hasRole("ADMIN")
                .and()
                .csrf()
                .disable()
                .formLogin()
                .loginPage("/login");
    }

    @Bean

    @Override
    protected UserDetailsService userDetailsService(){
        final User.UserBuilder builder = User.withDefaultPasswordEncoder();
        final UserDetails admin = builder.username("user1").password("user1").roles("ADMIN").build();
        final UserDetails user1 = builder.username("user2").password("user2").roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user1, admin);
    }

}
