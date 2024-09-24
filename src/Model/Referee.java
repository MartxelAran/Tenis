package Model;

public class Referee {

    public String name;
    public String password;

    public Referee(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void logReferee(){
        
    }

    public void registerReferee(String name, String password){
        this.name=name;
        this.password=password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
