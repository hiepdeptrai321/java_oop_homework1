package prj_May29_23683411_DoPhuHiep_Bai8;

import java.util.Arrays;
import java.util.Comparator;

public class DanhSachHangHoa {
	private int count;
	private HangHoa[] list;
	public DanhSachHangHoa(int max) {
		list = new HangHoa[max];
		count=0;
	}
	public void add(HangHoa x) {
		list[count++]=x;
	}
	public String toString() {
		String s="";
		for(int i=0;i<count;i++) {
			s+=list[i].toStringb()+"\n";
		}
		return s;
	}
	public String tieuDe() {
		return String.format(" %-10s%-15s%15s%15s","Mã hàng","Tên hàng","Đơn giá","Số lượng tồn");
	}
	public String tieuDeDienMay() {
		return String.format(" %-10s%-15s%15s%15s%20s%20s%20s","Mã hàng","Tên hàng","Đơn giá","Số lượng tồn","Thời gian BH","Công suất","Đánh giá");
	}
	public String tieuDeSanhSu() {
		return String.format(" %-10s%-15s%15s%15s%20s%20s%20s","Mã hàng","Tên hàng","Đơn giá","Số lượng tồn","Nhà sản xuất","Ngày nhập kho","Đánh giá");
	}
	public String tieuDeThucPham() {
		return String.format(" %-10s%-15s%15s%15s%20s%20s%20s%20s","Mã hàng","Tên hàng","Đơn giá","Số lượng tồn","Nhà cung cấp","Ngày sản xuất","Ngày hết hạn","Đánh giá");
	}
	public String chonLoaiHang() {
		return "\n1. Hàng điện máy\n2. Hàng sành sứ\n3. Hàng thực phẩm";
	}
	public String toStringDienMay() {
		String s="";
		for(int i=0;i<count;i++) {
			if(list[i] instanceof HangDienMay) s+=list[i].toString()+"\n";
		}
		return s;
	}
	public String toStringSanhSu() {
		String s="";
		for(int i=0;i<count;i++) {
			if(list[i] instanceof HangSanhSu) s+=list[i].toString()+"\n";
		}
		return s;
	}
	public String toStringThucPham() {
		String s="";
		for(int i=0;i<count;i++) {
			if(list[i] instanceof HangThucPham) s+=list[i].toString()+"\n";
		}
		return s;
	}
	public String timKiem(String maHang) {
		boolean check=false;
		String s="";
		for(int i=0;i<count;i++) {
			if(list[i].getMaHang().compareTo(maHang)==0) {
				check = true;
				s+=list[i].toString()+"\n";
			}
		}
		if(check == false) s+="Không tìm thấy";
		return s;
	}
	public void sxHHTheoTen() {
		Arrays.sort(list,new Comparator<HangHoa>(){
			public int compare(HangHoa o1, HangHoa o2) {
				if (o1 != null && o2 != null) {
					if(o1.getTenHang().compareToIgnoreCase(o2.getTenHang())>0) return 1;
					else if(o1.getTenHang().compareToIgnoreCase(o2.getTenHang())<0) return -1;
				}
				return 0;
			}
		});
	}
	public void sxHHTheoSLTon() {
		Arrays.sort(list,new Comparator<HangHoa>(){
			public int compare(HangHoa o1, HangHoa o2) {
				if (o1 != null && o2 != null) {
					if(o1.getSlTon()>o2.getSlTon()) return 1;
					else if(o1.getSlTon()<o2.getSlTon()) return -1;
				}
				return 0;
			}
		});
	}
	public String toStringTPKhoBan() {
		String s="";
		for(int i=0;i<count;i++) {
			if(list[i] instanceof HangThucPham && list[i].danhGiaSP().compareTo("khó bán")==0) s+=list[i].toStringb();
		}
		return s;
	}
	public boolean xoaHHTheoMH(String maHang) {
		boolean check=false;
		for(int i=0;i<count;i++) {
			if(list[i].getMaHang().equalsIgnoreCase(maHang)) check=true;
		}
		if(check==true) {
			HangHoa[] l= new HangHoa[count-1];
			int countl=0;
			for(int i=0;i<count;i++) {
				if(list[i].getMaHang().compareTo(maHang)!=0) {
					l[countl]=list[i]; countl++;
				}
			}
			this.list=l;
			this.count=countl;
			return true;
		}
		else return check;
	}
	public boolean suaDonGiaTheoMH(String maHang,double donGia) throws Exception {
		boolean check=false;
		for(int i=0;i<count;i++) {
			if(list[i].getMaHang().equalsIgnoreCase(maHang)) {
				list[i].setDonGia(donGia);;
				check=true;
			}
		}
		return check;
	}
}

