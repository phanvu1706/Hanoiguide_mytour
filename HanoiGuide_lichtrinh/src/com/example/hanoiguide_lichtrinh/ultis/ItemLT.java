package com.example.hanoiguide_lichtrinh.ultis;

import java.io.File;
import java.net.URI;

import com.example.hanoiguide_lichtrinh.My_tour_review;
import com.example.hanoiguide_lichtrinh.R;
import com.example.hanoiguide_lichtrinh.R.id;
import com.example.hanoiguide_lichtrinh.R.layout;
import com.example.hanoiguide_lichtrinh.model.ItemTest;
import com.example.hanoiguide_lichtrinh.model.LichTrinh;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemLT extends Fragment {
	private int imageResource;
	private String text;
	private LichTrinh item;
	private View android;
	private File mediaStorageDir;

	public ItemLT(int imageResource, String text) {
		super();
		this.imageResource = imageResource;
		this.text = text;
	}

	public ItemLT(LichTrinh item) {
		super();
		this.item = item;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		if (Build.VERSION.SDK_INT > 8) {
			mediaStorageDir = Environment
					.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
		} else {
			mediaStorageDir = new File(
					Environment.getExternalStorageDirectory(), "Pictures");
		}

		android = inflater.inflate(R.layout.mytour_list_item, container, false);
		
		setHasOptionsMenu(true);
		
		ImageView iv = (ImageView) android.findViewById(R.id.circularImg);
		TextView tv = (TextView) android.findViewById(R.id.tvTourName);
		if (item != null) {
			// Xử lý thông tin file ảnh
			File file;
			file = getFileFromUri("file://" + mediaStorageDir.getPath() + "/"
					+ item.getImage());

			if (file != null) { // Nếu file khác null thì sẽ được Decode thành
								// file
								// Bitmap và hiển thị
				Bitmap bm = decodeSampledBitmapFromFile(file, 500, 500);
				iv.setImageBitmap(bm);
			}
			iv.setImageResource(1);
			iv.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent t = new Intent(getActivity(), My_tour_review.class);
					t.putExtra("item", item);
					startActivity(t);
				}
			});

			tv.setText(item.getTenLichTrinh());

		} else {
			iv.setImageResource(imageResource);
			tv.setText(text);
		}

		return android;
	}

	private Bitmap decodeSampledBitmapFromFile(File file, int reqWidth,
			int reqHeight) {
		// TODO Auto-generated method stub
		// First decode with inJustDecodeBounds=true to check dimensions
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeFile(file.getAbsolutePath(), options);

		// Calculate inSampleSize
		options.inSampleSize = calculateInSampleSize(options, reqWidth,
				reqHeight);

		// Decode bitmap with inSampleSize set
		options.inJustDecodeBounds = false;
		return BitmapFactory.decodeFile(file.getAbsolutePath(), options);
	}

	private File getFileFromUri(String imgUri) {
		// TODO Auto-generated method stub

		try {
			URI uri = URI.create(imgUri);
			File file = new File(uri);
			if (file != null) {
				if (file.canRead()) {
					return file;
				}
			}
		} catch (Exception e) {
			return null;
		}

		return null;
	}

	/** Calculate the scaling factor */
	public static int calculateInSampleSize(BitmapFactory.Options options,
			int reqWidth, int reqHeight) {
		// Raw height and width of image
		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;

		if (height > reqHeight || width > reqWidth) {

			// Calculate ratios of height and width to requested height and
			// width
			final int heightRatio = Math.round((float) height
					/ (float) reqHeight);
			final int widthRatio = Math.round((float) width / (float) reqWidth);

			// Choose the smallest ratio as inSampleSize value, this will
			// guarantee
			// a final image with both dimensions larger than or equal to the
			// requested height and width.
			inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
		}

		return inSampleSize;
	}

}
