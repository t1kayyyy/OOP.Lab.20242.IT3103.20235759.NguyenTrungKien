package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class NoGarbage {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		String filename="src/PhongBan.txt";
		byte[] inputBytes= {0};
		inputBytes = Files.readAllBytes(Paths.get(filename));
		StringBuilder sb = new StringBuilder();
		for(byte b: inputBytes) {
			sb.append((char)b);
		}
		System.out.println(System.currentTimeMillis()-start);
	}
}

