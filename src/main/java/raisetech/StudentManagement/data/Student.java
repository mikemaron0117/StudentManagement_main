package raisetech.StudentManagement.data;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

  private String id;
  private String name;
  private String kanaName;
  private String nickname;
  private String email;
  private String area;
  private int age;
  private String sex;
  private String remark; //備考欄
  private boolean isDeleted; //削除フラグ
  // 論理削除（対義語：物理削除）→表では削除されているが、データ上は残っている状態（分析用に残しておくため）


  /*private String placeOfBirth;*/

/*
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }*/

/*  public String getPlaceOfBirth() {
    return placeOfBirth;
  }

  public void setPlaceOfBirth(String placeOfBirth) {
    this.placeOfBirth = placeOfBirth;
  }*/

}
