package test.grammer;

import java.util.Scanner;

public class NyanNyanHomework {
	public static void main(String[] args) {
		//System.out.println("do~while문 카페 주문 처리 시작 -----------");
		Scanner sc = new Scanner(System.in);

		String order;
		do {
			System.out.println("메뉴(아메리카노, 카페라떼, 카푸치노)중에서 주문(단, 주문안함 또는 stop)>");
			order = sc.nextLine();//"주문안함"

			if (order.equals("주문안함")) {
				break;
			}

			if (order.equals("stop")) {
				break;
			}

			switch (order) {
				case "아메리카노":
					System.out.println(order + "를 주문하셨습니다");
					break;
				case "아페라떼":
					System.out.println(order + "를 주문하셨습니다");
					break;
				case "카푸치노":
					System.out.println(order + "를 주문하셨습니다");
					break;
				case "stop":
					System.out.println("그만  주문하겠습니다");
					break;//switch문 빠져나감
				default:
					System.out.println("메뉴에 없습니다."); //break;
			}
			//
		} while (true);//[과제-1] stop을 제외한 4가지 경우는 조건문이 참, stop만 거짓
		System.out.println("do~while문 s카페 주문 처리 끝");

		sc.close(); // 스캐너 객체 더이상 사용안하면 닫아야함
	}
}
