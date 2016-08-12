app.factory('serverCommunication', ['$http', function($http) {
    var serverCommunicator = {
        lahetaOstos: function(lisattava, updateAfterSuccess, updateAfterFailure) {
            $http({
                method: 'POST',
                url: '/lisaaOstos',
                data: lisattava
            }).then(function successCallback(response) {
                updateAfterSuccess;
            }, function errorCallback(response) {
                updateAfterFailure;
            });
        }
    };
    return serverCommunicator;
}])