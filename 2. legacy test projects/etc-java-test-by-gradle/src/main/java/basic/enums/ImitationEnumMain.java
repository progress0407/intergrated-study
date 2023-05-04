package basic.enums;

public class ImitationEnumMain {

    public static void main(final String... args) {
        System.out.println("ImitationEnum.FOO = " + ImitationEnum.FOO);
        System.out.println("ImitationEnum.BOO = " + ImitationEnum.BOO);
    }
    
    static abstract class ImitationEnum {
        public static ImitationEnum FOO = new ImitationEnum("푸우") {
            @Override
            void doSomething() {
                System.out.println();
            }
        };
        
        public static ImitationEnum BOO = new ImitationEnum("뿌뿌") {
            @Override
            void doSomething() {
                System.out.println();
            }
        };
        
        
        private final String name;

        public ImitationEnum(String name) {
            this.name = name;
        }

        abstract void doSomething();
    }
}
