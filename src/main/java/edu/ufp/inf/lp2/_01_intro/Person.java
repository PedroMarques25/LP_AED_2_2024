package edu.ufp.inf.lp2._01_intro;


import java.util.Objects;

public class Person {

  private String idNumber;

  public String getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Date getBirth() {
    return birth;
  }

  public void setBirth(Date birth) {
    this.birth = birth;
  }

  private String name;

  private String address;

  private Date birth;

  public int age() {
  return 0;
  }

  public Person() {
  }

  public Person(String idNumber, String name, String address, Date birth) {
    this.idNumber = idNumber;
    this.name = name;
    this.address = address;
    this.birth = birth;
  }

  public boolean olderThan(Person p) {
  return false;
  }

  @Override
  public String toString() {
    return "Person{" +
            "idNumber='" + idNumber + '\'' +
            ", name='" + name + '\'' +
            ", address='" + address + '\'' +
            ", birth=" + birth +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return Objects.equals(idNumber, person.idNumber) && Objects.equals(name, person.name) && Objects.equals(address, person.address) && Objects.equals(birth, person.birth);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idNumber, name, address, birth);
  }

  public static void main_person() {


  }
}