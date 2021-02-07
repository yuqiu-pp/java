import java.math.BigDecimal;

public class Test {

    public static void main(String[] args) {
        // 使用 BigDecimal 表示和计算浮点数，且务必使用字符串的构造方法来初始化 BigDecimal：
        System.out.println(new BigDecimal("0.1").add(new BigDecimal("0.2")));
        System.out.println(new BigDecimal("1.0").subtract(new BigDecimal("0.8")));
        System.out.println(new BigDecimal("4.015").multiply(new BigDecimal("10.1")));
        System.out.println(new BigDecimal("123.3").divide(new BigDecimal("100")));
        // 只有Double时转化
        System.out.println(new BigDecimal("4.015").multiply(new BigDecimal(Double.toString(100))));
        System.out.println(new BigDecimal("4.015").multiply(BigDecimal.valueOf(10.1)));




        // 使用 BigDecimal 时有几个坑需要避开:仍然存在精度问题
        System.out.println(new BigDecimal(0.1).add(new BigDecimal(0.2)));
        System.out.println(new BigDecimal(1.0).subtract(new BigDecimal(0.8)));
        System.out.println(new BigDecimal(4.015).multiply(new BigDecimal(100)));
        System.out.println(new BigDecimal(123.3).divide(new BigDecimal(100)));


        System.out.println(0.1 + 0.2);
        System.out.println(1.0 - 0.8);
        System.out.println(4.015 * 100);
        System.out.println(123.3 / 100);

        double amount1 = 2.15;
        double amount2 = 1.10;
        if (amount1 - amount2 == 1.05)
            System.out.println("OK");


    }
}
