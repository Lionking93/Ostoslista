app.controller('OstosController', ['$scope', 'serverCommunication', function($scope, serverCommunication) {

    $scope.ostoslista = [];

    $scope.ostos = {
        id: "",
        nimi: "",
        maara: "",
        yksikko: "",
        ostettu: false
    };

    $scope.onkoYhtakaanTuotettaOstettu = false;

    $scope.naytaTaiPiilotaLisays = "Lisää uusi ostos";

    $scope.naytetaankoLisaysnakyma = false;

    $scope.lisayksenTila = "";

    $scope.onnistuikoLisays = false;

    $scope.ostoslistanTuotettaPainetaan = function(ostos) {
        ostos.ostettu === false ? ostos.ostettu = true : ostos.ostettu = false;
        naytaTaiPiilotaOstoslistanTyhjennysNappi();
    }

    $scope.naytaTaiPiilotaLisaysnakyma = function() {
        if ($scope.naytetaankoLisaysnakyma === true) {
            $scope.naytetaankoLisaysnakyma = false;
            $scope.naytaTaiPiilotaLisays = "Lisää uusi ostos";
        } else {
            $scope.naytetaankoLisaysnakyma = true;
            $scope.naytaTaiPiilotaLisays = "Piilota lisäysnäkymä";
        }
    }

    $scope.lisaaOstos = function() {
        var lisattava = angular.toJson($scope.ostos);
        var lisaysPyynto = serverCommunication.lahetaOstos(lisattava);
        lisaysPyynto.then(function(data) {
            $scope.ostoslista = data;
            updateAfterSuccessfulAddition;
        })
    };

    $scope.poistaYliviivatut = function() {
        var uusiTaulukko = [];
        var poistettavat = [];
        for (i = 0; i < $scope.ostoslista.length; i++) {
            if ($scope.ostoslista[i].ostettu === false) {
                uusiTaulukko.push($scope.ostoslista[i]);
            } else {
                poistettavat.push($scope.ostoslista[i]);
            }
        }
        serverCommunication.poistaOstokset(angular.toJson(poistettavat));
        $scope.ostoslista = uusiTaulukko;
        naytaTaiPiilotaOstoslistanTyhjennysNappi();
        poistoOnnistui();
    }

    var hakuPyynto = serverCommunication.haeTehdytOstokset();
    hakuPyynto.then(function(data) {
        $scope.ostoslista = data;
    });

    var onkoOstettuja = function() {
        for (i = 0; i < $scope.ostoslista.length; i++) {
            if ($scope.ostoslista[i].ostettu === true) {
                return true;
            }
        }
        return false;
    }

    var naytaTaiPiilotaOstoslistanTyhjennysNappi = function() {
        if (onkoOstettuja() === true) {
            $scope.onkoYhtakaanTuotettaOstettu = true;
        } else {
            $scope.onkoYhtakaanTuotettaOstettu = false;
        }
    }

    var lisaysOnnistui = function() {
        $scope.onnistuikoLisays = true;
        $scope.lisayksenTila = "Lisäys onnistui!";
    }

    var lisaysEpaonnistui = function() {
        $scope.onnistuikoLisays = false;
        $scope.lisayksenTila = "Lisäys epäonnistui!";
    }

    var poistoOnnistui = function() {
        $scope.lisayksenTila = "Poisto onnistui!";
    }

    var updateAfterSuccessfulAddition = function(lisattava) {
        lisaysOnnistui();
        nollaaOstoksenTiedotLisaysnakymasta();
        $scope.naytaTaiPiilotaLisaysnakyma();
        console.log("Lisäys onnistui");
    }

    var updateAfterFailedAddition = function() {
        lisaysEpaonnistui();
        console.log("Lisäys epäonnistui");
        $scope.naytaTaiPiilotaLisaysnakyma();
    }

    var nollaaOstoksenTiedotLisaysnakymasta = function() {
        $scope.ostos.nimi = "";
        $scope.ostos.maara = "";
        $scope.ostos.yksikko = "";
        $scope.ostos.ostettu = false;
    }
}]);