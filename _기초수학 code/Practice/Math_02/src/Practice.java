// Practice
// ArrayList를 사용한 집합 구현 실습 (집합 관련 연산 사용 X)

import java.util.ArrayList;

class MySet {
// ArrayList
    ArrayList<Integer> list;

// 생성자1
    MySet() {
        this.list = new ArrayList<Integer>();
    }

// 생성자 2
    MySet(int[] arr) {
        this.list = new ArrayList<Integer>();

        for (int item : arr) {
            this.list.add(item);
        }
    }

// 원소 추가 (중복 X)
    public void add(int x) {
        for (int item : this.list) {
            if (item == x) { // 중복되는게 있으면 그냥 리턴해라 라는 뜻
                return;
            }
        }
        this.list.add(x);
    }


// 교집합
    public MySet retainAll(MySet b) {
        MySet result = new MySet(); // 반환을 위한 MySet 자료형 result를 만듬

        for (int itemA : this.list) { // 자기 자신을 순회하고
            for (int itemB : b.list) { // 새로 들어온 집합도 순회한다
                if (itemA == itemB) { // 같은 데이터만
                    result.add(itemA); // result에 넣는다
                }
            }
        }
        return result;
    }


// 합집합
    public MySet addAll(MySet b) {
        MySet result = new MySet();

        for (int itemA : this.list) {
            result.add(itemA);
        }

        for (int itemB : b.list) {
            result.add(itemB);
        }
        return result;
    }


// 차집합
    public MySet removeAll(MySet b) {
        MySet result = new MySet(); // 반환을 위한 새로운 자료형

        for (int itemA : this.list) {
            boolean containFlag = false;

            for (int itemB : b.list) {
                if (itemA == itemB) {
                    containFlag = true;
                    break;
                }
            }

            if (!containFlag) { // false면 true가 돼서 실행이됨
                result.add(itemA);
            }

        }

        return result;
    }

}

public class Practice {
    public static void main(String[] args) {

//      Test code
        MySet a = new MySet();

        a.add(1);
        a.add(1);
        a.add(1);
        System.out.println(a.list);
        a.add(2);
        a.add(3);
        System.out.println(a.list);

        a = new MySet(new int[]{1, 2, 3, 4, 5});
        MySet b = new MySet(new int[]{2, 4, 6, 8, 10});
        System.out.println("a: " + a.list);
        System.out.println("b: " + b.list);

        MySet result = a.retainAll(b);
        System.out.println("교집합: " + result.list);

        result = a.addAll(b);
        System.out.println("합집합: " + result.list);

        result = a.removeAll(b);
        System.out.println("차집합: " + result.list);
    }
}
