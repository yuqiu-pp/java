package ch06;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@TestAnnotation(Annotation.class)
public class TestAnnot {

    public static void main(String[] args) {
        TestAnnot testAnnot = new TestAnnot();
        Class testAnnotClass = testAnnot.getClass();

        TestAnnotation annotation = (TestAnnotation)testAnnotClass.getAnnotation(TestAnnotation.class);
        System.out.println(annotation);
        System.out.println(annotation.value());
    }
}
