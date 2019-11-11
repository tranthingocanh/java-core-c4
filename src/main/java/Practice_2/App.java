package Practice_2;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //ex1();
        //ex2();
        //ex3();
        //ex4();
        //ex5();
        //ex6();
        ex7();
    }

    public static void ex1 (){
        Scanner sc = new Scanner( System.in );

        System.out.println( "1. Viết chương trình tính tổng của các chữ số được người dùng nhập vào (so nguyen)" );
        System.out.println( "Nhap so: " );

        try {
            int so = sc.nextInt();
            int tong = 0;
            while ( so > 0 ) {
                tong = tong + so % 10;
                so = so / 10;
            }
            System.out.println( String.format( "Tong cua so %s: %s", so, tong ) );

        }catch (Exception e) {
            System.out.println( "Du lei dau vai sai!!!!" );
        }

        System.out.println( "____________________________________" );
    }

    public static void ex2 (){
        Scanner sc = new Scanner( System.in );

        System.out.println( "2. Tim nghiem phuong trinh bac 1: ax + b = 0, a # 0, a,b: so nguyen" );

        try {
            System.out.println("Nhap a = ");
            int a = sc.nextInt();

            System.out.println( "Nhap b = " );
            int b = sc.nextInt();

            System.out.println( String.format( "Nghiem x cua phuong trinh %sx + %s = 0 la: %s", a, b , - (float)b/a ));

        } catch ( Exception e ){
            System.out.println( "Du lieu dau vao sai!!!!" );
        }

        System.out.println( "____________________________________" );

    }

    public static void ex3 (){
        Scanner sc = new Scanner( System.in );
        System.out.println( "3. Tim nghiem phuong trinh bac 2: ax*x + bx + c = 0" );
        System.out.println( "Nhap lan luot theo thu tu a, b, c : ");

        try {

            float a = sc.nextFloat(), b = sc.nextFloat(), c = sc.nextFloat();

            float denta = b*b - 4*a*c;

            if ( denta < 0 ) {

                System.out.println( "Phuong trinh vo nghiem" );

            } else if ( denta > 0 ) {

                System.out.println( String.format( "Phuong trinh co hai nghiem: %s va %s",
                        (-b + Math.sqrt(denta))/(2*a), (-b - Math.sqrt(denta))/(2*a) ) );

            } else {

                System.out.println( String.format( "Phuong trinh co nghiem kep: %s", - b/(2*a) ) );

            }
        } catch ( Exception e ) {
            System.out.println( "Dau lieu dau vai sai!!!" );
        }

    }

    public static void ex4 (){
        Scanner sc = new Scanner( System.in );
        System.out.println("4. Viet chuong trinh nhap vao 1 so, kiem tra so do co phai la so nguyen to khong?");
        System.out.println("Nhap so: ");
        try {
            int so = sc.nextInt();

            int flag = 1;

            for (int i = so-1; i > 1; i--){
                if( so%i == 0) {
                    flag = 0;
                    break;
                }
            }
            if( flag == 1){
                System.out.println(String.format("%s la so nguyen to", so));
            }else{
                System.out.println(String.format("%s khong la so nguyen to", so));
            }
        }catch (Exception e){
            System.out.println("Du lieu dau vao sai!!!!!");
        }


    }

    public static void ex5 (){
        Scanner sc = new Scanner(System.in);
        System.out.println("5. viết chương trình in ra tất cả các số nguyên tố nhỏ hơn số n cho trước");
        System.out.println("Nhap n: ");

        try{
            int n = sc.nextInt();
            for( int i = 1; i <= n; i++ ){
                if (ktraSoNguyento(i)){
                    System.out.println(i);
                }

            }
        }catch (Exception e){
            System.out.println("Dau lieu dau vao sai!!!!!");
        }
    }

    public static boolean ktraSoNguyento(int so){
        for (int i = so -1 ; i > 1; i--){
            if ( so % i == 0 ){
                return false;
            }
        }
        return true;
    }

    public static void ex6 (){
        Scanner sc = new Scanner(System.in);

        System.out.println("6. Viết chương trình tìm ước chung lớn nhất và bội chung nhỏ nhất của hai số.");
        System.out.println("Nhap so a va b lan luot: ");

        try{
            int a = sc.nextInt(), b = sc.nextInt();
            int boiChungNhoNhat = a*b;
            if( a > b){
                for (int i = b; i <= boiChungNhoNhat; i++){
                    if (i%b == 0 && i%a == 0){
                        boiChungNhoNhat = i;
                        break;
                    }
                }
            } else {
                for (int i = a; i <= boiChungNhoNhat; i++){
                    if (i%b == 0 && i%a == 0){
                        boiChungNhoNhat = i;
                        break;
                    }
                }
            }
            System.out.println("BCNN: " + boiChungNhoNhat);
        }catch (Exception e){
            System.out.println("Du lieu dau vao sai!!!!!!");
        }
    }

    public static void ex7() {
        Scanner sc = new Scanner(System.in);

        System.out.println("7. Sắp xếp dãy số 1 mảng số nguyên theo thứ tự tăng dần sử dụng thuật toán selection và quick sort.");

        try{
            System.out.print("Nhập vào độ dài của mảng: ");
            int kichThuoc = sc.nextInt();

            int[] mang = new int[kichThuoc];

            System.out.print("Nhập phan tu: ");

            for (int i = 0; i < kichThuoc; i++){
                 mang[i] = sc.nextInt();
            }
            for(int i = 0; i < kichThuoc; i++){
                for(int j = i+1; j < kichThuoc; j++){
                    if (mang[i] > mang[j]){
                        hoanVi(mang, i, j);
                    }
                }
            }
            System.out.print("Selection sort: ");
            for (int i = 0; i < kichThuoc; i++){
                System.out.print(mang[i] + " ");
            }


        }catch (Exception e){
            System.out.println("Du lieu dau vao sai!!!");
        }
    }
    private static void hoanVi(int mang[], int i, int j){
        int bienTam = mang[j];
        mang[j] = mang[i];
        mang[i] = bienTam;
    }

}
