package kr.pe.playdata.controller.swaggestudy.api.v1;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.pe.playdata.model.domain.Employee;
import springfox.documentation.annotations.ApiIgnore;


/* class명 대소문자가 doc에 적용되는 명명규칙
 * 
 * 1. 중간 대문자는 '-소문자'로 변경
 * 2. 예시
 * 	 	클래스명 : SwaggerDocTest1 
 * 		doc에 표현되 이름 -> swagger-doc-test-1
 */
@RestController
@RequestMapping("/v1/api") //모든 메소드에 적용되는 공통 url
public class SwaggerDocTest1 {  
 
	//@ApiIgnore //- 존재 여부 확인 해 보기/없을 경우 Swagger Doc에 표현 - web에서 사라짐
	//각각의 리소스에 제목과 설명 표기
    @ApiOperation(value = "사원 검색", notes = "API 설명 부분 : 사원 한명 검색")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 404, message = "404 에러 발생, Not Found !"),
            @ApiResponse(code = 500, message = "500 에러 발생, Internal Server Error !")
    })
    
    /* @RequestParam 
     * 실제 서비스 시에는 생략 가능 단, swagger doc 에는 가급적 설정 권장
     * - 없을 경우 : try it out 클릭시 @ApiParam의 example 속성이 의미가 없음
     * - 있을 경우 : @ApiParam example 속성 값이 test시에 적용
     */
    @GetMapping("/employee")
    public Map<String, String> selectOneEmployee(@ApiParam(value = "사원 번호", required = true, example = "1") 
    											 @RequestParam String no) {
        
    	//no 값으로 db에 select 했다 가정
    	Map<String, String> result = new HashMap<>(); 
        result.put("사번", "1");
        result.put("사원명", "유재석");
        result.put("사원정보", "유재석 사원입니다.");
        return result; //JSON 포멧으로 응답
    }
    
    
    /* @RequestBody
     * - 요청시에 json 포멧으로 parameter 전송될 경우 처리하는 애노테이션
     * - json 포멧의 key와 DTO(VO)의 멤버 변수가 일치가 되는 조건에 한해서 정상 실행
     * - swagger doc 개발시에는 생략 금지
     * - DTO 클래스의 각 변수에 선언한 @ApiModelProperty(example=테스트데이터)와 연관
     */
    @ApiOperation(value = "사원 정보 저장", notes = "API 설명 부분 : 사원 한명 저장 또는 수정")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "500 에러 발생, 가령 Internal Server Error !"),
            @ApiResponse(code = 404, message = "404 에러 발생, Not Found !")
    })
    @PostMapping("/employee")
    public String addOneEmployee(@RequestBody Employee emp, @ApiIgnore HttpSession session) {
    	return "한명의 사원 저장 성공";
    }
    
}