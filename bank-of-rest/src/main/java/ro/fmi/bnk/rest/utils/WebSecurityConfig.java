package ro.fmi.bnk.rest.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import ro.fmi.bnk.service.UserService;

import ro.fmi.rest.utilsAjax.AjaxAuthenticationProvider;
import ro.fmi.rest.utilsAjax.JWTLoginFilter;
@Configuration
@EnableWebSecurity

@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired private AjaxAuthenticationProvider ajaxAuthenticationProvider;
    @Autowired
    private UserService userBean;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() 
        .authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers(HttpMethod.GET,"/user/*").permitAll()
        .anyRequest().authenticated()
        .and()
        .addFilterBefore(new JWTLoginFilter("/login", authenticationManager(),userBean), UsernamePasswordAuthenticationFilter.class)
        .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.authenticationProvider(ajaxAuthenticationProvider);
    }
}