package model;


public class Child{

    private String name;
    private String lastName;
    private String address;
    private String country;
    private String id;
    private int magicNumber;
    private String xmasWish;
    private ListType type;

    public Child(String name, String lastName, String address, String country, String id, String xmasWish, int wish, int opType){

        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.country = country;
        this.id = id;
        magicNumber = (int) Math.random() * 99;

        switch (wish) {
            case 1:
                this.xmasWish = "Aun no se decide";
                break;

            case 2:
                this.xmasWish = "Un deseo no material";
                break;
            
            case 3: 
                this.xmasWish = "Cualquier regalo";
                break;

            case 4: 
                this.xmasWish = xmasWish;
            default:
                break;
        }

        switch(opType){

            case 1:
                type = ListType.GOOD;
                break;
            case 2:
                type = ListType.NAUGHTY;
                break;
        }
    }

    public ListType getType(){
        return type;
    }

    public void setType(ListType t){
        type = t;
    }

    public String getID(){
        return id;
    }

    public String getCountry(){
        return country;
    }

    public String toString(){
        return "Nombre: " + name + "\n" + 
        "Apellido: " + lastName + "\n" + 
        "Direccion: " + address + "\n" + 
        "Pais: " + country + "\n" + 
        "ID: " + id + "\n" + 
        "Deseo de navidad: " + xmasWish + "\n"+
        "Lista: " + type+ "\n";
    }
}  
