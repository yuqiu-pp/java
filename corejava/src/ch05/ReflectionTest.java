package ch05;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ReflectionTest {

    public static void main(String[] args) {
        String name;
        if (args.length > 0){
            name = args[0];
        }else {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name(e.g. java.util.Date):");
            // name = in.next();
            name = "java.lang.Double";
        }


        try {
            // print class name and superclass name
            Class cls = Class.forName(name);
            Class supercls = cls.getSuperclass();
            String modifiers = Modifier.toString(cls.getModifiers());
            if (modifiers.length() > 0){
                System.out.print(modifiers + " ");
            }
            System.out.print("class " + name);

            if (supercls!=null && supercls!=Object.class){
                System.out.print(" extends " + supercls.getName());
            }
            System.out.print("\n{\n");

            printConstructors(cls);

            printMethods(cls);

            printFields(cls);




        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void printFields(Class cls){
        Field[] fields = cls.getDeclaredFields();

        for (Field f : fields){
            Class type = f.getType();
            String name = f.getName();
            System.out.print("   ");

            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0){
                System.out.print(modifiers + " ");
            }
            System.out.println(type.getName() + " " + name + ";");
        }
    }


    public static void printMethods(Class cls){
        Method[] methods = cls.getDeclaredMethods();

        for (Method m : methods){
            Class retType = m.getReturnType();
            String name = m.getName();
            System.out.print("   ");

            // print modifiers/return type/method name
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0){
                System.out.print(modifiers + " ");
            }
            System.out.print(retType.getName() + " " + name + "(");

            // print parameter
            Class[] params = m.getParameterTypes();
            for (Class p : params){
                System.out.print(p.getName() + ", ");
            }
            System.out.print(");\n");
        }
        System.out.println();
    }


    public static void printConstructors(Class cls){
        Constructor[] constructors = cls.getConstructors();

        for (Constructor c: constructors){
            String name = c.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0){
                System.out.print(modifiers + " ");
            }
            System.out.print(name + "(");

            // print parameter types
            Class[] paramTypes = c.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0){
                    System.out.print(", ");
                }
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
        System.out.println();
    }
}
