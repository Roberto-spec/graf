import exception.GrafException;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Graf graf=new Graf();
        Scanner scannerInt=new Scanner(System.in);
        Scanner scannerLine=new Scanner(System.in);
        char name;
        int[] index;
        int a=0;

        do {
            System.out.println("MENU");
            System.out.println("[1] Add element");
            System.out.println("[2] Show matrica");
            System.out.println("[3] Show graf");
            System.out.println("[4] EXIT");
            System.out.println("[5] ADD connection");
            System.out.print(">_");
            a= scannerInt.nextInt();
            switch (a){
                case 1:{
                    System.out.println("Enter name Vertex:");
                    //System.out.print(">_";
                    String s;
                    s=scannerLine.nextLine();
                    name=s.charAt(0);
                    Vertex vertex=new Vertex(name);
                    try {
                        graf.add(vertex);
                    }
                    catch (GrafException j){
                        j.getMessage();
                    }
                    break;
                }
                case 2:{
                    //if(!graf.is_Empty())
                    try {
                        graf.matrica_show();
                    }catch (GrafException l){
                        l.getMessage();
                    }

                    break;
                }
                case 3:{
                    //if(!graf.is_Empty())
                    try {
                        graf.obhod_glubina();
                    }catch (GrafException k){
                        k.getMessage();
                    }

                    break;
                }
                case 5:{
                    /* if(!graf.is_Empty()) { */
                        String first, second;
                        System.out.println("Enter first name new connection:");
                        System.out.print(">_");
                    first = scannerLine.nextLine();
                        System.out.println("Enter second name new connection:");
                        System.out.print(">_");
                    second = scannerLine.nextLine();
                    try {
                        graf.addConnection(first.charAt(0), second.charAt(0));
                    }catch (GrafException five){
                        five.getMessage();
                        }

                    //}
                    break;
                }
                default:
                break;
            }

        }while (a!=4);

    }

}