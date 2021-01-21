import exception.*;

import java.util.Arrays;
import java.util.TreeSet;

public class Graf {
    Vertex[] vertex_list;
    int[][] matrica;
    TreeSet<String> names=new TreeSet<>();
    Graf(){
        vertex_list=new  Vertex[1];
        vertex_list[0]=null;

    }
    boolean is_Empty(){
        if(vertex_list[0]==null){
            return true;
        }
        return false;

    }
    public  void add(Vertex vertex) throws NotUnicaleNameException, EmptyMatricaException {
        if(names.contains(""+vertex.getName())){
            throw new NotUnicaleNameException("Такое имя вершины уже было задано");
        }
        if(is_Empty()){
            vertex_list[0]=vertex;
            matrica=new int[1][1];
            matrica[0][0]=0;
            names.add(""+vertex.getName());
            matrica_show();

        }
        else {

            vertex_list= Arrays.copyOf(vertex_list,vertex_list.length+1);

            vertex_list[vertex_list.length-1]=vertex;
            matrica_biggetst();
            matrica_show();
            names.add(""+vertex.getName());

        }
        zero();
    }
    public void matrica_update(int one,int two){
        if(!is_Empty()){
            if(one>=0&&one< vertex_list.length&&one!=two){
                matrica[one][two]=1;
                matrica[two][one]=1;
            }

        }

    }
    public void addConnection(char one,char two) throws GrafEmptyException, OneNameException {
        int indexOne=-1;
        int indexTwo=-1;

        if(!is_Empty()&&one!=two){
           for (int i=0;i<vertex_list.length;i++){
               if(vertex_list[i].getName()==one){
                   indexOne=i;
               }
               if (vertex_list[i].getName()==two){
                   indexTwo=i;
               }
           }
           if(indexOne!=-1&&indexTwo!=-1){
               matrica_update(indexOne,indexTwo);
           }

        }else if(is_Empty()){
            throw new GrafEmptyException("Граф пустой");
        }
        else if(one==two){
            throw new OneNameException("Вы ввели одинаковые имена");
        }

    }

    void matrica_biggetst(){
        int[][] m=new int[matrica.length+1][matrica.length+1];
        for (int i=0;i< matrica.length;i++){

            for (int y=0;y< matrica.length;y++){
                m[i][y]=matrica[i][y];

            }
        }
        for (int y=0;y< m.length;y++){
            m[m.length-1][y]=0;

        }
        matrica=m;

    }

    public void obhod_glubina() throws GrafEmptyException, NotAllConnectionException {
        if(!is_Empty()){
            boolean exep=true;
            for (int k=0;k< matrica.length;k++){
                if(matrica[0][k]==1){
                    exep=false;
                }
            }
            if(exep){
                throw new NotAllConnectionException("Не все связи установлены");
            }
            System.out.println("Поиск в глубину");
            glubina(0);
        }
        else {
           throw new GrafEmptyException("Граф пустой");
        }
        for (int i=0;i< vertex_list.length;i++)vertex_list[i].setIs_visited(false);

    }
    void glubina(int index){
        vertex_list[index].setIs_visited(true);
        vertex_list[index].show();
        for (int l=0;l< matrica[index].length;l++){
            if(matrica[index][l]==1&&vertex_list[l].get_Is_visited()==false){
                glubina(l);
            }
        }
    }
    public void zero(){
        for (int i=0;i< matrica.length;i++){

            for (int y=0;y< matrica.length;y++){
               if(matrica[i][y]!=1){
                   matrica[i][y]=0;
               }

            }
        }
    }
    public void matrica_show() throws EmptyMatricaException{

        if(is_Empty()){
            throw new EmptyMatricaException("Матрица пуста");
        }
        System.out.print("  ");
        for (int y=0;y<vertex_list.length;y++){
            System.out.print(vertex_list[y].getName()+" ");
        }
        System.out.print("\n");
        for (int i=0;i< matrica.length;i++){
            System.out.print(vertex_list[i].getName()+" ");
            for (int y=0;y< matrica.length;y++){
                System.out.print(matrica[i][y]+" ");

            }
            System.out.println();
        }
    }




}
