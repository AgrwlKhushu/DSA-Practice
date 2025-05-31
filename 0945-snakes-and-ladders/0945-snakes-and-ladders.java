class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int endPos = n*n;

        short[] brd = new short[endPos+1];
        int brdPos = 1;
    
        for(int row=n-1;row>=0;row--){
            for(int col=0;col<n;col++){
                brd[brdPos++]= (short) board[row][col];
            }
            if(--row <0) { break;}
            for(int col=n-1;col>=0;col--){
                brd[brdPos++]=(short) board[row][col];
            }
        }

        short[] bfsQ = new short[n*n];
        int bfsQRead=0, bfsQWrite=0;
        bfsQ[bfsQWrite++]=1;
        int[] moves = new int[endPos+1];
        moves[1] = 1;

        while(bfsQRead!=bfsQWrite){
            int currPos = bfsQ[bfsQRead++];
            bfsQRead %= endPos;

            if(currPos + 6 >= endPos ){
                return moves[currPos];
            }
            int maxMove = 0;
            for(int diceRoll=6;diceRoll>=1;diceRoll--){
                int nextPos = currPos + diceRoll;

                if(brd[nextPos]>=0){
                    nextPos = brd[nextPos];
                    if(nextPos==endPos){
                        return moves[currPos];
                    }
                }else{
                    if(diceRoll < maxMove){
                        continue;
                    }
                    maxMove = diceRoll;
                }

                if(moves[nextPos]==0){
                    moves[nextPos]= moves[currPos]+1;
                    bfsQ[bfsQWrite++]=(short) nextPos;
                    bfsQWrite %= endPos;

                    if(bfsQRead==bfsQWrite){
                        return 0;
                    }
                }
            }

        }

        return -1;
    }
    
}