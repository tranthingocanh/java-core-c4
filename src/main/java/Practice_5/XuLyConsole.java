package Practice_5;

import java.util.ArrayList;
import java.util.Scanner;

public class XuLyConsole {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<LopHoc> dsLopHoc = new ArrayList<>();

        LopHocController lopHocController = new LopHocController();
        try {
            while (true){
                System.out.println("//////////////////////");
                System.out.println("\t\t\t0. Thoat chuong trinh.");
                System.out.println("\t\t\t1. Nhap Thong tin Lop Hoc.");
                System.out.println("\t\t\t2. In ra Danh sach Lop Hoc.");
                System.out.println("\t\t\t3. Sap xep Danh sach Lop Hoc theo so luong hoc sinh.");
                System.out.println("\t\t\t4. In ra Danh sach Hoc sinh.");
                System.out.println("\t\t\t5. Nhap Thong tin Hoc sinh theo Lop Hoc.");
                System.out.println("\t\t\t6. Nhap Diem Hoc Sinh theo HocSinh/Lop Hoc.");
                System.out.println("//////////////////////");
                System.out.println(">>>>>>>Nhap so tuong ung thao tac muon thuc hien:");
                int  numberOption = sc.nextInt();
                switch (numberOption){
                    case 0:
                        System.out.println("========Ket Thuc Chuong Trinh=========");
                        System.exit(0);
                    case 1:
                        System.out.println("========1. Nhap Thong tin Lop Hoc.=========");
                        lopHocController.xuLyNhapDsThongTinLopHoc(dsLopHoc);
                        break;
                    case 2:
                        System.out.println("========2. In ra Danh sach Lop Hoc.=========");
                        lopHocController.xuLyInRaDanhSachLopHocs(dsLopHoc);
                        break;
                    case 3:
                        System.out.println("========3. Sap xep Danh sach Lop Hoc theo so luong hoc sinh.=========");
                        lopHocController.sapXepDsLopTheoQuickSort(dsLopHoc, 0, dsLopHoc.size() -1);
                        System.out.println("Sap xep Thanh Cong.");
                        break;
                    case 4:
                        System.out.println("========4. In ra Danh sach Hoc sinh.=========");
                        lopHocController.xuLyInRaThongTinHocSinhTheoLopHoc(dsLopHoc);
                        break;
                    case 5:
                        System.out.println("========5. Nhap Thong tin Hoc Sinh theo Lop Hoc.=========");
                        lopHocController.xuLyNhapHocSinhTheoLopHoc(dsLopHoc, "Thong tin co ban");
                        break;
                    case 6:
                        System.out.println("========6. Nhap Diem Hoc Sinh theo Lop Hoc.=========");
                        lopHocController.xuLyNhapHocSinhTheoLopHoc(dsLopHoc, "Diem mon hoc");
                        break;
                    default:
                        System.out.println("========Ket Thuc Chuong Trinh=========");
                        System.exit(1);

                }
            }
        }catch (Exception e){
            System.out.println("Du lieu dau vao loi!!!");
        }


    }

}
