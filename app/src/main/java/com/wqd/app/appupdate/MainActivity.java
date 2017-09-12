package com.wqd.app.appupdate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app.update.AppUpdate;
import com.app.update.AppUpdateCheckUpdate;
import com.app.update.DownloadServiceConnection;

public class MainActivity extends AppCompatActivity {
    private boolean isUpdate;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DownloadServiceConnection downloadServiceConnection =new DownloadServiceConnection(new AppUpdateCheckUpdate() {
            @Override
            public void checkUpdate() {
                if (isUpdate){
                    AppUpdate.update(MainActivity.this,url);
                }
            }
        });
        AppUpdate.bindUpdateService(this,downloadServiceConnection);
    }
}
