package Model;

public class Player {

    public int id;
    public String name;


    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "name:"+this.name + "; id:" + this.id;
    }
}
