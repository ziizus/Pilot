package ru.ziizus.annotations;



import java.lang.reflect.Method;
import java.util.Arrays;

public class TestAnnotationAnalyzer {
    public void analyz(Class<?> clazz) throws Exception {
        Method[] methods = clazz.getMethods();
        int pass = 0;
        int fail = 0;
        Arrays.stream(methods).forEach( (x) -> {
            System.out.println("methodName=" + x + ", " + x.isAnnotationPresent(Test.class));
        });
        System.out.println("---");

        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                // Получаем доступ к атрибутам
                System.out.println(method);

                Test test = method.getAnnotation(Test.class);
                Class expected = test.expected();
                try {
                    method.invoke(null);
                    pass++;
                } catch (Exception e) {
                    if (Exception.class != expected) {
                        fail++;
                    } else {
                        pass++;
                    }
                }
            }
        }
    }
}