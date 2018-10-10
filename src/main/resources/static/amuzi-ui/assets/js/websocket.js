var eseict;
(function (eseict) {
    var XwsWebsocket = (function () {
        function XwsWebsocket() {
            this.uid = this.getGUID();
            this.websk;
            this.port;
        }
        XwsWebsocket.prototype.setup = function (port) {
        	var thisAsign = this;
        	thisAsign.port = port;
        	thisAsign.websk = new WebSocket("ws://"+document.location.hostname+":"+port+"/websocket");
        	thisAsign.websk.onopen = function(){
        	    console.log('websocket opened');
        	};
        	
        	// Websocket 서버가 보내준 내용을 전달받음
        	thisAsign.websk.onmessage = function(event){
        		var msgObj = JSON.parse(event.data);
        		console.log("WEBSOCKET" ,msgObj);
                alert(msgObj);
                //startNoti(msgObj);

        	};
        	
        	thisAsign.websk.onerror = function(){
        		// alert("");
                console.error("Websocket Connection Fail.");
        	};

        	thisAsign.websk.onclose = function(){
        	    setTimeout(function(){
                    eseict.XwsWebsocket.setup(thisAsign.port);
                }, 3000);
            };
        	
        	// UX-Platform main close 시 EVENT
        	$(window).on('beforeunload', function() {
        		// 창 닫을 때 WebSocket 객체 close
        		thisAsign.websk.close();
        	});
        	
        };
        XwsWebsocket.prototype.getWebSocket = function () {
        	return this.websk;
        };
        XwsWebsocket.prototype.getGUID = function () {
            var lut = [];
            for (var i = 0; i < 256; i++) {
                lut[i] = (i < 16 ? '0' : '') + (i).toString(16);
            }
            var d0 = Math.random() * 0xffffffff | 0;
            var d1 = Math.random() * 0xffffffff | 0;
            var d2 = Math.random() * 0xffffffff | 0;
            var d3 = Math.random() * 0xffffffff | 0;
            return lut[d0 & 0xff] + lut[d0 >> 8 & 0xff] + lut[d0 >> 16 & 0xff] + lut[d0 >> 24 & 0xff] + '-' +
                lut[d1 & 0xff] + lut[d1 >> 8 & 0xff] + '-' + lut[d1 >> 16 & 0x0f | 0x40] + lut[d1 >> 24 & 0xff] + '-' +
                lut[d2 & 0x3f | 0x80] + lut[d2 >> 8 & 0xff] + '-' + lut[d2 >> 16 & 0xff] + lut[d2 >> 24 & 0xff] +
                lut[d3 & 0xff] + lut[d3 >> 8 & 0xff] + lut[d3 >> 16 & 0xff] + lut[d3 >> 24 & 0xff];
        };
        XwsWebsocket.prototype.isDefined = function (obj) {
            return typeof obj !== 'undefined';
        };
        return XwsWebsocket;
    }());
    eseict.XwsWebsocket = new XwsWebsocket();
})(eseict || (eseict = {}));