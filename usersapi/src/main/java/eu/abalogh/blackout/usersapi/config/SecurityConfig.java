package eu.abalogh.blackout.usersapi.config;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	protected void configure(final HttpSecurity http) throws Exception {
		http.authorizeRequests(authz -> authz.anyRequest().authenticated()).oauth2ResourceServer(
				oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())));
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**").antMatchers("/swagger-ui.html").antMatchers("/swagger-ui/**")
				.antMatchers("/api-docs/**");
	}

	private Converter<Jwt, ? extends AbstractAuthenticationToken> jwtAuthenticationConverter() {
		JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();
		jwtConverter.setJwtGrantedAuthoritiesConverter(new Converter<Jwt, Collection<GrantedAuthority>>() {
			@SuppressWarnings("unchecked")
			@Override
			public Collection<GrantedAuthority> convert(Jwt jwt) {
				final Map<String, Object> realmAccess = (Map<String, Object>) jwt.getClaims().get("realm_access");
				return ((List<String>) realmAccess.get("roles")).stream().map(roleName -> "ROLE_" + roleName) // prefix
																												// to
																												// map
																												// to a
																												// Spring
																												// Security
																												// "role"
						.map(SimpleGrantedAuthority::new).collect(Collectors.toList());
			}
		});
		return jwtConverter;
	}

}
