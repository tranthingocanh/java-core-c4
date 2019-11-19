package Practice_5;

import java.util.Scanner;

public class HocSinhController {

    public void nhapThongTinHocSinh(HocSinh hs) throws Exception{
        Scanner sc = new Scanner(System.in);

        System.out.print("Ma hoc sinh: ");
        hs.maHS = sc.nextLine();
        System.out.print("Ten Hs: ");
        hs.tenHS = sc.nextLine();
        System.out.print("Nu?: ");
        hs.nu = sc.nextBoolean();
    }

    public void nhapDiemMonHoc(HocSinh hs) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Diem mon Toan: ");
        hs.diemToan = sc.nextFloat();
        System.out.println("Diem mon Ly: ");
        hs.diemLy = sc.nextFloat();
        System.out.println("Diem mon Hoa: ");
        hs.diemHoa = sc.nextFloat();
        sc.nextLine();
        hs.diemTB = (hs.diemToan + hs.diemLy + hs.diemHoa)/3;
        System.out.println("Diem Trung Binh: " + hs.diemTB);
    }



}
