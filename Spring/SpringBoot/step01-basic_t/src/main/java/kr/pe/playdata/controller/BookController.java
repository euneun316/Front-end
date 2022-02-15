package kr.pe.playdata.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.pe.playdata.domain.Book;

@RestController
public class BookController{
	
	//http://ip:port/hello
	//http://localhost:80/hello
	//Get - 검색
	@GetMapping("hello")
	public String m1() {
		// ...
		System.out.println("get");
		return "get";
	}
		
	//Post - 수정
	@PostMapping("hello")
	public String m2() {
		// ...
		System.out.println("post");
		return "post";
	}
			
	//Put - 생성
	@PutMapping("hello")
	public String m3() {
		// ...
		System.out.println("put");
		return "put";
	}
		
	//Delete - 삭제
	@DeleteMapping("hello")
	public String m4() {
		// ...
		System.out.println("delete");
		return "delete";
	}	
	
	//10개의 Book 객체를 생성해서 List에 저장 후에 반환
	//db에서 select한 데이터라 가정
	@GetMapping("books")
	public List<Book> m5(){
		List<Book> all = new ArrayList<>();
		
		for(int i=1; i < 11; i++) {
			all.add(new Book(i, "sb"+i, "재석"+i));
		}
		
		return all; //JSON 배열 형식으로 문자열로 반환(JSON.parse()로 JSON 객체로 실 변환)
	}
	
	//client 가 요청시 parameter 값 받아서 해당 데이터 검색해서 응답해주는 실습
	//parameter : 주고 받는 데이터(메소드 또는 생성자의 ())
	
	//get - isbn값으로 해당 책 정보 select 해서 Book객체 반환
	/* isbn 어떻게 받을것인가? Book 단수 객체 반환시 어떤 포멧으로 응답? json 포멧의 문자열
	 * 
	 * http://ip:port/one?isbn=1
	 * 	? 기준으로 web query string이며 key로 value 구분
	 * server는 web query string 받아서 key로 value를 뽑아서 활용
	 * 
	 * RertAPI로 개발시 parameter로 선언된 변수에 web query string 값 자동 대입
	 * 장점 : 형변환 즉 String 타입으로 client로 부터 server 전송된다 할지라도 API 가 자체적으로
	 * Integer.parseInt() 로 String타입의 데이터를 int로 변환해서 parameter변수에 대입
	 */
	//http://ip:port/one?isbn=1&age=20
	@GetMapping("one")
	public Book m5(String isbn, int age) {
		//select 했다 가정
		System.out.println("m5() --- " + isbn + " " + age);
		return new Book(1, "sb1", "재석1");
	}

	
	//http://ip:port/one
	@PostMapping("one")
	public Book m6(String isbn, int age) {
		System.out.println("m6() --- " + isbn + " " + age);
		return new Book(1, "sb1", "재석1");
	}

	//http://ip:port/one?isbn=1&title=20&author=재석
	/* web query string의 key들과 dto 클래스의 멤버변수명과 매핑된 setXxx()명이
	 * rule에 맞게 개발되어 있다면
	 * web query string값으로 DTO 객체 자동 생성해서 parameter값으로 적용
	 */
	@PostMapping("one2")
	public String m7(Book book) {
		System.out.println("m7() " + book.getIsbn() + " " + book.getTitle());
		//생성된 Book 객체 insert 실행
		return "Book 객체 생성";
	}
	
}





