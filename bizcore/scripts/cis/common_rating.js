$(function(){
    	$('._sky_rating-panel').click( function(e){
    		var panel = $(this);
    		var score = $(this).parent();
    		var offset = e.offsetX + 12;
    		var width = $(this).width();
    		console.log(offset+"/"+width);
    		var rating = offset*100 / width;
    		$(score).removeClass();
    		if (rating < 10){
    			$(score).addClass("rating_score_10");
    			$(panel).data("item-value", 10);
    		}else if (rating < 20){
    			$(score).addClass("rating_score_20");
    			$(panel).data("item-value", 20);
    		}else if (rating < 30){
    			$(score).addClass("rating_score_30");
    			$(panel).data("item-value", 30);
    		}else if (rating < 40){
    			$(score).addClass("rating_score_40");
    			$(panel).data("item-value", 40);
    		}else if (rating < 50){
    			$(score).addClass("rating_score_50");
    			$(panel).data("item-value", 50);
    		}else if (rating < 60){
    			$(score).addClass("rating_score_60");
    			$(panel).data("item-value", 60);
    		}else if (rating < 70){
    			$(score).addClass("rating_score_70");
    			$(panel).data("item-value", 70);
    		}else if (rating < 80){
    			$(score).addClass("rating_score_80");
    			$(panel).data("item-value", 80);
    		}else if (rating < 90){
    			$(score).addClass("rating_score_90");
    			$(panel).data("item-value", 90);
    		}else {
    			$(score).addClass("rating_score_100");
    			$(panel).data("item-value", 100);
    		} 
    	});
    });

function sky_getRatingResult() {
	var result = {};
	$("._sky_rating-panel").each(function(idx, elem){
		var key = $(elem).data("item-key");
		var value = $(elem).data("item-value");
		result[key] = parseInt(value);
	});
	return result;
	
}