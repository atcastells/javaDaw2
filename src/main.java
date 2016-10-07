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
                    String opcioOperacions = gui.readString();      //Hem de escriure Velocitat , graus , circumferencia
                    for (String exercici:data.operacions){
                        if(exercici.equalsIgnoreCase(opcioOperacions)){
                            operacions(opcioOperacions);
                        }
                    }
                    break;
                case 2: //Bifurcacions
                    System.out.print("Elegeix un exercici: \n");
                    for (String exercici:data.bifurcacions){
                        System.out.print(" - "+exercici+"\n");
                    }
                    gui.imprimir("Escriu el nom del exercici: ");
                    String opcioBifurcacions = gui.readString();      //Hem de escriure Velocitat , graus , circumferencia
                    for (String exercici:data.bifurcacions){
                        if(exercici.equalsIgnoreCase(opcioBifurcacions)){
                            bifurcacions(opcioBifurcacions);
                        }
                    }
                    break;
                case 3: //Bucles
                    System.out.print("Elegeix un exercici: \n");
                    for (String exercici:data.bucles){
                        System.out.print(" - "+exercici+"\n");
                    }
                    gui.imprimir("Escriu el nom del exercici: ");
                    String opcioBucles = gui.readString();      //Hem de escriure Velocitat , graus , circumferencia
                    for (String exercici:data.bucles){
                        if(exercici.equalsIgnoreCase(opcioBucles)){
                            bucles(opcioBucles);
                        }
                    }
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
        Scanner teclat = new Scanner(System.in); //Es crea el scanner
        if(nom.equalsIgnoreCase("Velocitat")){
            gui.imprimir("Introdueix els km/h: ");
            int km = teclat.nextInt(); //llegim els km/h per teclat
            float ms;
            ms = (float) (km * 0.27777); //fem el calcul de km/h a m/s i donem valor a la variable ms
            gui.imprimir(km+" km/h són "+ms+" m/s"); //Mostrem el resultat a l'usuari.
            gui.enterContinue();
        }
        else if (nom.equalsIgnoreCase("Graus")){
            float graus = (float) 0.0;
            gui.imprimir("Introdueix una quantitat de graus (ºC): ");
            graus = gui.readFloat();
            gui.ln();           //Salt de linea
            float grausF = 32 + (9*(graus/5));
            /*Calcul*/
            gui.imprimir("\nEls graus(ºF) son: "+grausF+".\n");
            gui.enterContinue();
        }
        else if(nom.equalsIgnoreCase("Circumferencia")){
        /*Definició de variables*/
            float longitud, radi, area;
            double PI = 3.1;

        /*Inicialitzem les variables*/
            longitud = 0;
            radi = 0;
            area = 0;

        /*Lectura de dades*/
            Scanner sc = new Scanner (System.in); //inicialitzem l'eina Scanner
            System.out.print("Introdueix el valor del radi: ");
            radi = sc.nextFloat();

        /*Operacions*/
            longitud = (float) (2*PI*radi);
            area = (float) (PI*radi);

        /*Resultat*/
            System.out.println("La longitud de la circumferencia es "+longitud);
            System.out.println("L'area de la circumferencia es "+area);
        }
        gui.enterContinue();
    }

    void bifurcacions(String programa){
        gui gui = new gui();
        Scanner teclat = new Scanner(System.in); //Es crea el scanner
        if(programa.equalsIgnoreCase("Calculadora")){
            System.out.print("Introdueix el primer número per operar: ");
            float primer = teclat.nextFloat();

            System.out.print("Introdueix el sengon número per operar: ");
            float segon = teclat.nextFloat();

            System.out.print("Introdueix el símbol per a fer el càlcul (+, -, *, /): ");

            char simbol = teclat.next().charAt(0);
            float resultat;

            if(simbol == '+'){
                resultat = primer + segon;
                System.out.println("El resultat es: "+resultat);
            }
            else if(simbol == '-'){
                resultat = primer - segon;
                System.out.println("El resultat es: "+resultat);
            }
            else if(simbol == '*'){
                resultat = primer * segon;
                System.out.println("El resultat es: "+resultat);
            }
            else if(simbol == '/'){
                if(segon == 0){
                    System.out.println("La operació es infinita.");
                }
                else{
                    resultat = primer / segon;
                    System.out.println("El resultat es: "+resultat);
                }
            }
            gui.enterContinue();
        }
        else if(programa.equalsIgnoreCase("Ciutats")){
        /*Definició de variables*/
            boolean encertat;
            String[] resultat = {"Tokyo","New York","Mexic"};
            String ciutat;
            int n, pos;

        /*Inicialitzem les variables*/
            encertat = false;
            ciutat = " ";
            n = 0;
            pos = 4;

        /*Operacions*/
            Scanner sc = new Scanner(System.in); //inicialitzem l'Scanner
            System.out.print("Escriu el nom d'una de les tres ciutats "
                    + "més grans del mon: ");
            ciutat = sc.nextLine(); //llegim el nom de la ciutat
            for (int i=0;i<3;i++){ //mirem que la ciutat sigui correcta
                if (ciutat.equals(resultat[i])){
                    encertat = true;
                }
            }
            if (encertat == false){ //en cas que no l'hagi endevinat li donem una ajuda
                System.out.println("Ho sentim, aquesta ciutat no està entre "
                        + "les tres ciutats més grans del món");
                System.out.println("\nLes tres ciutats més grans són aquestes: Mexic, Tokyo i"
                        + " New York.\nTria'n una!");
                while (encertat == false){ //Torna a escriure la ciutat i revisem que sigui correcte
                    System.out.print("\n\nCiutat: ");
                    ciutat = sc.nextLine();
                    for (int i=0;i<3;i++){
                        if (ciutat.equals(resultat[i])){
                            encertat = true;
                        }
                    }
                    if (encertat == false){
                        System.out.println("Revisa el que has escrit!");
                    }
                }
            }
            System.out.println("Ara endevina en quina posició del ranking (1, 2 o 3) es troba "+ciutat+": ");
            pos = sc.nextInt() -1;
            for (int i=0;i<3;i++){ //mirem la posició que ocupa la ciutat
                if (ciutat.equals(resultat[i])){
                    n = i;
                }
            }
            if (n == pos){
                System.out.println("Enhorabona! L'has encertat!");
            }
            else{
                System.out.println("Has fallat!");
                System.out.println("El ranking és:\n1. Tokyo\n2. New York\n3. Mexic");
            }

            gui.enterContinue();
        }
        else if(programa.equalsIgnoreCase("IMC")){
            try{
                System.out.print("Introdueix el teu pes amb kg: ");
                float pes = teclat.nextFloat();

                System.out.print("Introdueix la teva altura amb cm: ");
                float altura = teclat.nextFloat()/100;

                float imc;

                imc = pes/(altura*altura);

                if(imc<=16){
                    System.out.print("El teu IMC es de: "+imc+" Molt poc pes. Ves a l'hospital que tinguis més a prop.");
                }
                else if(imc>16&&imc<=17){
                    System.out.print("El teu IMC es de: "+imc+" Tens infrapès.");
                }
                else if(imc>17&&imc<=18){
                    System.out.print("El teu IMC es de: "+imc+" Tens poc pes.");
                }
                else if(imc>18&&imc<=25){
                    System.out.print("El teu IMC es de: "+imc+" Tens un bon pes! Estas més fort que el vinagre!");
                }
                else if(imc>25&&imc<=30){
                    System.out.print("El teu IMC es de: "+imc+" Tens sobrepès. (obesitat de grau I) Cuidado en los doritos.");
                }
                else if(imc>30&&imc<=35){
                    System.out.print("El teu IMC es de: "+imc+" Tens sobrepès crònic. (obesitat de grau II).");
                }
                else if(imc>35&&imc<=40){
                    System.out.print("El teu IMC es de: "+imc+" Tens obesitat premòrbida. (obesitat de grau III).");
                }
                else{
                    System.out.print("El teu IMC es de: "+imc+" Tens obesitat mòrbida. (obesitat de grau IV).");
                }
            }
            catch (Exception e){
                System.out.print("Error: "+e);
            }
        }
    }

    void bucles(String programa){
        gui gui = new gui();
        Scanner teclat = new Scanner(System.in); //Es crea el scanner
        if(programa.equalsIgnoreCase("10impars")) {
            long producte = 1;

            for (int i=1; i<20; i+=2){
                producte = producte*i;
            }
            System.out.println("El producte dels 10 primers nombres impars és: "+producte);
        }
        else if(programa.equalsIgnoreCase("positiuNegatiu")){

        }
        else if(programa.equalsIgnoreCase("Mitjana")){
            int limit = 10;
            double[] mitjana = new double[10];
            double total = 0.0;
            /*Guardem xifres*/
            for (int i = 0; i < mitjana.length; i++) {
                gui.imprimir("Escriu el valor per calular la mitjana("+(i+1)+"): ");
                mitjana[i] = teclat.nextFloat();
                gui.ln();
            }

            /*Calculem mitjana*/
            for(double xifra:mitjana){
                total += xifra;
            }

            /*Imprimim resultat*/
            total = total/mitjana.length;
            gui.imprimir("El total es: "+total);
            gui.enterContinue();
        }
    }
}