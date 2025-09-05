package raisetech.StudentManagement.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;

/**
 * 受講生を扱うリポジトリ
 *
 * 全件検索や単一条件での検索、コース情報の検索が行えるクラスです。
 */
@Mapper //mybatisが操作するもの
public interface StudentRepository {

  /**
   *
   * @return 全件検索した受講生情報の一覧
   */
  @Select("SELECT * FROM students")
  List<Student> search();

  @Select("SELECT * FROM students_courses")
  List<StudentsCourses> searchStudentsCourse();

  @Insert("INSERT INTO students(name, kana_Name, nickname, email, area, age, sex, remark, isDeleted)"
   + "values(#{name}, #{kanaName}, #{nickname}, #{email}, #{area}, #{age}, #{sex}, #{remark}, false)")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudent(Student student);

  @Insert("INSERT INTO students_courses(course_name, course_start_at, course_end_at, students_id)"
      +"values(#{courseName}, #{courseStartAt}, #{courseEndAt}, #{studentsId})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudentsCourses(StudentsCourses studentsCourses);

/*  @Insert("INSERT students_courses values(#{id}, #{courseName}, #{courseStartAt},#{courseEndAt}, #{studentsId}")
  void registerStudentCourse(StudentsCourses studentsCourses);*/

  /*@Update("UPDATE student SET age = #{age} WHERE name = #{name}")
  void updateStudent(String name, int age);

  @Delete("DELETE FROM student WHERE name = #{name}")
  void deleteStudent(String name);

  @Select("SELECT * FROM student")
  List<Student> displayStudent();

  @Update("UPDATE student SET age=#{age}, place_of_birth=#{placeOfBirth} WHERE name = #{name}")
  void updateStudent2(
      @Param("name") String name,
      @Param("age") int age,
      @Param("placeOfBirth") String placeOfBirth
  );*/

}
