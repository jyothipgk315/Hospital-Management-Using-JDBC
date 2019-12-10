package hospitalManagement;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Hadmin {
	ConnectionMan con =new ConnectionMan();
	public void add() throws ClassNotFoundException, SQLException{
		Scanner s=new Scanner (System.in);    //checking the username and password are valid
		System.out.println("user name");
		String name=s.next();
		System.out.println("password");
		String pswrd=s.next();
		Statement s1=con.getConnection().createStatement();
		ResultSet r=s1.executeQuery("select * from admin");
		
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
	case 1: //emergency doctor section
	int em;
	do
	{
	System.out.println("1.add(doctor)\n2.remove(doctor)\n3.update(doctor)\n4.view \n5.logout");
	em=s.nextInt();
		switch(em)
			{
			
			case 1:// add doctor details(emergency)
			System.out.println("id");
			int id=s.nextInt();
			System.out.println("doctor name");
			String name1=s.next();
			System.out.println("department");
			String dpt=s.next();
			System.out.println("Start time");
			String start=s.next();
			System.out.println("End time");
			String end=s.next();
			System.out.println("fee");
			int fee=s.nextInt();
			
			PreparedStatement st= con.getConnection().prepareStatement("insert into doctor (did,dname,department,stime,etime,fee) values(?,?,?,?,?,?);");
			st.setInt(1,id);
			st.setString(2, name1);
			st.setString(3, dpt);
			st.setString(4, start);
			st.setString(5, end);
			st.setInt(6, fee);
			
			st.executeUpdate();
			System.out.println("added");
			break;
			
			
			
			
			
			case 2: //remove doctor details (emergency)
				System.out.println("enter the id of doctor to be removed");
				int rol=s.nextInt();
				PreparedStatement stm=con.getConnection().prepareStatement("DELETE FROM doctor WHERE did=?");
				stm.setInt(1,rol);
				stm.execute();
				System.out.println("data deleted");
				break;
			case 3://update details of doctor(emergency)
				System.out.println("id to be updated ");
				int upid=s.nextInt();
				System.out.println("no of field want to change ");
				int feild=s.nextInt();
				int arr[]=new int[feild];
				System.out.println("1.start time\n2.end time\n3.fee");
				System.out.println("which u want to change");
				for(int i=0;i<feild;i++)
				{
					arr[i]=s.nextInt();
				}
				if(feild ==1)
				{
					for(int i=0;i<feild;i++)
					{
						if(arr[i]==1)
						{
						System.out.println("start time");
						String stime=s.next();
						PreparedStatement pr=con.getConnection().prepareStatement("update doctor set stime=? where did=?");
						pr.setString(1, stime);
						pr.setInt(2, upid);
						pr.execute();
						System.out.println("details updated");
						}
						else if(arr[i]==2)
						{
						System.out.println("end time");
						String etime=s.next();
						PreparedStatement pr=con.getConnection().prepareStatement("update doctor set etime=? where did=?");
						pr.setString(1, etime);
						pr.setInt(2, upid);
						pr.execute();
						System.out.println("details updated");
						
						}
						else if(arr[i]==3)
						{
						System.out.println("fee");
						int fees=s.nextInt();
						PreparedStatement pr=con.getConnection().prepareStatement("update doctor set fee=? where did=?");
						pr.setInt(1,fees);
						pr.setInt(2, upid);
						pr.execute();
						System.out.println("details updated");
						
						}
					}
			}
			else if(feild ==2)
			{
				for(int i=0;i<feild-1;i++)
				{
					 if(arr[i]==1&&arr[i+1]==2)
					{
						System.out.println("start time");
						String stime1=s.next();
						System.out.println("end time");
						String etime1=s.next();
						PreparedStatement pr=con.getConnection().prepareStatement("update doctor set stime=?,etime=? where did=?");
						pr.setString(1, stime1);
						pr.setString(2, etime1);
						pr.setInt(3, upid);
						pr.execute();
						System.out.println("details updated");
						break;
					}
					 else if(arr[i]==1&&arr[i+1]==3)
					{
						System.out.println("start time");
						String stime1=s.next();
						System.out.println("fee");
						int fee1=s.nextInt();
						PreparedStatement pr=con.getConnection().prepareStatement("update doctor set stime=?,fee=? where did=?");
						pr.setString(1, stime1);
						pr.setInt(2, fee1);
						pr.setInt(3, upid);
						pr.execute();
						System.out.println("details updated");
						break;
					}
					 else if(arr[i]==2&&arr[i+1]==3)
					{
						System.out.println("end time");
						String etime1=s.next();
						System.out.println("fee");
						int fee1=s.nextInt();
						PreparedStatement pr=con.getConnection().prepareStatement("update doctor set etime=?,fee=? where did=?");
						pr.setString(1, etime1);
						pr.setInt(2, fee1);
						pr.setInt(3, upid);
						pr.execute();
						System.out.println("details updated");
						
					}
				}
			}
			else  if(feild ==3)
			{
				for(int i=0;i<feild-1;i++)
				{
					 if (arr[i]==2&&arr[i+1]==3&&arr[i+2]==1)
					{
						System.out.println("end time");
						String etime=s.next();
						System.out.println("fee");
						int fee1=s.nextInt();
						PreparedStatement pr=con.getConnection().prepareStatement("update doctor set etime=?,fee=? where did=?");
						pr.setString(1, etime);
						pr.setInt(2, fee1);
						pr.setInt(3, upid);
						pr.execute();
						System.out.println("details updated");
						
					}
				}
			}
			
				break;
			case 4:
				Statement s2=con.getConnection().createStatement();
				ResultSet re=s2.executeQuery("select*from doctor");
				while(re.next())
				{
					System.out.println("doctor id:"+re.getInt(1));
					System.out.println("name:"+re.getString(2));
					System.out.println("department"+re.getString(3));
					System.out.println("start time:"+re.getString(4));
					System.out.println("end time:"+re.getString(5));
					System.out.println("fee :"+re.getString(6));
					System.out.println("*************************");
				}
				break;
			case 5://logout
				login();
				break;
				
			}
			}
			while(em==1||em==2||em==3||em==4);
			
			
		
			
			break;
	case 2://op doctors details
	int op;
	do
	{
	System.out.println("1.add(doctor)\n2.remove(doctor)\n3.update(doctor)\n4.view \n5.logout");
	op=s.nextInt();
			switch(op)
			{
			case 1: // add doctor details(op)
				System.out.println("id");
				int id=s.nextInt();
				System.out.println("doctor name");
				String name1=s.next();
				System.out.println("department");
				String dpt=s.next();
				System.out.println("Start time");
				String start=s.next();
				System.out.println("End time");
				String end=s.next();
				System.out.println("fee");
				int fee=s.nextInt();
				
				PreparedStatement st= con.getConnection().prepareStatement("insert into opdoct (did,dname,department,stime,etime,fee) values(?,?,?,?,?,?);");
				st.setInt(1,id);
				st.setString(2, name1);
				st.setString(3, dpt);
				st.setString(4, start);
				st.setString(5, end);
				st.setInt(6, fee);
				
				st.executeUpdate();
				System.out.println("added");
				break;
			case 2: //remove doctor details(op)
				System.out.println("enter the id of doctor to be removed");
				int rol=s.nextInt();
				PreparedStatement stm=con.getConnection().prepareStatement("DELETE FROM opdoct WHERE did=?");
				stm.setInt(1,rol);
				stm.execute();
				System.out.println("data deleted");
				break;
			case 3://update details of doctor(op)
				System.out.println("id to be updated ");
				int upid=s.nextInt();
				System.out.println("no of field want to change ");
				int feild=s.nextInt();
				int arr[]=new int[feild];
				System.out.println("1.start time\n2.end time\n3.fee");
				System.out.println("which u want to change");
				for(int i=0;i<feild;i++)
				{
					arr[i]=s.nextInt();
				}
				if(feild ==1)
				{
					for(int i=0;i<feild;i++)
					{
						if(arr[i]==1)
						{
						System.out.println("start time");
						String stime=s.next();
						PreparedStatement pr=con.getConnection().prepareStatement("update opdoct set stime=? where did=?");
						pr.setString(1, stime);
						pr.setInt(2, upid);
						pr.execute();
						System.out.println("details updated");
						}
						else if(arr[i]==2)
						{
						System.out.println("end time");
						String etime=s.next();
						PreparedStatement pr=con.getConnection().prepareStatement("update opdoct set etime=? where did=?");
						pr.setString(1, etime);
						pr.setInt(2, upid);
						pr.execute();
						System.out.println("details updated");
						
						}
						else if(arr[i]==3)
						{
						System.out.println("fee");
						int fees=s.nextInt();
						PreparedStatement pr=con.getConnection().prepareStatement("update opdoct set fee=? where did=?");
						pr.setInt(1,fees);
						pr.setInt(2, upid);
						pr.execute();
						System.out.println("details updated");
						
						}
					}
			}
			else if(feild ==2)
			{
				for(int i=0;i<feild-1;i++)
				{
					 if(arr[i]==1&&arr[i+1]==2)
					{
						System.out.println("start time");
						String stime1=s.next();
						System.out.println("end time");
						String etime1=s.next();
						PreparedStatement pr=con.getConnection().prepareStatement("update opdoct set stime=?,etime=? where did=?");
						pr.setString(1, stime1);
						pr.setString(2, etime1);
						pr.setInt(3, upid);
						pr.execute();
						System.out.println("details updated");
						break;
					}
					 else if(arr[i]==1&&arr[i+1]==3)
					{
						System.out.println("start time");
						String stime1=s.next();
						System.out.println("fee");
						int fee1=s.nextInt();
						PreparedStatement pr=con.getConnection().prepareStatement("update opdoct set stime=?,fee=? where did=?");
						pr.setString(1, stime1);
						pr.setInt(2, fee1);
						pr.setInt(3, upid);
						pr.execute();
						System.out.println("details updated");
						break;
					}
					 else if(arr[i]==2&&arr[i+1]==3)
					{
						System.out.println("end time");
						String etime1=s.next();
						System.out.println("fee");
						int fee1=s.nextInt();
						PreparedStatement pr=con.getConnection().prepareStatement("update opdoct set etime=?,fee=? where did=?");
						pr.setString(1, etime1);
						pr.setInt(2, fee1);
						pr.setInt(3, upid);
						pr.execute();
						System.out.println("details updated");
						
					}
				}
			}
			else  if(feild ==3)
			{
				for(int i=0;i<feild-1;i++)
				{
					 if (arr[i]==2&&arr[i+1]==3&&arr[i+2]==1)
					{
						System.out.println("end time");
						String etime=s.next();
						System.out.println("fee");
						int fee1=s.nextInt();
						PreparedStatement pr=con.getConnection().prepareStatement("update opdoct set etime=?,fee=? where did=?");
						pr.setString(1, etime);
						pr.setInt(2, fee1);
						pr.setInt(3, upid);
						pr.execute();
						System.out.println("details updated");
						
					}
				}
			}
				break;
			case 4:
				Statement s2=con.getConnection().createStatement();
				ResultSet re=s2.executeQuery("select*from opdoct");
				while(re.next())
				{
					System.out.println("doctor id:"+re.getInt(1));
					System.out.println("name:"+re.getString(2));
					System.out.println("department"+re.getString(3));
					System.out.println("start time:"+re.getString(4));
					System.out.println("end time:"+re.getString(5));
					System.out.println("fee :"+re.getString(6));
					System.out.println("*************************");
				}
				break;
			case 5://logout
				login();
				break;
				
			}
			}
			while(op==1||op==2||op==3||op==4);
			
			 break;
	case 3:
	Hmain h=new Hmain();
	h.menu();
	break;
			
		}
		
	}

}
