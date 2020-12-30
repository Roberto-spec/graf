


public class Vertex {

    private char name;
    private boolean is_visited=false;

    Vertex(char name){
        this.name=name;
        is_visited=false;
    }


    public char getName() {
        return name;
    }

    public boolean get_Is_visited() {
        return is_visited;
    }

    public void setIs_visited(boolean is_visited) {
        this.is_visited = is_visited;
    }

    public void setName(char name) {
        this.name = name;
    }
    public  void show(){
        System.out.print(name+" ");
    }
}
