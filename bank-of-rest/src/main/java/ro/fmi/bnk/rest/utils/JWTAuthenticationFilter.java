package ro.fmi.bnk.rest.utils;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.ExpiredJwtException;

public class JWTAuthenticationFilter extends GenericFilterBean{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
    	HttpServletResponse resp=(HttpServletResponse) response; 
    	Authentication authentication=null;
    	try{ 
    		authentication = new TokenAuthenticationService().getAuthentication((HttpServletRequest)request);
    		 SecurityContextHolder.getContext().setAuthentication(authentication);
    	} catch(ExpiredJwtException c){
    		resp.setStatus(403);
    	}

       
        filterChain.doFilter(request,resp);
    }
}