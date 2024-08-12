package interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class IntervalOverlapping {
	
	public static class Interval {
		private int start;
		private int end;
		
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	public static List<Interval> mergeInterval(List<Interval> intervals) {
		if(intervals.size() < 2)
			return intervals;
		List<Interval> result = new ArrayList<>();
		intervals.sort(Comparator.comparingInt(in->in.start));
		Interval first = intervals.get(0);
		int start = first.start;
		int end = first.end;
		for(int i=1;i<intervals.size();i++) {
			Interval current = intervals.get(i);
			if(current.start<=end) {
				end = Math.max(current.end, end);
			}else {
				result.add(new Interval(start, end));
				end = current.end;
				start = current.start;
			}
		}
		result.add(new Interval(start, end));
		return result;
	}
	
	public static List<Interval> insertInterval(List<Interval> intervals, Interval newInterval) {	//pass sorted intervals
		if(intervals.isEmpty() || intervals == null)
			return intervals;
		
		List<Interval> result = new LinkedList<>();
		int i=0;
		
		while(i<intervals.size() && intervals.get(i).end < newInterval.start) {
			result.add(intervals.get(i));
			i++;
		}
		
		while(i<intervals.size() && intervals.get(i).start <= newInterval.end) {
			Interval current = intervals.get(i);
			newInterval.start = Math.min(current.start, newInterval.start);
			newInterval.end = Math.max(current.end, newInterval.end);
			i++;
		}
		
		result.add(newInterval);
		while(i<intervals.size()) {
			result.add(intervals.get(i));
			i++;
		}
		return result;
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(2,6));
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(8,10));
		
		for(Interval i : intervals) {
			System.out.print("(" + i.start + ", " + i.end + ")");
		}
		
		System.out.println();
		
		List<Interval> result = mergeInterval(intervals);
		
		System.out.println("----After merging overlapping intervals----");
		
		for(Interval r : result) {
			System.out.print("(" + r.start + ", " + r.end + ")");
		}
		
		List<Interval> intervals2 = new ArrayList<>();
		intervals2.add(new Interval(0,1));
		intervals2.add(new Interval(3,5));
		intervals2.add(new Interval(6,7));
		intervals2.add(new Interval(9,10));
		
		System.out.println();
		for(Interval i : intervals2) {
			System.out.print("(" + i.start + ", " + i.end + ")");
		}
		
		System.out.println();
		
		List<Interval> result2 = insertInterval(intervals2, new Interval(2,6));	//pass sorted intervals
		
		System.out.println("----After inserting new interval----");
		
		for(Interval r : result2) {
			System.out.print("(" + r.start + ", " + r.end + ")");
		}
	}

}
