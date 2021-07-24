/**
 * 
 */
package fr.narbonneau.mpl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import fr.narbonneau.mpl.security.jwt.JWTAuthenticationFilter;
import fr.narbonneau.mpl.security.jwt.JWTAuthorizationFilter;
import fr.narbonneau.mpl.security.service.MplUserDetailsService;
import fr.narbonneau.mpl.security.utils.SecurityConstants;

/**
 * @author narbonneau
 *
 */
@EnableWebSecurity
public class MplWebSecurity extends WebSecurityConfigurerAdapter {

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private MplUserDetailsService userDetailsService;
	
	public MplWebSecurity(BCryptPasswordEncoder passwordEncoder)
	{
		this.bCryptPasswordEncoder = passwordEncoder;
	}


	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}



	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {


		http.cors().and().csrf().disable();
		
		// Gestion partie login
		http.authorizeRequests().antMatchers(HttpMethod.POST,SecurityConstants.SIGN_UP_URL).permitAll()
		.anyRequest().authenticated()
        .and()
        .addFilter(new JWTAuthenticationFilter(authenticationManagerBean()))
        .addFilter(new JWTAuthorizationFilter(authenticationManagerBean()))
        // this disables session creation on Spring Security
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		/*
		http
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers("/").permitAll().antMatchers("/h2-console/**").permitAll().antMatchers("/api/auth/**")
				.permitAll().antMatchers("/utilisateurs/login").permitAll().antMatchers("/utilisateurs/signup")
				.permitAll().antMatchers("/api/test/**").permitAll();
		http.anyRequest().authenticated();

		// Autorisation de l'url h2console
		http.headers().frameOptions().disable();

		http.httpBasic().and().apply(securityConfigurerAdapter());
*/
	}

	// Used by spring security if CORS is enabled.
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("https://localhost:3000");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

}
