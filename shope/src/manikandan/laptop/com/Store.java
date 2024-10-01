package manikandan.laptop.com;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.util.*;

public class Store {
	  computer com[];
	  Statement stmt;
	  ResultSet rs;
	  String qry=null;
	  DButil db=new DButil();
	  Connection con;
	  List<computer> list=new ArrayList<>();
      Scanner sc = new Scanner(System.in);
      int i;
	  int e;
	private Object count;
      public void add(computer c)
      {
    	      c.setId(Gtid(c));
//    	      list.add(c);
//    	      System.out.println("Successfully Added");
    
    	     try
    	     {
    	      	   Statement stmt;
    	    	   Connection con=db.getDBConnection();
    	    	   stmt = con.createStatement();
    	    	   String qry=null;
    	    	   int count = stmt.executeUpdate("insert into shope(id,uname,name,model_name,price,processor_type) values ('"+c.getId()+"','"+c.getUname()+"','"+c.getName()+"','"+c.getName()+"','"+c.getPrice()+"','"+c.getProcessor_type()+"')");
   	    	     if(count==1)
   	    	     {    	    		  
   	    	    	 System.out.println("1 row inserted");
    	    	   }
    	    	  else 
    	    	  {
    	    		  throw new Exception();
    	    	  }
   	    	  } catch(Exception ex)
    	    		  {
    	    			   System.out.println("No row is inserted");
   	    		  }
    }
      public void show()
      {
//    	  System.out.println(list);
    	  Statement stmt;
    	  ResultSet rs;
    	  String qry=null;
    	  DButil db=new DButil();
    	  Connection con;
   	     try {
         con=db.getDBConnection();
         stmt=con.createStatement();
         rs=stmt.executeQuery("select * from shope");
         while(rs.next())
         System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5)+" "+rs.getString(6));
      }
      catch(Exception e) 
   	  {
      System.out.println(e.getMessage());
      }
      }
      
      public computer search(String id)
      {
    	  
    	  for(i=0;i<list.size();i++)
    	  {
    		  if(id.equals(list.get(i).getId()))
    	         return list.get(i);
    	  }
		return null;
      }
    public String Gtid(computer com)
    {
    	String id;
    	String n=com.getUname();
        String bn=com.getName();
    	n=n.substring(0,2);
    	bn=bn.substring(0,2);
    	n=n.toUpperCase();
    	id=n+bn;
    	return id;
    }
     public void remove(String id)
     { 
//    	 int i;
//    	 for(i=0;i<list.size();i++)
//   	  {
//   		  if(id.equals(list.get(i).getId()));
//   		  list.remove(i);
//      }
    	 try
	     {
	      	   Statement stmt;
	    	   Connection con=db.getDBConnection();
	    	   stmt = con.createStatement();
	    	   String qry=null;
	    	   int count = stmt.executeUpdate("delete from shope where id='"+id+"'");
	    	     if(count==1)
	    	     {    	    		  
	    	    	 System.out.println("1 row is deleted");
	    	   }
	    	  else 
	    	  {
	    		  throw new Exception();
	    	  }
	    	  } catch(Exception ex)
	    		  {
	    			   System.out.println("No row is deleted");
	    		  }
    	 
     }
     public void update(String id)
     {
    	 Scanner sc=new Scanner(System.in);
 		int ch;
 		try
 		{
 		  Connection con=db.getDBConnection();
 		  stmt=con.createStatement();
 		  System.out.print("Enter to update 1.Username 2.name 3.model 4.Price 5.type 6.exit");
 		  ch=sc.nextInt();
 		  switch(ch)
 		  {
 		    case 1:
 		    {
 			   //b.setCusname(sc.next());
 			   qry="update shope set uname='"+sc.next()+"' where id='"+id+"'";
 			   break;
 		    }
 		    case 2:
 		    {
 			  // b.setBrand(sc.next());
 			   qry="update shope set name='"+sc.next()+"' where id='"+id+"'";
 			   break;
 		    }
 		    case 3:
 		    {
 			   //b.setModel(sc.next());
 			   qry="update shope set model_name='"+sc.next()+"' where id='"+id+"'";
 			   break;
 		    }
 		    case 4:
 		    {
 			  // b.setSno(sc.next());
 			   qry="update shope set price='"+sc.nextInt()+"' where id='"+id+"'";
 			   break;
 		    }
 		    case 5:
 		    {
 			  // b.setPrice(sc.nextInt());
 			   qry="update shope2 set processor_type='"+sc.next()+"' where id='"+id+"'";
 			   break;
 		    }
 		    default:
 		    {
 			   System.out.println("Invalid choice");
 		    }
 		  }
 		  int count=stmt.executeUpdate(qry);
 		  if(count==1)
 			  System.out.println("1 row is updated");
 		  else
 			  throw new Exception("No row is updated");
 		}
 		catch(Exception e)
 		{
 			System.out.println(e);
 		}
     }
}




