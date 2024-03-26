package edu.ufp.inf.lp2._03_course.version2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Discipline {
  public Discipline(String name, int ects, short courseSemester, short courseYear, List<Grade> grades) {
    this.name = name;
    this.ects = ects;
    this.courseSemester = courseSemester;
    this.courseYear = courseYear;
    this.grades = grades;
  }

  public Discipline(ArrayList<CourseClass> courseClass) {
    this.courseClass = courseClass;
  }

  public ArrayList<CourseClass> getCourseClass() {
    return courseClass;
  }

  public void setCourseClass(ArrayList<CourseClass> courseClass) {
    this.courseClass = courseClass;
  }

  private ArrayList<CourseClass> courseClass;

  public Discipline() {

  }

  @Override
  public String toString() {
    return "Discipline{" +
            "name='" + name + '\'' +
            ", ects=" + ects +
            ", courseSemester=" + courseSemester +
            ", courseYear=" + courseYear +
            ", grades=" + grades +
            '}';
  }

  private String name;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Discipline that = (Discipline) o;
    return ects == that.ects && courseSemester == that.courseSemester && courseYear == that.courseYear && Objects.equals(name, that.name) && Objects.equals(grades, that.grades);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, ects, courseSemester, courseYear, grades);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getEcts() {
    return ects;
  }

  public void setEcts(int ects) {
    this.ects = ects;
  }

  public short getCourseSemester() {
    return courseSemester;
  }

  public void setCourseSemester(short courseSemester) {
    this.courseSemester = courseSemester;
  }

  public short getCourseYear() {
    return courseYear;
  }

  public void setCourseYear(short courseYear) {
    this.courseYear = courseYear;
  }

  public List<Grade> getGrades() {
    return grades;
  }

  public void setGrades(List<Grade> grades) {
    this.grades = grades;
  }

  private int ects;

  private short courseSemester;

  private short courseYear;

      /**
    * 
    *
   */
  public List<Grade> grades;

  public void associateGrade(Grade g) {
  }

}