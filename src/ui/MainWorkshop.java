package ui;
import java.util.Scanner;
import model.WorkShop;

//javac -cp src src/ui/Template.java -d bin
//java -cp bin ui.Template

public class MainWorkshop{
	
	private Scanner reader;
	private WorkShop objShop;

	public MainWorkshop(){
		reader = new Scanner(System.in);
		objShop = new WorkShop();
	}
	
	public static void main(String[] a){
		
		System.out.println("Bienvenido al taller de santa");

		MainWorkshop objMain = new MainWorkshop();

		int op = 1;

		do{
			op = objMain.menu();
			objMain.executeOp(op);
		}while(op != 0);
	}

	public int menu(){

		int option;

		System.out.println("Que desea hacer?\n"+ 
		"1) Registrar ninio\n" + 
		"2) Cambiar ninio de lista\n" + 
		"3) Mostrar lista\n" +
		"4) Contar ninios buenos en un pais" + 
		"5) Ninios con regalo sorpresa\n" + 
		"0) Salir de la app");
		option = reader.nextInt();

		return option;

	}

	public void executeOp(int op){

		switch (op) {
			case 1:
				addChild();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
			 break;

			default:
				break;
		}
	}

	public void addChild(){

		System.out.println("Ingrese el nombre del ninio");
		String name = reader.next();

		System.out.println("Ingrese el apellido del ninio");
		String lastName = reader.next();

		System.out.println("Ingrese la direccion del ninio");
		String address = reader.next();

		System.out.println("Ingrese el pais del ninio");
		String country = reader.next();

		System.out.println("Ingrese el id del ninio");
		String id = reader.next();

		System.out.println("Ingrese el deseo de navidad del ninio\n 1) Aun no sabe \n 2) Un deseo no material \n 3) Cualquier regalo \n 4) El ninio elige");
		int wish = reader.nextInt();

		String xmasWish = "";

		if(wish == 4){
			System.out.println("Que quiere el ninio de regalo?");
			xmasWish = reader.next();
		}

		System.out.println("Fue un ninio:\n (1) bueno\n (2) malo?");
		int opType = reader.nextInt();

		System.out.println(objShop.addChild(name, lastName, address, country, id, xmasWish, wish, opType));
	}

	public void changeChild(){

		System.out.println("Ingrese el id del ninio");
		String idChild = reader.next();

		System.out.println("Ingrese el pais del ninio");
		String country = reader.next();

		System.out.println("Ingrese a que lista pertenece\n 1) Bueno \n 2) Malo");
		int opType = reader.nextInt();

		System.out.println(objShop.changeChildList(opType, idChild, country));
	}

	public void showList(){

		System.out.println("Ingrese la lista que desee consultar\n 1) Bueno \n 2) Malo");
		int op = reader.nextInt();

		System.out.println(objShop.showListInfo(op));
	}

	public void showChildrenCountry(){

		System.out.println("Ingrese el pais que desee consultar");
		String country = reader.next();

		System.out.println(objShop.countChildrenCountry(country));
	}

}