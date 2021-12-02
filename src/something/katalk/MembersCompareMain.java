package something.katalk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MembersCompareMain {
	private static List<String> MembersA;
	private static List<String> MembersB;
	private static List<String> MembersSame;

	public static void main(String[] args) {
		long s1 = System.currentTimeMillis();
		MembersA = getMebers(1_000);
		MembersB = getMebers(1_000_000);
		MembersSame = new ArrayList<>();
		long s2 = System.currentTimeMillis();
		System.out.println("객체 생성시간 (초) = " + (s2 - s1) / 1000.0);
		System.out.println("MembersA = " + MembersA.size());
		System.out.println("MembersA = " + MembersB.size());
		long s3 = System.currentTimeMillis();
		// compareByForStatesments2Layers();
		compareByMap();
		long s4 = System.currentTimeMillis();
		System.out.println("비교시간 (초)= " + (s4 - s3) / 1000.0);

	}

	private static void compareByMap() {
		Map<String, String> map = new HashMap<>();
		for (String memberA : MembersA) {
			map.put(memberA, memberA);
		}
		for (String memberB : MembersB) {
			String sameMember = map.get(memberB);
			MembersSame.add(sameMember);
		}
	}

	private static void compareByForStatesments2Layers() {
		for (String memberA : MembersA) {
			for (String memberB : MembersB) {
				if (memberA.equals(memberB)) {
					MembersSame.add(memberA);
				}
			}
		}
	}

	private static List<String> getMebers(int groupSize) {
		List<String> Members = new ArrayList<>();
		for (int i = 0; i < groupSize; i++) {
			Members.add(getMemberName());
		}
		return Members;
	}

	private static String getMemberName() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			char alphabet = getAlphabet();
			sb.append(alphabet);
		}
		return sb.toString();
	}

	private static char getAlphabet() {
		return (char)('A' + new Random().nextInt('Z' + 1 - 'A'));
	}
}
