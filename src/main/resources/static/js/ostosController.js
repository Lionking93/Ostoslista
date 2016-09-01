app.controller('OstosController', ['$scope', 'serverCommunication', function($scope, serverCommunication) {

    var hakuPyynto = serverCommunication.haeOstokset();
    hakuPyynto.then(function(data) {
        $scope.ostoslista = data;
        lisaaPoistettavaKentat();
    });

    $scope.ostoslista = [];

    $scope.ostos = {
        id: "",
        nimi: "",
        maara: "",
        yksikko: "",
        ostettu: false,
        poistettava: false
    };

    $scope.onkoYhtakaanTuotettaOstettu = false;

    $scope.naytaTaiPiilotaLisays = "Lisää uusi ostos";

    $scope.naytetaankoLisaysnakyma = false;

    $scope.lisayksenTila = "";

    $scope.onnistuikoLisays = false;

    $scope.ostoslistanTuotettaPainetaan = function(ostos) {
        ostos.poistettava === false ? ostos.poistettava = true : ostos.poistettava = false;
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
            lisaaPoistettavaKentat();
            paivitaOnnistuneenLisayksenJalkeen();
        }, function(data) {
            paivitaEpaonnistuneenLisayksenJalkeen();
        })
    };

    $scope.poistaYliviivatut = function() {
        var poistettavat = [];
        console.log($scope.ostoslista);
        for (i = 0; i < $scope.ostoslista.length; i++) {
            if ($scope.ostoslista[i].poistettava === true) {
                $scope.ostoslista[i].ostettu = true;
                poistettavat.push($scope.ostoslista[i]);
            }
        }
        var poistoPyynto = serverCommunication.merkitseOstetuiksi(angular.toJson(poistettavat));
        poistoPyynto.then(function(data) {
            $scope.ostoslista = data;
            lisaaPoistettavaKentat();
            naytaTaiPiilotaOstoslistanTyhjennysNappi();
            poistoOnnistui();
        });
    }

    function lisaaPoistettavaKentat() {
        angular.forEach($scope.ostoslista, function(ostos) {
            ostos.poistettava = false;
        });
    }

    function onkoOstettuja() {
        for (i = 0; i < $scope.ostoslista.length; i++) {
            if ($scope.ostoslista[i].poistettava === true) {
                return true;
            }
        }
        return false;
    }

    function naytaTaiPiilotaOstoslistanTyhjennysNappi() {
        if (onkoOstettuja() === true) {
            $scope.onkoYhtakaanTuotettaOstettu = true;
        } else {
            $scope.onkoYhtakaanTuotettaOstettu = false;
        }
    }

    function lisaysOnnistui() {
        $scope.onnistuikoLisays = true;
        $scope.lisayksenTila = "Lisäys onnistui!";
    }

    function lisaysEpaonnistui() {
        $scope.onnistuikoLisays = false;
        $scope.lisayksenTila = "Lisäys epäonnistui!";
    }

    function poistoOnnistui() {
        $scope.lisayksenTila = "Poisto onnistui!";
    }

    function paivitaOnnistuneenLisayksenJalkeen(lisattava) {
        lisaysOnnistui();
        nollaaOstoksenTiedotLisaysnakymasta();
        $scope.naytaTaiPiilotaLisaysnakyma();
        console.log("Lisäys onnistui");
    }

    function paivitaEpaonnistuneenLisayksenJalkeen() {
        lisaysEpaonnistui();
        console.log("Lisäys epäonnistui");
        $scope.naytaTaiPiilotaLisaysnakyma();
    }

    function nollaaOstoksenTiedotLisaysnakymasta() {
        $scope.ostos.nimi = "";
        $scope.ostos.maara = "";
        $scope.ostos.yksikko = "";
        $scope.ostos.ostettu = false;
        $scope.ostos.poistettava = false;
    }
}]);