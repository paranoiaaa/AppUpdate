
# AppUpdate

An App Update Util for Android.

# Gradle

```
allprojects {
    repositories {
        jcenter()
        google()
        maven { url 'https://jitpack.io' }
    }
}
```

```
compile('com.github.paranoiaaa:AppUpdate:1.0.1') {
    exclude group: 'com.android.support'
}
```

 # How to Use

```
DownloadServiceConnection downloadServiceConnection =new DownloadServiceConnection(new AppUpdateCheckUpdate() {
    @Override
    public void checkUpdate() {
		------ 网络请前判断是否更新
		if(update){   
       		AppUpdate.update(MainActivity.this,url);
		}
    }
});
AppUpdate.bindUpdateService(this,downloadServiceConnection);
```

