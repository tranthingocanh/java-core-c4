package Practice_5;

import java.util.Scanner;

public class HocSinh {

    public HocSinh(){

    }

    // properties

    String maHS;
    String tenHS;
    Boolean nu;
    float diem;

    public HocSinh nhapThongTinHocSinh() throws Exception{
        Scanner sc = new Scanner(System.in);

        HocSinh hs = new HocSinh();

        System.out.print("Ma hoc sinh: ");
        hs.maHS = sc.nextLine();
        System.out.print("Ten Hs: ");
        hs.tenHS = sc.nextLine();
        System.out.print("Diem TB: ");
        hs.diem = sc.nextFloat();
        sc.nextLine();
        System.out.print("Nu?: ");
        hs.nu = sc.nextBoolean();

        return hs;
    }

}
