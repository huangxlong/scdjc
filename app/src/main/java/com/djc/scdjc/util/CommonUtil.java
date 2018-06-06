package com.djc.scdjc.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import com.djc.scdjc.R;
import com.djc.scdjc.app.AppConstant;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Administrator
 * on 2018/5/18 星期五.
 */
public class CommonUtil {
    public static String FormatTime(String time) {
        String[] appTime = time.split("-");
        SimpleDateFormat systemTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] systemTime = systemTimeFormat.format(System.currentTimeMillis()).split("-");
        if (appTime[0].equals(systemTime[0])) {
            return time.substring(5, time.length());
        } else {
            return time;
        }
    }


    /**
     * 日期相同只返回时秒分
     *
     * @param time
     * @return
     */
    public static String FormatTimeOnlyTime(String time) {
        String[] appTime = time.split(" ");
        SimpleDateFormat systemTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] systemTime = systemTimeFormat.format(System.currentTimeMillis()).split(" ");
        if (appTime[0].equals(systemTime[0])) {
            return time.substring(11, time.length());
        } else {
            return time;
        }
    }

    /**
     * 返回当前是星期几
     *
     * @return
     */
    public static String getCurrentWeek() {
        int i = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        String week = "";
        switch (i) {
            case 1:
                week = "星期日";
                break;
            case 2:
                week = "星期一";
                break;
            case 3:
                week = "星期二";
                break;
            case 4:
                week = "星期三";
                break;
            case 5:
                week = "星期四";
                break;
            case 6:
                week = "星期五";
                break;
            case 7:
                week = "星期六";
        }
        return week;
    }

    public static void startActivity(Activity activity, String templateName) {

    }

    public static int getLayout(String templateName) {
        int layout = 0;
//        if (templateName.equals(AppConstant.TYPE_IMG_MEDIUM)) {
        layout = R.layout.item_news_custom;
//        }

//        else if (templateName.equals(AppConstant.TYPE_IMG_SMALL)) {
//            layout = R.layout.item_news_column;
//        }

        return layout;
    }


    public static void saveImageToGallery(Context context, Bitmap bitmap) {
        if (bitmap == null) {
            ToastUtil.show(context, "保存出错了...");
            return;
        }
        // 首先保存图片
        File appDir = new File(Environment.getExternalStorageDirectory(), "djc");
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = "wx_code" + ".jpg";
        File file = new File(appDir, fileName);
        try {
            if (!file.exists()) {
                FileOutputStream fos = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                fos.flush();
                fos.close();

                // 其次把文件插入到系统图库
                try {
                    MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getAbsolutePath(), fileName, null);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                //最后通知图库更新
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);//扫描单个文件
                intent.setData(Uri.fromFile(file));//给图片的绝对路径
                context.sendBroadcast(intent);

                ToastUtil.show(context, "保存成功");
            } else {
                ToastUtil.show(context, "保存成功");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
