package Practice_5;

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
    public LopHoc nhapThongTinLopHoc() throws Exception{

        Scanner sc = new Scanner(System.in);

        LopHoc lh = new LopHoc();
        System.out.print("Nhap ten lop hoc: ");
        lh.tenLopHoc = sc.nextLine();
        System.out.print("Nhap so Hoc sinh: ");
        lh.soHocSinh = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhap ten GVCN: ");
        lh.tenGiaoVienChuNhiem = sc.nextLine();
        System.out.print("Lop chuyen? ");
        lh.lopChuyen = sc.nextBoolean();
        sc.nextLine();
        return lh;

    }

    public void inRaDsLop(LopHoc lh){
        System.out.println("Ten lop hoc: " + lh.tenLopHoc
                            + " - So Hoc sinh: " + lh.soHocSinh
                            + " - Ten GVCN: " + lh.tenGiaoVienChuNhiem
                            + (lh.lopChuyen?" - Lop chuyen":" - Khong chuyen"));

    }

    public void nhapDsHocSinhTheoLopHoc(LopHoc lh) throws Exception {

            System.out.println("Ten Lop Hoc: " + lh.tenLopHoc + " - So HS: " + lh.soHocSinh);
            lh.dsHocSinh = new HocSinh[lh.soHocSinh];
            for (int i = 0; i < lh.soHocSinh; i++) {
                HocSinh hs = new HocSinh();
                System.out.println("------STT " + (i + 1));
                lh.dsHocSinh[i] = hs.nhapThongTinHocSinh();
            }
    }

    public void inRaDsHSTheoLopHoc(LopHoc lh){
        System.out.println("-----------" + lh.tenLopHoc);
        for( HocSinh hs: lh.dsHocSinh){
            System.out.println("Ma HS: " + hs.maHS
                                + " - Ten HS: " + hs.tenHS
                                + " - Gioi Tinh: " + (hs.nu? "Nu": "Nam")
                                + " - Diem TB: " + hs.diem);
        }
    }

    public void sapXepDsLopTheoQuickSort(LopHoc[] dsLopHoc, int left, int right){

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
