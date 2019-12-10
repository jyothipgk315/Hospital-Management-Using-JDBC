package hospitalManagement;

import java.sql.SQLException;

import java.util.Scanner;





public class Hmain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Hmain h=new Hmain();
		h.menu();
	}
		 void menu() throws ClassNotFoundException, SQLException {
			
		
		Scanner s= new Scanner (System.in);
		System.out.println("1.admin\n2.staff\n3.exit");
		int n= s.nextInt();
		switch(n)
		{
		case 1:                            //for admin
			Hadmin  ha=new Hadmin();
			ha.add();
			break;
		case 2:                           //for Staff
			Hopstaff ho=new Hopstaff();
			ho.adds();
			break;
		case 3:                           //for exit
			System.exit(0);
			default:System.out.println("wrong number");
		}
	}

	
		
	

}
