package utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {

    public static void inspectClass(Class<?> clazz) {
        System.out.println("\n=== REFLECTION INFO ===");
        System.out.println("Class: " + clazz.getName());

        System.out.println("\nFields:");
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            System.out.println("- " + f.getType().getSimpleName() + " " + f.getName());
        }

        System.out.println("\nMethods:");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println("- " + m.getName());
        }
    }
}

