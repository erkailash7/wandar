package com.wander.wander.project.config;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.wander.wander.project.dao.UserDao;

//@Configuration
//@EnableWebSecurity
public class WanderSecurityConfig /*extends WebSecurityConfigurerAdapter*/ {

	@Autowired
	private UserDao userDao;
	
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("daoooooooo login");
		List<com.wander.wander.project.bean.User> users  = userDao.getUsers();
		if(users != null) {
			for(int i =0 ; i < users.size() ; i++) {
				com.wander.wander.project.bean.User u1 = users.get(i);
				String userName  = u1.getUserName();
				String pwd = u1.getPassword();
				UserBuilder user  = User.withDefaultPasswordEncoder();
				auth.inMemoryAuthentication()
				.withUser(user.username(userName).password(pwd));
			}
			
			
		}
		*/
		
		// Add our user in memory Authentication
	//	UserBuilder user  = User.withDefaultPasswordEncoder();
		//auth.inMemoryAuthentication()
		//.withUser(user.username("john").password("test123"));
	//	.withUser(user.username("kailash").password("test123").roles("MANAGER"))
	//	.withUser(user.username("lucky").password("test123").roles("ADMIN"));
	//}

	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/").hasRole("EMPLOYEE")
		.antMatchers("/leaders/**").hasRole("MANAGER")
		.antMatchers("/system/**").hasRole("ADMIN")
		.and()
			.formLogin().loginPage("/showMyLoginPage")
			.loginProcessingUrl("/authenticateTheUser")
			.permitAll()
			.and()
			.logout()
			.permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
		
	}
*/
}
