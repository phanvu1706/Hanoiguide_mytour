package com.hanoiguide_lichtrinh.app;

import java.util.ArrayList;
import java.util.List;

import com.example.hanoiguide_lichtrinh.model.DiemDuLich;
import com.example.hanoiguide_lichtrinh.model.ItemTest;

public final class Global {
	public static final List<ItemTest> LIST = new ArrayList<ItemTest>();
	public static final ArrayList<DiemDuLich> LIST_DIEMDULICH = new ArrayList<DiemDuLich>();
	public static MaterialAccount FBaccount = null;
	
	/*
	 * List diem
	 */
	public static void DL() {
		Global.LIST_DIEMDULICH.add(new DiemDuLich("DL_hohoankiem",
				"Hồ Hoàn Kiếm", "", "21.028970", "105.852146"));
		Global.LIST_DIEMDULICH.add(new DiemDuLich("DL_nhatholon",
				"Nhà Thờ Lớn", "", "21.028663", "105.849161"));
		Global.LIST_DIEMDULICH.add(new DiemDuLich("DL_thaprua", "Tháp Rùa", "",
				"21.027951", "105.852243"));
		Global.LIST_DIEMDULICH.add(new DiemDuLich("DL_cotcohanoi",
				"Cột Cờ Hà Nội", "", "21.032647", "105.839900"));
		Global.LIST_DIEMDULICH.add(new DiemDuLich("DL_hoangthanh",
				"Hoàng Thành Thăng Long", "", "21.037112", "105.840003"));
		Global.LIST_DIEMDULICH.add(new DiemDuLich("DL_qtbadinh",
				"Quảng Trường Ba Đình", "", "21.036997", "105.835922"));
		Global.LIST_DIEMDULICH.add(new DiemDuLich("DL_hotay", "Hồ Tây", "",
				"21.054607", "105.825714"));
		Global.LIST_DIEMDULICH.add(new DiemDuLich("DL_vanmieu",
				"Văn Miếu Quốc Tử Giám", "", "21.028430", "105.836042"));
		Global.LIST_DIEMDULICH.add(new DiemDuLich("DL_denkimlien",
				"Đền Kim Liên", "", "21.012402", "105.834315"));
		Global.LIST_DIEMDULICH.add(new DiemDuLich("DL_denquanthanh",
				"Đền Quán Thánh", "", "21.043149", "105.836631"));
		Global.LIST_DIEMDULICH.add(new DiemDuLich("DL_hotrucbach",
				"Hồ Trúc Bạch", "", "21.046233", "105.838892"));
		Global.LIST_DIEMDULICH.add(new DiemDuLich("DL_bthcm",
				"Bảo tàng Hồ Chí Minh", "", "21.035427", "105.832629"));
		Global.LIST_DIEMDULICH.add(new DiemDuLich("DL_chodongxuan",
				"Chợ Đồng Xuân", "", "21.038150", "105.850118"));
		Global.LIST_DIEMDULICH.add(new DiemDuLich("DL_caulongbien",
				"Cầu Long Biên", "", "21.041599", "105.853977"));
		Global.LIST_DIEMDULICH.add(new DiemDuLich("DL_godongda", "Gò Đống Đa",
				"", "21.011841", "105.824502"));
		Global.LIST_DIEMDULICH.add(new DiemDuLich("DL_hoalo",
				"Khu di tích Hỏa Lò", "", "21.024953", "105.846543"));
		Global.LIST_DIEMDULICH.add(new DiemDuLich("DL_chuaquansu",
				"Chùa Quán Sứ", "", "21.024529", "105.845180"));
		Global.LIST_DIEMDULICH.add(new DiemDuLich("DL_nhahatlon",
				"Nhà Hát Lớn Hà Nội", "", "21.023967", "105.857943"));
		Global.LIST_DIEMDULICH.add(new DiemDuLich("DL_langcthochiminh",
				"Lăng Chủ tịch Hồ Chí Minh", "", "21.036487", "105.834651"));
	}
}
