package data_structures_and_algorithms.leetCode.easy;

public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");
        for(int i=0;i<Math.max(v1.length, v2.length);i++){
            Integer i_v1=0;
            Integer i_v2=0;
            if(i<v1.length)
                i_v1=Integer.parseInt(v1[i]);
            if(i<v2.length)
                i_v2=Integer.parseInt(v2[i]);
            if(i_v1!=i_v2)
                return i_v1.compareTo(i_v2);
        } 
        return 0;
    }

}
