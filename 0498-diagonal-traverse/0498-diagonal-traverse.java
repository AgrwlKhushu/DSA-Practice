class Solution {
    public int[] findDiagonalOrder(int[][] mat) {

        if(mat.length == 1){
            return mat[0];
        }

        int total = mat.length*mat[0].length; 

        int[] ret = new int[total];

        ret[0] = mat[0][0];
        
        if(mat[0].length == 1){
            for(int i=1; i<mat.length; i++){
                ret[i] = mat[i][0];
            }
            return ret;
        }

        int count = 1;
        int i = 0; int j=1;
        boolean downLeft = true;

        while(count < total){
            if(downLeft){
                while(j>0 && i<mat.length-1){
                    ret[count] = mat[i][j];
                    count++;
                    i++;
                    j--;
                }

                ret[count] = mat[i][j];
                count++;                

                if(i<mat.length-1){
                    i++;
                }else{
                    j++;
                }
                downLeft = false;
            }else{
                while(i>0 && j<mat[0].length-1){
                    ret[count] = mat[i][j];
                    count++;
                    i--;
                    j++;
                }

                ret[count] = mat[i][j];
                count++;

                if(j<mat[0].length-1){
                    j++;
                }else{
                    i++;
                }

                downLeft = true;
            }
        }

        return ret;
    }
}