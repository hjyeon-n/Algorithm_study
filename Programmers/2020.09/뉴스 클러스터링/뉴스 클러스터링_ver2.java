import java.util.ArrayList;
import java.util.regex.Pattern;

public class Programmers {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("abbccdeff", "aabcdde"));
	}

	public static int solution(String str1, String str2) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		ArrayList<String> set1 = splitStr(str1);
		ArrayList<String> set2 = splitStr(str2);
		
		if (set1.size() == 0 && set2.size() == 0) {
			return 65536;
		}
		
		int intersectionSize = 0;
        int unionSize = 0;

        while (!set1.isEmpty()) {
            String target = set1.get(0);
            int targetSizeOfSet1 = 0;
            int targetSizeOfSet2 = 0;
            
            while (set1.contains(target)) {
                set1.remove(target);
                targetSizeOfSet1++;
            }
            
            while (set2.contains(target)) {
                set2.remove(target);
                targetSizeOfSet2++;
            }
            
            if (targetSizeOfSet2 > 0) {
                intersectionSize += Math.min(targetSizeOfSet1, targetSizeOfSet2);
                unionSize += Math.max(targetSizeOfSet1, targetSizeOfSet2);
            } else {
                unionSize += targetSizeOfSet1;
            }
        }

        unionSize += set2.size();

        double j = (double) intersectionSize / unionSize;

        return (int) (j * 65536);
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
}
