package com.ifmo.jjd.hw0701;

import java.util.Arrays;

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
        this.teachers = teachers.clone();
        if (schoolchilds == null) throw new IllegalArgumentException("Нет учеников!");
        this.schoolchilds = schoolchilds.clone();
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
                schoolchild.learn(teacher);
            }
        }
        director.StopLessons(this);
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", director=" + director +
                ", teachers=" + Arrays.toString(teachers) +
                ", schoolchilds=" + Arrays.toString(schoolchilds) +
                ", isLessonsStart=" + isLessonsStart +
                '}';
    }
}
