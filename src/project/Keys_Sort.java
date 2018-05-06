package project;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.StringTokenizer;

public class Keys_Sort implements Serializable, Comparable{

	
	public String file;
	public int pcount;
	public String key;
	@Override
	public int compareTo(Object compareIndexing) {
		int compareQuantity = ((Keys_Sort) compareIndexing).pcount; 

		//ascending order
//		return this.frequency - compareQuantity;

		//descending order
		return compareQuantity - this.pcount;

	}

	
}
