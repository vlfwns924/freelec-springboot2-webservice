package kr.co.lgit.boot;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import kr.co.lgit.boot.controller.HelloController;

@RunWith(SpringRunner.class) //테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행.
//즉, 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 한다.
@WebMvcTest(controllers = HelloController.class)
/*
 @WebMvcTest를 사용했더니 @Test import 시 import org.junit.Test; 이 안생겨서 @SpringBootTest로 대체했다가 다시했더니 돼서 돌아옴.
 Web(Spring MVC)에 집중할 수 있는 어노테이션으로 선언할 경우 @Controller, @ControolerAdvice 등은 사용할 수있지만
 @Server, @Component, @Repository 등은 사용할 수 없다. 여기서는 컨트롤러만 사용하기 때문에 선언했다.
 */

public class HelloControllerTest {
	
	@Autowired // 스프링이 관리하는 빈(Bean)을 주입 받는다.
	private MockMvc mvc; //웹 API를 테스트할 때 사용, 스프링 MVC 테스트의 시작점.
						//이 클래스를 통해 HTTP GET, POST 등에 대한 API를 테스트할 수 있다.
	
	@Test
	public void hello가_리턴된다() throws Exception {
		String hello = "hello";
		
		mvc.perform(get("/hello")) //Mock를 통해 /hello 주소로 HTTP GET 요청을하며 체이닝이 지원되어 아래와 같이 여러 검증 기능을 이어서 선언 가능
			.andExpect(status().isOk()) //mvc.perform의 결과를 검증. HTTP Header의 Status를 검증. 흔히 알고있는 200, 404, 500 등의 상태검증. 여기선 OK 즉, 200인지 아닌지 검증
			.andExpect(content().string(hello)); //mvc.perform의 결과를 검증한다. Controller에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증한다.
		
	}
	
	@Test
	public void helloDto가_리턴된다() throws Exception {
		String name = "hello";
		int amount = 1000;
		
		mvc.perform(get("/hello/dto")
					.param("name", name) //param : API 테스트할 때 사용될 요청 파라미터를 설정. 단, 값은 String만 허용(숫자/날짜는 문자열로 변경해야만 가능)
					.param("amount", String.valueOf(amount)))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.name", is(name))) 
					.andExpect(jsonPath("$.amount", is(amount)));
					/*
					 jsonPath : JSON 응답값을 필드별로 검증할 수 있는 메소드.
					 $를 기준으로 필드명을 명시
					 여기서는 name과 amount를 검증하니 $.name, $.amoun로 검증
					 */
					
	}

}


