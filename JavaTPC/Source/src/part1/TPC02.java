package part1;

public class TPC02 {

	public static void main(String[] args) {
		int a, b, c;

		a = 1;
		b = 1;
		c = a + b;

		System.out.println(c);

		float f; // float, double
		// java는 소수점을 기본으로 double로 인식
		// f = 34.5 컴파일 오
		f = 34.5f; // float형식이라 선언해줌 
		
		char d; 
		//char type은 ''로 묶어서 저장해야함  만약 ""로 묶으면 string으로 인
		d = 'A';
		
		boolean g;
		g = true;
		System.out.println(g);
	}

}
