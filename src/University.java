
import java.io.Serializable;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PMYLS
 */
public class University implements Serializable{
    private String uniName;
    private String location;
    private String acronym;
    private ArrayList<Student> students;

    public University(String uniName, String location, String acronym, ArrayList<Student> students) {
        this.uniName = uniName;
        this.location = location;
        this.acronym = acronym;
        this.students = students;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return ("University Name=" + uniName + acronym + ", location=" + location + ", acronym="  + ", NO of students=" + students.size());
    }

    
    
    
}
