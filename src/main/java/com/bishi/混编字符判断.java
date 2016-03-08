package com.bishi;

import org.junit.Test;

/**
 * Created by MENGHUCHENG012 on 2016/3/4.
 * @author mhc
 *    A、B和C。如果C包含且仅包含来自A和B的所有字符，而且在C中属于A的字符之间保持原来在A中的顺序，属于B的字符之间保持原来在B中的顺序，那么称C是A和B的混编。实现一个函数，判断C是否是A和B的混编。
 *   给定三个字符串A,B和C，及他们的长度。请返回一个bool值，代表C是否是A和B的混编。保证三个串的长度均小于等于100。
 *   测试样例：
 *  "ABC",3,"12C",3,"A12BCC",6
 *   返回：true
 */
public class 混编字符判断 {

    public boolean chkMixture(String A,int n,String B,int m,String C,int v){
        //判断长度是否正确
        if(n+m  != v){
            return false;
        }
        int x=0,y=0;
        int aMatch=0,bMatch=0;
        for (int i = 0; i < v; i++) {
            if(x<n && A.charAt(x)==C.charAt(i)){
                System.out.println("比较字符:"+A.charAt(x)+"=="+C.charAt(i));
                ++x;
                ++aMatch;
//                ++i;
            }
            else if(y<m && B.charAt(y)==C.charAt(i)){
                System.out.println("比较字符:"+B.charAt(y)+"=="+C.charAt(i));
                ++y;
                ++bMatch;
//                ++i;
            }
        }
            /*当出现C[i] == A[j] && C[i] == B[k]时，aMatch,bMatch都会
            自加1，相当于提前将C[x]这个匹配值用了，等比较到C[x]!= A[j] && C[x]
                    != B[k]时，都不自加也没关系，结果是aMatch == n && bMatch == m；可是
                    如果：C不是A和B的混排这种情况，C[y] != A[j] && C[y] != B[k]，
                    aMatch和bMatch都不会自加1，反应到结果上aMatch < n | bMatch < m。
                    */
        if(n == aMatch && m==bMatch){
            System.out.println("是混编字符");
            return true;
        }else {
            System.out.println("不是混编字符");
        }
        return false;
    }
    @Test
    public void Test(){
//            chkMixture("bcbccabccacccbcac",17,"abbbacaabccbccaaaabbcbcbaaacccbaaba",35,"babbbacaabccbccaaaabbcbcbaaacccbaabacbccabccacccbcac",52);
        System.out.println(chkMixture("abcd",4,"mnce",4,"abmncdey",8));
//        System.out.println(chkMixture("ac",2,"mnce",4,"acmnce",6));
    }

}
