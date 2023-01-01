import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_10814 { 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		List<Member> list = new ArrayList<Member>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			
			list.add(new Member(name, age));
		}
		
		Comparator<Member> c = (Member a, Member b) -> a.getAge().compareTo(b.getAge());
		list.sort(c);
		
		for (Member m : list) {
			System.out.println(m.getAge() + " " + m.getName());
		}
	}
}

class Member {
	private String name;
	private int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getAge() {
		return age;
	}
}