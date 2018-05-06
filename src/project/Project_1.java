package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.jsoup.Jsoup;

/*************************************************************************
 *  Compilation:  javac TST.java
 *  Execution:    java TST < words.txt
 *  Dependencies: StdIn.java
 *
 *  Symbol table with string keys, implemented using a ternary search
 *  trie (TST).
 *
 *
 *  % java TST < shellsST.txt
 *  by 4
 *  sea 6
 *  sells 1
 *  she 0
 *  shells 3
 *  shore 7
 *  the 5

 *
 *  % java TST
 *  theory the now is the time for all good men

 *  Remarks
 *  --------
 *    - can't use a key that is the empty string ""
 *
 *************************************************************************/

public class Project_1 implements Serializable{
	
	
	
    public static void main(String[] args) throws IOException, ClassNotFoundException {
    	
    In in;
   List<Keys_Sort> obj=new ArrayList<Keys_Sort>();
   ArrayList<String> arrayList = new ArrayList<String>();
	File folder = new File("C:\\Users\\admin\\workspace\\ACT_Project\\textfiles\\");
	File[] listOfFiles = folder.listFiles();
	File folder1 = new File("C:\\Users\\admin\\workspace\\ACT_Project\\htmls\\"); 
	File[] listOfFiles1 = folder1.listFiles(); 
	
	 for (int i = 0; i < listOfFiles.length; i++) {
	      if (listOfFiles[i].isFile()) {
	    	  arrayList.add("C:\\Users\\admin\\workspace\\ACT_Project\\textfiles\\"+listOfFiles[i].getName());
	      }
	 }
	 for(int i=0;i<arrayList.size();i++)
	 {
	    	  org.jsoup.nodes.Document doc1 = Jsoup.parse(new File(arrayList.get(i)), "UTF-8", "www.w3sfjj.com");
	    	  String text = doc1.text();
	 		 TST<Integer> st=new TST<Integer>();
	 		 StringTokenizer taker = new StringTokenizer(text," .,'\"\"*&^%$#@`~-_+=;:?<>()[]/|!\t\n\r\f,.:;?![]'\\{}");
	 		ArrayList<String> keys=new ArrayList();
	 		while (taker.hasMoreElements())
	        {
	        	keys.add(taker.nextToken().toLowerCase());
	        }
	 		
	 		for (int j = 0; j < keys.size(); j++) {
	        	int counter=1;
	        	for(int k=0;k<keys.size();k++){

	        		   if(keys.get(j).equals(keys.get(k))){
	       			 counter++;
	       		 }
	       		  		 
	       	     }   
	        		 st.put(keys.get(j), counter);
	        }
	 		/*ArrayList<String> duplicate=new ArrayList<String>();
	        duplicate.add(keys.get(0));
	        for(int u=0;u<keys.size();u++)
	        {
	     	   for(int w=1;w<duplicate.size();w++)
	     	   {
	     		   if(keys.get(u).equals(duplicate.get(w)))
	     		   {
	     			   keys.remove(u);
	     		   }
	     			   
	     		   
	     	   }duplicate.add(keys.get(u));
	     	   
	        }*/
	 		Keys_Sort p1 = null;
			for (String key : st.keys()) 
			{
				
				p1 = new Keys_Sort();
				p1.file=arrayList.get(i);
				p1.pcount= st.get(key);
				p1.key= key;
				obj.add(p1);
			
	 		
	    } 
	  }
	 
    FileOutputStream out = new FileOutputStream("dictionary.txt");
	ObjectOutputStream oout = new ObjectOutputStream(out);
	oout.writeObject(obj);
	oout.writeObject(null);
	oout.close();
    }
        
	     
	/*
        FileOutputStream fos = new FileOutputStream("mybean.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		for(int u=0;u<5;u++)
		oos.writeObject(p1[u]);
		oos.close();
	     }
        
        System.out.println("Enter a Word to be searched");
        Scanner sc=new Scanner(System.in);
        
        String key1 = sc.nextLine().toLowerCase();
        Integer l[]=new Integer[3];
        ArrayList<String> notfound=new ArrayList<String>();
        for(int i=0;i<3;i++)
        {
        		l[i]= st.get(key1);
        }
        FileInputStream fis = new FileInputStream("mybean.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Project_1 result[] = new Project_1[5];
		for(int u=0;u<5;u++)
		{
			result[u]=new Project_1();
		}
		for(int u=0;u<5;u++)
		result[u] = (Project_1) ois.readObject();
		ois.close();
        for(int l1=0;l1<5;l1++)
        {
        	for(int l2=0;l2<p1[l1].key.size();l2++)
        	{
        		System.out.println("file    " + result[l1].gethtml(l1) + ", key:    " + result[l1].getkey(l2)+", "+"Frequency:  "+result[l1].getfrequency(l2));
        	}
        }
        
    }*/
}


 
