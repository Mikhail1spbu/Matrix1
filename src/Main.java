/**
 * Created by misha on 25.11.2016.
 */
public class Main {

    public static void main(String[] args) {
        String adress1 = "in1.txt";
        String adress2 = "in2.txt";
        Mat m1 = new Mat(adress1);
        Mat m2 = new Mat(adress2);
        System.out.println("Дана матрица А:");
        m1.Matout();
        System.out.println();
        System.out.println("Дана матрица B:");
        m2.Matout();
        System.out.println();
        System.out.println("Результат А*В:");
        m1.mulMatMat(m2);
        System.out.println();
        System.out.println("Результат А+В:");
        m1.addMat(m2);
        System.out.println();
        Mat test_add = new Mat("testadd.txt");
        Mat test_mult = new Mat("testmult.txt");
        Mat out_add = new Mat("outadd.txt");
        Mat out_mult = new Mat("outmult.txt");
        int k=test_add.Checking("out_add",out_add);
        int m=test_mult.Checking("out_mult",out_mult);
        if(k==1) System.out.println("Умножение корректно");
        else System.out.println("Умножение не корректно");

        if(m==1) System.out.println("Сложение корректно");
        else System.out.println("Сложение не корректно");



    }

}
