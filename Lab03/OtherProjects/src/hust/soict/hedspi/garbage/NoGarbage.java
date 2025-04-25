package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
	public static void main(String[] args) throws IOException {
		String filename = "C:\\Users\\An\\Documents\\eclipse_workspace\\OtherProjects\\src\\test.txt" ;
		byte[] inputBytes = { 0 };
		long startTime, endTime;

		inputBytes = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(filename));
		startTime = System.currentTimeMillis();
		StringBuilder outputStringBuilder = new StringBuilder();
		for (byte b : inputBytes) {
			outputStringBuilder.append(Character.toString((char) b));
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		System.out.println(outputStringBuilder.toString());
	}
}
