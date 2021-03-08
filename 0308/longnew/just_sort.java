package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

abstract class Student implements Comparable<Student> {
    public String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        if (this.getClass() == o.getClass()) {
            return this.compare(o);
        } else {
            return this.getClass().toString().compareTo(o.getClass().toString());
        }
    }

    abstract public int compare(Object o);
}

class H extends Student{
    int StudentNumber;

    public H(String name, int num){
        super(name);
        this.StudentNumber = num;
    }

    @Override
    public int compare(Object o) {
        H next_student = (H)o;
        if (this.StudentNumber > next_student.StudentNumber)
            return 1;

        else if(this.StudentNumber < next_student.StudentNumber)
            return -1;

        return this.name.compareTo(next_student.name);
    }

    public String toString(){
        return this.name + " "  + this.StudentNumber;
    }
}

class A extends Student{
    String serial;
    String model;

    public A(String name, String b, String c){
        super(name);
        this.model = b;
        serial = c;
    }

    @Override
    public int compare(Object o) {
        A next_student = (A)o;
        if (this.model.equals(next_student.model))

            if (this.serial.equals(next_student.serial))

                return this.name.compareTo(next_student.name);

            else
                return this.serial.compareTo(next_student.serial);

        return this.model.compareTo(next_student.model);
    }

    public String toString(){
        return this.name + " " + this.model + " "  + this.serial;
    }
}

public class sort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        List<Student> data = new ArrayList<>();

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String which = st.nextToken();

            if (which.equals("H")){
                H student = new H(st.nextToken(), Integer.parseInt(st.nextToken()));
                data.add(student);

            }else {
                A student = new A(st.nextToken(), st.nextToken(), st.nextToken());
                data.add(student);
            }
        }

        Collections.sort(data);

        System.out.println(data.get(r - 1));
    }
}
