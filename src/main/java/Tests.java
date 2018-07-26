import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Tests {

    public static void start(Class o) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = o.getMethods();
        int countBefore = 0;
        int countAfter = 0;
        for (Method method : methods) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                if (countBefore > 1) {
                    throw new RuntimeException();
                }
                countBefore += 1;
                method.setAccessible(true);
                method.invoke(o);
            }
        }

        for (Method method : methods) {
            if (method.getAnnotation(Test.class) != null) {
                method.setAccessible(true);
                method.invoke(o);
            }
        }

        for (Method method : methods) {
            if (countAfter > 1) {
                throw new RuntimeException();
            }
            if (method.getAnnotation(AfterSuite.class) != null) {
                countAfter += 1;
                method.setAccessible(true);
                method.invoke(o);
            }

        }
    }

    public static void start(String className) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Class o = Class.forName(className);
        Method[] methods = o.getMethods();
        int countBefore = 0;
        int countAfter = 0;
        for (Method method : methods) {
            if (countBefore > 1) {
                throw new RuntimeException();
            }
            if (method.getAnnotation(BeforeSuite.class) != null) {
                countBefore += 1;
                method.setAccessible(true);
                method.invoke(o);
            }
        }

        for (Method method : methods) {
            if (method.getAnnotation(Test.class) != null) {
                method.setAccessible(true);
                method.invoke(o);
            }
        }
        for (Method method : methods) {
            if (countAfter > 1) {
                throw new RuntimeException();
            }

            if (method.getAnnotation(AfterSuite.class) != null) {
                countAfter +=1;
                method.setAccessible(true);
                method.invoke(o);
            }
        }

    }
}