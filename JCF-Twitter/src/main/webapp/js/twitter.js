(function(j) {
	console.log("hello world!");

	j.ajax({
		url : 'tweetList.json',
		headers : {
			'Accept' : 'application/json+sua'
		},
		success : function(data, t) {
			j.each(data.tweetList, function(i, val) {
				createStreamItem(val);
			});

			resize();
		}

	});

	var objToServer = {TweetDS : []};
	objToServer.TweetDS[0] = {tweets : $('.twitter-anywhere-tweet-box-editor').val()}
	console.log(JSON.stringify(objToServer));

//	function sendTweet(tweetData){
//		j.ajax({
//			url : 'insertTweet.action',
//			headers : {
//				'Accept' : 'application/json+sua'
//			},
//			data : JSON.stringify(tweetData)
//		});
//	}

	function resize(){
		$('.main-content').height($('.stream-manager').height()+167);
	}

	function createStreamItem(tweet) {
		var tweetId = tweet.id,
			regData = tweet.regDate,
			register = tweet.register,
			tweets = tweet.tweets,
			streamItemDiv = j(document.createElement('div')).addClass('stream-item')
				.append('<div class="stream-item-content clearfix stream-item-activity stream-item-favorite stream-item-activity-network" />'),
			timeStampDiv = j('<div class="activity-timestamp"><span class="_timestamp">'+regData+'</span></div>')
			userDiv = j(document.createElement('div')).addClass('stream-item-activity-line js-actionable-user stream-item-activity-line-network')
				.append('<img  height="48" width="48" src="file/fileView/'+tweetId+'">')
				.append('<span class="user"><a class="user-profile-link pretty-link" href="tweet/'+register+'" title="'+register+'"><s>@</s><b>'+register+'</b></a></span>'),
			tweetDiv = j(document.createElement('div')).addClass('activity-supplement')
				.wrapInner('<div class="tweet-text js-tweet-text">'+tweets+'</div>')
				.wrapInner('<div class="tweet-row" />')
				.wrapInner('<div class="tweet-content activity-item-tweet-content clearfix" />')
				.wrapInner('<div class="js-stream-tweet js-actionable-tweet stream-item-content tweet stream-tweet activity-item-tweet callout-tweet-actions" />')
				.wrapInner('<div class="sub-stream-item clearfix" />');

		j('.stream').append(j(streamItemDiv).find('.stream-item-content')
						.append(timeStampDiv)
						.append(userDiv)
						.append(tweetDiv));
	}
})(jQuery);


