package com.app.update;

import android.content.Context;
import android.content.Intent;

/**
 * Created by wqd on 16-8-27.
 */

public class AppUpdate {
    public static void update(Context context, String downloadUrl) {
        Intent intent = new Intent(context.getApplicationContext(), DownloadService.class);
        intent.putExtra(Constants.APK_DOWNLOAD_URL, downloadUrl);
        context.startService(intent);
    }
}
