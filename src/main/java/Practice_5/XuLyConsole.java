package Practice_5;

import java.util.Scanner;

public class XuLyConsole {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("So luong Lop Hoc can nhap: ");

            int soLuongLopHoc = sc.nextInt();

            LopHoc[] dsLopHoc = new LopHoc[soLuongLopHoc];

            try{

                for( int i = 0; i < soLuongLopHoc; i++ ){
                    LopHoc lh = new LopHoc();
                    dsLopHoc[i] = lh.nhapThongTinLopHoc();
                }

            }catch(Exception e){
                System.out.println("Du lieu thong tin lop hoc sai!!!" + e);
            }

            System.out.println("-------------IN RA DANH SACH LOP HOC ------------");
            for (LopHoc lh : dsLopHoc){
                lh.inRaDsLop(lh);
            }

            System.out.println("-------------IN RA DANH SACH LOP SAP XEP THEO QUICKSORT----------");
            LopHoc[] dsLopHocQuickSort = dsLopHoc.clone();
            LopHoc lh = new LopHoc();
            lh.sapXepDsLopTheoQuickSort(dsLopHocQuickSort, 0, dsLopHocQuickSort.length-1);
            for (LopHoc l : dsLopHocQuickSort){
                lh.inRaDsLop(l);
            }

            System.out.println("--------------NHAP THONG TIN HOC SINH THEO LOP HOC --------------");
            for (LopHoc l : dsLopHoc){
                lh.nhapDsHocSinhTheoLopHoc(l);
            }

            System.out.println("-------------IN RA DANH SACH HOC SINH THEO LOP HOC --------------");
            for (LopHoc l : dsLopHoc) {
                lh.inRaDsHSTheoLopHoc(l);
            }

        }catch (Exception e){
            System.out.println("Du lieu dau vao sai!!!" + e);
        }
    }

}
