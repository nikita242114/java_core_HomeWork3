package ru;

import java.time.*;

public class Manager extends Worker{

    public Manager(String surname, String name, String middleName, String position, String phoneNumber, int salary, LocalDate birthDate) {
        super(surname, name, middleName, position, phoneNumber, salary, birthDate);
    }

    public static void addSalary(Worker[] workers, int age, int addAmount) {
        for (Worker worker : workers) {
            if (worker.getAge() >= age && !worker.getPosition().equals("manager")) {
                worker.setSalary(worker.getSalary() + addAmount);
            }
        }
        System.out.println("Зарплата повышена успешно!!!");
    }

    public void assign(String taskTarget) {
        Task task = new Task(taskTarget, this);
        System.out.println("Менеджер " + this.getSurname() + " " + this.getName() + " " + this.getMiddleName()
                + " обязался " + taskTarget);
        System.out.println();
    }
    public void assign(String taskTarget, Worker worker) {
//        System.out.println();
        System.out.println("Постановка задачи от " + this.getSurname() + " (" + this.getPosition() + ") " + " сотруднику " + worker.getSurname() +  " (" + worker.getPosition() + "):");
        if (worker.getPosition().equals("manager")) {
            if (worker.getSurname().equals(this.getSurname())) {
                Task task = new Task(taskTarget, this);
                System.out.println(this.getSurname() + " " + this.getName() + " " + this.getMiddleName()
                        + " обязался " + taskTarget);
                System.out.println();
            } else  {
//                System.out.println();
                System.out.println("!!!!===========================================================!!!");
                System.out.println("!!!! Попытка превышения своих полномочий! \n!!!! Менеджер не может ставить задачу равному себе.");
                System.out.println("!!!!===========================================================!!!");
                System.out.println();
            }
        } else {
            Task task = new Task(taskTarget, worker);
            taskTarget += " (задача от " + this.getSurname() + ")";
            System.out.println("Менеджер " + this.getSurname() + " " + this.getName() + " " + this.getMiddleName()
                    + " поручил задачу " + worker.getSurname() + " " + worker.getName() + " " + worker.getMiddleName()
                    + " " + taskTarget);
        }

        System.out.println();
    }
}