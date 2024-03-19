package ru;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Worker[] workers = {
                new Worker("Ivanov", "Ivan", "Ivanovich",
                        "backend-developer", "+7-999-888-77-66", 100,
                        LocalDate.of(2000, 8, 17)),
                new Worker("Shorohov", "Ivan", "Pavlovich", "worker",
                        "+7-999-111-22-66", 200,
                        LocalDate.of(1999, 2, 17)),
                new Worker("Mironov", "Ivan", "Pavlovich", "worker",
                        "+7-999-111-22-66", 200,
                        LocalDate.of(1990, 1, 17)),
                new Worker("Denisov", "Ivan", "Pavlovich", "worker",
                        "+7-999-111-22-66", 200,
                        LocalDate.of(1972, 10, 17)),
                new Worker("Syslov", "Oleg", "Pavlovich", "worker",
                        "+7-999-111-22-66", 2000,
                        LocalDate.of(1976, 12, 16)),
                new Manager("Golopushko", "Apollonariy", "Mitrofanovitch", "manager",
                        "+375-29-649-49-49",3000,
                        LocalDate.of(1974, 4, 13)),
                new Manager("Zhuk", "Sergey", "Koloradovitch", "manager",
                        "+375-29-649-49-50",3000,
                        LocalDate.of(1996, 8, 13))
        };

        List<Worker> workerList = Arrays.asList(workers);
        System.out.println();
        System.out.println("Доблестная команда сразу после внесения в массив:");
        System.out.println(workerList);

        System.out.println();
        System.out.println("Average age: " + getAverageAge(workers));
        System.out.println("Average salary: " + getAverageSalary(workers));

        Manager.addSalary(workers, 45, 50);
        System.out.println(Arrays.toString(workers));

        Collections.sort(workerList);
        System.out.println("---".repeat(5) + " Те же после сортировки списка:");
        System.out.println(workerList);
        System.out.println("---".repeat(5));

        workerList.sort(new WorkerSalaryComparator());
        System.out.println("---".repeat(5) + " Они же после сортировки списка по зарплате с помощью WorkerSalaryComparator():");
        System.out.println(workerList);
        System.out.println("---".repeat(5));

        workerList.sort(new WorkerNameComparator());
        System.out.println("---".repeat(5) + " После сортировки по имени с помощью WorkerNameComparator():");
        System.out.println(workerList);

        System.out.println();
        System.out.println("---------------- НАЗНАЧЕНИЕ ЗАДАЧ ----------------------------------------");
        System.out.println();
        workerList.get(1).assign("контролировать количество мух в офисе");
        workerList.get(0).assign("присматривать за " + workerList.get(1).getSurname());
        workerList.get(0).assign("обеспечить средствами ПВО сотрудника Denisov" , workerList.get(3));
        workerList.get(1).assign("не мешать Denisov" , workerList.get(3));
        workerList.get(0).assign("наладить работу станции радиолокации" , workerList.get(6));
        workerList.get(0).assign("наладить работу станции радиолокации" , workerList.get(5));
        workerList.get(2).assign("обеспечить поставку горячего кофе истребителю мух Denisov");


        System.out.println("Отныне список задач выглядит так:");
        System.out.println(Task.getTaskList());
    }

    public static double getAverageAge(Worker[] array) {
        int sumAge = 0;
        for (Worker worker : array) {
            sumAge += worker.getAge();
        }
        return sumAge / (double) array.length;
    }

    public static double getAverageSalary(Worker[] array) {
        int sumSalary = 0;
        for (Worker worker : array) {
            sumSalary += worker.getSalary();
        }
        return sumSalary / (double) array.length;
    }

}