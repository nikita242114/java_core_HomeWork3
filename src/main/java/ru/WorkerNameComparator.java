package ru;

import java.util.*;

public class WorkerNameComparator  implements Comparator<Worker> {

    @Override
    public int compare(Worker o1, Worker o2) {
//    String name = this.getName();
        int result = o1.getName().compareTo(o2.getName());
        if (result == 0) {
            result = o1.getSurname().compareTo(o2.getName());
        }
        if (result == 0) {
            result = o1.getMiddleName().compareTo(o2.getMiddleName());
        }

        return result;
    }

}