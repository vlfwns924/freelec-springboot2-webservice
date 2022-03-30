package kr.co.lgit.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//이 프로젝트의 메인클래스
@SpringBootApplication 
//이 어노테이션으로 인해 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정한다.
//특히나 이 어노테이션이 있는 위치부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트의 최상단에 위치해야만 한다.
public class SpringbootWebservicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebservicApplication.class, args);
		/*
		 main 메소드에서 실행하는 SpringApplication.run로 인해 내장 WAS(Web Application Server, 웹 애플리케이션 서버)를 실행.
		 내장 WAS로 인해 항상 톰캣을 설치할 필요가 없게 되고, 스프링 부트로 만들어진 Jar 파일(실행가능한 Java 패키징 파일)로 실행하면 된다.
		 */
	}

}
