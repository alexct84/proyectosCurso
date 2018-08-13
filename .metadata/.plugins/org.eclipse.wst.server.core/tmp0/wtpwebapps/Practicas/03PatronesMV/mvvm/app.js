// Code goes here

var app = angular.module('myApp', []);

app.controller('MyCtrl', function($scope) {

	$scope.items = [ {
		'name' : 'apple',
		'price' : 1
	}, {
		'name' : 'biscuit',
		'price' : 2
	}, {
		'name' : 'grapes',
		'price' : 3
	}, {
		'name' : 'mango',
		'price' : 4
	} ];

	$scope.addFruit = function() {
		$scope.items.push({
			'name' : 'orange',
			'price' : 4
		});
	};
});

app.directive('myDirective', function() {
	return function(scope, ele, attr) {
		scope.$watchCollection('items', function(value) {
			ele.html('');
			alert(value.length);
			angular.forEach(scope.items, function(item, idx) {
				ele.append("<h2>" + item.name + "</h2>");
			});
		});

	}
});