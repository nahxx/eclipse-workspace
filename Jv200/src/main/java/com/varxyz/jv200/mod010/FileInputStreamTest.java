package com.varxyz.jv200.mod010;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		int totalBytes = 0; // 읽은 바이트 수
		try {
			try {
				fis = new FileInputStream("test.txt"); // 상대주소. (절대주소는 /가 앞에 붙어야 한다.) : 읽어들일 소스가 담긴 파일
				fos = new FileOutputStream("test_copy.txt"); // 복사한 소스가 담길 파일
				for(int readByte; (readByte = fis.read()) != -1;) { // FileInputStream은 더이상 긁을 내용이 없을 때 -1을 반환한다.
					fos.write(readByte);
					totalBytes++;
				}
			}finally {
				fos.close();
				fis.close();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("\n전체 바이트 수: " + totalBytes + " bytes.");
	}
}
