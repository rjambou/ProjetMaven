package rj;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
    	App monApp;
    	monApp = new App();
        System.out.println( "Hello World, it's me, Remi !" );
        monApp.max(4, 5);
        int monmax = 0;
        try{
        CSVReader reader = new CSVReader(new FileReader("data.csv"));
    	CSVWriter writer = new CSVWriter(new FileWriter("data-filtered.csv"));
        List<String[]> myEntries = reader.readAll();
        for (String[] ligne : myEntries){
        	List<String> list = Arrays.asList(ligne);
        	Vector<String> out=new Vector <String>();
        	CollectionUtils.select(list, new Predicate<String>() {
				
				public boolean evaluate(String arg0) {
					// TODO Auto-generated method stub
					int test = Integer.parseInt(arg0);
					if (test>50){
						return false;
					}
					return true;
				}
			},out);
        	System.out.println("OUT : " + out);
        	String[] tab_out = out.toArray(new String[0]);
        	writer.writeNext(tab_out);
        	for (String element : ligne){
        		int nb=Integer.parseInt(element);
        		monmax=monApp.max(monmax,nb);
        	}
        }
        reader.close();
    	writer.close();
        }
        catch(IOException e){
        	System.out.println("Erreur de fichier.");
        }
        System.out.println(monmax);
    }

    
    public int max(int a, int b)
    {
    	return a > b ? a : b;
    }
	
}