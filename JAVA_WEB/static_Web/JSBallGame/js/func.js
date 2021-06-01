var dead=10;//死亡所需层数
var num=1;//球的数量
var speed=2;//球速
var score=0;//分数 总共打的层数
var isStop=true;
//设置小球位置,这里传入的x和y代表小球球心的坐标
function ballPosition(b,x,y){
    b.style.left=x-10+'px';
    b.style.top=y-10+'px';
}

//初始化小球位置和方块位置
function init(){
    var mb=document.getElementById('mBall');
    mb.innerHTML="<div class=\"ball\" state=\"stopped0\"></div>";
    var b1=document.getElementsByClassName("ball");
    ballPosition(b1[0],150,540);
    showBallNum(150,540);
    newSquare();
    newSquare();
    newSquare();
}

/*
 * 产生新方块
 * * */
function newSquare(){
    var mq=document.getElementById("mSquare");
    //之前存在的方块层数+1
    floorPlus();
    //新增方块 且设置新增的方块层数为0
    //为了防止得到的随机数重复 这里定义一个0到6的数组，每次取一个随机数之后比较这个数组中是否存在这个随机数
    //如果存在 就新建一个方块 并把数组中这个相同的数字改成-1 ，这就防止了下次重复的数字再次创建方块
    var i1=0;
    var arr=new Array(0,1,2,3,4,5,6);
    //每次会随机出现1到5个新方块
    var rdSquareNum=parseInt(Math.random()*5+1);
    for(i1;i1<rdSquareNum;i1++){
        var sqOrOther=Math.random()*100;
        var rd=Math.random()*7;
        rd=parseInt(rd);
        if(rd==arr[rd]){
            //这里表示新产生的东西有80%几率是方块
            if(sqOrOther<70){
                //产生的方块中的数字是分数的80%到160%
                var square=document.createElement("div");
                square.className="square";
                square.setAttribute("floor","0");
                square.style.left=(rd*50)+"px";
                square.innerHTML="<div class=\"num\">"+
                    parseInt(Math.random()*score*0.8+score*0.8+2)
                    +"<div>";
                setSquareColor(square);
                mq.appendChild(square);
            }else{
                //产生道具 碰到道具小球加一
                mq.innerHTML=mq.innerHTML+"<div class=\"plusBall\""+
                    " floor=\"0\" style=\"left:"+rd*50+"px\"></div>";
            }
            arr[rd]=-1;
        }
    }
    //根据修改后的层数设置所有方块高度
    setAllSqareTop();
}

//之前存在的方块层数+1
function floorPlus(){
    var q=document.getElementsByClassName("square");
    if(q[0]!=undefined){
        for(var i0=0;i0<q.length;i0++){
            var floor=q[i0].getAttribute("floor");
            floor=parseInt(floor);
            q[i0].setAttribute("floor",floor+1);
        }
    }
    var o=document.getElementsByClassName("plusBall");
    if(o[0]!=undefined){
        for(var i1=0;i1<o.length;i1++){
            var floor=o[i1].getAttribute("floor");
            floor=parseInt(floor);
            o[i1].setAttribute("floor",floor+1);
        }
    }
}

//根据所有方块层数设置高度
function setAllSqareTop(){
    var s=document.getElementsByClassName("square");
    var o=document.getElementsByClassName("plusBall");
    if(s[0]!=undefined){
        for(var i=0;i<s.length;i++){
            s[i].style.top=parseInt(s[i].getAttribute("floor"))*50+"px";
            if(s[i].getAttribute("floor")==dead){
                alert("你挂了！");
                window.location.reload();
                return;
            }
        }
    }
    if(o[0]!=undefined){
        for(var i1=0;i1<o.length;i1++){
            o[i1].style.top=parseInt(o[i1].getAttribute("floor"))*50+"px";
            if(o[i1].getAttribute("floor")==dead){
                alert("你挂了！");
                window.location.reload();
                return;
            }
        }

    }
}

//所有方块下降
function squareDown(){
    var s=document.getElementsByClassName("square");
    var o=document.getElementsByClassName("plusBall");
    if(s[0]!=undefined){
        for(var i=0;i<s.length;i++){
            s[i].style.top=parseInt(s[i].style.top)+50+"px";
        }
    }
    if(o[0]!=undefined){
        for(var i1=0;i1<o.length;i1++){
            o[i1].style.top=parseInt(o[i1].style.top)+50+"px";
        }
    }
}

