<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Welcome</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery/jquery-1.9.0.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery/jquery.atmosphere.js"></script>

<script type="text/javascript">
	$(function() {
		var socket = $.atmosphere
		var request = {
			url : document.location.toString() + 'room1',
			contentType : "plain/text",
			logLevel : 'TRACE',
			transport : 'sse',
			fallbackTransport : 'long-polling',
            trackMessageLength : true,
            trackMessageSize : true
		}
		request.onOpen = function(data) {
			console.log(data);
		}
		request.onReconnect = function(request, response) {
			console.log(request, response);
		}
		request.onMessage = function(response) {
            console.log(response)
			$('#output').text(response.responseBody);
		}
		request.onError = function(response) {
			console.log(response);
		}

		subSocket = socket.subscribe(request);
		console.log(subSocket)
	})
</script>
</head>
<body>
	<h1 id="output">see console log</h1>
</body>
</html>
