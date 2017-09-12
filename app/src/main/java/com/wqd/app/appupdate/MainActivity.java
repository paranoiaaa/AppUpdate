package com.wqd.app.appupdate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.app.update.AppUpdate;
import com.app.update.AppUpdateCheckUpdate;
import com.app.update.DownloadServiceConnection;
import com.wqd.app.dialog.ShowAlertDialog;
import com.wqd.app.listener.DialogOnClickListener;

public class MainActivity extends AppCompatActivity {
    private boolean isUpdate=true;
    private String url ="http://shouji.360tpcdn.com/170831/0577eae6fcaf3744efb07aee53272f18/com.shuchuang.shihua_57.apk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DownloadServiceConnection downloadServiceConnection =new DownloadServiceConnection(new AppUpdateCheckUpdate() {
            @Override
            public void checkUpdate() {
                if (isUpdate){
                    new ShowAlertDialog.Builder(MainActivity.this).setTitleText("Update").setContentText("Update Context").setLeftButtonText("Cancel").setRightButtonText("Confirm")
                            .setCanceledOnTouchOutside(false).setOnclickListener(new DialogOnClickListener() {
                        @Override
                        public void clickLeftButton(View view) {

                        }

                        @Override
                        public void clickRightButton(View view) {
                            AppUpdate.update(MainActivity.this,url);
                        }
                    }).build().show();
                }
            }
        });
        AppUpdate.bindUpdateService(this,downloadServiceConnection);
    }
}
