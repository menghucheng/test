package com.test.BeanCopier;

import org.springframework.cglib.beans.BeanCopier;

/**
 * Created by MENGHUCHENG012 on 2016/3/14.
 */
public class Main {

    public static void main(String[] args) {
        Student stu = new Student();
        stu.setAge(11);
        stu.setName("你好");
        BeanCopier beanCopier = BeanCopier.create(Student.class,Teacher.class
                ,false);
        Teacher teacher = new Teacher();
        beanCopier.copy(stu,teacher,null);
        System.out.println(teacher);

        System.out.println("==============");


        //属性名一样但是类型不一样，不能拷贝，int和Integer不能拷贝
        beanCopier = BeanCopier.create(Student.class,People.class
                ,false);
        People people = new People();
        beanCopier.copy(stu,people,null);
        System.out.println(people);


        /**
         * 总结：

         1. BeanCopier只拷贝名称和类型都相同的属性。

         2. 当目标类的setter数目比getter少时，创建BeanCopier会失败而导致拷贝不成功。
         */

    }
}
