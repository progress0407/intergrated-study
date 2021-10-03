package codingtest;

import java.util.*;

public class HashTableMain {

    private Map<Integer, List<String>> indexTable = new HashMap<>();

    /*public HashTableMain() {
        this.indexTable.put(0, null);
        this.indexTable.put(1, null);
        this.indexTable.put(2, null);
    }*/

    public static void main(String[] args) {
        HashTableMain hashFunc = new HashTableMain();
        hashFunc.save("ABC");
        hashFunc.save("abc");
        hashFunc.save("cho");
        hashFunc.save("seong");
        hashFunc.save("woo");

        System.out.println("indexTable.values() = " + hashFunc.indexTable.values());

        System.out.println("hashFunc.find(\"seong\") = " + hashFunc.find("seong"));
        System.out.println("hashFunc.find(\"batman\") = " + hashFunc.find("batman"));
    }

    public String find(String name) {
        int index = getIndexByName(name);
        System.out.println("index = " + index);

        List<String> targetList = this.indexTable.get(index);
        if (targetList != null) {
            String findName = targetList.stream().filter(n -> n.equals(name)).findFirst().orElse(null);
            System.out.println("findName = " + findName);
            return findName;
        }

        return null;
    }

    public int save(String name) {
        int index = getIndexByName(name);
        if (indexTable.get(index) == null) {
            LinkedList<String> list = new LinkedList<>();
            list.add(name);
            indexTable.put(index, list);
        }
        else {
            indexTable.get(index).add(name);
        }

        System.out.println("index = " + index);
        return index;
    }

    private int getIndexByName(String name) {
        int sum = 0;
        for (char c : name.toCharArray()) {
//            System.out.printf("c : %c | %d \n", c, (int)c);
            sum += (int) c;
        }
        int index = sum % 3;
        return index;
    }

}
