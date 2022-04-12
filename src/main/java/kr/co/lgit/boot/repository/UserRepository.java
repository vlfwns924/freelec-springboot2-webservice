package kr.co.lgit.boot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.lgit.boot.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	//로그인으로 반환되는 값 중 eamil을 통해 이미 생성된 사용자인지 처음 가입하는 사용자인지 판단하기 위한 메소드
	Optional<User> findByEmail(String eamil); 
}
