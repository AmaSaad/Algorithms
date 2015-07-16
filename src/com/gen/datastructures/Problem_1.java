package com.gen.datastructures;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem_1 {
	public static final String fileDir = Constants.folderDir + "Problem_1";

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream(fileDir));
		while (sc.hasNext()) {
			System.out.println(sc.nextLine());

		}

		sc.close();
	}

}
