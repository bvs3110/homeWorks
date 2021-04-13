package com.ifmo.jjd.hw0701;

public class Teacher extends People implements Teach{
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

    @Override
    public void teach(Schoolchild schoolchild) {
        if (schoolchild == null) return;
        schoolchild.learn(this);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", subject='" + subject + '\'' +
                ", efficiency=" + efficiency +
                '}';
    }
}
