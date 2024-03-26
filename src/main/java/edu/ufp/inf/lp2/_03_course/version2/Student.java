package edu.ufp.inf.lp2._03_course.version2;

import edu.ufp.inf.lp2._01_intro.Date;
import edu.ufp.inf.lp2._01_intro.Person;

import java.util.List;
import java.util.Objects;


public class Student extends Person {

  private long number;

  private Date registration;

  private String email;

  private String password;

  public CourseClass courseClass;
  /**
   *
   *
   */
  public List<Grade> grades;

  public Student() {
  }

  public Student(String idNumber, String name, String address, Date birth, long number, Date registration, String email, String password, CourseClass courseClass) {
    super(idNumber, name, address, birth);
    this.number = number;
    this.registration = registration;
    this.email = email;
    this.password = password;
    this.courseClass = courseClass;
  }

  @Override
  public String toString() {
    return "Student{" +
            "number=" + number +
            ", registration=" + registration +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", courseClass=" + courseClass +
            ", grades=" + grades +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return number == student.number && Objects.equals(registration, student.registration) && Objects.equals(email, student.email) && Objects.equals(password, student.password) && Objects.equals(courseClass, student.courseClass) && Objects.equals(grades, student.grades);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, registration, email, password, courseClass, grades);
  }

  public long getNumber() {
    return number;
  }

  public void setNumber(long number) {
    this.number = number;
  }

  public Date getRegistration() {
    return registration;
  }

  public void setRegistration(Date registration) {
    this.registration = registration;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public CourseClass getCourseClass() {
    return courseClass;
  }

  public void setCourseClass(CourseClass courseClass) {
    this.courseClass = courseClass;
  }

  public List<Grade> getGrades() {
    return grades;
  }

  public void setGrades(List<Grade> grades) {
    this.grades = grades;
  }

  public void addGrade(Grade g) {
    this.grades.add(g);
  }

  /*public Grade removeGrade(float grade, String nd, Date d) {

    for (Grade g: grades) {
      if (g.getGrade() == grade && getDate.compareto(d) == 0 && g.getDiscipline().compareto() == 0) {

        this.grades.remove(g);
        return g;
      }
    }

    return null;
  }*/

  public Grade changeGrade(float ng, float g, String nd, Date d) {
  return null;
  }

  public Grade searchGrade(float g, String nd, Date d) {
  return null;
  }

  public float averageGrades() {
  return 0.0F;
  }

  public Grade maxGrade() {
  return null;
  }

  public Grade minGrade() {
  return null;
  }

  public void registerCourseClass(CourseClass cc) {
  }

  public CourseClass unregisterFromCourseClass() {
  return null;
  }

}