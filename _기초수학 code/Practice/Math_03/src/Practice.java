// Practice
// 약수 구하기, 두 수의 최대공약수와 최소공배수 구하기
// 활용) 1~10의 수 중 A의 약수 또는 B의 약수인 경우의 수
// 활용) 1~10의 수 중 A의 약수이면서 B의 약수인 경우의 수

import java.util.ArrayList;

public class Practice {
    
//  💎 약수 (나눠서 나머지가 발생하지 않는 수 ex. 4 = 1, 2, 4)
    public ArrayList getDivisor(int num) {
        ArrayList result = new ArrayList();

        for (int i = 1; i <= (int)num/2; i++) {
            // 절반으로 나눈이유 num이 6일 경우 1,2,3,6 인데 절반 이상의 값
            // 4, 5는 6과 나눠 떨어지지 않기때문에 num / 2를 해준다
            if (num % i == 0) {
                result.add(i);
            }
        }
        result.add(num); // 자기 자신도 넣어준다!

        return result;
    }

//  💎 최대 공약수 (4와 6의 최대공약수는 2 이다 [4 = 1, 2, 4] [6 = 1, 2, 3, 6] 중 공통된 약수의 제일 큰 수)
//  GCD: the Greatest Common Denominator
    public int getGCD(int numA, int numB) {
        int gcd = -1;

        // 1. 약수 구하기
        ArrayList divisorA = this.getDivisor(numA);
        ArrayList divisorB = this.getDivisor(numB);

        // 2. 최대공약수 구하기
        for (int itemA: (ArrayList<Integer>)divisorA) {
            for (int itemB: (ArrayList<Integer>)divisorB) {
                if (itemA == itemB) { // 공통된 약수 찾기
                    if (itemA > gcd) { // gcd변수에 최대공약수 넣기
                        gcd = itemA;
                    }
                }
            }
        }

        return gcd;
    }

//  💎 최소 공배수 (4의 배수 4, 8, 12 ... 6의 배수 6, 12, 18 ... 공통된 배수 중 가장 작은수 12)
//  최소 공배수 쉽게 구하는 법 ex) 4와 6의 최대 공약수를 구하고(2), 4와 6을 곱하고(24) 24 나누기 2를 한다
//  LCM: the Lowest Common Multiple
    public int getLCM(int numA, int numB) {
        int lcm = -1;

        int gcd = this.getGCD(numA, numB); // 최대공약수

        if (gcd != -1) {
            lcm = numA * numB / gcd;
        }

        return lcm;
    }

    public static void main(String[] args) {

//      Test code
        int number1 = 10;
        int number2 = 6;

        Practice p = new Practice();
        ArrayList l1 = p.getDivisor(number1);   // 10: 1, 2, 5, 10
        ArrayList l2 = p.getDivisor(number2);   // 6: 1, 2, 3, 6
        System.out.println("l1 = " + l1);
        System.out.println("l2 = " + l2);

        System.out.println("최대 공약수: " + p.getGCD(number1, number2));
        System.out.println("최소 공배수: " + p.getLCM(number1, number2));
    }
}
