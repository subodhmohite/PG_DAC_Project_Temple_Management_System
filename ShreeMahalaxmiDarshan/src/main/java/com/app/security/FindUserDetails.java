package com.app.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class FindUserDetails {
	
	public Long getUserId()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth!=null && auth.isAuthenticated())
		{
			Object credentials = auth.getCredentials();
			if(credentials instanceof Long)
			{
				return (Long)credentials;
			}
		}
		
		return null;
	}
}
