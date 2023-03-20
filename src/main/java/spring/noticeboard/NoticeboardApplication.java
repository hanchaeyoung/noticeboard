package spring.noticeboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NoticeboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoticeboardApplication.class, args);
		System.out.println("실행 완료");
	}

}
