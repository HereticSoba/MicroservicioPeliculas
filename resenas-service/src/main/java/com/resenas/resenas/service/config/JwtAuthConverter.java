package com.resenas.resenas.service.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Collection;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class JwtAuthConverter implements Converter<Jwt, AbstractAuthenticationToken>{
	@Override
	public AbstractAuthenticationToken convert(Jwt jwt) {
		Map<String, Object> realmAccess = jwt.getClaim("realm_access");
		Collection<SimpleGrantedAuthority> authorities = List.of();
		if(realmAccess != null && realmAccess.containsKey("roles")) {
			Object rolesObject = realmAccess.get("roles");
			if(rolesObject instanceof List<?> rolesList) {
				authorities = rolesList.stream()
						.map(Object::toString)
						.map(role -> new SimpleGrantedAuthority("ROLE_" + role))
						.collect(Collectors.toList());
			}
		}
		return new JwtAuthenticationToken(jwt, authorities);
	}

}
