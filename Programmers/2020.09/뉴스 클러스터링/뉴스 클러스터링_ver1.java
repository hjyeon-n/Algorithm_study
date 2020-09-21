import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Programmers {
	static ArrayList<String> list1;
	static ArrayList<String> list2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("abbccdeff", "aabcdde"));
	}

	public static int solution(String str1, String str2) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		list1 = splitStr(str1);
		list2 = splitStr(str2);
		
		if (list1.size() == 0 && list2.size() == 0) {
			return 65536;
		}
		
		Set<String> set1 = makeSet(list1);
		Set<String> set2 = makeSet(list2);
		Set<String> inter = new HashSet<String>(set1);
		Set<String> union = new HashSet<String>(set1);
		
		inter.retainAll(set2);
		union.addAll(set2);
		
		double n1 = makeList(inter, 0);
		double n2 = makeList(union, 1);
		System.out.println(n1);
		System.out.println(n2);
		int answer = (int) ((n1 / n2) * 65536);
		return answer;
    }
	
	public static ArrayList<String> splitStr(String str) {
		ArrayList<String> list = new ArrayList<String>();
		int i = 0;
		int j = 2;
		
		String sub = "";
		String pattern = "^[a-z]*$";
		boolean flag = false;
		while (true) {
			if (j >= str.length()) {
				sub = str.substring(i);
				flag = true;
			}
			else {
				sub = str.substring(i, j);
			}
		    boolean isOk = Pattern.matches(pattern, sub);
		    if (isOk) {
		    	list.add(sub);
		    }
		    
		    if (flag) {
		    	break;
		    }
		    i++;
		    j++;
		}
		
		return list;
	}
	
	public static Set<String> makeSet(ArrayList<String> list) {
		Set<String> set = new HashSet<String>();
		for(String item: list){
            set.add(item);
        }
		return set;
	}
	
	public static int makeList(Set<String> set, int flag) {
		ArrayList<String> list = new ArrayList<String>();
		int cnt = 0;
		for (String str : set) {
			if (list1.contains(str) && list2.contains(str)) {
				cnt = count(str, flag);
				
				while (cnt-- > 0) {
					list.add(str);
				}
			}
		}
		
		ArrayList<String> add = new ArrayList<String>();
		if (flag == 1) {
			for (String str : list1) {
				if (!list.contains(str)) {
					add.add(str);
				}
			}
			for (String str : list2) {
				if (!list.contains(str)) {
					add.add(str);
				}
			}
			list.addAll(add);
		}
		return list.size();
	}
	
	public static int count(String str, int flag) {
		int cnt1 = 0;
		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i).equals(str)) {
				cnt1++;
			}
		}
		
		int cnt2 = 0;
		for (int i = 0; i < list2.size(); i++) {
			if (list2.get(i).equals(str)) {
				cnt2++;
			}
		}
		if (flag == 0) {
			return Math.min(cnt1, cnt2);
		}
		else {
			return Math.max(cnt1, cnt2);
		}
	}
}
