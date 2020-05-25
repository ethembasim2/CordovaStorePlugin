var exec = require('cordova/exec');

exports.checkAvailableService = function (arg0, success, error) {
    exec(success, error, 'ServiceAvailability', 'checkAvailableService', [arg0]);
};
