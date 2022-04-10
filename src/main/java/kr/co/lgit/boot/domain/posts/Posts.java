package kr.co.lgit.boot.domain.posts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import kr.co.lgit.boot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter //롬복의 어노테이션. 클래스 내 모든 필드의 Getter 메소드를 자동생성
@NoArgsConstructor //롬복의 어노테이션. 기본 생성자 자동 추가 //여기선 public Posts() {} 와 같은 효과
@Entity(name="posts") //@Table이나 @Column에 name 명시하는 버릇 들이자 "개발자를 위해"
/*
 JPA의 어노테이션 - 롬복보다 더 주요 어노테이션이기 때문에 클래스에 가깝게 두었다. -> 나중에 코틀린 등의 새 언어 전환 시 롬복 @ 쉽게삭제
 @Entity는 테이블과 링크될 클래스임을 나타낸다. 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭한다.
 ex) SalesManager.java -> sales_manager table    //그리고 참고사항 91p (요약:Entity의 PK는 Long 타입의 Auto_increment를 추천)
 그리고 Entity에는 절대 Setter 메소드를 만들지 않는다. 대신, 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드 추가. 92p
*/
public class Posts extends BaseTimeEntity{
	
	@Id //해당 테이블의 PK 필드를 나타낸다.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//PK의 생성 규칙을 나타낸다. 스프링부트 2.0에서는 GenerationType.IDENTITY 옵션을 추가해야 auto_increment가 된다. 
	private Long id;
	
	@Column(length = 500, nullable = false) //테이블의 칼럼을 나타내며, 굳이 선언하지 않아도 해당 클래스의 필드는 모두 칼럼이 된다.
	//사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용한다. ex) 문자열의경우 VARCHAR(255)가 기본값인데 사이즈를 500으로 늘리고싶다.
	private String title;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;
	
	private String author;
	
	@Builder //해당 클래스의 빌더 패턴 클래스를 생성. 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
	public Posts(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}

	public void update(String title, String content) {
		this.title = title;
		this.content = content;
	}

}



