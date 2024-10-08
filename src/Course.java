
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PMYLS
 */
public class Course implements Serializable{
    private String degreetitle;
    private String acronym;

    public Course(String coursetitle, String acronym) {
        this.degreetitle = coursetitle;
        this.acronym = acronym;
    }

    public String getCoursetitle() {
        return degreetitle;
    }

    public void setCoursetitle(String coursetitle) {
        this.degreetitle = coursetitle;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    @Override
    public String toString() {
        return ("Course" + "coursetitle=" + degreetitle +" "+ acronym );
    }
    
    public static void writeToFile(Course bs) {
        try {
            File f = new File("course.ser");
            ObjectOutputStream oos;
            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }
            oos.writeObject(bs);
            oos.close();
        } catch (IOException e) {
            System.out.println("Error in the file warning: " + e.getMessage());
        }
    }
}
