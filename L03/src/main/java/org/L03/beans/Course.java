package org.L03.beans;

public class Course {
    private Instructor instructor;
    private Subject subject;

    public Course() {}
    public Course(Instructor instructor, Subject subject) {
        this.instructor = instructor;
        this.subject = subject;
    }

    public void setInstructor(Instructor instructor){
        this.instructor = instructor;
    }

    public void setSubject(Subject subject){
        this.subject = subject;
    }

    public Instructor getInstructor(){ return this.instructor; }
    public Subject getSubject() {return this.subject; }
}
