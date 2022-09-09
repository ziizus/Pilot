package ru.ziizus.annotations;

import org.testng.annotations.Test;

public class Demo {
    private class MyClass{
        @ru.ziizus.annotations.Test(expected = Test.class)
        public void function(){
            System.out.println("MyClass#function1");
        }
    }
    @Test
    public void TestMyAnnotation() throws Exception {
        new TestAnnotationAnalyzer().analyz(MyClass.class);
    }
}
