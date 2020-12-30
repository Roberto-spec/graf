public class Graf {
    Vertex[] vertex_list;
    int[][] matrica;

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
    public  void add(Vertex vertex){
        if(is_Empty()){
            vertex_list[0]=vertex;
            matrica=new int[1][1];
            matrica[0][0]=0;

        }
        else {
            Vertex[] v=new Vertex[vertex_list.length+1];
            v=vertex_list;
            vertex_list=new Vertex[v.length];
            vertex_list[vertex_list.length-1]=vertex;
            matrica_biggetst();

        }

    }
    public void matrica_update(int one,int two){
        if(!is_Empty()){
            if(one>=0&&one< vertex_list.length&&one!=two){
                matrica[one][two]=1;
                matrica[two][one]=1;
            }

        }

    }
    void matrica_biggetst(){
        int[][] m=new int[matrica.length+1][matrica.length+1];
        m=matrica;
        matrica=new int[m.length][m.length];
        matrica[matrica.length-1][matrica.length-1]=0;
    }

    public void obhod_glubina(){
        if(!is_Empty()){
            System.out.println("Поиск в глубину");
            glubina(0);
        }
        else System.out.println("Graf is empty");
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
    public void matrica_show(){

        for (int i=0;i< matrica.length;i++){
            System.out.println();
            for (int y=0;y< matrica.length;y++){
                System.out.println(matrica[i][y]+" ");

            }
        }
    }




}
