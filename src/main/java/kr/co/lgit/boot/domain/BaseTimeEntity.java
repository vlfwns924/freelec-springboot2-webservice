package kr.co.lgit.boot.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@Getter
@MappedSuperclass //JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들(createDate,modifiedDate)도 칼럼으로 인식하도록 한다.
@EntityListeners(AuditingEntityListener.class) //BaseTimeEntity 클래스에 Auditing 기능을 포함시킨다.
public class BaseTimeEntity { 
	//이 클래스는 모든 Entity의 상위 클래스가 되어 Entity들의 createDate(작성일), modifiedDate(수정일)을 자동으로 관리하는 역할
	
	@CreatedDate //Entity가 생성되어 저장될 때 시간이 자동 저장
	@Column(name="create_date")
	private LocalDateTime createDate;
	
	@LastModifiedDate //조회한 Entity의 값을 변경할 때 시간이 자동 저장
	@Column(name="modified_date")
	private LocalDateTime modifiedDate;

}
//그리고 Posts 클래스가 BaseTimeEntity를 상속받도록 변경한다.
//그 후 JPA Auditing 어노테이션들을 모두 활성화할 수 있도록 Application 클래스에 활성화 어노테이션(@EnableJpaAuditing)을 추가한다.
