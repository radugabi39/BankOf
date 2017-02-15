package ro.fmi.rest.utilsAjax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.lang.Assert;
import ro.fmi.bnk.enitites.User;
import ro.fmi.bnk.service.UserService;


	@Component
	public class AjaxAuthenticationProvider implements AuthenticationProvider {  

	    private final UserService userService;

	    @Autowired
	    public AjaxAuthenticationProvider(final UserService userService) {
	        this.userService = userService;
	   
	    }

	    @Override
	    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	        Assert.notNull(authentication, "No authentication data provided");

	        String username = (String) authentication.getPrincipal();
	        String password = (String) authentication.getCredentials();

	        User user = userService.authentificateUser(username, password);
	        		if(user==null){
	        			throw new UsernameNotFoundException("User not found: " + username);
	        		}

//	        if (!encoder.matches(password, user.getPassword())) {
//	            throw new BadCredentialsException("Authentication Failed. Username or Password not valid.");
//	        }

//	        if (user.getRoles() == null) throw new InsufficientAuthenticationException("User has no roles assigned");

//	        List<GrantedAuthority> authorities = user.getRoles().stream()
//	                .map(authority -> new SimpleGrantedAuthority(authority.getRole().authority()))
//	                .collect(Collectors.toList());
//
	        UserContext userContext = UserContext.create(user.getUserName(), null);

	        return new UsernamePasswordAuthenticationToken(userContext, null, null);
	    }

	    @Override
	    public boolean supports(Class<?> authentication) {
	        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	    }
	}