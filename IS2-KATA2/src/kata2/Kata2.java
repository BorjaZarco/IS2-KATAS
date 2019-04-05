
package kata2;

import java.util.HashMap;
import java.util.Map;


public class Kata2 {

 
    public static void main(String[] args) {
        // TODO code application logic here
        Integer [] data = {1,2,3,4,5,6,7,8,9,10,1,2,3,3,3,7,23};
        String [] names =  {"Rosa", "Pepe", "María", "Pepe", "Pepe", "Rosa"};
        Histogram histo = new Histogram(names);
        System.out.println("=============STRING HISTOGRAM============");
        histo.printHistogram();
        histo.initHistogram(data);
                System.out.println("=============INTEGER HISTOGRAM============");
        histo.printHistogram();
        
    }
    
}
