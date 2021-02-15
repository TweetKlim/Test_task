package com.test_tasks.task3;

public class Main {

    public static void main(String[] args) {
        String[][] matrix  = {
            {"1","2","3","4","3"},
            {"1","2","g","4"},
            {"1","2","3","4"},
            {"1","2","3","4"}};
        System.out.println(sumOfStringMatrix(matrix));

    }
    private static int sumOfStringMatrix(String[][] matrix){
        if(matrix.length != 4){
            throw new MyArraySizeException();
        }
        int sum = 0;
        for (int i = 0; i < 4; ++i){
            if(matrix[i].length != 4){
                throw new MyArraySizeException();
            }
            for(int j = 0; j < 4; ++j){
                try{
                   sum += Integer.valueOf(matrix[i][j]);
                }   catch (NumberFormatException e)
                {
                    throw new MyArrayDataException(i,j);
                }

            }
        }
        return sum;
    }
}
