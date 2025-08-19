package raisetech.StudentManagement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	@Autowired
	private StudentRepository repository;

/*	private String name = "Enami Kouji";
	private int age = 37;*/

	public static void main(String[] args) {
		//localhost:8080
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/student")
	public List<Student> getStudentList(){
		return repository.search();

/*		Student student = new Student();
		student.setName("EnamiKouji");
		String name = student.getName();*/
	}

	@GetMapping("/studentsCoeses")
	public List<StudentsCourses> getStudentsCoursesList() {
		return repository.searchCourse();
	}

/*	@GetMapping("/studentInfo")
*//*	public List<Student> displayStudent(){
		List<Student> studentList = repository.displayStudent();
		return studentList;
	}*//*
	public String displayStudent() {
		List<Student> studentList = repository.displayStudent();

		StringBuilder sb = new StringBuilder();
		for (Student student : studentList) {
			sb.append(student.getName())
					.append(" ")
					.append(student.getAge())
					.append("歳")
					.append(" ")
					.append(student.getPlaceOfBirth())
					.append("出身\n"); // 空行で区切る「\n」

		}

		return sb.toString();
	}*/

/*	@GetMapping("/studentInfo")
	public String getName() {
		return name;
	}

	@GetMapping("/studentInfo")
	public String getAge() {
		return age;
	}*/

/*	@PostMapping("/student")
	public void registerStudent(String name, int age) {
		repository.registerStudent(name, age);
	}

 @PatchMapping("/student")
	public void updateStudentName(String name, int age){
		repository.updateStudent(name, age);
	}

	@DeleteMapping("/student")
	public void deleteStudent(String name){
		repository.deleteStudent(name);
	}

	@PatchMapping("/student2")
	public void updateStudent2(@RequestParam String name, @RequestParam int age, @RequestParam String placeOfBirth){
		repository.updateStudent2(name, age, placeOfBirth);
	}*/
	//★補足
	//講座内では@RequestPramや@Paramはついていないが、順番が合ってるのマッピングできて
	//いるだけ。そのため、念の為に模範解答には追記している。

}
