package com.andyidea.cat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader.TileMode;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class ImageAdapter extends BaseAdapter {
	private ImageView[] mImages;

	private Context mContext;
	public List<Map<String, Object>> list;
	

	public Integer[] imgs = { R.drawable.img01, R.drawable.img02, R.drawable.img03, R.drawable.img04, R.drawable.img05, 
							  R.drawable.img06, R.drawable.img07, R.drawable.img08, R.drawable.img09, R.drawable.img10 };
	
	public ImageAdapter(Context c) {
		this.mContext = c;
		list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < imgs.length; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("image", imgs[i]);
			list.add(map);
		}
		mImages = new ImageView[list.size()];
	}

	
	public boolean createReflectedImages() {
		final int reflectionGap = 3;
		int index = 0;
		for (Map<String, Object> map : list) {
			Integer id = (Integer) map.get("image");
			Bitmap tbitmap = BitmapFactory.decodeResource(mContext.getResources(), id);
			Bitmap originalImage = Bitmap.createScaledBitmap(tbitmap, 248, 350, true);	
			int width = originalImage.getWidth();
			int height = originalImage.getHeight();

			Matrix matrix = new Matrix();
			matrix.preScale(1, -1);			
			Bitmap reflectionImage = Bitmap.createBitmap(originalImage, 0, height*3/4, width, height/4, matrix, false);	
			Bitmap bitmapWithReflection = Bitmap.createBitmap(width, (height + height/4), Config.ARGB_8888);			

			Canvas canvas = new Canvas(bitmapWithReflection);	
			canvas.drawBitmap(originalImage, 0, 0, null);		
			Paint paint = new Paint();
			paint.setColor(0x00ffffff);
			canvas.drawRect(0, height, width, height + reflectionGap, paint);		
			canvas.drawBitmap(reflectionImage, 0, height + reflectionGap, null);	

			paint = new Paint();
			LinearGradient shader = new LinearGradient(0, originalImage.getHeight(), 0, bitmapWithReflection.getHeight() + reflectionGap, 0x70ffffff, 0x00ffffff, TileMode.CLAMP);
			paint.setShader(shader);
			paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
			canvas.drawRect(0, height, width, bitmapWithReflection.getHeight() + reflectionGap, paint);		

			ImageView imageView = new ImageView(mContext);
			imageView.setImageBitmap(bitmapWithReflection);		
			imageView.setLayoutParams(new myGallery.LayoutParams(originalImage.getWidth(), originalImage.getHeight()+originalImage.getHeight()/2));
			imageView.setScaleType(ScaleType.MATRIX);
			mImages[index++] = imageView;
		}
		return true;
	}

	@Override
	public int getCount() {
		return Integer.MAX_VALUE;
	}

	@Override
	public Object getItem(int position) {
		return mImages[position % imgs.length];
	}

	@Override
	public long getItemId(int position) {
		return position % imgs.length;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return mImages[position % imgs.length];
	}

	public float getScale(boolean focused, int offset) {
		return Math.max(0, 1.0f / (float) Math.pow(2, Math.abs(offset)));
	}

}
