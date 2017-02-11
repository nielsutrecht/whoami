var appModule = angular.module('myApp', []);

appModule.controller('MainCtrl', ['$scope', '$http',
        function($scope, $http) {
            $http.get('/whoami').then(function(response) {
                $scope.whoami = response.data;
            });
        } ]);

