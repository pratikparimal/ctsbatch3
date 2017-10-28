<tr data-ng-repeat="PersDet in LoanDetails | filter:search">
					<td>{{PersDet.applicantAadhaar}}</td>
					<td>{{PersDet.applicantName}}</td>
					<td>{{PersDet.applicantMobile}}</td>
					<td>{{PersDet.applicantEmail}}</td>
					<tr data-ng-repeat="ProfDet in ProfDetails">
						<td>{{ProfDet.applicantProfTotExp}}</td>
					</tr>
				</tr>
        
        
        app.controller('HouseLoanCtrl', function($scope, $http) {
				$http({
					url: 'http://localhost:8080/HousingLoan/Loan/api/ViewLoan/',
					method: 'GET'
				}).then(res => {
					if(res.data ==null) {
						console.log("It is null")
					}
					$scope.LoanDetails = res.data;
					console.log($scope.LoanDetails);
				});
				
				$scope.ProfDetails = [];
				angular.forEach($scope.LoanDetails, function(LoanDet) {
			    	console.log("into the 1st loop");
					angular.forEach(LoanDet.hlprofDetails, function(profdet) {
			    	console.log("into the 2nd loop");
			    	$scope.ProfDetails.push(profdet);
			    	console.log($scope.ProfDetails);
			    })
			});
			});
