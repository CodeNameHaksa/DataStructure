//comparable example using extension

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        String type = "";
        ArrayList<human> h = new ArrayList<>();
        ArrayList<android> a = new ArrayList<>();
        ArrayList<Student> s = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            input = br.readLine();
            st = new StringTokenizer(input);
            type = st.nextToken();
            if(type.equals("A")){
                android tmpA = new android(st.nextToken(), st.nextToken(), st.nextToken());
                a.add(tmpA);
                s.add(tmpA);
            }else if(type.equals("H")){
                human tmpH = new human(st.nextToken(), Integer.parseInt(st.nextToken()));
                h.add(tmpH);
                s.add(tmpH);
            }
        }

        Collections.sort(s);

        for(int i=0;i<N;i++){
            System.out.println(s.get(i));
        }
        System.out.println(s.get(R-1));
    }
}

class human extends Student{
    int studentNum;

    public human(String name, int studentNum) {
        super(name);
        this.studentNum = studentNum;
    }

    @Override
    public int compare(Object o) {
        human tmp = (human)o;
        if(this.studentNum<tmp.studentNum){
            return -1;
        }else if(this.studentNum>tmp.studentNum){
            return 1;
        }
        if(this.name.compareTo(tmp.name)<0){
            return -1;
        }else if(this.name.compareTo(tmp.name)>0){
            return 1;
        }else{
            return 0;
        }
    }

    public String toString(){
        return this.name+" "+this.studentNum;
    }
}

class android extends Student{
    String modelNum;
    String Serial;

    public android(String name, String modelNum, String Serial) {
        super(name);
        this.modelNum = modelNum;
        this.Serial = Serial;
    }

    @Override
    public int compare(Object o) {
        android a = (android)o;
        if(this.modelNum.compareTo(a.modelNum)<0){
            return -1;
        }else if(this.modelNum.compareTo(a.modelNum)>0){
            return 1;
        }
        if(this.Serial.compareTo(a.Serial) < 0){
            return -1;
        }else if(this.Serial.compareTo(a.Serial) > 0){
            return 1;
        }

        if(this.name.compareTo(a.name)<0){
            return -1;
        }else if(this.name.compareTo(a.name)>0){
            return 1;
        }else{
            return 0;
        }

    }

    public String toString(){
        return this.name+" "+this.modelNum+" "+this.Serial;
    }
}

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
            return this.getClass().toString().compareTo(
                    o.getClass().toString());
        }
    }

    abstract public int compare(Object o);
}
