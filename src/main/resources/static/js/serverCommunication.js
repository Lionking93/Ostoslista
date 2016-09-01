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
        merkitseOstetuiksi: function(ostoslista) {
            return $http({
                method: 'POST',
                url: '/merkitseOstetuiksi',
                data: ostoslista
            }).then(function successCallback(response) {
                console.log("Poisto onnistui!");
                return response.data;
            }, function errorCallback(response) {
                console.log("Poisto epäonnistui");
                return response.data;
            });
        },
        haeOstokset: function() {
            return $http({
                method: 'GET',
                url: '/haeOstokset'
            }).then(function successCallback(response) {
                console.log("Ostosten haku onnistui!");
                return response.data;
            }, function errorCallback(response) {
                console.log("Ostosten haku epäonnistui!");
                return response.data;
            })
        }
    };
    return serverCommunicator;
}])