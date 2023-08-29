package domain;

public class Member {

	private String name;
	private int age;
	
	public Member (String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return "会員：" + name + "（" + age + "歳）";
	}
}
