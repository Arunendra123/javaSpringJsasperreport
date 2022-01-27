package demo.spring.orm;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.spring.orm.reports.LocalUserReports;
import demo.spring.orm.userEntity.LocalUser;
import demo.spring.orm.userService.UserService;
import net.sf.jasperreports.engine.JRException;


public class main {
	public static void main(String args[]) throws FileNotFoundException, JRException {
		
       	ApplicationContext context= new ClassPathXmlApplicationContext("config.xml");
       	UserService userService=context.getBean("userService",UserService.class);
       	
       	Scanner s=new Scanner(System.in);
       	while(true) {
       		System.out.println("\n1: Insert \n2: Update \n3: GetUser \n4: List User\n5: Delete\n6: Generate Report");
       		int opt=s.nextInt();
       		switch(opt){
       		case 1:
       			    System.out.println("Id:\n");
       			    String id=s.next();
       				System.out.println("User's Name:\n");
       				String uname=s.next();
       				System.out.println("Email:\n");
       				String email=s.next();
       			    System.out.println("Title:\n");
       			    String title=s.next();

       			    userService.add(new LocalUser(Integer.parseInt(id),uname,email,title));
       			    System.out.print("Value inserted...\n");
       				break;
       		case 2:
       			   System.out.println("Id:\n");
   			       id=s.next();
   				   System.out.println("User's Name:\n");
   				   uname=s.next();
   				   System.out.println("Email:\n");
   				   email=s.next();
   			       System.out.println("Title:\n");
   			       title=s.next();
   			       userService.add(new LocalUser(Integer.parseInt(id),uname,email,title));

   			       System.out.print("Value updated...\n");  
       			   break;
       		case 3:
       			    System.out.println("Id:\n");
			        id=s.next();
			        System.out.print(userService.getLocalUser(Integer.parseInt(id)));
       				break;
       		case 4: 
       			    ArrayList<LocalUser> userList=(ArrayList<LocalUser>) userService.list();
       			    for(LocalUser user2:userList) {
       			    	System.out.print(user2+"\n");
       			    }
       			    LocalUserReports report=new LocalUserReports();
       			    report.generateReport(userService, "");
       			    break;
       		case 5: 
   			       System.out.println("Id:\n");
		           id=s.next();
		           userService.delete(Integer.parseInt(id));
		           System.out.print("User deleted");
   				   break;   
       		case 6:
       			   System.out.print("Generating Reports......");
       		default:
       				System.out.print("Incorect input\n");
       				
       		}       		
       	}
       }
   }

