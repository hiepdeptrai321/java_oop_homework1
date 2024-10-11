package prj_May29_23683411_DoPhuHiep_Bai8;

import java.text.NumberFormat;
import java.util.Locale;

public class HangDienMay extends HangHoa{
	private int thoiGianBH,congSuat;
	public HangDienMay() {
		super();
	}
	
	public HangDienMay(String maHang, String tenHang, double donGia, int slTon,int thoiGianBH,int congSuat) throws Exception {
		super(maHang, tenHang, donGia, slTon);
		setThoiGianBH(thoiGianBH);
		setCongSuat(congSuat);
	}


	public int getThoiGianBH() {
		return thoiGianBH;
	}

	public void setThoiGianBH(int thoiGianBH) {
		if(thoiGianBH>=0) this.thoiGianBH = thoiGianBH;
		else this.thoiGianBH=0;
	}

	public int getCongSuat() {
		return congSuat;
	}

	public void setCongSuat(int congSuat) {
		if(congSuat>=0) this.congSuat = congSuat;
		else this.congSuat=0;
	}

	public double calcVAT() {
		return 0.1*this.donGia;
	}
	public String danhGiaSP() {
		return slTon<3? "bán được":"không đánh giá";
	}
	public String toString() {
		Locale local = Locale.forLanguageTag("vi-VN");
		NumberFormat fmt1 = NumberFormat.getCurrencyInstance(local);
		return String.format(" %-10s%-15s%15s%15d%20d%20d%20s",maHang,tenHang,fmt1.format(donGia),slTon,thoiGianBH,congSuat,danhGiaSP());
	}
}
