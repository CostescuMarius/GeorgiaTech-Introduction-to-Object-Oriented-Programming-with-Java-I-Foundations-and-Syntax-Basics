public class StringOperations {
    
	//TODO: Start your code after this line
	public static void main(String[] args) {
		String name = "Marius";
		System.out.println(name);

		name = name.replace('M', 'A');
		name = name.replace('s', 'Z');
		System.out.println(name);

		String URL = "www.facebook.com";
		System.out.println(URL);

		String nameURL = URL.substring(4, URL.length() - 4);
		System.out.println(nameURL);
	}
}