var aim22=function aim2(){
    var canvas=document.getElementById("aimLine");
    this.ctx=canvas.getContext('2d');
    return ctx;
}

//鼠标进入游戏窗口时 产生瞄准线 aim 瞄准
function aim(eve){
    //如果小球停止了 就可以开始绘制瞄准线
    if(isStop){
        var endX=eve.offsetX;
        var endY=eve.offsetY;
        var b=document.getElementsByClassName("ball");
        var startX=b[0].style.left;
        startX=parseInt(startX)+10;
        var startY=540;
        aim22().clearRect(0,0,350,550);
        aim22().beginPath();//这句一定要加！不然clearrect无法清除之前的痕迹
        aim22().moveTo(startX,startY);
        aim22().lineTo(endX,endY);
        aim22().strokeStyle = '#09f';
        aim22().stroke();
        aim22().closePath();
    }else{
        aim22().clearRect(0,0,350,550);
    }
}

//瞄准线的箭头
function arr(eve){
    var endX=eve.offsetX;
    var endY=eve.offsetY;
    var sda=document.getElementById("arr");
    sda.style.left=endX-10+"px";
    sda.style.top=endY-10+"px";
}


function shoot(eve){
    //点击时 小球不在停止状态  所以清除瞄准线 且只有处于停止状态的小球才可响应此函数的点击事件
    deleteBallNum();
    isStop=false;
    aim(eve);
    //鼠标点击位置
    mx=eve.x-20;
    my=eve.y-20;
    var ball=document.getElementsByClassName("ball");
    //这里btop和bleft代表球心位置
    var bx=new Array(ball.length);
    var by=new Array(ball.length);
    //xy方向正负  这里以往左上角发射为正
    var xf=new Array(ball.length);
    var yf=new Array(ball.length);
    for(var xyfi=0;xyfi<ball.length;xyfi++){
        xf[xyfi]=1;
        yf[xyfi]=1;
        bx[xyfi]=parseFloat(ball[xyfi].style.left)+10;
        by[xyfi]=parseFloat(ball[xyfi].style.top)+10;
    }
    //sx和sy代表水平数值速度
    bbx=bx[0];
    bby=by[0];
    /*
     sx=speed*(bx[0]-mx)/Math.sqrt((by[0]-my)*(by[0]-my)+(bx[0]-mx)*(bx[0]-mx));
    sy=Math.sqrt(speed*speed-sx*sx);
    如果计算速度的式子写在这里，代表每次点击鼠标之后便确定了速度 只能等到下次发射才能改变速度
    而写在计时器里面，全局变量speed的变化可以即时的改变小球速度
    * */

    //嵌套循环 计时器进行每一毫秒后的状态的变化 ，for循环实现每一毫秒中每个球的状态
    //使用t来计算计时器进行了多少毫秒 每隔一定毫秒数再发射下一枚小球
    //t决定了小球发射之间的间隔时间
    //ball的state属性代表小球的状态 stopped0代表发射前  moved代表运动中  stopped1代表发射后停止
    var t=0;
    var timer=setInterval(function(){
        sx=speed*(bbx-mx)/Math.sqrt((bby-my)*(bby-my)+(bbx-mx)*(bbx-mx));
        sy=Math.sqrt(speed*speed-sx*sx);
        var i1=0;
        for(i1=0;i1<ball.length;i1++){
            //这里i1乘的值代表小球间隔的毫秒数
            if(i1*25==t){
                ball[i1].setAttribute("state","moved");
            }
            if(ball[i1].getAttribute("state")=="moved"){
                //小球下一步的位置
                bx[i1]=bx[i1]-xf[i1]*sx;
                by[i1]=by[i1]-yf[i1]*sy;
                //检测下一步是否撞墙
                var isBB=isBumpBorder(xf[i1],yf[i1],bx[i1],by[i1]);
                xf[i1]=isBB.xf;
                yf[i1]=isBB.yf;
                //检测下一步是否撞方块
                var isBS=isBumpSquare(xf[i1],yf[i1],bx[i1],by[i1]);
                if(isBS.isBS){
                    minusSquareNum(isBS.squ);
                }
                //检测下一步是否撞加分球
                isBumpPlus(bx[i1],by[i1]);
                xf[i1]=isBS.xf;
                yf[i1]=isBS.yf;
                //小球到达底部 所以重新绘制瞄准线 同时停止小球的运行 小球处于停止状态
                if(by[i1]>540){
                    ball[i1].style.top=530+"px";
                    ball[i1].setAttribute("state","stopped1");
                    //若全部小球的状态变成了发射后落地 即stopped1  结束循环
                    var stopBallNum=0;
                    for(var i3=0;i3<ball.length;i3++){
                        if(ball[i3].getAttribute("state")=="stopped1"){
                            stopBallNum++;
                        }
                    }
                    if(stopBallNum==ball.length){
                        isStop=true;
                        for(var i2=0;i2<ball.length;i2++){
                            ball[i2].setAttribute("state","stopped0");
                            ballPosition(ball[i2],parseInt(ball[i1].style.left)+10,540);
                        }
                        score++;
                        //小球全部落地之后 显示分数 方块下降 产生新房块 显示小球个数
                        showScore();
                        squareDown();
                        showBallNum(bx[i1],by[i1]);
                        newSquare();
                        var mb=document.getElementById("mBall");
                        for(var ballNumi=0;ballNumi<num-ball.length;ballNumi++){
                            var newBall=document.createElement("div");
                            newBall.className="ball";
                            newBall.state="stopped0";
                            ballPosition(newBall,parseInt(ball[i1].style.left)+10,540);
                            mb.appendChild(newBall);
                        }
                        clearInterval(timer);
                        return;
                    }
                }else{
                    //若没有到底 按照小球下一步的位置设置小球
                    ballPosition(ball[i1],bx[i1],by[i1]);
                }
            }
        }
        t++;
    },1);

}

