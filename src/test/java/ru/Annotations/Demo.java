package ru.Annotations;

import org.testng.annotations.Test;

public class Demo {
    private class MyClass{
        @ru.Annotations.Test(expected = Test.class)
        public void function(){
            System.out.println("MyClass#function1");
        }
    }
    @Test
    public void TestMyAnnotation() throws Exception {
        new TestAnnotationAnalyzer().analyz(MyClass.class);
    }
}
