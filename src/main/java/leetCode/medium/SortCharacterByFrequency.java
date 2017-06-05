import java.util.*;

public class SortCharacterByFrequency{

  public String frequencySort(String s) {
    Map<Integer, List<Character>> im = getInvertedMap(getFreqeuncyMap(s));
    StringBuilder sb = new StringBuilder();
    for(Map.Entry<Integer, List<Character>> entry : im.entrySet()){
      for(Character ch : entry.getValue()){
        for(int i = 0;i<entry.getKey();i++){
          sb.append(ch);
        }
      }
    }
    return sb.toString();
  }

  public Map<Character, Integer> getFreqeuncyMap(String s){
    Map<Character, Integer> freq = new HashMap<Character, Integer>();
    for(int i=0;i<s.length();i++){
      Character c = s.charAt(i);
      if(!(freq.containsKey(c))){
        freq.put(c, 0);
      }
      freq.put(c, freq.get(c) + 1);
    }
    return freq;
  }

  public Map<Integer, List<Character>> getInvertedMap(Map<Character, Integer> freq){
    Map<Integer, List<Character>> im = new TreeMap<Integer, List<Character>>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    for(Map.Entry<Character, Integer> entry : freq.entrySet()){
      final int count = entry.getValue();
      Character ch = entry.getKey();
      if(!(im.containsKey(count))) {
        im.put(count, new LinkedList<>());
      }
      im.get(count).add(ch);
    }
    return im;
  }
}
