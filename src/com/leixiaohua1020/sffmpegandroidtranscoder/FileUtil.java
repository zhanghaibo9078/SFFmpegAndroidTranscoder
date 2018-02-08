package com.leixiaohua1020.sffmpegandroidtranscoder;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.leixiaohua1020.sffmpegandroidtranscoder.*;;

public class FileUtil {
	
	public static final int MEDIA_TYPE_IMAGE = 1;

	public static Uri getOutputMediaFileUri(int type,Context mContext){
	      return Uri.fromFile(getOutputMediaFile(type,mContext));
	}
//String path = File.getAbsoultePath();
	@SuppressLint("ShowToast")
	public static File getOutputMediaFile(int type,Context mContext){
		File mediaStorageDir=null;
		File path1=new File("/mnt/udisk1");
		File path2=new File("/mnt/udisk");
		File path3=new File("/mnt/sdcard");
		if(Parameter.addr==1){
		 //   mediaStorageDir = new File(Environment.getExternalStorageDirectory(), "TestCameraFile");
	//		File path1=new File("/mnt/sdcard2");
			mediaStorageDir = new File(path1, "photo");
			if (! mediaStorageDir.exists()){
		        if (! mediaStorageDir.mkdirs()){
		            Log.d("MyCameraApp", "failed to create directory");
		            return null; 
		        }
		    }
		}else if(Parameter.addr==2){
			 mediaStorageDir=new File(path2,"photo");
			 if (! mediaStorageDir.exists()){
			        if (! mediaStorageDir.mkdirs()){
			            Log.d("MyCameraApp", "failed to create directory");
			            return null;
			        }
			    }
			 Log.d("MyCameraApp","路径为"+mediaStorageDir);
		}else if(Parameter.addr==3){
			 mediaStorageDir=new File(path3,"photo");
			 if (! mediaStorageDir.exists()){
			        if (! mediaStorageDir.mkdirs()){
			            Log.d("MyCameraApp", "failed to create directory");
			            return null;
			        }
			    }
			 Log.d("MyCameraApp","路径为"+mediaStorageDir);
		}
	    String timeStamp =  new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    File mediaFile;
	    if (type == MEDIA_TYPE_IMAGE){
	        mediaFile = new File(mediaStorageDir.getPath() + File.separator +
	        "IMG_"+ timeStamp + ".jpg");
	    } else {
	        return null;
	    }

	    return mediaFile;
	}
}