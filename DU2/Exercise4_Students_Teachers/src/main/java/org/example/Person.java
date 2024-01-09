package org.example;

public class Person implements Runnable{
    private String name;
    private boolean student;

    private Greeting gr;



    public Person(String name,boolean student,Greeting gr) {
        this.name=name;
        this.student = student;
        this.gr=gr;
    }

    public String getName() {
        return name;
    }

    public boolean isStudent() {
        return student;
    }

    @Override
    public void run() {
        System.out.println(this.name+" has arrived.");
        if(!student){
            gr.teacherGreets(this.name);
        }else{
            gr.studentGreets(this.name);
        }
    }
}
