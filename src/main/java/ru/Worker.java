package ru;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//Создать класс ”Сотрудник” с полями: ФИО, должность, телефон, зарплата, возраст;
public class Worker implements Comparable<Worker> {
    private String surname;
    private String name;
    private String middleName;
    private String position;
    private String phoneNumber;
    private int salary;
    private LocalDate birthDate;

    public Worker(String surname, String name, String middleName, String position,
                  String phoneNumber, int salary, LocalDate birthDate) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        setBirthDate(birthDate);
    }

    public Worker(String surname, String name, String middleName) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return this.birthDate == null ? -1 : (int) this.birthDate.until(LocalDate.now(), ChronoUnit.YEARS);
    }

    public void setBirthDate(LocalDate birthDate) {
        if (birthDate == null || birthDate.isAfter(LocalDate.now().minusYears(14))) {
            System.out.println("Дата рождения работника задана некорректно!");
        } else {
            this.birthDate = birthDate;
        }
    }


    public void assign(String taskTarget, Worker worker) {
        System.out.println("Постановка задачи от " + this.getSurname() + " (" + this.getPosition() + ") "
                + " сотруднику " + worker.getSurname() + " (" + worker.getPosition() + "):");
        if (worker.getSurname().equals(this.getSurname())) {
            Task task = new Task(taskTarget, worker);
            System.out.println(worker.getSurname() + " " + worker.getName() + " " + worker.getMiddleName()
                    + " обязался " + taskTarget);
        } else {
//            System.out.println();
            System.out.println("!!!!===========================================================!!!");
            System.out.println("!!!! Попытка превышения полномочий у " + this.getSurname());
            System.out.println("!!!! Сотрудник может определить задачу только для себя.");
            System.out.println("!!!!===========================================================!!!");
        }
        System.out.println();
    }
    public void assign(String taskTarget) {
        Task task = new Task(taskTarget, this);
        System.out.println(this.getSurname() + " " + this.getName() + " " + this.getMiddleName()
                + " взялся за задачу: " + taskTarget);
        System.out.println();
    }

    @Override
    public String toString() {
        return "\nWorker{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", position='" + position + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", salary=" + salary +
                ", age=" + this.getAge() +
                "}";
    }

    @Override
    public int compareTo(Worker o) {
        return this.getAge() - o.getAge();
    }
}