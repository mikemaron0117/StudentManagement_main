package raisetech.StudentManagement;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper //mybatisが操作するもの
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Student> search();

  /*@Insert("INSERT student values(#{name}, #{age})")
  void registerStudent(String name, int age);

  @Update("UPDATE student SET age = #{age} WHERE name = #{name}")
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
