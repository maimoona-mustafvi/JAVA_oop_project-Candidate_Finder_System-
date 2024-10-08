
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PMYLS
 */
public class FinderRunner {
    public static void main(String[] args){
        Course c1 = new Course("Bachelors in Electrical Engineering " , "BSEE");
        Course c2 = new Course("Bachelors in Computer Science" , "BSCyS");
        Course c3 = new Course("Bachelors in CyberSecurity" ,"CISA");
        Course c4 = new Course("Bachelors in Business Administration" , "BBA");
        Course c5 = new Course("Bechelors in Datascience" , "BDS");
    
        BachelorStudent b1 = new BachelorStudent("Ahmed", "B001" , 3.8 , c1);
        BachelorStudent b2 = new BachelorStudent("Fatima", "B002",3.6,c2);
        BachelorStudent b3 = new BachelorStudent("Hassan", "B003",3.9,c3);
        BachelorStudent b4 = new BachelorStudent("Aisha", "B004",3.7 , c4);
        BachelorStudent b5 = new BachelorStudent("Bilal", "B005",3.5 , c5);
        
        BachelorStudent b6 = new BachelorStudent("Zainab", "B006" ,  3.4 , c1);
        BachelorStudent b7 = new BachelorStudent("Omar", "B007" , 3.3 , c2);
        BachelorStudent b8 = new BachelorStudent("Maryam", "B008" , 3.2 , c3);
        BachelorStudent b9 = new BachelorStudent("Yusuf", "B009" , 3.1 , c4);
        BachelorStudent b10 = new BachelorStudent("Sara", "B010" , 3.0 , c5);
        
        BachelorStudent b11 = new BachelorStudent("Ali", "B011" , 3.8 , c1);
        BachelorStudent b12 = new BachelorStudent("Noor", "B012" , 3.6 ,c2);
        BachelorStudent b13 = new BachelorStudent("Imran", "B013" , 3.9 , c3);
        BachelorStudent b14 = new BachelorStudent("Nadia", "B014" , 3.7 , c4);
        BachelorStudent b15 = new BachelorStudent("Kamran", "B015", 3.5 , c5);
        
        ArrayList<BachelorStudent> bach_students = new ArrayList<>();
        for(BachelorStudent bach : bach_students){
            BachelorStudent.writeToFile(bach);
        }
        
        MastersStudent m1 = new MastersStudent("AI in Healthcare", "Dr. Ali", "Khadija", "M001");
        MastersStudent m2 = new MastersStudent("Blockchain Technology", "Dr. Ayesha", "Mustafa", "M002");
        MastersStudent m3 = new MastersStudent("Data Mining", "Dr. Omar", "Noor", "M003");
        MastersStudent m4 = new MastersStudent("Cybersecurity Frameworks", "Dr. Fatima", "Ibrahim", "M004");
        MastersStudent m5 = new MastersStudent("Business Analytics", "Dr. Hassan", "Layla", "M005");
        MastersStudent m6 = new MastersStudent("Quantum Computing", "Dr. Bilal", "Sami", "M006");
        MastersStudent m7 = new MastersStudent("IoT Applications", "Dr. Zainab", "Amina", "M007");
        MastersStudent m8 = new MastersStudent("Sustainable Energy", "Dr. Yusuf", "Hamza", "M008");
        MastersStudent m9 = new MastersStudent("Machine Learning", "Dr. Sara", "Mariam", "M009");
        ArrayList<MastersStudent> mas_students = new ArrayList<>();
        for(MastersStudent mas : mas_students){
            MastersStudent.writeToFile(mas);
        }
        
        
        
        /*
        
        System.out.println("BEFORE\n");
        BachelorStudent.writeToFile(b1);
        BachelorStudent.writeToFile(b2);
        BachelorStudent.writeToFile(b3);
        BachelorStudent.writeToFile(b4);
        BachelorStudent.writeToFile(b5);
        BachelorStudent.writeToFile(b6);
        ArrayList<BachelorStudent> list = BachelorStudent.readAllBachelorStudents();
        for(int i =0; i< list.size() ; i++){
            System.out.println(list.get(i).toString());
        }
        
        
        System.out.println("AFTER\n");
        BachelorStudent.deleteFromFile("B005");
        BachelorStudent.deleteFromFile("B006");
        list = BachelorStudent.readAllBachelorStudents();
        for(int i =0; i< list.size() ; i++){
            System.out.println(list.get(i).toString());
        }
              
        
        System.out.println("BEFORE\n");
        MastersStudent.writeToFile(m1);
        MastersStudent.writeToFile(m2);
        ArrayList<MastersStudent> mList = MastersStudent.readAllMastersStudents();
        for (MastersStudent ms : mList) {
            System.out.println(ms.toString());
        }
        

        System.out.println("AFTER\n");
        MastersStudent.deleteFromFile("M002");
        mList = MastersStudent.readAllMastersStudents();
        for (MastersStudent ms : mList) {
            System.out.println(ms.toString());
        } */
        
        ArrayList<Student> fastStudents = new ArrayList<>();
        fastStudents.add(b1);
        fastStudents.add(b2);
        fastStudents.add(b3);
        fastStudents.add(b4);
        fastStudents.add(b5);
        fastStudents.add(m1);
        fastStudents.add(m2);
        fastStudents.add(m3);

        ArrayList<Student> comsatsStudents = new ArrayList<>();
        comsatsStudents.add(b6);
        comsatsStudents.add(b7);
        comsatsStudents.add(b8);
        comsatsStudents.add(b9);
        comsatsStudents.add(b10);
        comsatsStudents.add(m4);
        comsatsStudents.add(m5);
        comsatsStudents.add(m6);

        ArrayList<Student> uetTaxilaStudents = new ArrayList<>();
        uetTaxilaStudents.add(b11);
        uetTaxilaStudents.add(b12);
        uetTaxilaStudents.add(b13);
        uetTaxilaStudents.add(b14);
        uetTaxilaStudents.add(b15);
        uetTaxilaStudents.add(m7);
        uetTaxilaStudents.add(m8);
        uetTaxilaStudents.add(m9);

        University fast = new University("FAST", "Islamabad", "FAST", fastStudents);
        University comsats = new University("COMSATS", "Islamabad", "CIIT", comsatsStudents);
        University uetTaxila = new University("UET Taxila", "Taxila", "UET", uetTaxilaStudents);
        
        
        
        
        ArrayList<University> universities = new ArrayList<>();
        universities.add(fast);
        universities.add(comsats);
        universities.add(uetTaxila);
        
        CandidateFinder cf = new CandidateFinder(universities);
        CandidateFinder.writeToFile(universities);
        
        /*
        ArrayList<University> temp = CandidateFinder.readAllCandidateFinders();
        for(int i =0; i< temp.size() ; i++){
            System.out.println(temp.get(i).getUniName());
            ArrayList<Student> stu = temp.get(i).getStudents();
            for(Student s:stu){
                System.out.println(s.toString());
            }
        }   */
        
        /*
        ArrayList<Student> tem = cf.candidateFinder("FAST", "Bachelors in Computer Science" ,3.8 , 3.0 ,"Dr. Ali" );// will return student
        for(Student j:tem){
            if(j instanceof BachelorStudent){
                BachelorStudent bs = (BachelorStudent) j;
                System.out.println(bs.toString());
            }
            if(j instanceof MastersStudent){
                MastersStudent ms = (MastersStudent) j;
                System.out.println(ms.toString());
            }
        }*/
        
        
        /*ArrayList<University> universities = new ArrayList<>();
        universities.add(fast);
        universities.add(comsats);
        universities.add(uetTaxila);
        CandidateFinder cf = new CandidateFinder(universities);
        ArrayList<University> temp =new  ArrayList<>();
        temp = cf.getUniversities();
        for(int i =0; i< temp.size() ; i++){
            System.err.println("yup yup yup");
            System.out.println(temp.get(i).getUniName());
            ArrayList<Student> stu = temp.get(i).getStudents();
            for(Student s:stu){
                System.err.println(s.toString());
            }
        }*/
        
        Start s1 = new Start();
        

    }
}
