package something.VendingMachine;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineMain {

	/**
	 * 자판기 돈벌기
	 * 밸리데이션
	 */

	public static void main(String[] args) {
		VendingMachine vendingMachine = new VendingMachine(0, 10, 10, 10);
		User user = new User(10000);

		user.buy(vendingMachine, BEVERAGE.COCA_COLA, 2);
		user.buy(vendingMachine, BEVERAGE.MIX_COFFE, 3);
		user.buy(vendingMachine, BEVERAGE.BANANA_MILK, 4);

		System.out.println("사람 잔여액수 = " + user.getMoney());
		System.out.println("자판기 수입 = " + vendingMachine.getMoney());

		user.buy(vendingMachine, BEVERAGE.COCA_COLA, 1);
	}

	private static class VendingMachine {
		private int money;
		private Map<BEVERAGE, Integer> classifier;

		public VendingMachine(int money, int cocaColaStock, int mixCoffeStock, int bananaMilkStock) {
			money = 0;
			initMap(cocaColaStock, mixCoffeStock, bananaMilkStock);
		}

		public int getMoney() {
			return money;
		}

		private void initMap(int cocaColaStock, int mixCoffeStock, int bananaMilkStock) {
			classifier = new HashMap<>();
			classifier.put(BEVERAGE.COCA_COLA, cocaColaStock);
			classifier.put(BEVERAGE.MIX_COFFE, mixCoffeStock);
			classifier.put(BEVERAGE.BANANA_MILK, bananaMilkStock);
		}

		public void buy(BEVERAGE beverage, int drinksNumber) {
			int beveragePrice = beverage.getPrice();
			Integer beverageNumber = classifier.get(beverage);
			classifier.replace(beverage, beverageNumber - drinksNumber);
			money += (beveragePrice * drinksNumber);
		}
	}

	private static class User {
		private int money;

		public User(int money) {
			this.money = money;
		}

		public int getMoney() {
			return money;
		}

		public void buy(VendingMachine vendingMachine, BEVERAGE beverage, int drinksNumber) {
			System.out.println("음료수를 삽니다! 음료:" + beverage + ", 수량: " + drinksNumber);
			validateBuying(beverage, drinksNumber);
			vendingMachine.buy(beverage, drinksNumber);
			money -= (beverage.getPrice() * drinksNumber);
			System.out.println("잔여 액수:  = " + money);
		}

		private void validateBuying(BEVERAGE beverage, int drinksNumber) {
			int beveragePrice = beverage.getPrice();
			if (money < beveragePrice * drinksNumber) {
				int needMoney = beveragePrice * drinksNumber - money;
				throw new IllegalArgumentException("음료수를 사기엔 금액이 부족합니다 ! " + needMoney);
			}
		}
	}

	enum BEVERAGE {
		COCA_COLA("코카 콜라", 1500),
		MIX_COFFE("라떼는 말야", 700),
		BANANA_MILK("바나나는 원래 하얘", 1200);

		private final String name;
		private final int price;

		BEVERAGE(String name, int price) {
			this.name = name;
			this.price = price;
		}

		public int getPrice() {
			return price;
		}
	}
}
