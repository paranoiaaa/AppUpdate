package com.app.update;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/**
 * Created by Paranoia on 17-9-12.
 */

public class DownloadServiceConnection implements ServiceConnection {

    private AppUpdateCheckUpdate appUpdateCheckUpdate;

    public DownloadServiceConnection(AppUpdateCheckUpdate appUpdateCheckUpdate) {
        this.appUpdateCheckUpdate = appUpdateCheckUpdate;
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder service) {
        if (service != null) {
            DownloadService downloadService = ((DownloadService.MyBinder) service).getService();
            if (!downloadService.isDownLoading) {
                appUpdateCheckUpdate.checkUpdate();
            }
        } else {
            appUpdateCheckUpdate.checkUpdate();
        }
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {

    }
}
