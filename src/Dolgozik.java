import java.sql.*;
import java.util.ArrayList;

public class Dolgozik {

    ArrayList<Dolgozok> dolgozok;

    public Dolgozik()
    {
        dolgozok= Beolvas("select * from dolgozok");
    }

    private ArrayList<Dolgozok> Beolvas(String kapcs)
    {
        ArrayList<Dolgozok> dolgozok = new ArrayList<>();

        try
        {
            String url = "jdbc:mysql://localhost:3306/dolgozok";
            String user="root";
            String password="";
            Connection kapcsolat= DriverManager.getConnection(url,user,password);
            Statement allapot= kapcsolat.createStatement();
            ResultSet result= allapot.executeQuery(kapcs);
            //System.out.println("Sikeres Kapcsolat");
            while (result.next())
            {
                int id = result.getInt(1);
                int kor = result.getInt(4);
                int wage = result.getInt(5);
                String nev = result.getString(2);
                String nem= result.getString(3);

                Dolgozok obj=new Dolgozok(id, nev,nem,kor,wage);
                dolgozok.add(obj);
            }
            kapcsolat.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return dolgozok;
    }



    public void selectALL()
    {
        System.out.println(dolgozok);
    }

    public void insert(String nev, String nem, int age, int wage)
    {
        //INSERT INTO `dolgozok`(`id`, `nev`, `nem`, `kor`, `fizetes`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5])
        try
        {
            String url = "jdbc:mysql://localhost:3306/dolgozok";
            String user="root";
            String password="";
            Connection kapcsolat= DriverManager.getConnection(url,user,password);
            Statement allapot= kapcsolat.createStatement();
            allapot.executeUpdate("INSERT INTO dolgozok(nev, nem, kor, fizetes) VALUES ('"+nev+"','"+nem+"',"+age+","+wage+");");
            System.out.println("Sikeres beszúrás");

            kapcsolat.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }


    public String keresNev(String nev)
    {
        int i=0;
        int ez=0;
        String vissza="";
        for (Dolgozok item:dolgozok)
        {
            if (item.getNev()==nev){
                ez=i;
            }
            i++;
        }

        if (ez==0)
        {
             vissza="Nem található ilyen nevű dolgozo az adatbázisban";
        }
        else
        {
            vissza="A keresett dolgozo adatai: "+dolgozok.get(ez).toString();
        }

        return vissza;
    }

    public String keresId(int id)
    {
        int i=0;
        int ez=0;
        String vissza="";
        for (Dolgozok item:dolgozok)
        {
            if (item.getId()==id){
                ez=i;
            }
            i++;
        }

        if (ez==0)
        {
            vissza+="Nem található ilyen nevű dolgozo az adatbázisban";
        }
        else
        {
            vissza+="A keresett dolgozo adatai: "+dolgozok.get(ez).toString();
        }

        return vissza;
    }


}
