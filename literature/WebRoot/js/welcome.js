if(LGlobal.canTouch){
	LGlobal.stageScale = LStageScaleMode.EXACT_FIT;
	LSystem.screen(LStage.FULL_SCREEN);
}
init(10,"legend",1350,130,main);

var backLayer;
var bitmapData;
var snowBack;
var lightBack;
var _snow = [];
var gravity = 0.15;
var drag = 0.6;
var loader;
function main(){
	LGlobal.setDebug(true);
	var labelText = new LTextField();
	labelText.color = "#000000";
	labelText.font = "HG行書体";
	labelText.weight = "bolder";
	labelText.text = getParameter("k");
	if(!labelText.text)labelText.text="欢 迎 加 入 ！";
	labelText.size = 80;
	while(labelText.getWidth() < 700){
		labelText.size += 5;
	}
	labelText.x = (LGlobal.width - labelText.getWidth())*0.5;
	labelText.y = 10;
	backLayer = new LSprite();
	addChild(backLayer);
	backLayer.addChild(labelText);
	backLayer.addEventListener(LEvent.ENTER_FRAME,onframe);
}
function getParameter(key) {
	var str = location.search.split("?");
	if (str.length < 2) {
		return "";
	}
	
	var params = str[1].split("&");
	for (var i = 0; i < params.length; i++) {
		var keyVal = params[i].split("=");
		if (keyVal[0] == key && keyVal.length == 2) {
			return decodeURIComponent(keyVal[1]);
		}
	}
	return "";
}
function onframe(){
	backLayer.removeEventListener(LEvent.ENTER_FRAME,onframe);
	loader = new LLoader();
	loader.addEventListener(LEvent.COMPLETE,loadBitmapdata);
	loader.load(LGlobal.canvasObj.toDataURL(),"bitmapData");
}
function loadBitmapdata(event){
	backLayer.removeAllChild();
	backLayer.graphics.drawRect(1,"#000000",[0,0,LGlobal.width,LGlobal.height],true,"#000000");
	bitmapData = new LBitmapData(loader.content);

	snowBack = new LSprite();
	backLayer.addChild(snowBack);
	
	lightBack = new LSprite();
	backLayer.addChild(lightBack);
	
	backLayer.addEventListener(LEvent.ENTER_FRAME,run);
}
function run(){
	var n = _snow.length, d;
	snowBack.graphics.clear();
	lightBack.graphics.clear();
	bitmapData.lock();
	while(n--){
		var p = _snow[n];
		p.vy += gravity * p.s;
		p.y += p.vy;
		if(checkPixel(p.x, p.y)){
			p.y -= p.vy;
			p.vy = 0;
			p.y += 0.2;
			lightBack.graphics.drawRect(1,"#ffffff",[p.x,p.y,1,1],true,"#ffffff");
		}else{
			snowBack.graphics.drawRect(1,"#ffffff",[p.x,p.y,1,1],true,"#ffffff");
		}
		if(p.y > LGlobal.height) {
			_snow.splice(n, 1);
		}
	}
	bitmapData.unlock();
	n = 10;
	while(n--) {
		particle(Math.random() * LGlobal.width, 0, Math.random() + 0.5);
	}
	
}
function particle(px,py,ps,pvx,pvy){
	if(typeof ps == UNDEFINED)ps = 1;
	if(typeof pvx == UNDEFINED)pvx = 0;
	if(typeof pvy == UNDEFINED)pvy = 0;
	
	_snow.push({x:px,y:py,s:ps,vx:pvx,vy:pvy});
}
function checkPixel(x,y){
	var pixel = bitmapData.getPixel(x,y);
	for(var i=0;i<pixel.length;i++){
		if(pixel[i])return true;
	}
	return false;
}