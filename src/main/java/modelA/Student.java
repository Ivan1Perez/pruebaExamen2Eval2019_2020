package modelA;

public class Student extends Person{

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

    @Override
    public String toString(){
        return "Student {" + "Name: " + super.getName() + ", " + "Surname: " + super.getSurname() + ", " +"NIA: " + NIA + "}";
    }

}
