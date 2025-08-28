package raisetech.StudentManagement.data.taimenkadai01;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Cource_kadai {
  private String name;
  private String instructor;
  private int capacity;


/*
  @Override
  public String toString() {
    return "Course(" +
        "name=" + name +
        ", instructor=" + instructor +
        ", capacity=" + capacity +
        ")";
  }
*/

/*  @Override
  public boolean equals(Object o) {
    // 省略: equalsの実装
    return this.equals(o);
  }*/
  /*
  @Override
  public int hashCode() {
    // hashCode()はすでに実装されているので、このメソッドは不要
    return 0;
  }
   */


}
