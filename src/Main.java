import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Graf graf=new Graf();
        Scanner scanner=new Scanner(System.in);
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
            a= scanner.nextInt();
            switch (a){
                case 1:{
                    System.out.println("Enter name Vertex:");
                    //System.out.print(">_";
                    String s;
                    s=scanner.nextLine();
                    if(s.length()>0){
                    name=s.charAt(0);

                    Vertex vertex=new Vertex(name);}
                    break;
                }
                case 2:{
                    if(!graf.is_Empty())
                    graf.matrica_show();
                    break;
                }
                case 3:{
                    if(!graf.is_Empty())
                    graf.obhod_glubina();
                    break;
                }
                case 5:{
                    if(!graf.is_Empty()) {
                        int d, n;
                        System.out.println("Enter first index new connection:");
                        System.out.print(">_");
                        d = scanner.nextInt();
                        System.out.println("Enter second index new connection:");
                        System.out.print(">_");
                        n = scanner.nextInt();
                        graf.matrica_update(a, n);
                    }
                    break;
                }
                default:
                break;
            }

        }while (a!=4);

    }

}