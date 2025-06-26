package raiseTech.Student.Management;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
@GetMapping("/Hello")
	public  String Hello(){
		return  "Hello,World! Today is WednesDay.";
}

private String name ="Yamada Hanako";
	private  String age = "30";

	@GetMapping("/StudentInfo")
	public String getStidentInfo(){
		return name+" "+ age +"歳";
	}
	@PostMapping("/StudentInfo")
	public  void  setName(String name,String age){
		this.name = name;
		this.age = age;
	}




}
