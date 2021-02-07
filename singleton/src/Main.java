public class Main {

    public static void main(String[] args) {
        System.out.println("singleton");

        HungrySingleTest();
        LazySingleTest();
        DoubleCheckLockSingleTest();
        StaticClassSingleTest();
        EnumSingleTest();
    }

    private static void EnumSingleTest() {
        EnumSingle.INSTANCE.doSomething();
    }

    private static void StaticClassSingleTest() {
        StaticClassSingle single01 = StaticClassSingle.getInstance();
        StaticClassSingle single02 = StaticClassSingle.getInstance();
        System.out.println(judgeTwoInstance("StaticClassSingleTest", single01, single02));
    }

    private static void HungrySingleTest() {
        HungrySingle single01 = HungrySingle.getInstance();
        HungrySingle single02 = HungrySingle.getInstance();
        System.out.println(judgeTwoInstance("HungrySingle", single01, single02));
    }

    private static void LazySingleTest() {
        LazySingle single01 = LazySingle.getInstance();
        LazySingle single02 = LazySingle.getInstance();
        System.out.println(judgeTwoInstance("LazySingle", single01, single02));
    }

    private static void DoubleCheckLockSingleTest() {
        DoubleCheckLockSingle single01 = DoubleCheckLockSingle.getInstance();
        DoubleCheckLockSingle single02 = DoubleCheckLockSingle.getInstance();
        System.out.println(judgeTwoInstance("DoubleCheckLock", single01, single02));
    }

    private static String judgeTwoInstance(String module, Object obj01, Object obj02) {
        if (obj01 == obj02) {
            return module + " - 是同一个实例";
        } else {
            return module + " - 不是同一个";
        }
    }

    // private static String judgeTwoInstance(Class clazz) {
    //     Object obj01 = clazz
    //     if (obj01 == obj02) {
    //         return module + " - 是同一个实例";
    //     } else {
    //         return module + " - 不是同一个";
    //     }
    // }
}
