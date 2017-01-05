package com.ivo;

/**
 * Created by ivant on 03.01.2017.
 */

public class Main {

    static final short QTY = 51;    // quantity from requirements

    static final short CN = 3;      // Number of colour components (and columns in array) if RGB then LN=3

    static final short CG = 256;    // number of color grades per color component

    static short RN = 125;          // number of rows : ( CG / QTY ) ^ CN

    static short[][] mas = new short[RN][CN];

    static short r = 0;
    static short g = 0;
    static short b = 0;

    static int i = 0;


    public static void main(String[] args) {

        // setting initial meanings
        r += QTY;
        g += QTY;
        b += QTY;

        // setting initial array row counter
         //int i = 0;

        while (r < 256) {

            //starting every new cycle G is 51
            g = QTY;

            while (g < 256) {

                //starting every new cycle B is 51
                b = QTY;

                while (b < 256) {

                    //saving R
                    mas[i][0] = r;

                    //saving G
                    mas[i][1] = g;

                    //saving B
                    mas[i][2] = b;
                    b += 51;

                    i++;
                }
                g += QTY;
            }
            r += QTY;
        }

        showArray();

        sortByG(false);

        System.out.println("==================================");

        showArray();
    }

    // exchanges rows in mas[][] array
    static void swap(int a, int b){
        short[] temp = new short[CN];
        temp[0] = mas[a][0];
        temp[1] = mas[a][1];
        temp[2] = mas[a][2];

        mas[a][0] = mas[b][0];
        mas[a][1] = mas[b][1];
        mas[a][2] = mas[b][2];

        mas[b][0] = temp[0];
        mas[b][1] = temp[1];
        mas[b][2] = temp[2];

    }

    // sorts array of colors by Green component
    // dir - sorting direction, true - ascending, false - descending
    static void sortByG(boolean dir){

        boolean flag = true;

        if(dir) {       // sorting by ascending

            for (int m = 0; m < RN; m++) {
                for (int n = 0; n < RN - m - 1; n++) {
                    if ((mas[n][1] > mas[n + 1][1]) && (mas[n][0] == mas[n + 1][0])) {
                        swap(n, n + 1);
                    }
                }
            }


        } else {        //sorting by descending
            while (flag) {

                flag = false;

                for (int m = 0; m < RN - 5; m++) {
                    if ( (mas[m][1] < mas[m + 5][1]) && (mas[m][0] == mas[m + 5][0]) ) {
                        swap(m, m + 5);
                        flag = true;     // flag  indicates if there were an
                    }
                }

            }

        }
    }

    private static void showArray(){

        for (int j = 0; j < RN; j++) {

            System.out.print(j + " ");

            for (int k = 0; k < 3; k++) {

                System.out.print(mas[j][k] + " ");
            }

            System.out.println();

        }

    }
}
