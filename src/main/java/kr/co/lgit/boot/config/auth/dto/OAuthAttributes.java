package kr.co.lgit.boot.config.auth.dto;

import java.util.Map;

import kr.co.lgit.boot.domain.user.Role;
import kr.co.lgit.boot.domain.user.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OAuthAttributes {
	private Map<String, Object> attributes;
	private String nameAttributekey;
	private String name;
	private String email;
	private String picture;
	
	@Builder
	public OAuthAttributes(Map<String, Object> attributes, String nameAttributekey, String name,
							String email, String picture) {
		this.attributes = attributes;
		this.nameAttributekey = nameAttributekey;
		this.name = name;
		this.email = email;
		this.picture = picture;
	}
	
	public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
		return OAuthAttributes.builder()
				.name((String) attributes.get("name"))
				.email((String) attributes.get("email"))
				.picture((String) attributes.get("picture"))
				.attributes(attributes)
				.nameAttributekey(userNameAttributeName)
				.build();
	}
	
	public User toEntity() {
		return User.builder()
				.name(name)
				.email(email)
				.picture(picture)
				.role(Role.GUEST)
				.build();
	}
}
