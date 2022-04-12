package kr.co.lgit.boot.config.auth.dto;

import kr.co.lgit.boot.domain.user.User;
import lombok.Getter;

@Getter
public class SessionUser {
	private String name;
	private String email;
	private String picture;
	
	public SessionUser(User user) {
		this.name = user.getName();
		this.email = user.getEmail();
		this.picture = user.getPicture();
	}
	
	
}
