app.factory('serverCommunication', ['$http', function($http) {
    var serverCommunicator = {
        lahetaOstos: function(lisattava) {
            return $http({
                method: 'POST',
                url: '/lisaaOstos',
                data: lisattava
            }).then(function successCallback(response) {
                console.log("Lisäys onnistui");
                return response.data;
            }, function errorCallback(response) {
                console.log("Lisäys epäonnistui");
                return response.data;
            });
        },
        poistaOstokset: function(ostoslista) {
            $http({
                method: 'POST',
                url: '/poistaOstokset',
                data: ostoslista
            }).then(function successCallback(response) {
                console.log("Poisto onnistui!");
            }, function errorCallback(response) {
                console.log("Poisto epäonnistui");
            });
        },
        haeTehdytOstokset: function() {
            return $http({
                method: 'GET',
                url: '/haeTehdytOstokset'
            }).then(function successCallback(response) {
                console.log("Tehtyjen ostosten haku onnistui!");
                return response.data;
            }, function errorCallback(response) {
                console.log("Tehtyjen ostosten haku epäonnistui!");
                return response.data;
            })
        }
    };
    return serverCommunicator;
}])