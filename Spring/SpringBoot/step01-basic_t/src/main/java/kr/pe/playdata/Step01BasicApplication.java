/* spring boot 프로젝트 생성시 자동 생성되는 핵심 실행 클래스
 * 1. 서버 실행
 * 2. 구현된 application을 서버 내에 배포
 * 3. 1+2로 인해 client는 브라우저로 요청/응답 서비스가 가능
 * 
 * 4. 주요 사항
 * 	단, 해당 package 내부의 sub package만 자동인식
 *  만일 package가 다를 경우 스캔 에노테이션으로 스캔 지시 
 *  	@ComponentScan 설정 추가
 * 
 */
package kr.pe.playdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Step01BasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(Step01BasicApplication.class, args);
	}

}
