package com.lockedme;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class LockedMe 
{
	static final String projectFilesPath = "E:\\simpli learn class\\LockedMeFiles";
	static final String errorMessage = "some error occured. Please contact : admin@lockedme.com";
	
	public static void main(String[] args) 
	{
		//Take input from user 
		Scanner obj = new Scanner(System.in);
		int ch;
		do
		{
			displayMenu();
			System.out.println("Enter your choice:");
			ch = Integer.parseInt(obj.nextLine());
			
			switch(ch)
			{
			case 1:getAllFiles();
			break;
			case 2:creatFile();
			break;
			case 3:deleteFiles();
			break;
			case 4:searchFiles();
			break;
			case 5:System.exit(0);
			break;
			default:System.out.println("Invalid Option");
			break;
			}
		}
		while(ch>0);
		obj.close();
	}
	
	public static void displayMenu()
	{
		System.out.println("*****************************************************************************");
		System.out.println("\t\tWelcome to Lockedme.com");
		System.out.println("\t\tCode return by khushboo sinha");
		System.out.println("*****************************************************************************");
		System.out.println("\t\t1. Display all the files");
		System.out.println("\t\t2. Add a new file");
		System.out.println("\t\t3. Delete a file");
		System.out.println("\t\t4. Search a file");
		System.out.println("\t\t5. Exit");
	}
	/**
	**This function will return all the files from the project directory
	**/		
	public static void getAllFiles()
	{
		try {
			File folder = new File(projectFilesPath);
			File [] listofFiles = folder.listFiles();
			if(listofFiles.length==0)
				System.out.println("No files exist in the directory");
			else
			{
			for (var l:listofFiles)
			{
				System.out.println(l.getName());
			}
			}
			}
			catch(Exception Ex)
			{
				System.out.println(errorMessage);
			}
	}
	/**
	**This function is use for create a new file from directory
	**/
	public static void creatFile()
	{
		try
		{
			 Scanner obj =  new Scanner(System.in);
			 
			 String fileName;
			 
			 System.out.println("Enter file name:");
			 fileName = obj.nextLine();
			 
			 int linesConunt;
			 
			 System.out.println("Enter how many lines in the file:");
			 linesConunt=Integer.parseInt(obj.nextLine());
	
			 FileWriter myWriter = new FileWriter(projectFilesPath+ "\\"+ fileName);
			 
			 for(int i=1;i<=linesConunt;i++)
			 {
				 System.out.println("Enter the file line:");
				 myWriter.write(obj.nextLine()+"\n");
		     }
			 System.out.println("File created successfully");
			 myWriter.close();
			 obj.close();
		}
		catch(Exception Ex)
		{
			System.out.println(errorMessage);
		}
	}
	/**
	**This function is use for delete file form directory
	**/
	public static void deleteFiles()
	{
		Scanner obj = new Scanner(System.in);

		try {
			String fileName;
			
			System.out.println("Enter the final name to be delted:");
			
			fileName = obj.nextLine();
			
			File file = new File(projectFilesPath+ "\\"+ fileName);
	        
			if(file.exists())
			{
	        file.delete();
			System.out.println("File delete successfully"+ fileName);
			}
			else
				System.out.println("File do not exist");
			}
		catch(Exception Ex)
		{
			System.out.println(errorMessage);
		}
		finally {
			obj.close();
		}
	}
	/**
	**This function for search file form directory
	 **/
	public static void searchFiles()
	{
		Scanner obj = new Scanner(System.in);

		try {
			String fileName;
			
			System.out.println("Enter the final name to be searched:");
			
			fileName = obj.nextLine();
			
			File folder = new File(projectFilesPath);
			File [] listofFiles = folder.listFiles(); 
			
			LinkedList<String> filename = new LinkedList<String>();
			
			for(var l:listofFiles)
				filename.add(l.getName());
			
			if(filename.contains(fileName))
				System.out.println("File is available");
			else
				System.out.println("File is not available");			 
			}
		catch(Exception Ex)
		{
			System.out.println(errorMessage);
		}
		finally {
			obj.close();
		}
	}
	
}
