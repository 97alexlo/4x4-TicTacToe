package sample.logic;

public class gameLogic {

    public int checkDraw(int arr[][]) {
        int x = 0;
        for (int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(arr[i][j] == 1 || arr[i][j] == 2) {
                    x++;
                }
            }
        }
        if(x == 16) { // full gameboard
            return 16;
        }
        return 100;
    }

    public int checkRows(int arr[][]) {
        if(((arr[0][0] == arr[1][0]) && (arr[1][0]==arr[2][0])) && (arr[2][0] == arr[3][0])){
            if(arr[3][0] == 1 ){
                return 1;
            }
            else if(arr[3][0]==2){
                return 2;
            }
        }

        if(((arr[0][1]==arr[1][1])&&(arr[1][1]==arr[2][1]))&&(arr[2][1]==arr[3][1])){
            if(arr[0][1]==1){
                return 1;
            }
            else if(arr[0][1]==2){
                return 2;
            }
        }
        if(((arr[0][2]==arr[1][2])&&(arr[1][2]==arr[2][2]))&&(arr[2][2]==arr[3][2])){
            if(arr[0][2]==1){
                return 1;
            }
            else if(arr[0][2]==2){
                return 2;
            }
        }
        if(((arr[0][1]==arr[1][1])&&(arr[1][1]==arr[2][1]))&&(arr[2][1]==arr[3][1])){
            if(arr[1][1]==1){
                return 1;
            }
            else if(arr[1][1]==2){
                return 2;
            }
        }
        if(((arr[0][3]==arr[1][3])&&(arr[1][3]==arr[2][3]))&&(arr[2][3]==arr[3][3])){
            if(arr[0][3]==1){
                return 1;
            }
            else if(arr[0][3]==2){
                return 2;
            }
        }
        return 100;
    }

    public int checkCols(int arr[][]) {
        if(((arr[0][0] == arr[0][1]) && (arr[0][1] == arr[0][2])) && (arr[0][2] == arr[0][3])) {
            if(arr[0][2] == 1) {
                return 1;
            }
            else if(arr[0][2] == 2) {
                return 2;
            }
        }
        if(((arr[1][0] == arr[1][1]) && (arr[1][1] == arr[1][2])) && (arr[1][2] == arr[1][3])) {
            if(arr[1][0] == 1) {
                return 1;
            }
            else if(arr[1][0] == 2) {
                return 2;
            }
        }
        if(((arr[2][0] ==  arr[2][1]) && (arr[2][1] == arr[2][2])) && (arr[2][2] == arr[2][3])) {
            if(arr[2][0] == 1) {
                return 1;
            }
            else if(arr[2][0] == 2) {
                return 2;
            }
        }
        if(((arr[3][0] == arr[3][1]) && (arr[3][1] == arr[3][2])) && (arr[3][2] == arr[3][3])) {
            if(arr[3][0] == 1) {
                return 1;
            }
            else if(arr[3][0] == 2) {
                return 2;
            }
        }
        return 100;
    }


    public int checkDiagonal(int arr[][]) {
        if(((arr[0][0] == arr[1][1]) && (arr[1][1] == arr[2][2])) && (arr[2][2] == arr[3][3])) {
            if(arr[1][1] == 1) {
                return 1;
            }
            else if(arr[1][1] == 2) {
                return 2;
            }
        }
        else if(((arr[3][0] == arr[2][1]) && (arr[2][1] == arr[1][2])) && (arr[1][2] == arr[0][3])) {
            if(arr[3][0] == 1) {
                return 1;
            }
            else if(arr[3][0] == 2) {
                return 2;
            }
        }
        return 100;
    }

}

