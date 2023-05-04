package designpattern.singleton;

abstract class AbstractSingleton {

    private static ConcreteSingleton singleton;

    public static AbstractSingleton newInstance() {

        if (singleton == null) {
            singleton = new ConcreteSingleton();
        }

        return singleton;
    }

    public void introduceMe() {

        singleton.introduceMe();
    }

    public int createdNumberOfObjects() {

        return singleton.createdNumberOfObjects();
    }

    static class ConcreteSingleton extends AbstractSingleton {

        // 객체 생성 갯수
        private static int createdNumberOfObjects = 0;

        public ConcreteSingleton() {
            createdNumberOfObjects++;
        }

        public void introduceMe() {

            if (createdNumberOfObjects >= 2) {
                throw new RuntimeException("어이쿠 ! 제 자신이 두 개 생성돼 버렸네요... 이런 일은 있을 수 없는데!!");
            }
            String displayName = String.format("안녕 난 싱글톤이얌 ^^ 내가 생성된 갯수는 %d 야 \n" +
                    "만일 내가 2개 이상이라면 이 문장이 실행되지 않겠지?? ^^ \n", createdNumberOfObjects);

            System.out.print(displayName);
        }

        public int createdNumberOfObjects() {
            return createdNumberOfObjects;
        }
    }
}
