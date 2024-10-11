package prj_May29_23683411_DoPhuHiep_Bai8;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class HangThucPham extends HangHoa {
	private String ncc;
	private LocalDate ngaySx,ngayhh;
	
	public HangThucPham() {
		super();
	}
	public HangThucPham(String maHang, String tenHang, double donGia, int slTon, String ncc, LocalDate ngaySx, LocalDate ngayhh) throws Exception {
		super(maHang, tenHang, donGia, slTon);
		setNcc(ncc);
		setNgaySx(ngaySx);
		setNgayhh(ngayhh);
	}
	public String getNcc() {
		return ncc;
	}
	public void setNcc(String ncc) {
		this.ncc = ncc;
	}
	public LocalDate getNgaySx() {
		return ngaySx;
	}
	public void setNgaySx(LocalDate ngaySx) {
		LocalDate today = LocalDate.now();
		if(ngaySx.isBefore(today)) this.ngaySx = ngaySx;
		else this.ngaySx=today;
	}
	public LocalDate getNgayhh() {
		return ngayhh;
	}
	public void setNgayhh(LocalDate ngayhh) {
		if(ngayhh.isAfter(this.ngaySx)) this.ngayhh=ngayhh;
		else this.ngayhh=this.ngaySx;
	}
	@Override
	public double calcVAT() {
		return 0.05*this.donGia;
	}
	public boolean ktHetHan() {
		LocalDate today = LocalDate.now();
		if(this.ngayhh.isBefore(today)) return true;
		else return false;
	}
	public String danhGiaSP() {
		if(slTon>0 && ktHetHan()==true) return "khó bán";
		else return "không đánh giá";
	}
	public String toString() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Locale local = Locale.forLanguageTag("vi-VN");
		NumberFormat fmt1 = NumberFormat.getCurrencyInstance(local);
		return String.format(" %-10s%-15s%15s%15s%20s%20s%20s%20s",maHang,tenHang,fmt1.format(donGia),slTon,ncc,fmt.format(ngaySx),fmt.format(ngayhh),danhGiaSP());
	}
}
