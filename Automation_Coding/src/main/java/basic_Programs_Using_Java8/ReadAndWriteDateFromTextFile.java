package basic_Programs_Using_Java8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.function.Consumer;

public class ReadAndWriteDateFromTextFile {

	// Approach 1 using filereader and bufferedReader

	static Consumer<String> readUsingFileReader = (path) -> {
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			String str = "";
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	};

	static Consumer<String> readUsingScannerClass = (path) -> {
		try {
			Scanner sc = new Scanner(new File(path));
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	};

	static Consumer<String> readUsingScannerClassAndDelimiter = (path) -> {
		try {
			Scanner sc = new Scanner(new File(path));
			sc.useDelimiter("\\Z");
			System.out.println(sc.next());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	};

	static Consumer<String> writeUsingFileReader = (path) -> {
		try {
			FileWriter fr = new FileWriter(path);
			BufferedWriter br = new BufferedWriter(fr);
			br.flush();
			br.write("Hi Sharath,Welcome\n");
			br.write("Happy Learning");
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	};

	public static void main(String[] args) {

		String path = "src\\main\\resources\\Test.txt";
		String writePath = "src\\main\\resources\\TestWrite.txt";
		readUsingFileReader.accept(path);
		readUsingScannerClass.accept(path);
		readUsingScannerClassAndDelimiter.accept(path);
		System.out.println("======================");
		writeUsingFileReader.accept(writePath);
		readUsingFileReader.accept(writePath);

	}

}
