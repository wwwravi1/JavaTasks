package com.string;

public class DuplicateCharcters {

	public static void main(String[] args) {

		System.out.println(stringWithoutDuplicates("harsha"));
	}

	private static String stringWithoutDuplicates(String name) {
		int i = 0;
		char[] endResult = new char[name.length()];
		boolean[] result = new boolean[256];

		for (char ch : name.toCharArray()) {
			if (result[ch] == true) {

			} else {
				result[ch] = true;
				endResult[i] = ch;
				i++;
			}
		}
		return new String(endResult);
	}

}
