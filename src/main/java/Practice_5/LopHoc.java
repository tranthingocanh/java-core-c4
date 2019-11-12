package Practice_5;

import java.util.Arrays;
import java.util.Scanner;

public class LopHoc {
    //default conductor
    public LopHoc (){

    }
    //properties
    String tenLopHoc;
    int soHocSinh;
    String tenGiaoVienChuNhiem;
    Boolean lopChuyen;
    HocSinh[] dsHocSinh;

    //
    public LopHoc[] nhapThongTin(LopHoc[] dsLopHoc) {

        Scanner sc = new Scanner(System.in);

        try {
            int soLuong = dsLopHoc.length;
            for(int i = 0; i < soLuong; i++){
                LopHoc lh = new LopHoc();
                System.out.println( "------" + i + "-------");
                System.out.println("Nhap ten lop hoc: ");
                lh.tenLopHoc = sc.nextLine();
                System.out.print("Nhap so Hoc sinh: ");
                lh.soHocSinh = sc.nextInt();
                sc.nextLine();
                System.out.print("Nhap ten GVCN: ");
                lh.tenGiaoVienChuNhiem = sc.nextLine();
                System.out.print("Lop chuyen? ");
                lh.lopChuyen = sc.nextBoolean();
                sc.nextLine();
                dsLopHoc[i] = lh;
            }


        }catch (Exception e){
            System.out.println("Du lieu dau vao sai!!!!");
        }
        return dsLopHoc;
    }

    public void inRaDsLop(LopHoc[] dsLopHoc){
        sapXepDsLopTheoQuickSort(dsLopHoc, 0, dsLopHoc.length-1);
        for(LopHoc l : dsLopHoc){
            System.out.println( "------------");
            System.out.println("Ten lop hoc: " + l.tenLopHoc
                                + " - So Hoc sinh: " + l.soHocSinh
                                + " - Ten GVCN: " + l.tenGiaoVienChuNhiem
                                + (l.lopChuyen?" - Lop chuyen":" - Khong chuyen"));
        }
    }

    public void nhapDsHocSinhTheoLopHoc(LopHoc[] dsLopHoc){

        Scanner sc = new Scanner(System.in);

        System.out.println("Danh sach Lop Hoc: " + Arrays.toString(dsLopHoc));
        System.out.println("Nhap so luong Loc Hoc can nhap thong tin hoc sinh: ");

        int soLuongLopHoc = sc.nextInt();
        sc.nextLine();

        for (int i=0; i < soLuongLopHoc; i++){
            System.out.println("------STT Lop Hoc "+ i + " ---------");
            System.out.print("Ten Lop Hoc: ");
            String tenLopHoc = sc.nextLine();
            for (LopHoc lh: dsLopHoc){
                if(tenLopHoc.equals(lh.tenLopHoc)){
                    lh.dsHocSinh = new HocSinh[lh.soHocSinh];
                    for (int j = 0; j < lh.soHocSinh; j++){
                        HocSinh hs = new HocSinh();
                        System.out.println("------STT Hoc Sinh "+ i + " ---------");
                        lh.dsHocSinh[j] = hs.nhapThongTinHocSinh();
                    }
                    break;
                }
            }

        }

    }

    public void inRaDsHSTheoLopHoc(LopHoc[] dsLopHoc){
        System.out.println("Thong tin Hs theo Lop Hoc: ");
        for( LopHoc lh: dsLopHoc){
            System.out.println("-----------" + lh.tenLopHoc + "--------------");
            for( HocSinh hs: lh.dsHocSinh){
                System.out.println("Ma HS: " + hs.maHS
                                    + " - Ten HS: " + hs.tenHS
                                    + " - Gioi Tinh: " + (hs.nu? "Nu": "Nam")
                                    + " - Diem TB: " + hs.diem);
            }
        }
    }

    private static void sapXepDsLopTheoQuickSort(LopHoc[] dsLopHoc, int left, int right){

        if (left >= right) return;

        int l = left;
        int r = right;

        LopHoc privot = dsLopHoc[(right + left ) / 2];

        while ( l <= r ){
            while ( dsLopHoc[l].soHocSinh < privot.soHocSinh ){
                l++;
            }
            while ( dsLopHoc[r].soHocSinh > privot.soHocSinh ){
                r--;
            }
            if ( l <= r ){
                hoanVi(dsLopHoc, l++, r--);
            }
        }

        sapXepDsLopTheoQuickSort(dsLopHoc, left, r );

        sapXepDsLopTheoQuickSort(dsLopHoc, l, right);

    }

    private static void hoanVi(LopHoc[] dsLopHoc, int a, int b){
        LopHoc tmp = dsLopHoc[a];
        dsLopHoc[a] = dsLopHoc[b];
        dsLopHoc[b] = tmp;
    }


}
