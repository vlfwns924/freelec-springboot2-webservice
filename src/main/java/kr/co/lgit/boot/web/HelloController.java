package kr.co.lgit.boot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.lgit.boot.web.dto.HelloResponseDto;

@RestController //@RestController는 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 준다.
//예전에 @ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해준다고 생각하면 된다.
public class HelloController {

	@GetMapping("/hello") //HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어 준다.
	public String Hello() {
		return "hello";
	}
	
	@GetMapping("/hello/dto")
	public HelloResponseDto helloDto(@RequestParam("name") String name,  
									@RequestParam("amount") int amount){
		return new HelloResponseDto(name, amount);
		//@RequestParam : 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션 
	}
}
