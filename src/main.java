import java.util.Scanner;

public class main {

    /*Menu*/
    public static void main(String[] args) {
        new main().init();
    }

    void init(){
        final int EXIT = data.menu.length;
        int menuControl = 0;
        while (menuControl != EXIT){
            for (int i = 0; i < data.menu.length; i++){
                System.out.print(data.menu[i]+"\n");
            }
            System.out.print("Escriu una opció per al menu");
            menuControl = funcioMenu(data.menu.length);

            switch (menuControl){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
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
}


/**/