package prj_May29_23683411_DoPhuHiep_Bai8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws Exception {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		HangHoa a1 = new HangThucPham("tp1","Thịt heo",20000,10,"CP Food",LocalDate.of(2024,10,8),LocalDate.of(2024,11,15));
		HangHoa a2 = new HangThucPham("tp2","Thịt gà",25000,15,"HP Food",LocalDate.of(2024,10,1),LocalDate.of(2024,11,15));
		HangHoa a3 = new HangThucPham("tp3","Xúc xích",10000,100,"CP Food",LocalDate.of(2024,9,8),LocalDate.of(2024,10,8));
		HangHoa b1 = new HangDienMay("dm1","Tivi Samsung",5000000,5,24,2000);
		HangHoa b2 = new HangDienMay("dm2","Tivi Sony",4500000,1,12,1000);
		HangHoa b3 = new HangDienMay("dm3","Tủ lạnh LG",8000000,3,24,600);
		HangHoa c1 = new HangSanhSu("ss1","Chén",5000,100,"Bát Tràng",LocalDate.of(2023,12,12));
		HangHoa c2 = new HangSanhSu("ss2","Bình hoa",50000,40,"PH Co",LocalDate.of(2022,10,12));
		HangHoa c3 = new HangSanhSu("ss3","Tượng",100000,15,"Bát Tràng",LocalDate.of(2023,9,9));
		DanhSachHangHoa l1 = new DanhSachHangHoa(30);
		l1.add(a1);
		l1.add(a2);
		l1.add(a3);
		l1.add(b1);
		l1.add(b2);
		l1.add(b3);
		l1.add(c1);
		l1.add(c2);
		l1.add(c3);
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("\n========= MENU QUẢN LÝ DANH SÁCH HÀNG HÓA ===========\n");
			System.out.println("0. Thoát");
			System.out.println("1. In danh sách hàng hóa");
			System.out.println("2. Thêm 1 hàng hóa");
			System.out.println("3. In danh sách theo từng loại hàng hóa");
			System.out.println("4. Tìm kiếm hàng hóa bằng mã hàng");
			System.out.println("5. Sắp xếp theo tên hàng");
			System.out.println("6. Sắp xếp theo số lượng tồn kho");
			System.out.println("7. In danh sách thực phẩm khó bán");
			System.out.println("8. Xóa hàng hóa theo mã hàng");
			System.out.println("9. Sửa đơn giá theo mã hàng");
			
			System.out.print("Nhập lựa chọn: ");
			choice = sc.nextInt();
			switch(choice) {
				case 0:{
					System.out.println("Đang thoát chương trình");
					System.exit(0);
					break;
				}
				case 1:{
					System.out.println(l1.tieuDe());
					System.out.println(l1.toString());
					break;
				}
				case 2:{
					int choice_lh;
					System.out.println(l1.chonLoaiHang());
					System.out.print("Nhập loại hàng: ");
					choice_lh = sc.nextInt();
					switch(choice_lh) {
						case 1:{
							HangDienMay x = new HangDienMay();
							System.out.print("Nhập mã hàng: ");
							x.setMaHang(sc.next());
							System.out.print("Nhập tên hàng: ");
							x.setTenHang(sc.next());
							System.out.print("Nhập đơn giá: ");
							x.setDonGia(sc.nextDouble());
							System.out.print("Nhập số lượng tồn: ");
							x.setSlTon(sc.nextInt());
							System.out.print("Nhập thời gian bảo hành: ");
							x.setThoiGianBH(sc.nextInt());
							System.out.print("Nhập công suất: ");
							x.setCongSuat(sc.nextInt());
							l1.add(x);
							System.out.println("Nhập thành công!");
							break;
						}
						case 2:{
							HangSanhSu x = new HangSanhSu();
							System.out.print("Nhập mã hàng: ");
							x.setMaHang(sc.next());
							System.out.print("Nhập tên hàng: ");
							x.setTenHang(sc.next());
							System.out.print("Nhập đơn giá: ");
							x.setDonGia(sc.nextDouble());
							System.out.print("Nhập số lượng tồn: ");
							x.setSlTon(sc.nextInt());
							System.out.print("Nhập nhà sản xuất: ");
							x.setNsx(sc.next());
							String s;
							System.out.print("Nhập ngày nhập kho (dd/mm/yyyy): ");
							s = sc.next();
							x.setNgayNhapKho(LocalDate.parse(s,fmt));
							l1.add(x);
							System.out.println("Nhập thành công!");
							break;
						}
						case 3:{
							HangThucPham x = new HangThucPham();
							System.out.print("Nhập mã hàng: ");
							x.setMaHang(sc.next());
							System.out.print("Nhập tên hàng: ");
							x.setTenHang(sc.next());
							System.out.print("Nhập đơn giá: ");
							x.setDonGia(sc.nextDouble());
							System.out.print("Nhập số lượng tồn: ");
							x.setSlTon(sc.nextInt());
							System.out.print("Nhập thời nhà cung cấp: ");
							x.setNcc(sc.next());
							System.out.print("Nhập ngày sản xuất (dd/mm/yyyy): ");
							String s;
							s = sc.next();
							x.setNgaySx(LocalDate.parse(s,fmt));
							System.out.print("Nhập ngày hết hạn (dd/mm/yyyy): ");
							s = sc.next();
							x.setNgayhh(LocalDate.parse(s,fmt));
							l1.add(x);
							System.out.println("Nhập thành công!");
							break;
							}
						}
						break;
					}
					case 3:{
						int choice_lh;
						System.out.println(l1.chonLoaiHang());
						System.out.println("Nhập loại hàng: ");
						choice_lh = sc.nextInt();
						switch(choice_lh) {
							case 1:{
								System.out.println("\nĐiện máy:");
								System.out.println(l1.tieuDeDienMay());
								System.out.println(l1.toStringDienMay());
								break;
							}
							case 2:{
								System.out.println("\nSành sứ:");
								System.out.println(l1.tieuDeSanhSu());
								System.out.println(l1.toStringSanhSu());
								break;
							}
							case 3:{
								System.out.println("\nThực phẩm:");
								System.out.println(l1.tieuDeThucPham());
								System.out.println(l1.toStringThucPham());
								break;
							}
						}
						break;
					}
					case 4:{
						System.out.print("Nhập mã hàng cần tìm: ");
						String s; s = sc.next();
						System.out.println(l1.timKiem(s));
						break;
					}
					case 5:{
						l1.sxHHTheoTen();
						System.out.println("Sắp xếp thành công");
						break;
					}
					case 6:{
						l1.sxHHTheoSLTon();
						System.out.println("Sắp xếp thành công");
						break;
					}
					case 7:{
						System.out.println(l1.tieuDe());
						System.out.println(l1.toStringTPKhoBan());
						break;
					}
					case 8:{
						System.out.print("Nhập mã hàng cần xóa: ");
						if(l1.xoaHHTheoMH(sc.next())==true) System.out.println("Xóa thành công!");
						else System.out.println("Không tìm thấy mã hàng cần xóa!");
						break;
					}
					case 9:{
						String mh; double dg;
						System.out.print("Nhập mã hàng cần sửa: "); mh=sc.next();
						System.out.print("Nhập đơn giá: "); dg=sc.nextDouble();
						if(l1.suaDonGiaTheoMH(mh, dg)) System.out.println("Sửa thành công!");
						else System.out.println("Không tìm thấy mã hàng cần sửa!");
						break;
					}
				}
			} while(choice!=0);
			sc.close();
	
	}

}
