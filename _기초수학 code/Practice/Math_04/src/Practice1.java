// Practice1
// 1, 2, 3, 4 를 이용하여 세자리 자연수를 만드는 방법 (순서 O, 중복 x)의 각 결과를 출력하시오
// 방법 1

public class Practice1 {
    void permutation(int[] arr, int depth, int n, int r) {

        if (depth == r) { // 3자리가 됐을때
            for (int i = 0; i < r; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }

    }

    void swap(int[] arr, int depth, int idx) {
        int tmp = arr[depth];
        arr[depth] = arr[idx];
        arr[idx] = tmp;
    }


    public static void main(String[] args) {
//      Test code
        int[] arr = {1, 2, 3, 4};

        Practice1 p = new Practice1();
        p.permutation(arr, 0, 4, 3);
        // n은 (1, 2, 3, 4) 4개를 나타내고, r은 세자리를 의미
        // depth는 각 자리수를 의미 0번째 1번째 2번째
    }
}
