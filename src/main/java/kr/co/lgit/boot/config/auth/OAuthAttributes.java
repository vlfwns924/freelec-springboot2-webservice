package kr.co.lgit.boot.config.auth;

import java.util.Map;

import kr.co.lgit.boot.domain.user.Role;
import kr.co.lgit.boot.domain.user.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OAuthAttributes {
	private Map<String, Object> attributes;
	private String nameAttributeKey;
	private String name;
	private String eamil;
	private String picture;
	
	@Builder
	public OAuthAttributes(Map<String, Object> attributes,
						String nameAttributeKey, String name, String email, String picture) {
		this.attributes = attributes;
		this.name = name;
		this.eamil = email;
		this.picture = picture;
	}
	
	//OAuth2User에서 반환하는 사용자 정보는 Map이기 때문에값 하나하나를 변환해야만 한다.
	public static OAuthAttributes ofGoogle(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
		return ofGoogle(userNameAttributeName, attributes);
	}
	
	private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
		return OAuthAttributes.builder()
				.name((String) attributes.get("name"))
				.email((String) attributes.get("email"))
				.picture((String) attributes.get("picture"))
				.attributes(attributes)
				.nameAttributeKey(userNameAttributeName)
				.build();
	}
	
	// User 엔터티 생성, OAuthAttributes에서 엔티티를 생성하는 시점은 처음 가입할 때.
	//가입할 때의 기본 권한을 GUEST로 주기위해서 role 빌더값에 Role.GUEST 사용
	public User toEntity() {
		return User.builder()
				.name(name)
				.email(eamil)
				.picture(picture)
				.role(Role.GUEST)
				.build();
	}
}