//检测是否撞击墙壁
function isBumpBorder(xf,yf,bx,by){
    if(by<10){
        //撞到天花板
        yf=-yf;
    }
    if(bx<10){
        //左边边界
        xf=-xf;
    }
    if(bx>340){
        xf=-xf;
    }
    return{xf,yf};
}

//根据方块内数字的范围设置颜色
function setSquareColor(square){
    var sNum=parseInt(square.innerText);
    if(sNum<=5){
        square.style.backgroundColor="chartreuse";
    }else if(sNum<=10){
        square.style.backgroundColor="blue";
    }else if(sNum<=20){
        square.style.backgroundColor="yellow";
    }
    else if(sNum<=30){
        square.style.backgroundColor="deeppink";
    }else if(sNum<=40){
        square.style.backgroundColor="indigo";
    }else if(sNum<=50){
        square.style.backgroundColor="lightpink";
    }else if(sNum<=60){
        square.style.backgroundColor="yellow";
    }else if(sNum<=80){
        square.style.backgroundColor="pink";
    }else if(sNum<=100){
        square.style.backgroundColor="#FF0000";
    }else if(sNum<=130){
        square.style.backgroundColor="blue";
    }else if(sNum<=160){
        square.style.backgroundColor="cadetblue";
    }else if(sNum<=200){
        square.style.backgroundColor="lightsalmon";
    }else{
        square.style.backgroundColor="#000000";
    }
}

