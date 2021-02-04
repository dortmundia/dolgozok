import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws IOException {
        Dolgozik d = new Dolgozik();


        //BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        Scanner br = new Scanner(System.in);



        do
        {
            System.out.println("Összes dolgozó lekérdezéséhez nyomjon az 1 gombra");
            System.out.println("Dolgozó nevére kereséséhez nyomjon a 2 gombra");
            System.out.println("Dolgozó azonositojára kereséséhez nyomjon a 3  gombra");
            System.out.println("Dolgozó beszurásához nyomjon a 4 gombra");
            System.out.println("Nyomjon akár milyen más gombra kilépéshez");
            int be = br.nextInt();
        if (be ==1)
        {
            d.selectALL();

        }
        else if(be ==2)
        {
            System.out.println("A dolgozó neve: ");
            String nev = br.nextLine();
            System.out.println(                    d.keresNev(nev));
            System.out.println();
        }
        else if(be ==3)
        {
            System.out.println("A dolgozó azonositója: ");
            int id= br.nextInt();

            System.out.println(d.keresId(id));
            System.out.println();
        }
        else if(be ==4)
        {
            System.out.println("Dolgozó felvételéhez az adatokat a következő sorrendben kell megadnia: név, nem, kor, fizetés ENTEREL elválasztva");

            String semmi=br.nextLine(); // itt nekem valamiért egy scanner cska ugy eltünik az univerzumba és csak így lesz jó
            String name = br.nextLine();
            String nem = br.nextLine();
            int kor= br.nextInt();
            int wage= br.nextInt();
            d.insert(name,nem,kor,wage);

        }
        else
        {
            System.out.println(be);
            System.out.println("kilépés");
            System.exit(0);
        }
        }while(true);

    }


}
