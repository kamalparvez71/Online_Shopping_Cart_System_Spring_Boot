var myApp = angular.module('myApp', []);


myApp.controller('myCtrl', function ($scope, $http) {
    $scope.message = "";
    $scope.error_message = "";

    //get All product
    $scope.getAllproduct = function () {
        $http({
            mehtod: "GET",
            url: 'http://localhost:8084/HRManagement3/webresources/products'
        }).then(
                function (response) {
                    $scope.products = response.data;
                },
                function (reason) {
                    $scope.error_message = reason.data;
                }
        );

    };

    $scope.getAllproduct();


    //save product
    $scope.newProduct = {};
    $scope.saveProduct = function () {
        $http({
            method: 'POST',
            url: 'http://localhost:8084/HRManagement3/webresources/products',
            data: angular.toJson($scope.newProduct),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(
                function (response) {
                    $scope.message = "Product Saved Successfully";
                    $scope.getAllproduct();
                },
                function (reason) {
                    $scope.error_message = reason.data;
                }
        );
    };



    //select product by click
    $scope.clickedProduct = {};
    $scope.selectProduct = function (product) {
        $scope.clickedProduct = product;
    };


    //updte product
    $scope.updateProduct = function () {
        $http({
            method: 'PUT',
            url: 'http://localhost:8084/HRManagement3/webresources/products',
            data: angular.toJson($scope.clickedProduct),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(
                function (response) {
                    $scope.message = "Product Update Successfully";
                    $scope.getAllproduct();
                },
                function (reason) {
                    $scope.error_message = reason.data;
                }
        );
    };

    //delete product
    $scope.deleteProduct = function () {
        $http({
            method: 'DELETE',
            url: 'http://localhost:8084/HRManagement3/webresources/products/' + $scope.clickedProduct.pid
        }).then(
                function (response) {
                    $scope.message = "Product deleted Successfully";
                    $scope.getAllproduct();
                },
                function (reason) {
                    $scope.error_message = reason.data;
                }
        );
    };


    //clear message
    $scope.messageClose = function () {
        $scope.message = "";
        $scope.error_message = "";
    };



});

