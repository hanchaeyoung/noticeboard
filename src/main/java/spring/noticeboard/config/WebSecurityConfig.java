package spring.noticeboard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.authorizeRequests()
                .antMatchers("/", "/login", "/user/add", "/css/**", "/js/**", "/bootstrap-5.3.0-alpha3-dist/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                // .defaultSuccessUrl("/").permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .csrf().disable();


//                .antMatchers("/**").permitAll()
//                // .antMatchers("/login").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                // .loginPage("/user/login")
//                .defaultSuccessUrl("/").permitAll()
//                .and()
//                .logout()
//                // .logoutSuccessUrl("/login")
//                .logoutSuccessUrl("/")
//                .permitAll();
    }


    //passwordEncoder
    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}