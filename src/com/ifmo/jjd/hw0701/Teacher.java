package com.ifmo.jjd.hw07;

public class Teacher extends People{
    final private String subject;
    private int efficiency;

    public Teacher(String name, int age, String subject, int efficiency) {
        super(name, age);
        if (subject == null || subject.strip().length() < 3) throw new IllegalArgumentException("Слишком короткое название предмета!");
        if (efficiency < 0) throw new IllegalArgumentException("Учитель не может преподавать!");
        this.subject = subject;
        this.efficiency = efficiency;
    }

    public String getSubject() {
        return subject;
    }

    public int getEfficiency() {
        return efficiency;
    }

    public boolean teach(Schoolchild schoolchild) {
        if (schoolchild == null || schoolchild.getSubject().equals(subject)) return false;
        schoolchild.addKnowledge(efficiency);
        return true;
    }

}
