app.controller('TehdytOstoksetController', ['$scope', 'serverCommunication', function($scope, serverCommunication) {
    $scope.tehdytOstokset = [];

    var pyynto = serverCommunication.haeTehdytOstokset();
    pyynto.then(function(data){
        $scope.tehdytOstokset = data;
    });
    console.log(pyynto);
}]);