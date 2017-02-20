package ro.fmi.rest.utilsAjax;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import ro.fmi.bnk.rest.utils.AccountCredentials;
import ro.fmi.bnk.rest.utils.TokenAuthenticationService;
import ro.fmi.bnk.service.UserService;


public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter{

    private TokenAuthenticationService tokenAuthenticationService;
	private UserService userBean; 

    public JWTLoginFilter(String url, AuthenticationManager authenticationManager, UserService userBean)
    {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authenticationManager);
        tokenAuthenticationService = new TokenAuthenticationService();
this.userBean=userBean;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws AuthenticationException, IOException, ServletException {
        AccountCredentials credentials = new ObjectMapper().readValue(httpServletRequest.getInputStream(),AccountCredentials.class);

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword());
        return getAuthenticationManager().authenticate(token);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication)
            throws IOException, ServletException{
        String name = ((UserContext) authentication.getPrincipal()).getUsername();
        tokenAuthenticationService.addAuthentication(response,name);
    }
}