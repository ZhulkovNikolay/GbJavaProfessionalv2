import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Tests {

    public static void start(Class o) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = o.getMethods();
        for (Method method : methods) {
            if (method.getAnnotation(Test.class) != null) {
                method.setAccessible(true);
                method.invoke(o);
            }
        }
    }

    public static void start(String className) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Class o = Class.forName(className);
        Method[] methods = o.getMethods();
        for (Method method : methods) {
            if (method.getAnnotation(Test.class) != null) {
                method.setAccessible(true);
                method.invoke(o);
            }
        }
    }
}