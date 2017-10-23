package XML解析;

public class Person {
	
	private int age;
	private String name;
	private int id;
	
	public Person(){}
	
	public Person(String name, int age, int id) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", id=" + id + "]";
	}

}
