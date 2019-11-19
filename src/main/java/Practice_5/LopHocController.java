package Practice_5;

import java.util.ArrayList;
import java.util.Scanner;

public class LopHocController {
    //default conductor
    public LopHocController(){

    }

    public void xuLyNhapDsThongTinLopHoc(ArrayList<LopHoc> dsLopHoc){
        try{
            Scanner sc = new Scanner(System.in);
            int flag = 1;
            while (flag == 1){
                LopHoc  lh = new LopHoc();
                dsLopHoc.add(nhapThongTinLopHoc(lh));
                System.out.println(">>>>>> Tiep tuc nhap Thong Tin Lop hoc? 1: co, 0: khong.");
                flag = sc.nextInt();
                sc.nextLine();
            }
        }catch(Exception e){
            System.out.println("Thong tin dau vao Lop Hoc sai!!!");
        }
    }

    public void xuLyInRaDanhSachLopHocs( ArrayList<LopHoc> dsLopHoc ){
        if (dsLopHoc.isEmpty()){
            System.out.println("Danh sach lop hoc rong!!!!");
        }
        for (LopHoc lh : dsLopHoc) {
            inRaThongTinLopHoc(lh);
            System.out.println("-----------------------------");
        }
    }

    public void xuLyInRaThongTinHocSinhTheoLopHoc(ArrayList<LopHoc> dsLopHoc){
        if (dsLopHoc.isEmpty()){
            System.out.println("Danh sach lop Hoc rong!!!");
        } else {
            for (LopHoc lh: dsLopHoc){
                inRaDsHSTheoLopHoc(lh);
            }
        }
    }

    public void xuLyNhapHocSinhTheoLopHoc(ArrayList<LopHoc> dsLopHoc, String loaiXuLy){
        Scanner sc = new Scanner(System.in);
        int flag = 1;
        try {
            while(flag==1){
                if (dsLopHoc.isEmpty()){
                    System.out.println("Danh sach Lop Hoc rong!!!");
                    break;
                } else {
                    for (LopHoc lh: dsLopHoc ) {
                        System.out.println("\t" + lh.tenLopHoc + ",");
                    }
                    System.out.print(">>>>> Chon Ten Lop: ");
                    String tenLopHoc = sc.nextLine();

                    for (LopHoc lh: dsLopHoc){
                        if(tenLopHoc.equals(lh.tenLopHoc)){
                            if ("Thong tin co ban".equals(loaiXuLy)) {
                                lh.dsHocSinh = nhapDsHocSinhTheoLopHoc(lh);
                            }
                            if ("Diem mon hoc".equals(loaiXuLy)){
                                nhapDiemMonHocTheoHocSinhTrongLopHoc(lh);
                            }
                            break;
                        }
                    }
                    System.out.print(">>>>> Tiep tuc nhap hoc sinh theo ten Lop Hoc?: 1: co, 0: khong ");
                    flag = sc.nextInt();
                    sc.nextLine();
                }
            }

        } catch (Exception e){
            System.out.println("Nhap Thong tin Hoc Sinh Lop Hoc sai!!!!!" + e);
        }

    }

    public void sapXepDsLopTheoQuickSort(ArrayList<LopHoc> dsLopHoc, int left, int right){

        if (left >= right) return;

        int l = left;
        int r = right;

        LopHoc privot = dsLopHoc.get((right + left ) / 2);

        while ( l <= r ){
            while ( dsLopHoc.get(l).soHocSinh < privot.soHocSinh ){
                l++;
            }
            while ( dsLopHoc.get(r).soHocSinh > privot.soHocSinh ){
                r--;
            }
            if ( l <= r ){
                hoanVi(dsLopHoc, l++, r--);
            }
        }

        sapXepDsLopTheoQuickSort(dsLopHoc, left, r );

        sapXepDsLopTheoQuickSort(dsLopHoc, l, right);

    }

    private static void nhapDiemMonHocTheoHocSinhTrongLopHoc(LopHoc lopHoc) throws Exception{
        HocSinhController hocSinhController = new HocSinhController();
        Scanner sc = new Scanner(System.in);
        int flag = 1;
        if (lopHoc.dsHocSinh != null){
            while (flag==1){
                inRaDsHSTheoLopHoc(lopHoc);
                System.out.println("Chon Ma HS muon nhap diem: ");
                String maHS = sc.nextLine();
                for (HocSinh hs: lopHoc.dsHocSinh) {
                    if(maHS.equals(hs.maHS)){
                        System.out.println("Ma HS: " + hs.maHS + " - Ten HS: " + hs.tenHS);
                        hocSinhController.nhapDiemMonHoc(hs);
                        break;
                    } else {
                        System.out.println("Khong co " + maHS + " trong lop" + lopHoc.tenLopHoc);
                    }
                }
                System.out.print(">>>>> Tiep tuc nhap diem hoc sinh theo Hoc sinh/Lop Hoc?: 1: co, 0: khong ");
                flag = sc.nextInt();
                sc.nextLine();

            }

        } else {
            System.out.println("Danh sach hoc sinh rong!!!!");
        }


    }

    private static void hoanVi(ArrayList<LopHoc> dsLopHoc, int a, int b){
        LopHoc tmp = dsLopHoc.get(a);
        dsLopHoc.set(a, dsLopHoc.get(b));
        dsLopHoc.set(b, tmp);
    }

    private static void inRaDsHSTheoLopHoc(LopHoc lh){
        System.out.println("-----------" + lh.tenLopHoc);
        if (lh.dsHocSinh == null){
            System.out.println("Danh sach hoc sinh rong!!!");
        } else {
            for( HocSinh hs: lh.dsHocSinh){
                System.out.println("Ma HS: " + hs.maHS
                        + " - Ten HS: " + hs.tenHS
                        + " - Gioi Tinh: " + (hs.nu? "Nu": "Nam")
                        + " - Diem TB: " + ((hs.diemTB==0)?"null": hs.diemTB));
            }
        }
    }

    private static void inRaThongTinLopHoc(LopHoc lh){
        System.out.println("Ten lop hoc: " + lh.tenLopHoc
                + " - So Hoc sinh: " + lh.soHocSinh
                + " - Ten GVCN: " + lh.tenGiaoVienChuNhiem
                + (lh.lopChuyen?" - Lop chuyen":" - Khong chuyen"));

    }

    private static ArrayList<HocSinh> nhapDsHocSinhTheoLopHoc(LopHoc lh) throws Exception {
        System.out.println("Ten Lop Hoc: " + lh.tenLopHoc + " - So HS: " + lh.soHocSinh);
        ArrayList<HocSinh> dsHocSinh = new ArrayList<>();
        HocSinhController hocSinhController = new HocSinhController();

        for (int i = 0; i < lh.soHocSinh; i++) {
            System.out.println("STT " + (i+1) +":");
            HocSinh hs = new HocSinh();
            hocSinhController.nhapThongTinHocSinh(hs);
            dsHocSinh.add(hs);
        }
        return dsHocSinh;
    }

    private static LopHoc nhapThongTinLopHoc(LopHoc lh) throws Exception{
        Scanner sc = new Scanner(System.in);
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
        System.out.println("Nhap Thong Tin Hoc Sinh cua Lop? 1: co, 0: khong");
        int choose = sc.nextInt();
        sc.nextLine();
        if (choose == 1){
            lh.dsHocSinh = nhapDsHocSinhTheoLopHoc(lh);
        }
        return lh;

    }
}
