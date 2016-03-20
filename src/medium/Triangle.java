package medium;
import java.util.*;

/**
 * 
 * @author Ankit
 * May b theres a better way.
 */
public class Triangle {
    
    public Triangle() {
	// TODO Auto-generated constructor stub
    }
    class Location{
        int level;
        int index;
        Location(int l, int i){
            level=l;
            index=i;
        }
        @Override
        public boolean equals(Object l){
            if(l instanceof Location){
                Location loc=(Location)l;
                if(loc.level==this.level && loc.index==this.index)
                    return true;
            }
            return false;
        }
        @Override
        public int hashCode() {
            int hash = 1;
            hash = hash * 17 + level;
            hash = hash * 31 + index;
            return hash;
        }
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        
        if(triangle.size()==0)
            return 0;
        if(triangle.size()==1)
            return triangle.get(0).get(0);
        Map<Location, Integer> map=new HashMap<Location, Integer>();    
        return minimumTotal(triangle, 0 , 0, map);
    }
    public int minimumTotal(List<List<Integer>> list, int level, int index, Map<Location, Integer> map){
        Location l=new Location(level, index);
        if(map.containsKey(l))
            return map.get(l);
        if(level==list.size()-1){
                int value=Math.min(list.get(level).get(index),list.get(level).get(index+1) );
                map.put(l,value);
                return value;
        }
        else{
            int value=0;
            if(level+1==list.size()-1)
                value=list.get(level).get(index)+minimumTotal(list, level+1, index, map);
            else
                value=list.get(level).get(index)+Math.min(minimumTotal(list, level+1, index, map), minimumTotal(list, level+1, index+1, map));
                map.put(l, value);
            return value;
        }
        
    }

}
