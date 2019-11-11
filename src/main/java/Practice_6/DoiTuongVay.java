package Practice_6;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DoiTuongVay {

    public DoiTuongVay(){

    }

    String id;
    double soTienVay;
    Date ngayVay;
    double laiSuat;

    public DoiTuongVay nhapThongTinVay(){
        DoiTuongVay dTV = new DoiTuongVay();
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Nhap id: ");
            dTV.id = sc.nextLine();
            System.out.println("Nhap ngay vay (theo format yyyy-MM-dd): ");
            dTV.ngayVay= xulyDate(sc.nextLine());
            System.out.println("Nhap so Tien Vay: ");
            dTV.soTienVay = sc.nextDouble();

            dTV.laiSuat = ((new Date().getTime() - dTV.ngayVay.getTime())/(1000*60*60*24))*dTV.soTienVay*0.17;
            DecimalFormat decimalFormat = new DecimalFormat("#.00000000000000000000");
            String numberAsString = decimalFormat.format( dTV.laiSuat);
            System.out.println("Xuat Lai Suat: " + numberAsString);
            System.out.println("Xuat Lai Suat: " + dTV.laiSuat);


        }catch(Exception e){
            System.out.println(e);
        }
        return dTV;
    }

    private static Date xulyDate (String Date) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse(Date);
        return d;
    }

    public static void main(String[] args) {
        DoiTuongVay dTV = new DoiTuongVay();
        DoiTuongVay[] dsVay = new DoiTuongVay[3];
        for(int i =0; i<dsVay.length;i++){
            dsVay[i] = dTV.nhapThongTinVay();
        }
        for(DoiTuongVay dTV1: dsVay){
            System.out.println(dTV1.id + "-" + dTV1.ngayVay + "-" + dTV1.soTienVay + "Lai Xuat: " + dTV1.laiSuat);
        }
    }

}
