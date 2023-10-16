// 기초 수학 - 집합

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

//      1. 자바에서 집합 사용 - HashSet
        // Set은 중복된 값은 들어가지 않는다
        System.out.println("== HashSet ==");
        HashSet set1 = new HashSet();
        set1.add(1);
        set1.add(1);
        set1.add(1);
        System.out.println("set1 = " + set1);
        set1.add(2);
        set1.add(3);
        System.out.println("set1 = " + set1);
        set1.remove(1);
        System.out.println("set1 = " + set1);
        System.out.println(set1.size());
        System.out.println(set1.contains(2));
        

//      2. 집합 연산
        System.out.println("== 집합 연산 ==");

//      2-1. 교집합
        // 두개의 집합 만듬
        HashSet a = new HashSet(Arrays.asList(1, 2, 3, 4, 5));
        HashSet b = new HashSet(Arrays.asList(2, 4, 6, 8, 10));
        a.retainAll(b); // 교집합을 얻기 위해서는 retainAll 함수를 사용
        // a변수에는 교집합된 변수들만 남게된다
        System.out.println("교집합: " + a);

//      2-2. 합집합
        HashSet c = new HashSet(Arrays.asList(1, 2, 3, 4, 5));
        HashSet d = new HashSet(Arrays.asList(2, 4, 6, 8, 10));

        c.addAll(d); // 합집합은 addAll 함수를 사용한다
        System.out.println("합집합: " + c);

//      2-3. 차집합
        // 차집합이란, e에만 있는 수를 걸러내는것 f에있는건 제외한다 1, 3, 5
        HashSet e = new HashSet(Arrays.asList(1, 2, 3, 4, 5));
        HashSet f = new HashSet(Arrays.asList(2, 4, 6, 8, 10));

        e.removeAll(f);
        System.out.println("차집합: " + e);

    }

}
