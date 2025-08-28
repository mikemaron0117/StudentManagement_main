package raisetech.StudentManagement.data.taimenkadai01;

public class Course {
  private String name;
  private String instructor;
  private int capacity;

  public Course() {}
  public Course(String name, String instructor, int capacity) {
    this.name = name;
    this.instructor = instructor;
    this.capacity = capacity;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getInstructor() {
    return instructor;
  }
  public void setInstructor(String instructor) {
    this.instructor = instructor;
  }

  public int getCapacity() {
    return capacity;
  }
  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  @Override
  public String toString() {
    return "Course(" +
        "name=" + name +
        ", instructor=" + instructor +
        ", capacity=" + capacity +
        ")";
    }

  @Override
  public boolean equals(Object o) {
    // 省略: equalsの実装
    return this.equals(o);
  }
  /*
  @Override
  public int hashCode() {
    // hashCode()はすでに実装されているので、このメソッドは不要
    return 0;
  }
   */

}
