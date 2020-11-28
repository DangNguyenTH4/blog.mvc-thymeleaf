$(document).ready(function(){

    $("#getContinue").click(function(){
     getMoreArticle();
    });
  });
var pageIndex = 1;
function getMoreArticle(){
console.log(pageIndex);
			pageIndex++;
			$.ajax({
				url: 'home/'+pageIndex,
				dataType: 'html',
				success: function(html) {
					$('#moreArticle').append(html);
				},
				error: function(){
				  pageIndex--;
				}
			});
}

//	var win = $(window);
//
//	// Each time the user scrolls
//	win.scroll(function() {
//		// End of the document reached?
//		if ($(document).height() - win.height() == win.scrollTop()) {
//		  console.log("Loadddd");
//			$.ajax({
//				url: 'article/1',
//				dataType: 'html',
//				success: function(html) {
//					$('#getContinue').append(html);
////					$('#loading').hide();
//				}
//			});
//		}
//	});
