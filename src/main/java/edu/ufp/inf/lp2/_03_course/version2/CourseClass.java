package edu.ufp.inf.lp2._03_course.version2;

import edu.ufp.inf.lp2._01_intro.A;
import edu.ufp.inf.lp2._01_intro.Date;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CourseClass extends Discipline {

  private String name;

  private Integer newAttr;

  private ArrayList<Discipline> disciplines = new ArrayList<>();
  private ArrayList<Student> students = new ArrayList<>();

  @Override
  public String toString() {
    return "CourseClass{" +
            "name='" + name + '\'' +
            ", newAttr=" + newAttr +
            ", disciplines=" + disciplines +
            ", students=" + students +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CourseClass that = (CourseClass) o;
    return Objects.equals(name, that.name) && Objects.equals(newAttr, that.newAttr) && Objects.equals(disciplines, that.disciplines) && Objects.equals(students, that.students);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, newAttr, disciplines, students);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getNewAttr() {
    return newAttr;
  }

  public void setNewAttr(Integer newAttr) {
    this.newAttr = newAttr;
  }

  public List<Discipline> getDisciplines() {
    return disciplines;
  }

  public void setDisciplines(List<Discipline> disciplines) {
    this.disciplines = (ArrayList<Discipline>) disciplines;
  }

  public List<Student> getStudents() {
    return students;
  }

  public void setStudents(List<Student> students) {
    this.students = (ArrayList<Student>) students;
  }

  public ArrayList searchStudent(String name) {
    ArrayList<Student> resultArr = new ArrayList();
    for (Student s : students){
      //if () {

      }


    return resultArr;
  }

  public Student searchStudent(long number) {
  return null;
  }

  public Discipline searchDiscipline(String name) {
  return null;
  }

  public void registerStudent(Student s) {
    this.students.add(s);
  }

  public Student unregisterStudent(String name) {
  return null;
  }

  public CourseClass(String name, Integer newAttr, ArrayList<Discipline> disciplines, ArrayList<Student> students) {
      super();
      this.name = name;
    this.newAttr = newAttr;
    this.disciplines = disciplines;
    this.students = students;
  }

  public void associateDiscipline(Discipline d) {
    if(!this.disciplines.contains(d)){
      this.disciplines.add(d);
    }
  }

  public Discipline desassociateDiscipline(String dname) {
  return null;
  }

  public void launchGrade(String disciplineName, long studentNumber, float grade) {
    Student s = this.searchStudent(studentNumber);
    Discipline d = this.searchDiscipline(disciplineName);
    Date today = new Date(System.currentTimeMillis());
    Grade g = new Grade(s,d,today,grade);
    g.associateDiscipline(d);
    g.associateStudent(s);
    s.addGrade(g);
    d.associateGrade(g);
  }

  public void associateGrade2Discipline(String disciplineName, long studentNumber, float grade) {
  }

}