package starterspringmvc4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/about").permitAll()
				.anyRequest().authenticated();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.eraseCredentials(true).inMemoryAuthentication().withUser("user")
				.password("password").roles("USER");
	}

	/**
	 * http://stackoverflow.com/a/24666187
	 * 
	 * Following Multiple HttpSecurity approach:
	 * http://docs.spring.io/spring-security
	 * /site/docs/3.2.x/reference/htmlsingle/#multiple-httpsecurity
	 */
	@Configuration
	@Order(1)
	public static class ManagerEndpointsSecurityConfig extends
			WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.antMatcher("/**").authorizeRequests().anyRequest()
					.hasRole("USER").and().httpBasic();
		}
	}
}
