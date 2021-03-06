package chapters15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileReaderEx2 {					//한글 파일을 불러오는 것

	public static void main(String[] args) throws IOException{
		InputStreamReader in = null;
		FileInputStream fin = null;
		int input;
		
		fin = new FileInputStream("C:\\김준일강사수업\\웹개발210512\\java\\박지호 8841\\src\\chapters15\\hangul.txt");
		in = new InputStreamReader(fin, "UTF-8");
		
		BufferedReader rin = new BufferedReader(in);
		
		System.out.println("인코딩 문자 집합은 " + in.getEncoding());
		while((input = rin.read()) != -1) {
			System.out.print((char)input);
		}
		in.close();
		fin.close();
		
		Scanner sc = new Scanner(System.in);
		FileWriter fout = null;
		int output;
		
		fout = new FileWriter("C:\\김준일강사수업\\웹개발210512\\java\\박지호 8841\\src\\chapters15\\hangul.txt");
		while(true) {
			String line = sc.nextLine();
			if(line.length() == 0) {
				break;
			}
			fout.write(line, 0 , line.length()); 	//라인의 0번째 부터 끝까지 write해라
			fout.write("\r\n", 0, 2); 				//한줄 띄우기
		}
		fout.close();
		sc.close();
	}

}
