package kr.co.lgit.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kr.co.lgit.boot.domain.posts.Posts;
/*
 보통 MyBatis에서 Dao라고 불리는 DB Layer 접근자다. JPA에선 Repository라고 부르며 인터페이스로 생성한다.
 단순히 인터페이스를 생성 후, JpaRepository<Entity클래스, PK 타입>를 상속하면 기본적인 CRUD 메소드가 자동으로 생성된다.
 @Repository를 추가할 필요도 없다. 주의할 점은 Entity클래스와 기본 Entity Repository는 함께 위치해야한다.(도메인 패지키에서 함께 관리)
 */
public interface PostsRepository extends JpaRepository<Posts, Long>{
	@Query("SELECT p FROM Posts p ORDER BY p.id DESC") 
	List<Posts> findAllDesc(); //147p에 QueryDSL 추천글 읽기
	
	/*
	Posts findById(String Id);
	== select * from posts where id = :id
	*/
}
 