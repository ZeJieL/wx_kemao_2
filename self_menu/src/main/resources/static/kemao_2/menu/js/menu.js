let menuData = {};
$.ajax({
	url: "",
	method: "get",
	dataType: "json",//要求返回JSON
	success: function (responseData) {
		menuData = responseData;
		initMenus();
    },
    error: function (responseData) {
        console.error(responseData);
    }
});
function initMenus(){
	let menus = new Vue({
		// el: "#menus",
			el: ".main-container",
		    data: menuData,
		    methods: {
		        // 显示或隐藏二级菜单
		        toggleSubMenus(m) {
		            // 先把所有二级菜单隐藏
		            this.hideLevelTwo();
		            // 显示点击时的二级菜单
		            m.show = !m.show;
		        },
		        activeButton(m, event) {
		            // 取消所有按钮的激活状态
		            this.subMenus.forEach((x) => {
		                if(x != m)
		                {
		                    x.active = false;
		                }
		                if (x.subMenus) {
		                    x.subMenus.forEach((y) => {
		                        if(y != m
		                )
		                    {
		                        y.active = false;
		                    }
		                })
		                    ;
		                }
		        	});
		            // 把当前被点击的对象激活
		            m.active = true;
		        },
		        hideLevelTwo() {
		            this.subMenus.forEach((x) => {
		                x.show = false;
		        	});
		        },
		        addNewButton(menu, event) {
		        	let emptyMenu = {
		        		    "id": null,
		        		    "name": "菜单",
		        		    "type": null,
		        		    "url": null,
		        		    "mediaId": null,
		        		    "key": null,
		        		    "show": false,
		        		    "active": false,
		        		    "subMenus": []
		        		};
		            menu.subMenus.push(emptyMenu);
		            this.activeButton(emptyMenu);
		        },
		        // 找到当前选中的菜单
		        current(){
		        	for( let i = 0; i < this.subMenus.length; i++ ){
		        		let x = this.subMenus[i];
		        		if(x.active === true){
		        			return x;
		        		}
		        		for( let j = 0; j < x.subMenus.length; j++ ){
		        			let y = x.subMenus[j];
		        			if(y.active === true){
		            			return y;
		            		}
		        		}
		        	}
		        	return {};
		        },
		    	selectMenu(){
		    	}
		    },
		    computed: {
		    	selectedMenu(){
		    		return this.current();
		    	}
		    }
		});
}

// 2.需要把修改后的信息，直接提交到服务器并保存到数据库
function saveMenus(){
	let json = JSON.stringify(menuData);
	$.ajax({
		url: "",
		method: "post",
		contentType: "application/json; charset=utf-8",
		data: json,
		dataType: "json",
		success: function (responseData) {
            console.log(responseData);
        },
        error: function (responseData) {
            console.error(responseData);
        }
	});
}


