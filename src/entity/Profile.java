package entity;

// [TODO] [Alper] iDisplayable'ı burada implement etmek de mantıklı mı bi düşün.
public class Profile {

    private String name;
    private int age;

    public Profile(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){

        return this.name;
    }

    public int getAge(){

        return this.age;
    }

    public void setName(String name){

        this.name = name;
    }

    public void setAge(int age){

        this.age = age;
    }
}
