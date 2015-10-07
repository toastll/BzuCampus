package cn.edu.bzu.bzucampus.util;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;




import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

/**
 * 图片加载工具类
 * @author monster
 * @date 2015-07-26
 * 使用多线程的方式进行数据的加载
 */
@SuppressLint("HandlerLeak")
public class ImageLoader {
	
	private ImageView mImageView;
	
	private String mUrl;
	private Handler mHandler=new Handler(){
		public void handleMessage(Message msg) {
			if(mImageView.getTag().equals(mUrl)){
				
				mImageView.setImageBitmap((Bitmap) msg.obj);
			}
		};
	};
	/**
	 * 通过Thread的方式进行图片的加载
	 * @param imageView
	 * @param url
	 */
	public void showImageByThread(ImageView imageView,final String url){
		mImageView=imageView;
		mUrl=url;
		new Thread()	{
			@Override
			public void run() {
				super.run();
				Bitmap bitmap=getBitmapFromURL(url);
				Message message=Message.obtain();
				message.obj=bitmap;
				mHandler.sendMessage(message);
			}
		}.start();
	}
	
	/**
	 * 
	 * @param urlString
	 * @return bitmap
	 */
	public Bitmap getBitmapFromURL(String urlString) {
		Bitmap bitmap;
		InputStream is = null;
		try {
			URL url=new URL(urlString);
			HttpURLConnection connection=(HttpURLConnection) url.openConnection();
			is=new BufferedInputStream(connection.getInputStream());
			bitmap=BitmapFactory.decodeStream(is);
			connection.disconnect(); //关闭连接
			return bitmap;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				is.close();  
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
//修改于:2015年10月7日
