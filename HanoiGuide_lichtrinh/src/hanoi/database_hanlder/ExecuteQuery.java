package hanoi.database_hanlder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.hanoiguide_lichtrinh.model.LichTrinh;
import com.example.hanoiguide_lichtrinh.model.LichTrinh_Diemdulich;
import com.example.hanoiguide_lichtrinh.model.Track;
import com.example.hanoiguide_lichtrinh.model.Waypoint;
import com.example.hanoiguide_lichtrinh.ultis.MyTourComplete_Item;

import android.R.color;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

public class ExecuteQuery {
	protected static final String TAG = "Execute Query";
	SQLiteDatabase database;
	DatabaseHelper mDbHelper;
	private final Context mContext;

	public ExecuteQuery(Context context) {
		this.mContext = context;
		mDbHelper = new DatabaseHelper(mContext);
	}

	public ExecuteQuery createDatabase() throws SQLException {
		try {
			mDbHelper.createDataBase();
		} catch (IOException mIOException) {
			Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase");
			throw new Error("UnableToCreateDatabase");
		}
		return this;
	}

	public ExecuteQuery open() throws SQLException {
		try {
			mDbHelper.openDataBase();
		} catch (SQLException mSQLException) {
			Log.e(TAG, "open >>" + mSQLException.toString());
			throw mSQLException;
		}
		return this;
	}

	public void close() {
		mDbHelper.close();
	}

	/*
	 * Insert into tblTrack
	 */
	public int insert_table_track(Track track) {
		ContentValues values = new ContentValues();
		database = mDbHelper.getWritableDatabase();

		values.put(ColumnName.TRACK_MALICHTRINH, track.getMaLichTrinh());
		values.put(ColumnName.TRACK_TRACKID, track.getTrackID());
		values.put(ColumnName.TRACK_TEN, track.getTen());
		values.put(ColumnName.TRACK_THOIGIANTAO, track.getThoiGianTao());

		int msg = Message_log.FALSE;
		if (database.insert(ColumnName.TRACK_TABLE, null, values) == -1) {
			msg = Message_log.FALSE;
		} else {
			msg = Message_log.SUCCESSFULL;
		}
		database.close();
		return msg;
	}

