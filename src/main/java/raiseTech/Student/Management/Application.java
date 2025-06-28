package raiseTech.Student.Management;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	private String name = "Yamada Hanako";
	private String age = "30";

	@GetMapping("/StudentInfo")
	public String getStidentInfo() {
		return name + " " + age + "歳";
	}

	@PostMapping("/StudentInfo")
	public void setName(String name, String age) {
		this.name = name;
		this.age = age;
	}


	private Map<String, String> studentData = new HashMap<>();

	{
		studentData.put("hanako", "25");
		studentData.put("taro", "30");
	}


	@GetMapping("/studentInfo")
	public String getstudentInfo() {
		String result = studentData.entrySet().stream()
				.map(entry -> entry.getKey() + "は" + entry.getValue() + "歳です。")
				.collect(Collectors.joining("\n"));

		return result;
	}

	@PostMapping("/studentInfo")
public String addStudent(@RequestBody Student request){
		studentData.put(request.getStudentName(),request.getStudentAge());
		return "名前："+request.getStudentName()+"年齢："+request.getStudentAge()+"を追加しました。";
	}

	@PostMapping("/changeStudentName")
public  String changeStudentname(@RequestBody ChangeStudentName request) {
		String oldStudentName = request.getOldStudentName();
		String newStudentName = request.getNewStudentName();

		if (!studentData.containsKey(oldStudentName)) {
			return "変更対象の名前が存在しませんでした。";
		} else {
			String studentAge = studentData.get(oldStudentName);
			studentData.remove(oldStudentName);
			studentData.put(newStudentName, studentAge);

			return "名前を" + oldStudentName + "から" + newStudentName + "に変更しました。";
		}
	}
}