//检测是否撞击方块
function isBumpSquare(xf,yf,bx,by){
    var isBS=false;
    var s=document.getElementsByClassName("square");
    var i=0;
    for(i;i<s.length;i++){
        var sx=s[i].style.left;
        var sy=s[i].style.top;
        sy=parseInt(sy);
        sx=parseInt(sx);
        if( (by>(sy-10))&&(by<sy)&&(bx>=sx)&&(bx<=(sx+50)) ){
            //撞到方块上方
            yf=-yf;
            isBS=true;
            setSquareColor(s[i]);
            minusSquareSize(s[i]);
            return{xf,yf,isBS,squ:s[i]};
        }
        if( (by<(sy+60))&&(by>(sy+50))&&(bx>=sx)&&(bx<=(sx+50)) ){
            //方块下方
            yf=-yf;
            isBS=true;
            setSquareColor(s[i]);
            minusSquareSize(s[i]);
            return{xf,yf,isBS,squ:s[i]};
        }
        if( (bx>(sx-10))&&(bx<sx)&&(by>=sy)&&(by<=(sy+50)) ){
            //方块左边
            xf=-xf;
            isBS=true;
            setSquareColor(s[i]);
            minusSquareSize(s[i]);
            return{xf,yf,isBS,squ:s[i]};
        }
        if( (bx<(sx+60))&&(bx>(sx+50))&&(by>=sy)&&(by<=(sy+50)) ){
            //方块右边
            xf=-xf;
            isBS=true;
            setSquareColor(s[i]);
            minusSquareSize(s[i]);
            return{xf,yf,isBS,squ:s[i]};
        }
        //小球磕到左上角
        if((bx-sx)*(bx-sx)+(by-sy)*(by-sy)<10){
            xf=-xf;
            yf=-yf;
            isBS=true;
            setSquareColor(s[i]);
            minusSquareSize(s[i]);
            return{xf,yf,isBS,squ:s[i]};
        }
        //小球磕到左下角
        if((bx-sx)*(bx-sx)+(by-(sy+50))*(by-(sy+50))<10){
            xf=-xf;
            yf=-yf;
            isBS=true;
            setSquareColor(s[i]);
            minusSquareSize(s[i]);
            return{xf,yf,isBS,squ:s[i]};
        }
        //小球磕到右上角
        if((bx-(sx+50))*(bx-(sx+50))+(by-sy)*(by-sy)<10){
            xf=-xf;
            yf=-yf;
            isBS=true;
            setSquareColor(s[i]);
            minusSquareSize(s[i]);
            return{xf,yf,isBS,squ:s[i]};
        }
        //小球磕到右下角
        if((bx-(sx+50))*(bx-(sx+50))+(by-(sy+50))*(by-(sy+50))<10){
            xf=-xf;
            yf=-yf;
            isBS=true;
            setSquareColor(s[i]);
            minusSquareSize(s[i]);
            return{xf,yf,isBS,squ:s[i]};
        }
    }
    return{xf,yf,isBS};
}

//小球撞到方块后缩小方块
function minusSquareSize(square){
    square.style.width="46px";
    square.style.height="46px";
    setTimeout(function(){
        square.style.width="49px";
        square.style.height="49px";
    },30);
}

//小球是否撞到加分球
function isBumpPlus(bx,by){
    var p=document.getElementsByClassName("plusBall");
    if(p[0]!=undefined){
        for(var i=0;i<p.length;i++){
            var px=p[i].style.left;
            var py=p[i].style.top;
            py=parseInt(py);
            px=parseInt(px);
            //距离
            var s=(py+25-by)*(py+25-by)+(px+25-bx)*(px+25-bx);
            if(s<35*35){
                p[i].parentNode.removeChild(p[i]);
                num++;
            }
        }
    }

}

//在一个div块上显示传入的参数 方便调试测试用
function showp(x,y){
    var show=document.getElementById("showp");
    show.innerText=x+"|"+y;
}

//显示分数
function showScore(){
    document.getElementById("showScore").innerText="分数: "+score;
}


//方块被撞后显示的数字---
function minusSquareNum(square){
    var num=parseInt(square.innerText)-1;
    square.innerHTML="<div class=\"num\">"+num+"</div>";
    if(num==0){
        square.parentNode.removeChild(square);
    }
}

//在小球旁边显示球数
function showBallNum(bx,by){
    var newDiv=document.createElement("div");
    var mb=document.getElementById("mBall");
    newDiv.style.top=(parseInt(by)-30)+"px";
    newDiv.style.left=(parseInt(bx)-10)+"px";
    newDiv.id="showBallNum";
    newDiv.innerText="x"+num;
    mb.appendChild(newDiv);
}

//小球运行时显示的球数消失
function deleteBallNum(){
    var sbn=document.getElementById("showBallNum");
    document.getElementById("mBall").removeChild(sbn);
}

function getkeycode(eve){
    //获取event对象
    var eve=window.event||eve;
    //获取键盘值
    var code=eve.keyCode;
    if(code==90){
        speed=3;
    }else if(code==88){
        speed=4;
    }else if(code==67){
        speed=5;
    }else if(code==86){
        speed=6;
    }
}
showp("|z键1.5倍速 x键2倍速"," |c键2.5倍速 v键3倍速|");
