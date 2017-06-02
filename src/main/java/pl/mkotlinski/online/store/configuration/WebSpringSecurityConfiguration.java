package pl.mkotlinski.online.store.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

@Configuration
@EnableWebSecurity
public class WebSpringSecurityConfiguration extends WebSecurityConfigurerAdapter
{

	@Autowired
	@Qualifier("storeUserDetailsService")
	private UserDetailsService userDetailsService;

	/*
	 * @Autowired PersistentTokenRepository tokenRepository;
	 */
	
	/*
	 * Configuration User Details Service.
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userDetailsService);
	//	auth.authenticationProvider(getAuthenticationProvider());
		auth.userDetailsService(userDetailsService);
		// auth.authenticationProvider(getAuthenticationProvider());
	}

	/*
	 * Main configuration web security.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests().antMatchers("/*").permitAll().and().formLogin().loginPage("/login")
				.defaultSuccessUrl("/").usernameParameter("ssoId").passwordParameter("password").and().csrf()
				.disable().exceptionHandling().accessDeniedPage("/Access_Denied");
	}

	/*
	@Bean
	public DaoAuthenticationProvider getAuthenticationProvider()
	{
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(getPasswordEncoder());
		return authenticationProvider;
	}

	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationTrustResolver getAuthenticationResolver()
	{
		return new AuthenticationTrustResolverImpl();
	}

	@Bean
	public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices()
	{
		PersistentTokenBasedRememberMeServices tokenBasedservice = new PersistentTokenBasedRememberMeServices(
				"remember-me", userDetailsService, tokenRepository);
		return tokenBasedservice;
	}*/
}
