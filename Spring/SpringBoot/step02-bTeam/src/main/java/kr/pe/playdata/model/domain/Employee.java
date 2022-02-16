package kr.pe.playdata.model.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

/*
Swagger가 적용될 Model에도 DTO에 대한 정보를 적용
@ApiModelProperty
	- Example Value 즉 test 데이터로 구성
	- JSON 포멧으로 구성
	{
	  "empno": 11,
	  "ename": "유재석",
	  "info": "요식업 부서에서 기량 발휘"
	}
	
	- controller 의 Employee를 parameter로 선언한 메소드에는 @RequestBody 설정
	
 */

public class Employee {
	
	@ApiModelProperty(example="11")
	private String empno;
	
	@ApiModelProperty(example="유재석")
	private String ename;
		
	@ApiModelProperty(example="엔터테이먼트 부서에서 기량 발휘")
	private String info;
}
