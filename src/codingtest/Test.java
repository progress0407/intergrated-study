package codingtest;

import static java.lang.System.out;

public class Test {

    static int[][] a = {
            {1,2},
            {3,4}
    };

    static int[][] b;

    public static void main(String[] args) {

        b = a.clone();

        b[0][0] = 100;

        out.println(a[0][0]);

        /*List<String> li1 = new ArrayList<>(Arrays.asList("a","b","c"));
        List<String> li2 = new ArrayList<>(Arrays.asList("1","2","c"));*/

//        List<String[][]> liArr = new ArrayList<>(Arrays.asList({
//                {"a","b","c"}, {"1","2","3"}
//        }));

        /*List<String[]> liArr =  new ArrayList<>();
        String[][] tempStr = {{"a","b","c"}, {"1","2","3"}};
        liArr.addAll(Arrays.asList(tempStr));
        liArr.stream().forEach(e->{
            Arrays.stream(e).forEach(out::println);
        });

        out.println("------------");
        for(int i=0; i<tempStr[0].length; i++) {
            String t = tempStr[1][i] + tempStr[0][i];
            out.println(t);
        }
        out.println("------------");

        String exampleArray[] =
                {"a1", "junk", "a2", "b1", "junk", "b2", "c1", "junk", "junk", "junk", "c2", "d1", "junk", "d2", "junk-n"};
        AtomicInteger counter = new AtomicInteger();
        Arrays.stream(exampleArray)
                .filter(s -> s.length() > 0)   // gets rid of blanks
                .filter(s -> !s.contains("junk"))
                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / 2))
                .values()
                .stream()
                .forEach(out::println);*/

    }
}
