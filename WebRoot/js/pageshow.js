var xmlHttp;
var indexPage;

//点击页码后,获得相应页的题目
function getPage(pageNum){
	//定义构造url时需要的三个元素，默认值为空
	var diff="", type="", point="";
	//获得用户选择的难度
	var s_diff = document.getElementsByName("diff");
	for(var i in s_diff){
		if(s_diff[i].checked){
			diff = s_diff[i].value;
		}
	}
	//获得用户选择的类型
	var s_type = document.getElementsByName("type");
	for(var i in s_type){
		if(s_type[i].checked){
			type = s_type[i].value;
		}
	}
	//获得用户选择的知识点
	var s_point = document.getElementsByName("point");
	for(var i in s_point){
		if(s_point[i].checked){
			point = s_point[i].value;
		}
	}
	//xmlHttp = 获得xmlHttp对象;
	xmlHttp = createXMLHttp();
	//更新当前页码
	indexPage = pageNum;
	//构造请求url
	var url = "ps?pageNum=" + escape(pageNum) + "&diff=" + escape(diff) + "&type=" + escape(type) + "&point=" + escape(point);
	//true表示JavaScript脚本会在send()方法之后继续执行，而不会等待来自服务器的响应。
	xmlHttp.open("GET",url,true);
	//xmlHttp绑定回调方法，这个回调方法会在xmlHttp状态改变的时候会被调用
	//xmlHttp的状态：0-4，我们只关心4(complete)这个状态，所以说当完成之后，再调用回调函数才有意义。
	xmlHttp.onreadystatechange = callback;
	//参数已经在url中了，不用在此处添加参数
	xmlHttp.send(null);

}

		//获得xmlHttp对象
    	function createXMLHttp(){
    		//对于大多数浏览器都适用的
    		var xmlHttp;
    		if(window.XMLHttpRequest){
    			xmlHttp = new XMLHttpRequest();
    		}
    		//要考虑浏览器的兼容性
    		if(window.ActiveXObject){
    			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    			//如果浏览器有ActiveXObject对象，但没有Microsoft.XMLHTTP的参数
    			if(!xmlHttp){
    				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
    			}
    		}
    		return xmlHttp;
    	}
    	//回调函数
    	function callback(){
    		//4表示完成
    		if(xmlHttp.readyState == 4){
    			//200代表服务器响应成功，404代表资源未找到，500代表服务器内部错误
    			if(xmlHttp.status == 200){
    				//交互成功，获得相应的数据，是文本格式。
    				var result = xmlHttp.responseText;
    				//解析获得的数据
    				var json = eval("("+result+")");
    				//获得这些数据之后，就可以动态的显示数据了。把这些数据展示到输入框下面。
    				//alert(json);
    				setContent(json);
    			}
    		}
    	}

    	//设置关联数据的展示，参数代表服务器传递过来的关联数据
    	function setContent(json){
    		
    		var idOne = document.getElementById("idOne");
    		idOne.value = json[0].id;
    		var descOne = document.getElementById("descOne");
    		descOne.innerText = json[0].edesc;
    		var answerOne = document.getElementById("answerOne");
    		answerOne.innerText = json[0].eanswer;

    		var idTwo = document.getElementById("idTwo");
    		idTwo.value = json[1].id;
    		var descTwo = document.getElementById("descTwo");
    		descTwo.innerText = json[1].edesc;
    		var answerTwo = document.getElementById("answerTwo");
    		answerTwo.innerText = json[1].eanswer;

    		var idThree = document.getElementById("idThree");
    		idThree.value = json[2].id;
    		var descThree = document.getElementById("descThree");
    		descThree.innerText = json[2].edesc;
    		var answerThree = document.getElementById("answerThree");
    		answerThree.innerText = json[2].eanswer;

    		var idFour = document.getElementById("idFour");
    		idFour.value = json[3].id;
    		var descFour = document.getElementById("descFour");
    		descFour.innerText =json[3].edesc;
    		var answerFour = document.getElementById("answerFour");
    		answerFour.innerText = json[3].eanswer;

    		var idFive = document.getElementById("idFive");
    		idFive.value = json[4].id;
    		var descFive = document.getElementById("descFive");
    		descFive.innerText =json[4].edesc;
    		var answerFive = document.getElementById("answerFive");
    		answerFive.innerText = json[4].eanswer;

    		var idSix = document.getElementById("idSix");
    		idSix.value = json[5].id;
    		var descSix = document.getElementById("descSix");
    		descSix.innerText =json[5].edesc;
    		var answerSix = document.getElementById("answerSix");
    		answerSix.innerText = json[5].eanswer;

    		var idSeven = document.getElementById("idSeven");
    		idSeven.value = json[6].id;
    		var descSeven = document.getElementById("descSeven");
    		descSeven.innerText =json[6].edesc;
    		var answerSeven = document.getElementById("answerSeven");
    		answerSeven.innerText = json[6].eanswer;

    		var idEight = document.getElementById("idEight");
    		idEight.value = json[7].id;
    		var descEight = document.getElementById("descEight");
    		descEight.innerText =json[7].edesc;
    		var answerEight = document.getElementById("answerEight");
    		answerEight.innerText = json[7].eanswer;

    		var idNine = document.getElementById("idNine");
    		idNine.value = json[8].id;
    		var descNine = document.getElementById("descNine");
    		descNine.innerText =json[8].edesc;
    		var answerNine = document.getElementById("answerNine");
    		answerNine.innerText = json[8].eanswer;

    		var idTen = document.getElementById("idTen");
    		idTen.value = json[9].id;
    		var descTen = document.getElementById("descTen");
    		descTen.innerText =json[9].edesc;
    		var answerTen = document.getElementById("answerTen");
    		answerTen.innerText = json[9].eanswer;
    	}

$("button[name='edit']").click(function() {
    var eid = $(this).siblings()[0].value;
    location.href = "/Java-Tiku/edit?eid=" + eid;
})

$("button[name='add']").click(function() {
    var eid = $(this).siblings()[0].value;
    $.ajax({
        type: "POST",
        url: "/Java-Tiku/cartapi",
        data: {eid: eid, op:"add"},
        success: function(data){
            alert("添加成功");
            //location.href = "/Java-Tiku/edit?eid=";
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status + ":" + XMLHttpRequest.statusText);
            }
    })
})
