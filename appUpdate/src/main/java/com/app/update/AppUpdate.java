package com.app.update;

import android.content.Context;
import android.content.Intent;

import static android.content.Context.BIND_AUTO_CREATE;

/**
 * Created by Paranoia on 16-8-27.
 */

public class AppUpdate {
    public static void update(Context context, String downloadUrl) {
        Intent intent = new Intent(context.getApplicationContext(), DownloadService.class);
        intent.putExtra(Constants.APK_DOWNLOAD_URL, downloadUrl);
        context.startService(intent);
    }

    public static void bindUpdateService(Context mContext,DownloadServiceConnection connection) {
        mContext.bindService(new Intent(mContext, DownloadService.class), connection, BIND_AUTO_CREATE);
    }
}
