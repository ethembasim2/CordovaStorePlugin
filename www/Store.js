var exec = require('cordova/exec');

exports.redirectToStore = function (arg0, success, error) {
    exec(success, error, 'Store', 'redirectToStore', [arg0]);
};
