package ch10.hw;

public class Student implements Comparable<Student> {
	private String name;
	private String id;
	private int height;

	public Student(String name, String id, int height) {
		this.name=name;
		this.id=id;
		this.height=height;
	}
	@Override
	public int compareTo(Student s) {
		// 숙제: 학생 키를 기준으로 크기 비교하는 코드를 작성해야 함 
		// 현재 학생(this)과 인자로 들어온 학생의 키를 비교해야 함
		// 현재 학생 키가 크면, +값, 현재 학생 키가 작으면, -값, 같으면 0을 리턴함 
		if(this.height>s.height)
			return 1;
		else if(this.height<s.height)
			return -1;
		else 
			return 0;
	}
	
	public String toString() {
		return "(학번:"+id+", 이름:"+name+", 키:"+height+")";
	}

	//getter 메소드 (속성값을 얻어가는 메소드)
	public int getHeight() { //get속성이름으로 메소드 이름 쓰기 
		return height;
	}

}
