package model;
import java.util.ArrayList;

public class WorkShop{

    private ArrayList<Child> goodChildren;
    private ArrayList<Child> naughtyChildren;
    private String[][] matrixGift;

    public WorkShop(){

        goodChildren = new ArrayList<Child>();
        naughtyChildren = new ArrayList<Child>();
        matrixGift = new String[5][5];

        fillMatrix();
    }

    public String addChild(String name, String lastName, String address, String country, String id, String xmasWish, int wish, int opType){
        
        String msg = "No se pudo registrar al ninio";

        Child child = new Child(name,lastName,address,country,id,xmasWish,wish,opType);

        if(child.getType() == ListType.GOOD){
            goodChildren.add(child);
            msg = "Se registro al ninio";
        }else{
            naughtyChildren.add(child);
            msg = "Se registro al ninio";
        } 

        return msg;
    }

    public void fillMatrix(){
        
        for(int i = 0; i<matrixGift.length;i++){
            for(int j = 0; j<matrixGift.length;j++){
                matrixGift[i][j] = "Un regalo bonito";
            }
        }
    }

    public Child searchChild(int opType, String idChild, String country){
        boolean flag = false;
        Child obChild = null;

        if(opType == 1){
            for(int i = 0; i<goodChildren.size()&&!flag;i++){
                if(goodChildren.get(i).getID().equals(idChild) && goodChildren.get(i).getCountry().equals(country)){
                    obChild = goodChildren.get(i);
                    flag = true;
                }
            }
        } else{
            for(int i = 0; i<naughtyChildren.size()&&!flag;i++){
                if(naughtyChildren.get(i).getID().equals(idChild) && goodChildren.get(i).getCountry().equals(country)){
                    obChild = naughtyChildren.get(i);
                    flag = true;
                }
            }   
        }

        return obChild;
    }

    public String changeChildList(int opType, String idChild, String country){

        String msg = "No se pudo cambiar de lista al ninio";

        Child child = searchChild(opType,idChild,country);

        if(child != null){
            if(goodChildren.contains(child)){
                child.setType(ListType.NAUGHTY);
                goodChildren.remove(child);
                naughtyChildren.add(child);

                msg = "Se ha cambiado de lista al ninio";
            }else if(naughtyChildren.contains(child)){
                child.setType(ListType.GOOD);
                naughtyChildren.remove(child);
                goodChildren.add(child);

                msg = "Se ha cambiado de lista al ninio";
            }
        }

        return msg;
    }

    public String showListInfo(int opType){
        
        String msg = "";

        if(opType == 1){
            for(int i = 0; i<goodChildren.size();i++){
                msg = goodChildren.get(i).toString() + "\n";
            }
        } else{
            for(int i = 0; i<naughtyChildren.size();i++){
                msg = naughtyChildren.get(i).toString() + "\n";
            } 
        }

        return msg;
    }

    public String countChildrenCountry(String country){
        
        String msg = "No hay ninios en la lista";
        int count = 0;

        if(!goodChildren.isEmpty()){
            for(int i = 0;i<goodChildren.size();i++){
                if(goodChildren.get(i).getCountry().equals(country)){
                    count++;
                }
            }

            msg = "Hay " + count + " ninios esperando por su regalo en " + country;
        }

        return msg;

    }

    public String surpriseGift(){

        String msg = "";

        

        return msg;

    }


}