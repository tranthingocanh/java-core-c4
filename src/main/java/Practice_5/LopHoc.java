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

    //
    public LopHoc[] nhapThongTin(LopHoc[] dsLopHoc) {

        Scanner sc = new Scanner(System.in);
        try {
            int soLuong = dsLopHoc.length;
            for(int i = 0; i < soLuong; i++){
                LopHoc lh = new LopHoc();
                System.out.println( "------" + i + "-------");
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

    private static LopHoc[] sapXepDsLopTheoQuickSort(LopHoc[] dsLopHoc, int left, int right){
        int pTuGiua = (right - left ) / 2 ;
        LopHoc privot = dsLopHoc[pTuGiua];
        int i, j;
        while (true){
            for ( i=left; i <= right; i++ ){
                if( dsLopHoc[i].soHocSinh > privot.soHocSinh){
                    left = i;
                    break;
                }
            }
            for (j = right; j > left; j--){
                if ( dsLopHoc[j].soHocSinh < privot.soHocSinh){
                    right = j;
                    break;
                }
            }
            if(left == right){
                break;
            }
            hoanVi(dsLopHoc, left, right);

        }
        if (pTuGiua==0){
            return dsLopHoc;
        }else {
            sapXepDsLopTheoQuickSort(dsLopHoc, left, pTuGiua);
            sapXepDsLopTheoQuickSort(dsLopHoc, pTuGiua, right);
            return  dsLopHoc;
        }
    }

    private static void hoanVi(LopHoc[] dsLopHoc, int a, int b){
        LopHoc tmp = dsLopHoc[a];
        dsLopHoc[a] = dsLopHoc[b];
        dsLopHoc[b] = tmp;
    }

}
