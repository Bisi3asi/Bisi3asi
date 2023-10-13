class BinarySearch {
    public int method(int m, int[] arr) { // m : 탐색 목표 값, arr : 탐색할 배열
        // 탐색 목표값의 위치를 저장
        int answer = 0;
        // 탐색 범위를 설정하는 start, end
        // [초기값] start : 배열의 첫 인덱스, end : 배열의 끝 인덱스
        int start = 0, end = arr.length - 1;
        // while을 활용한 binary search
        while (start <= end) {
            // 1회전마다 변화된 start, end 에 따른 중간 값 재설정
            int mid = (start + end) / 2;
            // 중간 값 ==  목표 값 (탐색 성공)
            if (arr[mid] == m) {
                answer = mid + 1;
                break;
            }
            // 중간 값 != 목표값 (start, end 인덱스 이동해 탐색 범위 이분)
            else if (arr[mid] > m) end = mid - 1;
            else start = mid + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] arr = {1, 2, 3, 5, 6};
        int m = 5;
        System.out.println(bs.method(m, arr));

    }
}
