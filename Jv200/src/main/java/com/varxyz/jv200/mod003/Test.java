package com.varxyz.jv200.mod003;

public class Test {
	public static boolean isSubString(String item, String line) {
		String str = "";
		if(item.length() > line.length()) { // 만약 검색할 item의 길이가 line의 길이보다 길다면
			return false;
		}
		for(int i = 0; i < line.length(); i++) { // line의 처음부터 끝까지 for문으로 확인
			if(item.charAt(0) == line.charAt(i)) { // 만약 item의 첫글자와 line의 i번째 글자가 같다면
				str += line.charAt(i); // 변수 str에 넣기
				System.out.println("첫번째 글자 : " + str);
				if(item.length() > 1) { // 만약 찾으려는 item의 글자수가 한글자 이상이라면
					for(int j = 1; j < item.length(); j++) { // item의 1번째 인덱스 글자부터 끝까지 확인
						if(item.charAt(j) == line.charAt(i + j)) { // item의 j번째(1이상) 글자와 line의 i+j번째 글자가 같다면
							str += line.charAt(i + j); // str에 넣기
						} else { // 같지 않다면 찾던 item이 아니므로 for문 빠져나와 다시 첫글자부터 찾기
							break;
						}
					}
					System.out.println("str : " + str);
					if(item.equals(str)) { // 만약 찾으려는 item과 찾아낸 str이 같다면 
						return true; // true
					} else { // 같지 않다면
						str = ""; // 변수 str을 비우고
						continue; // 다시 첫글자부터 찾기
					}
				} else { // 찾으려는 item의 글자수가 한자리 글자라면
					return true; // true
				}
			} else { // item의 첫글자와 line의 i번째 글자가 같지 않다면 다음 인덱스로 넘어가기
				continue;
			}
		}
		return false; // 찾으려는 item이 line에 없다면 false
	}
	public static void main(String[] args) {
		System.out.println(isSubString("hat", "The cat in the hat"));
	}
}
