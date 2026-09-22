class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> answer = new ArrayList<>();

        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            heap.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        while (!heap.isEmpty() && answer.size() < k) {
            int[] current = heap.poll();

            int i = current[1];
            int j = current[2];

            answer.add(Arrays.asList(nums1[i], nums2[j]));

            if (j + 1 < nums2.length) {
                heap.offer(new int[]{
                    nums1[i] + nums2[j + 1],
                    i,
                    j + 1
                });
            }
        }

        return answer;
    }
}