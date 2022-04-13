package kr.co.lgit.boot.config.auth;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import kr.co.lgit.boot.domain.user.Role;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity //Spring Security 설정들을 활성화시켜 준다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final CustomOAuth2UserService customOAuth2UserService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.headers().frameOptions().disable() //h2-console 화면을 사용하기 위해 해당 옵션들을 disable
				.and()
					.authorizeHttpRequests() //URL별 권한 관리를 설정하는 옵션의 시작점 //antMatchers옵션을 사용하려면 선언해야됨(나는 jsp인데..)
					.antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
					.antMatchers("/api/v1/**").hasRole(Role.USER.name()) //권한 관리 대상을 지정하는 옵션. URL, HTTP 메소드별로 관리가능 "/api/v1/**" 주소를 가진 API는 USER 권한을 가진 사람만 가능하도록 했음
					.anyRequest().authenticated() //설정된 값들 이외 나머지 URL들을 나타냄
				.and()
					.logout()
						.logoutSuccessUrl("/") //로그아웃 기능에 대한 여러 설정의 진입점
				.and()
					.oauth2Login() //OAuth 2 로그인 기능에 대한 여러 설정의 진입점
						.userInfoEndpoint() // OAuth 2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당
							.userService(customOAuth2UserService); //소셜로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록
	}

}