package myQuestions;

import java.util.Random;
import java.util.*;

public class FlightPlanner {

    public static int SEED = 100;

    public FlightPlanner() {
	
    }

    public static List<List<Integer>> testCasesGen() {
	Random randomGenerator = new Random();
	List<List<Integer>> testCases = new ArrayList<List<Integer>>();
	int i = 0;
	int limit = randomGenerator.nextInt(SEED);
	while (i < limit) {
	    List<Integer> a = new ArrayList<Integer>();
	    a.add(randomGenerator.nextInt(SEED));
	    a.add(randomGenerator.nextInt(SEED));
	    a.add(randomGenerator.nextInt(SEED));
	    i++;
	    testCases.add(a);
	}
	return testCases;
    }
    
    public static void main(String[] args){
	
	Random randomGenerator = new Random();
	int notc=randomGenerator.nextInt(500);
	int[] output=new int[notc];
	for(int i=0;i<notc;i++){
	    List<List<Integer>> tc=testCasesGen();
//	    output[i]=calculateFuel(tc);
	    System.out.println(testCasesGen());
	}
//	for(int i:output)
//	    System.out.println(i);
    }
    public static int calculateFuel(List<List<Integer>> route){
	if(route.size()==0)
	    return 0;
	int[] z=new int[route.size()];
	int idx=0;
	for(List<Integer> l:route){
	    z[idx++]=l.get(2);
	}
	int maxHeight = z[0];
	for(int i=1;i<z.length;i++){
	    maxHeight=Math.max(z[i], maxHeight);
	}
	return maxHeight - z[0]; 
    }
}
