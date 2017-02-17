var appModule = angular.module('myApp', []);

appModule.controller('MainCtrl', ['$scope', '$http',
    function($scope, $http) {
        $http.get('/whoami').then(function(response) {
            $scope.whoami = response.data;
            $scope.whoami.time = new Date($scope.whoami.time);
            $scope.whoami.startup = new Date($scope.whoami.startup);
        });

        $http.get('/info').then(function(response) {
            $scope.info = response.data;
            $scope.info.build.time = new Date($scope.info.build.time);
        });
    }
]);



