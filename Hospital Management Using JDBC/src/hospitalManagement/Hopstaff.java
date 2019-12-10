package hospitalManagement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Hopstaff {

	
		
		ConnectionMan con =new ConnectionMan();
		public void adds() throws ClassNotFoundException, SQLException{
			Scanner s=new Scanner (System.in);
			System.out.println("user name");
			String name=s.next();
			System.out.println("password");
			String pswrd=s.next();
			Statement s1=con.getConnection().createStatement();
			ResultSet r=s1.executeQuery("select * from opstaff");
			
			//checking login details
			
			
			int f=0;
			while(r.next())
			{
				 
				String n=r.getString(1);
				String h=r.getString(2);
				
				if(n.equals(name)&&h.equals(pswrd))
				{
					login();
					
				}
				else
				{
					System.out.println("invalid ");
					Hmain hi=new Hmain();
					hi.menu();
				}
			}
		}
		public void login() throws ClassNotFoundException, SQLException{
			Scanner s= new Scanner (System.in);
			System.out.println("1.emergency\n2.op\n3.logout");
			int n=s.nextInt();
			switch(n)
			{
			case 1: //emergency  section   (for patience)
				int em;
				do
				{
				System.out.println("1.avilable doctors\n2.add(patient)\n3.exit");
				 em=s.nextInt();
				switch(em)
				{
				case 1:
					Statement s2=con.getConnection().createStatement();
					ResultSet re=s2.executeQuery("select*from doctor");
					while(re.next())
					{
						System.out.println("doctor id :"+re.getInt(1));
						System.out.println("name ->"+re.getString(2));
						System.out.println("department ->"+re.getString(3));
						System.out.println("duty time ->"+re.getString(4)+" to "+re.getString(5));
						
						System.out.println("fee :"+re.getString(6));
						System.out.println("*************************");
					}
					break;
				
				case 2: // add patient details
					System.out.println("id");
					int id=s.nextInt();
					System.out.println("patient name");
					String name1=s.next();
					System.out.println("age");
					int age=s.nextInt();
					System.out.println("gender");
					String gen=s.next();
					System.out.println("Address");
					String add=s.next();
					PreparedStatement st= con.getConnection().prepareStatement("insert into patient (pid,pname,age,sex,address) values(?,?,?,?,?);");
					st.setInt(1,id);
					st.setString(2, name1);
					st.setInt(3, age);
					st.setString(4, gen);
					st.setString(5, add);
					st.executeUpdate();
					System.out.println("added");
					
					
					System.out.println("Which dpt u need ?");
					String dpt=s.next();
					System.out.println("emergency doctors are");
					Statement s3=con.getConnection().createStatement();
					ResultSet rem=s3.executeQuery("select*from doctor");
					while(rem.next())
					{
						
						if(dpt.equals(rem.getString(3)))
						{
							
						System.out.println(rem.getString(2));
						}
						else
						{
							System.out.println("invalid deparment");
						}
					}
					
						System.out.println("doctor u need");
						String doct=s.next();
						
						Statement s4=con.getConnection().createStatement();
						ResultSet re1=s4.executeQuery("select*from doctor");
					while(re1.next())
					{
						if(doct.equals(re1.getString(2)))
						{
							
							System.out.println("*******BILL********");
							System.out.println("Patient id ->"+id);
							System.out.println("Patient Name ->"+name1);
							System.out.println("Department ->"+dpt);
							System.out.println("Doctor Name ->"+doct);
							System.out.println("fee ->"+re1.getString(6));
							System.out.println("*************************");
							break;
						}
						else
						{
							System.out.println("invalid doctor");
						}
						
					}
						
						break;
					
				
				
				case 3://exit
					login();
					break;
					
				}
				}
				while(em==1||em==2||em==3);
				
				
			
				
				break;
			case 2: //op cosultation
				int op;
				do
				{
				System.out.println("1.avilable doctors\n2.add(patient)\n3.exit");
				 op=s.nextInt();
				switch(op)
				{
				case 1:
					Statement s2=con.getConnection().createStatement();
					ResultSet re=s2.executeQuery("select*from opdoct");
					while(re.next())
					{
						System.out.println("*************************");
						System.out.println("doctor id :"+re.getInt(1));
						System.out.println("name :"+re.getString(2));
						System.out.println("department :"+re.getString(3));
						System.out.println("consulting start time :"+re.getString(4));
						System.out.println("consulting end time :"+re.getString(5));
						System.out.println("fee :"+re.getString(6));
						System.out.println("*************************");
					}
					break;
				
				case 2: // add patient details
					System.out.println("id");
					int id=s.nextInt();
					System.out.println("patient name");
					String name1=s.next();
					System.out.println("age");
					int age=s.nextInt();
					System.out.println("gender");
					String gen=s.next();
					System.out.println("Address");
					String add=s.next();
					
					
					PreparedStatement st= con.getConnection().prepareStatement("insert into oppatient (pid,pname,age,sex,address) values(?,?,?,?,?);");
					st.setInt(1,id);
					st.setString(2, name1);
					st.setInt(3, age);
					st.setString(4, gen);
					st.setString(5, add);
					
					
					st.executeUpdate();
					System.out.println("added");
					
					
					System.out.println("Which dpt u need ?");
					String dpt=s.next();
					System.out.println("op doctors are");
					Statement s3=con.getConnection().createStatement();
					ResultSet rem=s3.executeQuery("select*from opdoct");
					while(rem.next())
					{
						
						if(dpt.equals(rem.getString(3)))
						{
							
						System.out.println(rem.getString(2)+"->"+rem.getString(4)+" to "+rem.getString(5)+" (time)");
						}
						else
						{
							System.out.println("invalid deparment");
						}
					}
					
						System.out.println("doctor u need");
						String doct=s.next();
						
						Statement s4=con.getConnection().createStatement();
						ResultSet re1=s4.executeQuery("select*from opdoct");
					while(re1.next())
					{
						if(doct.equals(re1.getString(2)))
						{
							
							System.out.println("*******BILL********");
							System.out.println("Patient id ->"+id);
							System.out.println("Patient Name ->"+name1);
							System.out.println("Department ->"+dpt);
							System.out.println("Doctor Name ->"+doct);
							System.out.println("fee ->"+re1.getString(6));
							System.out.println("********************");
							break;
						}
						else
						{
							System.out.println("invalid doctor");
						}
						
					}
					break;
					case 3://exit
					login();
					break;
					
				}
				}
				while(op==1||op==2||op==3);
				
				
			
				
				break;
			case 3:
				Hmain h=new Hmain();
				h.menu();
				break;
				
			}
			
		}

	}
