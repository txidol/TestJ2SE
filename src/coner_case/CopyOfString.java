package coner_case;

public class CopyOfString {
	public static void main(String[] args) {
		String a = "Version\\: V1.0.7";

		a = a.substring(a.lastIndexOf("V"), a.length());
		System.out.println(a);
	}
}
