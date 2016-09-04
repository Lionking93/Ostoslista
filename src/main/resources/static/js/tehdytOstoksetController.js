app.controller('TehdytOstoksetController', ['$scope', 'serverCommunication', function($scope, serverCommunication) {
    $scope.tehdytOstokset = [];

    var pyynto = serverCommunication.haeOstokset();
    pyynto.then(function(data){
        $scope.tehdytOstokset = data;
    });
}]);