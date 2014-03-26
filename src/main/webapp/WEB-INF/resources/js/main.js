var app = angular.module("app", []);

function initializeBeforeSearch($scope) {
    $scope.user = null;
    $scope.error = null;
}

app.controller('HomeController', function ($scope, $http) {
    $scope.message = 'Hello world';

    $scope.search = function () {
        initializeBeforeSearch($scope);
        $http({method: 'GET', url: '/customerDetail?phone=' + $scope.phone}).
            success(function (data, status, headers, config) {
                if (data != "") {
                    $scope.user = data;
                }
            }).error(function (data, status, headers, config) {
                if (status == 404)
                    $scope.error = "User not found, Please Register to continue"
            });
    };

    $scope.register = function () {
        userToRegister = {
            name: $scope.name,
            phone: $scope.phone
        };
        $http({method: 'POST', url: '/registerCustomer', userToRegister: userToRegister}).
            success(function (data, status, headers, config) {
                console.log(data);
            }).error(function (data, status, headers, config) {
                console.log(data);
            });
    };


    $scope.isUserLoaded = function () {
        return $scope.user != null;
    }
});