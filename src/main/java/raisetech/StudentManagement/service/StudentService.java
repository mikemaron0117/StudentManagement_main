package raisetech.StudentManagement.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

  @Transactional
  public void registerStudent(StudentDetail studentDetail){
    repository.registerStudent(studentDetail.getStudent());
    //　コース情報登録
    for (StudentsCourses studentsCourses : studentDetail.getStudentsCourses()){
      studentsCourses.setStudentsId(studentDetail.getStudent().getId());
      studentsCourses.setCourseStartAt(LocalDateTime.now());
      studentsCourses.setCourseEndAt(LocalDateTime.now().plusYears(1));
      repository.registerStudentsCourses(studentsCourses);
    }

  }

/*  @Autowired
  public void registerStudentCourseInfo(StudentsCourses studentsCourses){
    repository.registerStudentCourse(studentsCourses);
  }*/

}
