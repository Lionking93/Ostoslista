var app = angular.module('App', ['ngRoute']);

app.config(function($routeProvider) {
    $routeProvider
        .when('/', {
            controller: 'OstosController',
            templateUrl: 'templates/ostoslista.html'
        })
        .when('/tehdytOstokset', {
            controller: 'TehdytOstoksetController',
            templateUrl: 'templates/tehdytOstokset.html'
        })
        .otherwise({
            redirectTo: '/'
        });
});