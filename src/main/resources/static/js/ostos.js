app.controller('OstosController', ['$scope', '$http', function($scope, $http) {

    $scope.ostoslista = [];

    $scope.ostos = {
        nimi: "",
        maara: ""
    };

    $scope.naytaTaiPiilotaLisays = "Lisää uusi ostos";

    $scope.naytetaankoLisaysnakyma = false;

    $scope.lisayksenTila = "";

    $scope.onnistuikoLisays = false;

    $scope.naytaLisaysnakyma = function() {
        if ($scope.naytetaankoLisaysnakyma === true) {
            $scope.naytetaankoLisaysnakyma = false;
            $scope.naytaTaiPiilotaLisays = "Lisää uusi ostos";
        } else {
            $scope.naytetaankoLisaysnakyma = true;
            $scope.naytaTaiPiilotaLisays = "Piilota lisäysnäkymä";
        }
    }

    $scope.lisaaOstos = function() {
        var lisattava = "{\"nimi\":\""+$scope.ostos.nimi+"\",\"maara\":\""+$scope.ostos.maara+"\"}";
        console.log(lisattava);
        $http({
            method: 'POST',
            url: '/lisaaOstos',
            data: lisattava
        }).then(function successCallback(response) {
            $scope.onnistuikoLisays = true;
            $scope.lisayksenTila = "Lisäys onnistui!";
            $scope.ostoslista.push(angular.fromJson(lisattava));
            $scope.ostos.nimi = "";
            $scope.ostos.maara = "";
            $scope.naytetaankoLisaysnakyma = false;
            console.log($scope.ostoslista);
            $scope.naytaTaiPiilotaLisays = "Lisää uusi ostos";
            console.log("Lisäys onnistui");
        }, function errorCallback(response) {
            console.log("Lisäys epäonnistui");
            $scope.onnistuikoLisays = false;
            $scope.lisayksenTila = "Lisäys epäonnistui!";
        });
    };
}]);