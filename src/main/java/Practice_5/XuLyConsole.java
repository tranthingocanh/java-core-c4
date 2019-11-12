package Practice_5;

import java.util.Scanner;

public class XuLyConsole {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("So luong lop Hoc can nhap: ");
        int soLuong = sc.nextInt();

        LopHoc lh = new LopHoc();

        LopHoc[] dsLopHoc = new LopHoc[soLuong];

        dsLopHoc = lh.nhapThongTin(dsLopHoc);

        lh.inRaDsLop(dsLopHoc);

        lh.nhapDsHocSinhTheoLopHoc(dsLopHoc);

        lh.inRaDsHSTheoLopHoc(dsLopHoc);
    }




}
