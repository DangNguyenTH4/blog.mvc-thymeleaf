function countOnlineUser(){
      var url = location.origin + '/rest-v1/user-oneline';

      console.log("Get count user: " + url);
			$.ajax({
				url: location.origin+'/rest/v1/user-online',
				dataType: 'html',
				success: function(html) {
				console.log(html)
					$('#userOnline #count').html($.parseJSON(html).body.online);
				},
				error: function(){

				  console.log("Error");
//				  $('#getContinue').remove();
				}
			});

}
$(document).ready(function(){
    countOnlineUser();
});
