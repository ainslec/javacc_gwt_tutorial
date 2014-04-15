package org.consoli.javaccgwt.example1;

import org.consoli.javaccgwt.example1.parse.Parser;


public class Example1 {
	public static void main(String[] args) {

		try {
			Parser p = new Parser("one two three two one");
			p.parse();
			System.out.println("Parsed.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// TODO
		}

	}
}
