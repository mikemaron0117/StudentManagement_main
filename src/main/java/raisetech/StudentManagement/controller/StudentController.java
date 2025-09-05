package raisetech.StudentManagement.controller;

import java.util.Arrays;
import org.springframework.ui.Model;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import raisetech.StudentManagement.controller.converter.StudentConverter;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.service.StudentService;

@Controller
public class StudentController {

  private StudentService service;
  private StudentConverter converter;

  @Autowired
  public StudentController(StudentService service, StudentConverter converter) {
    //リクエストの加工処理、入力チェックとか
    this.service = service;
    this.converter = converter;
  }

  //メニュー
  @GetMapping("/menu")
  public String menu(){
    return "menu";
  }

/*  //受講生一覧に戻る
  @GetMapping("/studentList")
  public String studentList(){
    return "studentList";
  }*/

  @GetMapping("/studentList")
  public String getStudentList(Model model){
    List<Student> students = service.searchStudentList();
    List<StudentsCourses> studentsCourses = service.searchStudentsCourseList();

    model.addAttribute("studentList", converter.convertStudentDetails(students, studentsCourses));
    return "studentList";
      }


  @GetMapping("/studentsCourseList")
  public List<StudentsCourses> getStudentsCourseList() {
    return service.searchStudentsCourseList();
  }

  @GetMapping("/newStudent")
  public String newStudent(Model model){
    StudentDetail studentDetail = new StudentDetail();
    studentDetail.setStudentsCourses(Arrays.asList(new StudentsCourses()));
    model.addAttribute("studentDetail", studentDetail);
    return "registerStudent";
  }

  @PostMapping("/registerStudent")
  public String registerStudent(@ModelAttribute StudentDetail studentDetail,BindingResult result){
    if(result.hasErrors()){
      return "registerStudent";
    }
    //System.out.println(studentDetail.getStudent().getName() + "さんが新規受講生として登録されました。");
    //　①新規受講生情報を登録する処理を実装する。
    service.registerStudent(studentDetail);

    //　②コース情報も一緒に登録できるように実装する。コースは単体で良い。

    //リダイレクト
    return "redirect:/studentList";

  }

  @GetMapping("/updateStudent/{id}")
  public String showUpdateForm(@PathVariable("id") int id, Model model){
    StudentDetail studentDetail = service.searchByID(id);
    model.addAttribute("studentDetail", studentDetail);
    return "updateStudent";
  }

  @PostMapping("/updateStudent")
  public String updateStudent(@ModelAttribute StudentDetail studentDetail,BindingResult result){
    if(result.hasErrors()){
      return "updateStudent";
    }
    service.updateStudent(studentDetail);

    //リダイレクト
    return "redirect:/studentList";

  }



}
