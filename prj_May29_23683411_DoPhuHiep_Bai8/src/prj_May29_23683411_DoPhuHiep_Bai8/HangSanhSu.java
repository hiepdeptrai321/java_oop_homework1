package prj_May29_23683411_DoPhuHiep_Bai8;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class HangSanhSu extends HangHoa {
	private String nsx;
	private LocalDate ngayNhapKho;

	public HangSanhSu() {
		super();
	}

	public HangSanhSu(String maHang, String tenHang, double donGia, int slTon,String nsx, LocalDate ngayNhapKho) throws Exception {
		super(maHang, tenHang, donGia, slTon);
		setNsx(nsx);
		setNgayNhapKho(ngayNhapKho);
	}
	

	public String getNsx() {
		
		return nsx;
	}

	public void setNsx(String nsx) {
		this.nsx = nsx;
	}

	public LocalDate getNgayNhapKho() {
		return ngayNhapKho;
	}

	public void setNgayNhapKho(LocalDate ngayNhapKho) {
		LocalDate today = LocalDate.now();
		if(ngayNhapKho.isBefore(today)) this.ngayNhapKho = ngayNhapKho;
		else this.ngayNhapKho=today;
	}

	public double calcVAT() {
		return 0.1*this.donGia;
	}
	public int tgLuuKho() {
		LocalDate today = LocalDate.now();
		Period k = Period.between(this.ngayNhapKho, today);
		return k.getDays();
	}
	public String danhGiaSP() {
		if(tgLuuKho()>10 && this.slTon>50) return "bán chậm";
		else return "không đánh giá";
	}
	public String toString() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Locale local = Locale.forLanguageTag("vi-VN");
		NumberFormat fmt1 = NumberFormat.getCurrencyInstance(local);
		return String.format(" %-10s%-15s%15s%15s%20s%20s%20s",maHang,tenHang,fmt1.format(donGia),slTon,nsx,fmt.format(ngayNhapKho),danhGiaSP());
	}
}
