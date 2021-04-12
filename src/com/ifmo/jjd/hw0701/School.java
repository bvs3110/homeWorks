package com.ifmo.jjd.hw07;

public class School {
    final private String name;
    private Director director;
    private Teacher[] teachers;
    private Schoolchild[] schoolchilds;
    private boolean isLessonsStart = false;

    public School(String name, Director director, Teacher[] teachers, Schoolchild[] schoolchilds) {
        if (name == null || name.strip().length() < 1) throw new IllegalArgumentException("Слишком короткое имя школы!");
        this.name = name.strip();
        if (director == null) throw new IllegalArgumentException("Не назначен директор!");
        this.director = director;
        if (teachers == null) throw new IllegalArgumentException("Нет учителей!");
        this.teachers = teachers;
        if (schoolchilds == null) throw new IllegalArgumentException("Нет учеников!");
        this.schoolchilds = schoolchilds;
    }

    public String getName() {
        return name;
    }

    public Director getDirector() {
        return director;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public Schoolchild[] getSchoolchilds() {
        return schoolchilds;
    }

    public boolean isLessonsStart() {
        return isLessonsStart;
    }

    public void setLessonsStart(boolean lessonsStart) {
        isLessonsStart = lessonsStart;
    }

    public void schoolDay(){
        director.StartLessons(this);
        for (Teacher teacher : teachers) {
            for (Schoolchild schoolchild : schoolchilds) {
                teacher.teach(schoolchild);
            }
        }
        director.StopLessons(this);
    }
}
