app.factory('serverCommunication', ['$http', function($http) {
    var serverCommunicator = {
        lahetaOstos: function(lisattava, updateAfterSuccessfulAddition, updateAfterFailedAddition) {
            $http({
                method: 'POST',
                url: '/lisaaOstos',
                data: lisattava
            }).then(function successCallback(response) {
                updateAfterSuccesfulAddition;
            }, function errorCallback(response) {
                updateAfterFailedAddition;
            });
        }
    };
    return serverCommunicator;
}])