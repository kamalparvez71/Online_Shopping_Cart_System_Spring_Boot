var demoApp = angular.module("myApp", []);

demoApp.controller('ProCtrl', function ($scope, $http) {
    $scope.message = "";
    $scope.error_message = "";

    //get All product
    $scope.getAllproduct = function () {
        $http({
            mehtod: "GET",
            url: 'http://localhost:8084/AngularDemoPractices/rest/api/products/productlist'
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
            url: 'http://localhost:8084/AngularDemoPractices/rest/api/products/productlist',
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
            url: 'http://localhost:8084/AngularDemoPractices/rest/api/products/productlist',
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
            url: 'http://localhost:8084/AngularDemoPractices/rest/api/products/' + $scope.clickedProduct.pid
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


demoApp.controller("restCtrl", function ($scope, $http) {
var response = $http.get('http://localhost:8084/AngularDemoPractices/rest/api/products/productlist');
    response.success(function (data) {
        
        $scope.products = data;
        $scope.carts=[];
          console.log("getProducts data: " + angular.toJson(data, false));
          $scope.qty=1;
	$scope.add_cart = function(product){ //set a function name add_cart
					if(product){ //check if the product is already declared within the function
                                            
						$scope.carts.push({code: product.code, name: product.name, price: product.price,image:product.image}); //pushes the chosen product into a new variable called carts when the add to cart button is clicked
					}	
				};
 

				$scope.total=0; //display the default value of total
 
				$scope.setTotals = function(cart){ //set a function name setTotals 
					if(cart){ //check if cart is already set in the function
						$scope.total += (cart.price); //sum the total value of each product
					}
				};
 
				$scope.remove_cart = function(cart){ //set a function called remove_cart
					if(cart){ //checked if the cart has a value
						$scope.carts.splice($scope.carts.indexOf(cart), 1); //delete a product based on the index 
						$scope.total -= (cart.price); //deduct the price of the product  simultaneously when deleted
					}
				};

    });
    
    $scope.message = "";
    $scope.error_message = "";

//    //get All product
//    $scope.getAllproduct = function () {
//        $http({
//            mehtod: "GET",
//            url: 'http://localhost:8084/AngularDemoPractices/rest/api/products/productlist'
//        }).then(
//                function (response) {
//                    $scope.products = response.data;
//                },
//                function (reason) {
//                    $scope.error_message = reason.data;
//                }
//        );
//
//    };
//
//    $scope.getAllproduct();


    //save product
    $scope.newProduct = {};
    $scope.saveProduct = function () {
        $http({
            method: 'POST',
            url: 'http://localhost:8084/AngularDemoPractices/rest/api/products/productlist',
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
            url: 'http://localhost:8084/AngularDemoPractices/rest/api/products/productlist',
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
            url: 'http://localhost:8084/AngularDemoPractices/rest/api/products/' + $scope.clickedProduct.pid
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
