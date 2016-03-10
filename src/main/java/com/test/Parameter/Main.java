package com.test.Parameter;

/**
 * Created by MENGHUCHENG012 on 2016/3/10.
 */
public class Main {
    private static void change(Student student){
        student.setAge(12);
        student.setName("menghucheng");
    }

    public static void main(String[] args) {

        Student student = new Student();
        student.setName("蒙虎成");

        //改变前输出
        System.out.println(student);
        change(student);

        //改变后输出
        System.out.println(student);

        /**
         输出结果
         Student{age=0, name='蒙虎成'}
         Student{age=12, name='menghucheng'}
         */
    }
}
