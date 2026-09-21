class Solution {
    class Node{
        int value;
        int row;
        int col;
    
        Node(int value , int row , int col){
            this.value = value;
            this.row = row;
            this.col = col;

        }   
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> heap = new PriorityQueue<>((a,b) -> a.value - b.value);
        for(int row=0 ; row<matrix.length ; row++){
            heap.offer(new Node(matrix[row][0] , row , 0));
        }
        while(k>1){
            Node current = heap.poll();
            if(current.col + 1 < matrix[0].length){
                heap.offer(new Node(matrix[current.row][current.col+1] , current.row , current.col+1));
            }
            k--;
        }
        Node current=heap.poll();
        return current.value;
    }
    
}