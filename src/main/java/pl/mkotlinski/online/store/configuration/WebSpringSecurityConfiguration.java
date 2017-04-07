package pl.mkotlinski.online.store.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSpringSecurityConfiguration extends WebSecurityConfigurerAdapter
{

	@Autowired
	@Qualifier("customUserdetailsService")
	private UserDetailsService userDetailsService;

/*	@Autowired
	PersistentTokenRepository tokenRepository;
*/
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userDetailsService);
	//	auth.authenticationProvider(getAuthenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
        .antMatchers("/*").permitAll()
        .and().formLogin().loginPage("/login")
        //TODO: do usuniecia
        .defaultSuccessUrl("/userInfo")
        .usernameParameter("ssoId").passwordParameter("password")
        .and().csrf().disable()
        .exceptionHandling().accessDeniedPage("/Access_Denied");
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
