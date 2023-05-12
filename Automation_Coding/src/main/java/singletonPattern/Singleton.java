package singletonPattern;

public class Singleton {

	// Singleton class is one which should have only one instance, so therefore
	// restricting object creation in other class (sub class)
	// We declare constructor as private in singleton class

	private static Singleton obj = new Singleton();
	

	private Singleton() {

	}

	public static Singleton getInstance() {
		return Singleton.obj;
	}
	
	public static void main(String[] args) {
		System.out.println(obj);
	}

}

class B {

//	Singleton obj2 = new Singleton();   // This is not possible as new keyword will call singleton class default constructor which is public 
	// Now default constructor was changed to private so object creation is
	// restricted.
//	Only we can make use of Object which is already present in singleton class with getInstance method
	Singleton obj2 = Singleton.getInstance();
	
	public static void main(String[] args) {
		System.out.println(new B().obj2);
	}
	

}