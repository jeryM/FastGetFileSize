# FastGetFileSize
快速获得文件大小

此分支用于上传到npm仓库

#### Installation

`cordova plugin add https://github.com/jeryM/FastGetFileSize.git`

`cordova plugin add cordova.plugin.fast.get.file.size`

`npm install cordova.plugin.fast.get.file.size`

#### using

declare let FastGetFileSize:any;
FastGetFileSize.getFileSize(String externalRootDirectory,String filepath,successCallback,errorCallback);