	/*
	 * Select all from tblTrack
	 */
	public ArrayList<Track> getAllTrack() {
		ArrayList<Track> listTrack = new ArrayList<Track>();
		String selectQuery = "SELECT * FROM " + ColumnName.TRACK_TABLE;
		database = mDbHelper.getReadableDatabase();
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				Track track = new Track();
				track.setMaLichTrinh(cursor.getString(cursor
						.getColumnIndex(ColumnName.TRACK_MALICHTRINH)));
				track.setTen(cursor.getString(cursor
						.getColumnIndex(ColumnName.TRACK_TEN)));
				track.setThoiGianTao(cursor.getString(cursor
						.getColumnIndex(ColumnName.TRACK_THOIGIANTAO)));
				track.setTrackID(cursor.getString(cursor
						.getColumnIndex(ColumnName.TRACK_TRACKID)));
				listTrack.add(track);
			} while (cursor.moveToNext());
		}
		return listTrack;
	}

	/*
	 * Select from tblTrack where trackID
	 */
	public ArrayList<Track> getTrackByTrackID(String trackID) {
		ArrayList<Track> listTrack = new ArrayList<Track>();
		String selectQuery = "SELECT * FROM " + ColumnName.TRACK_TABLE
				+ " WHERE " + ColumnName.TRACK_TRACKID + " = " + trackID;
		database = mDbHelper.getReadableDatabase();
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				Track track = new Track();
				track.setMaLichTrinh(cursor.getString(cursor
						.getColumnIndex(ColumnName.TRACK_MALICHTRINH)));
				track.setTen(cursor.getString(cursor
						.getColumnIndex(ColumnName.TRACK_TEN)));
				track.setThoiGianTao(cursor.getString(cursor
						.getColumnIndex(ColumnName.TRACK_THOIGIANTAO)));
				track.setTrackID(cursor.getString(cursor
						.getColumnIndex(ColumnName.TRACK_TRACKID)));
				listTrack.add(track);
			} while (cursor.moveToNext());
		}
		return listTrack;
	}

	/*
	 * Select from tblTrack where maLichTrinh
	 */
	public ArrayList<Track> getTrackByMaLichTrinh(String maLichTrinh) {
		ArrayList<Track> listTrack = new ArrayList<Track>();
		String selectQuery = "SELECT * FROM " + ColumnName.TRACK_TABLE
				+ " WHERE " + ColumnName.TRACK_MALICHTRINH + " = "
				+ maLichTrinh;
		database = mDbHelper.getReadableDatabase();
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				Track track = new Track();
				track.setMaLichTrinh(cursor.getString(cursor
						.getColumnIndex(ColumnName.TRACK_MALICHTRINH)));
				track.setTen(cursor.getString(cursor
						.getColumnIndex(ColumnName.TRACK_TEN)));
				track.setThoiGianTao(cursor.getString(cursor
						.getColumnIndex(ColumnName.TRACK_THOIGIANTAO)));
				track.setTrackID(cursor.getString(cursor
						.getColumnIndex(ColumnName.TRACK_TRACKID)));
				listTrack.add(track);
			} while (cursor.moveToNext());
		}
		return listTrack;
	}

	/*
	 * Select from tblTrack where maLichTrinh and trackID
	 */
	public Track getSingleTrack(String maLichTrinh, String trackID) {

		String selectQuery = "SELECT * FROM " + ColumnName.TRACK_TABLE
				+ " WHERE " + ColumnName.TRACK_MALICHTRINH + " = "
				+ maLichTrinh + " AND " + ColumnName.TRACK_TRACKID + " = "
				+ trackID;
		database = mDbHelper.getReadableDatabase();
		Cursor cursor = database.rawQuery(selectQuery, null);
		Track track = new Track();
		if (cursor.moveToFirst()) {
			track.setMaLichTrinh(cursor.getString(cursor
					.getColumnIndex(ColumnName.TRACK_MALICHTRINH)));
			track.setTen(cursor.getString(cursor
					.getColumnIndex(ColumnName.TRACK_TEN)));
			track.setThoiGianTao(cursor.getString(cursor
					.getColumnIndex(ColumnName.TRACK_THOIGIANTAO)));
			track.setTrackID(cursor.getString(cursor
					.getColumnIndex(ColumnName.TRACK_TRACKID)));
		}
		return track;
	}

	/*
	 * Delete row Track
	 */
	public boolean delete_RecordTable_Track(String maLichTrinh, String trackID) {
		try {
			String del = "DELETE FROM " + ColumnName.TRACK_TABLE + " WHERE "
					+ ColumnName.TRACK_TRACKID + " = " + trackID + " AND "
					+ ColumnName.TRACK_MALICHTRINH + " = " + maLichTrinh;
			database = mDbHelper.getWritableDatabase();
			database.execSQL(del);
			database.close();
			return true;
		} catch (SQLiteException e) {
			return false;
		}
	}

	/*
	 * Insert table Lichtrinh
	 */
	public int insert_table_lichtrinh(LichTrinh lichtrinh) {
		ContentValues values = new ContentValues();
		database = mDbHelper.getWritableDatabase();

		values.put(ColumnName.LICHTRINH_MALICHTRINH, lichtrinh.getMaLichTrinh());
		values.put(ColumnName.LICHTRINH_TENLICHTRINH,
				lichtrinh.getTenLichTrinh());
		values.put(ColumnName.LICHTRINH_MOTA, lichtrinh.getMota());
		values.put(ColumnName.LICHTRINH_IMAGE, lichtrinh.getImage());
		values.put(ColumnName.LICHTRINH_ISPUBLIC, lichtrinh.getIsPublic());
		values.put(ColumnName.LICHTRINH_NGAY_BATDAU, lichtrinh.getNgayDatDau());
		values.put(ColumnName.LICHTRINH_NGAY_KETTHUC,
				lichtrinh.getNgayKetThuc());
		values.put(ColumnName.LICHTRINH_REMINDER, lichtrinh.getReminder());
		values.put(ColumnName.LICHTRINH_DIEMDB_LAT, lichtrinh.getDiemDB_lat());
		values.put(ColumnName.LICHTRINH_DIEMDB_LON, lichtrinh.getDiemDB_lon());
		values.put(ColumnName.LICHTRINH_USER_ID, lichtrinh.getUser_id());

		int msg = Message_log.FALSE;
		if (database.insert(ColumnName.LICHTRINH_TABLE, null, values) == -1) {
			msg = Message_log.FALSE;
		} else {
			msg = Message_log.SUCCESSFULL;
		}
		database.close();
		return msg;
	}

	/*
	 * Insert table Lichtrinh_Diemdulich
	 */
	public int insert_table_lichtrinh_diemdulich(LichTrinh_Diemdulich ld) {
		ContentValues values = new ContentValues();
		database = mDbHelper.getWritableDatabase();

		values.put(ColumnName.LICHTRINH_DIEMDULICH_MALICHTRINH,
				ld.getMaLichTrinh());
		values.put(ColumnName.LICHTRINH_DIEMDULICH_MADIEMDL, ld.getMaDiemDL());
		values.put(ColumnName.LICHTRINH_DIEMDULICH_THOIGIAN, ld.getThoigian());

		int msg = Message_log.FALSE;
		if (database
				.insert(ColumnName.LICHTRINH_DIEMDULICH_TABLE, null, values) == -1) {
			msg = Message_log.FALSE;
		} else {
			msg = Message_log.SUCCESSFULL;
		}
		database.close();
		return msg;
	}

	/*
	 * Insert table Waypoint
	 */
	public int insert_table_waypoint(Waypoint wp) {
		ContentValues values = new ContentValues();
		database = mDbHelper.getWritableDatabase();

		values.put(ColumnName.WAYPOINT_ID, wp.getWaypointID());
		values.put(ColumnName.WAYPOINT_LATITUDE, wp.getLatitude());
		values.put(ColumnName.WAYPOINT_LONGTITUDE, wp.getLongtitude());
		values.put(ColumnName.WAYPOINT_TIME, wp.getTime());
		values.put(ColumnName.WAYPOINT_ACCURACY, wp.getAccuracy());
		values.put(ColumnName.WAYPOINT_SPEED, wp.getSpeed());
		values.put(ColumnName.WAYPOINT_TRACKID, wp.getTrackID());

		int msg = Message_log.FALSE;
		if (database.insert(ColumnName.WAYPOINT_TABLE, null, values) == -1) {
			msg = Message_log.FALSE;
		} else {
			msg = Message_log.SUCCESSFULL;
		}
		database.close();
		return msg;
	}

	/*
	 * Update time tblLichtrinh_Diemdulich
	 */
	public void update_thoigian_tbl_lichtrinh_diemdulich(LichTrinh_Diemdulich ld) {
		database = mDbHelper.getWritableDatabase();
		String upd = "UPDATE tblLichtrinh_Diemdulich SET thoigian = '"
				+ ld.getThoigian() + "' WHERE maLichTrinh = '"
				+ ld.getMaLichTrinh() + "' AND maDiemDL = '" + ld.getMaDiemDL()
				+ "'";
		try {
			database.execSQL(upd);
		} catch (SQLException e) {

		}
		database.close();
	}

	/*
	 * Select tenDiemDL, maDiemDL from tblLichtrinh_diemdulich by maLichtrinh
	 */
	public ArrayList<MyTourComplete_Item> select_tenma_tbl_lichtrinh_diemdulich(
			String maLichTrinh) {
		ArrayList<MyTourComplete_Item> list = new ArrayList<MyTourComplete_Item>();

		database = mDbHelper.getReadableDatabase();
		String sel = "SELECT tblDiemDuLich."
				+ ColumnName.DIEMDULICH_MADIEMDL
				+ ", "
				+ ColumnName.DIEMDULICH_TENDIEMDL
				+ " FROM tblDiemDuLich, tblLichtrinh_Diemdulich WHERE tblDiemDuLich.maDiemDL = tblLichtrinh_Diemdulich.maDiemDL AND tblLichtrinh_Diemdulich.maLichTrinh = '"
				+ maLichTrinh + "'";
		Cursor c = database.rawQuery(sel, null);
		if (c.moveToFirst()) {
			do {
				MyTourComplete_Item s = new MyTourComplete_Item();
				s.setMaDiemDL(c.getString(0));
				s.setTenDiemDL(c.getString(1));
				s.setMaDiemDL("00:00");
				list.add(s);
			} while (c.moveToNext());
		}
		return list;
	}
}
