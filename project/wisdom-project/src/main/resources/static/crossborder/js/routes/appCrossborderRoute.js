/**
 * 路由
 */
define(['appCrossborder'], function(app){
    return app
        .config(['$stateProvider','$urlRouterProvider',
            function($stateProvider,$urlRouterProvider) {
                var loadFunction = function($templateCache, $ocLazyLoad, $q, $http,name,files,htmlURL){
                    lazyDeferred = $q.defer();
                    return $ocLazyLoad.load ({
                        name: name,
                        files: files
                    }).then(function() {
                        return $http.get(htmlURL)
                            .success(function(data, status, headers, config) {
                                return lazyDeferred.resolve(data);
                            }).
                            error(function(data, status, headers, config) {
                                return lazyDeferred.resolve(data);
                            });
                    });
                };
                $stateProvider
                    .state('home', {
                        url: '/home',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'homeCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.homeCtrl',
                                    ['js/controllers/homeCtrl.js'],
                                    'js/views/home.html');
                            }
                        }
                    })
                $urlRouterProvider.otherwise('home')
            }])
})