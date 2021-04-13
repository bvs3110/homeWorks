package com.ifmo.jjd.hw0701;

public class Schoolchild extends People implements Learn{
    final private String subject;
    private int knowledge;

    public Schoolchild(String name, int age, String subject, int knowledge) {
        super(name, age);
        if (subject == null || subject.strip().length() < 3) throw new IllegalArgumentException("Слишком короткое название предмета!");
        if (knowledge < 0) throw new IllegalArgumentException("Уровень интеллекта не для школы!");
        this.subject = subject.strip();
        this.knowledge = knowledge;
    }

    public String getSubject() {
        return subject;
    }

    public void addKnowledge(int knowledge) {
        if (knowledge < 0) throw new IllegalArgumentException("Уровень интеллекта не для школы!");
        this.knowledge += knowledge;
    }

    public int getKnowledge() {
        return knowledge;
    }

    @Override
    public void learn(Teacher teacher) {
        if (teacher == null) return;
        if (teacher.getSubject().equals(subject)) knowledge += teacher.getEfficiency();
    }

    @Override
    public String toString() {
        return "Schoolchild{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", subject='" + subject + '\'' +
                ", knowledge=" + knowledge +
                '}';
    }
}
