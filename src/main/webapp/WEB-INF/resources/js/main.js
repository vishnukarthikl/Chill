var app = angular.module("app", []);

app.controller('HomeController', function ($scope, $http) {
    $scope.message = 'Hello world';

    $scope.search = function () {
        console.log($scope.phone);
        $http({method: 'GET', url: '/customerDetail?phone=' + $scope.phone}).
            success(function (data, status, headers, config) {
                console.log(data);
            }).error(function (data, status, headers, config) {
                console.log(data);
            });
    }
});