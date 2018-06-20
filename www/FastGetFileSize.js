var exec = require('cordova/exec');

exports.coolMethod = function (arg0, success, error) {
    exec(success, error, 'FastGetFileSize', 'coolMethod', [arg0]);
};

exports.getFileSize = function (arg0,arg1, success, error) {
    exec(success, error, 'FastGetFileSize', 'getFileSize', [arg0,arg1]);
};
