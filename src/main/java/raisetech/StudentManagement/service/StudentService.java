package raisetech.StudentManagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.repository.StudentRepository;

@Service //スプリングが認識してくれるようになる
public class StudentService {

  private StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> searchStudentList() {
    repository.search();
    return repository.search();

    /*//検索処理
    List<Student> allStudentList = repository.search();
    //絞り込みをする。年齢が３０代の人のみを抽出する。
    List<Student> thirtiesList = allStudentList.stream()
        .filter(v -> v.getAge() >=30 && v.getAge() < 40)
        .toList();
    //抽出したリストをcontrollerに返す。
    return thirtiesList;*/

  }

  public List<StudentsCourses> searchStudentsCourseList() {

    repository.searchStudentsCourse();
    return repository.searchStudentsCourse();

    /*List<StudentsCourses> allStudentCourses = repository.searchStudentsCourse();

    //絞り込み検索で「Javaコース」のコース情報のみを抽出する。
    List<StudentsCourses> javaCorseList = allStudentCourses.stream()
        .filter(v -> v.getCourseName().contains("Java"))
        .toList();
    //抽出したリストをcontrollerに返す。
    return javaCorseList;*/

  }

  @Autowired
  public void registerStudentInfo(Student student){
    repository.registerStudent(student);
  }

  @Autowired
  public void registerStudentCourseInfo(StudentsCourses studentsCourses){
    repository.registerStudentCourse(studentsCourses);
  }

}
