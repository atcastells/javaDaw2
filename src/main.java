import java.util.Scanner;

public class main {

    /*Menu*/
    public static void main(String[] args) {
        gui gui = new gui();
        new main().init(gui);
    }

    void init(gui gui){
        final int EXIT = data.menu.length;
        int menuControl = 0;

        while (menuControl != EXIT){
            for (int i = 0; i < data.menu.length; i++){
                System.out.print("#"+(i+1)+":\t"+data.menu[i]+"\n");
            }
            System.out.print("Escriu una opció per al menu:");
            menuControl = funcioMenu(data.menu.length);

            switch (menuControl){
                case 1: //Operacions
                    System.out.print("Elegeix un exercici: \n");
                    for (String exercici:data.operacions){
                        System.out.print(" - "+exercici+"\n");
                    }
                    gui.imprimir("Escriu el nom del exercici: ");
                    String opcioOperacions = gui.readString();
                    for (String exercici:data.operacions){
                        if(exercici.equalsIgnoreCase(opcioOperacions)){
                            operacions(opcioOperacions);
                        }
                    }
                    break;
                case 2: //Bifurcacions
                    break;
                case 3: //Bucles
                    break;
                case 4:
                    break;
                default:
                    System.out.print("Opció incorrecta\n");
                    break;
            }

        }
    }

    public int funcioMenu(int limit){
        Scanner sc = new Scanner(System.in);
        int opcio = 0;
        boolean correcte = false;
        while (!correcte){
            try{
                opcio = Integer.parseInt(sc.nextLine());
                correcte = true;
            }
            catch (Exception e){
                System.out.print("Escriu una opció vàlida.\n");
            }
        }
        return opcio;
    }
    /*Operacions*/

    void operacions(String nom){
        gui gui = new gui();
        if(nom.equalsIgnoreCase("Velocitat")){
            System.out.print("Introdueix els km/h: ");

            Scanner teclat = new Scanner(System.in); //Es crea el scanner

            int km = teclat.nextInt(); //llegim els km/h per teclat

            float ms;

            ms = (float) (km * 0.27777); //fem el calcul de km/h a m/s i donem valor a la variable ms

            System.out.println(km+" km/h són "+ms+" m/s"); //Mostrem el resultat a l'usuari.
            gui.enterContinue();
        }
        else if (nom.equalsIgnoreCase("Graus")){

        }
        else if(nom.equalsIgnoreCase("Circumferència")){

        }
    }

}


/**/