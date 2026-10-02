class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int []> queue = new LinkedList<>();
        int fresh = 0;

        for(int i =0 ; i<row; i++){
            for(int j =0 ; j<col ; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});

                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int minutes = 0;
        int[][] direction = {{1,0} , {-1,0} , {0,-1} , {0,1}};
        while(!queue.isEmpty() && fresh>0){
            int size = queue.size();
            
            for(int i = 0; i<size ; i++){   
                int [] current = queue.poll();
                for(int[] dir : direction){
                    int nextrow = current[0] + dir[0];
                    int nextcol = current[1] + dir[1];

                    if(nextrow<row && nextrow>=0 && nextcol<col && nextcol>=0 && grid[nextrow][nextcol] == 1){
                        grid[nextrow][nextcol] = 2;
                        fresh--;
                        queue.add(new int[]{nextrow , nextcol});
                    }
                }

            }
            minutes++;

        }

        return fresh == 0 ? minutes : -1;
    }
}