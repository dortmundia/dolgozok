public class Dolgozok {
    private int id;
    private String nev;
    private String nem;
    private int age;
    private int wage;

    @Override
    public String toString() {
        return "\r\n" + nev + "  "+ nem + "  "+ age + " éves, fizetése: " + wage  ;
    }


    public int getId() {
        return id;
    }

    public String getNev() {
        return nev;
    }

    public String getNem() {
        return nem;
    }

    public int getAge() {
        return age;
    }

    public int getWage() {
        return wage;
    }

    public Dolgozok(int id, String nev, String nem, int age, int wage) {
        this.id = id;
        this.nev = nev;
        this.nem = nem;
        this.age = age;
        this.wage = wage;
    }
}
