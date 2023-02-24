package modelA;

import java.io.Serializable;

public class Student extends Person implements Serializable {

    private int NIA;

    public Student(String name, String surname, int NIA){
        super(name, surname);
        this.NIA = NIA;
    }

    public void setNIA(int NIA){
        this.NIA = NIA;
    }

    public int getNIA(){
        return NIA;
    }

//    @Override
//    public int compareTo(Student o) {
//        if(o.getSurname().compareToIgnoreCase(this.getSurname())!=0)
//            return getSurname().compareToIgnoreCase(o.getSurname());
//        e
//    }

    @Override
    public String toString(){
        return "{Name: " + super.getName() + ", " + "Surname: " + super.getSurname() + ", " +"NIA: " + NIA + "}";
    }

}
