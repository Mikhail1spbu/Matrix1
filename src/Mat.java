/**
 * Created by misha on 25.11.2016.
 */

import java.io.*;
import java.util.ArrayList;
import static java.lang.Double.parseDouble;
import java.util.Scanner;
public class Mat {

    double[][] Matrix;

    public Mat(String adress) {
        ArrayList<String> matrix = new ArrayList<String>();


        Scanner in = null;
        try {
            in = new Scanner(new File(adress));
        }   catch (IOException e) {
            e.printStackTrace();
        }

        int M = 0, N = 0;

        while (in.hasNextLine()) {
            M++;
            matrix.add(in.nextLine());

        }
        in.close();

        N = matrix.get(0).split(" ").length;


        Matrix = new double[M][N];
        for (int i = 0; i < M; i++) {
            String[] s = matrix.get(i).split(" ");
             for (int j = 0; j < N; j++) {
                this.Matrix[i][j] = parseDouble(s[j]);
            }
        }

    }

    public void Matout() {
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {
                System.out.print(Matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    public Mat(int x, int y) {

        Matrix = new double[x][y];
    }


    public void mulMatMat(Mat other) {
        try {
            File f = new File("outmult.txt");
            if (!f.exists()) {
                f.createNewFile();
            }

            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);


            if (Matrix[0].length == other.Matrix.length) {
                Mat res = new Mat(Matrix.length, other.Matrix[0].length);
                for (int i = 0; i < Matrix.length; i++) {
                    for (int j = 0; j < other.Matrix[0].length; j++) {
                        res.Matrix[i][j] = 0.0;
                        for (int k = 0; k < Matrix[0].length; k++) {
                            res.Matrix[i][j] = res.Matrix[i][j] + this.Matrix[i][k] * other.Matrix[k][j];

                        }
                        bw.write(res.Matrix[i][j] + " ");


                    }
                    bw.append("\n");
                }

                res.Matout();
            }
            else{
                bw.write("Ошибка в умножении матриц");
                System.out.println("Ошибка в умножении матриц");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void addMat(Mat other){
        try {
            File f = new File("outadd.txt");
            if (!f.exists()) {
                f.createNewFile();
            }

            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);


            if (Matrix.length == other.Matrix.length && Matrix[0].length== other.Matrix[0].length) {
                Mat res = new Mat(Matrix.length, Matrix[0].length);
                for (int i = 0; i < Matrix.length; i++) {
                    for (int j = 0; j < Matrix[0].length; j++) {
                        res.Matrix[i][j] = this.Matrix[i][j] + other.Matrix[i][j];
                        bw.write(res.Matrix[i][j] + " ");
                    }
                    bw.append("\n");
                }



                res.Matout();
            }
            else{
                bw.write("Ошибка в сложении матриц");
                System.out.println("Ошибка в сложении матриц");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public int Checking(String name, Mat other) {
        int flag=1;
        if (Matrix.length == other.Matrix.length && Matrix[0].length== other.Matrix[0].length) {
            for(int i=0;i<Matrix.length;i++)
                for(int j=0;j<Matrix[0].length;j++) {
                    if (Matrix[i][j] != other.Matrix[i][j])
                        flag = 0;
                }
        }

        else
        {
            flag=0;
            System.out.println("Ошибка в тесте "+name);
        }
        return  flag;
    }
}