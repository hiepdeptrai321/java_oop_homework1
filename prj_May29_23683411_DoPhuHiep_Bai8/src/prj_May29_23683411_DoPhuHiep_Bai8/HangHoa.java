package prj_May29_23683411_DoPhuHiep_Bai8;

import java.text.NumberFormat;
import java.util.Locale;

public abstract class HangHoa {
	protected String maHang,tenHang;
	protected double donGia;
	protected int slTon;
	public HangHoa() {
		super();
	}
	public HangHoa(String maHang, String tenHang, double donGia, int slTon) throws Exception {
		setMaHang(maHang);
		setTenHang(tenHang);
		setDonGia(donGia);
		setSlTon(slTon);
	}
	public String getMaHang() {
		return maHang;
	}
	public void setMaHang(String maHang) throws Exception {
		if(maHang!=null) this.maHang = maHang;
		else throw new Exception("Lỗi: Mã hàng phải khác rỗng");
		
	}
	public String getTenHang() {
		return tenHang;
	}
	public void setTenHang(String tenHang) {
		if(tenHang!=null) this.tenHang = tenHang;
		else this.tenHang="xxx";
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) throws Exception {
		if(donGia>=0) this.donGia = donGia;
		else throw new Exception("Lỗi: Đơn giá phải lớn hơn 0");
	}
	public int getSlTon() {
		return slTon;
	}
	public void setSlTon(int slTon) throws Exception {
		if(slTon>=0) this.slTon = slTon;
		else throw new Exception("Lỗi: Số lượng tồn phải lớn hơn không");
	}
	
	public String toStringb() {
		Locale local = Locale.forLanguageTag("vi-VN");
		NumberFormat fmt1 = NumberFormat.getCurrencyInstance(local);
		return String.format(" %-10s%-15s%15s%15d",maHang,tenHang,fmt1.format(donGia),slTon);
	}
	public abstract double calcVAT();
	public abstract String danhGiaSP();
	
}
