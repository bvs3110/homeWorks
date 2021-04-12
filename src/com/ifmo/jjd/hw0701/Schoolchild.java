package com.ifmo.jjd.hw07;

public class Schoolchild extends People {
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

    public int getKnowledge() {
        return knowledge;
    }

    public void addKnowledge(int knowledge) {
        if (knowledge < 0) throw new IllegalArgumentException("Знания не могут быть отрицательными!");
        this.knowledge += knowledge;
    }
}
