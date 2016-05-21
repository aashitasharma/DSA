package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class MeetingRooms {

	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public class Solution {
		public boolean canAttendMeetings(Interval[] intervals) {
			Comparator<Interval> comparator=new Comparator<MeetingRooms.Interval>() {
				@Override
				public int compare(Interval o1, Interval o2) {
					// TODO Auto-generated method stub
					Integer one=o1.start;
					Integer two=o2.start;
					return one.compareTo(two);
				}
			};
			List<Interval> i=new ArrayList<Interval>();
			for(Interval inter:intervals){
				i.add(inter);
			}
			Collections.sort(i, comparator);
			for(int j=0;j<i.size();j++){
				
			}
			return false;
		}
	}
}
