<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="/pages/common/head.jsp"></jsp:include>
<jsp:include page="/pages/common/menu.jsp"></jsp:include>

<style>
	<!--
		.item {
			width: 100px;
			height: 140px; 
			float: left;
			margin: 5px;
			text-align: center;
		}
		
		.item .icon {
			width: 96px;
			height: 96px;
			background-image: url("resource/icons/file-icon.png");
			margin: 0px auto;
		}
		.file .icon {
			background-position: 0px -96px;
		}
		
		.item:hover {
			border: 1px solid rgb(184,214,251);
			background-color: rgb(249,251,253);
			color: #000;
		}
		.context-menu {
			display: none;
			position: absolute;
			color: #000;
			width: 150px;
			border: 1px solid rgb(151,151,151);
			background-color: rgb(240,240,240);
			margin: 0px;
			cursor: default;
			padding: 0px;
		}
		
		.context-menu li {
			list-style-type: none;
			font-size: 12px;
			padding: 2px 20px;
			border: 1px solid rgb(240,240,240);
		}
		
		.context-menu li:hover {
			background-color: rgb(236,240,246);
			border: 1px solid rgb(174,207,247);
		}
		
		.newNameText {
			color: #000;
			width: 100%;
			border: 1px solid #000;
			text-align: center;
		}
		-->
	</style>
    <!-- Content -->
   <section id="content" class="container">
		<h4 class="page-title">文件管理</h4>
		<div id="filePanel" style="width: 100%;height: 500px;">
			
		</div>
    </section>
    
 	<script type="text/javascript" src="resource/ajax.js"></script>
	<script type="text/javascript">
		var currentFolder = "";
		var currentItem = null;
		
		var filePanel = document.getElementById("filePanel");
		
		var contextMenu = document.createElement("ul");
		var folderMenu = document.createElement("ul");
		var fileMenu = document.createElement("ul");
		
		filePanel.oncontextmenu = function (event) {
			var e = window.event || event;
			var x = e.clientX,y=e.clientY;
			var menu = null;
			if(currentItem == null) {
				menu = contextMenu;
			} else if(currentItem.className.indexOf("folder") != -1) {
				menu = folderMenu;
			} else if(currentItem.className.indexOf("file") != -1) {
				menu = fileMenu;
			}
			
			menu.style.left = x + "px";
			menu.style.top = y + "px";
			
			menu.style.display = "block";
			
			return false;
		};

		document.onmouseup = function () {
			contextMenu.style.display = "none";
			folderMenu.style.display = "none";
			fileMenu.style.display = "none";
		};
		
		function inItem(item) {
			currentItem = item;
		}
		function outItem() {
			currentItem = null;
		}
		
		/**
		 * 查询指定文件夹下的所有文件夹和文件并显示到页面
		 */	
		function loadFolder(div) {
			currentFolder = div ? div.id : "";
			filePanel.innerHTML = "";
			get("files/ListFilesServlet", "parentId=" + currentFolder, function (data) {
				for(var i=0;i<data.folders.length;i++) {
						var folder = data.folders[i];
						
						var itemHtml = "";
						itemHtml += "<div id=\"" + folder.id + "\" ";
						itemHtml += "	class=\"item folder\"         ";
						itemHtml += "	ondblclick=\"loadFolder(this);\"  ";
						itemHtml += "	title=\"" + folder.createTime + "\" ";
						itemHtml += "	onmouseover=\"inItem(this);\" ";
						itemHtml += "	onmouseout=\"outItem();\" ";
						itemHtml += "	>                             ";
						itemHtml += "	<div class=\"icon\"></div>    ";
						itemHtml += "	<div class=\"text\">" + folder.name + "</div>";
						itemHtml += "</div>                         ";
	  					
						filePanel.innerHTML = filePanel.innerHTML + itemHtml;
					}
					
					for(var i=0;i<data.files.length;i++) {
						var file = data.files[i];
						var itemHTML = "<div class=\"item file\" onmouseover=\"inItem(this);\" onmouseout=\"outItem();\"><div class=\"icon\"></div><div class=\"text\">" + file.name + "</div></div>"
						filePanel.innerHTML = filePanel.innerHTML + itemHTML;
					}
			});
		}
		
		
		// 新建文件夹
		function createFolder() {
			var itemHtml = "";
				itemHtml += "<div id=\"newFolder\"  ";
				itemHtml += "	class=\"item folder\"         ";
				itemHtml += "	ondblclick=\"loadFolder(this)\"  ";
				itemHtml += "	title=\"\"                 ";
				itemHtml += "	>                             ";
				itemHtml += "	<div class=\"icon\"></div>    ";
				itemHtml += "	<div class=\"text\"><input id=\"newNameText\" class=\"newNameText\" type='text' value=\"新建文件夹\" /></div>";
				itemHtml += "</div>                         ";
				
				filePanel.innerHTML = filePanel.innerHTML + itemHtml;
				
				var newNameText = document.getElementById("newNameText");
				var newFolder = document.getElementById("newFolder");
				newNameText.select();
				
				// 新建文件夹时焦点离开则表示确认文件夹名称,则需要添加到数据库中
				newNameText.onblur = function () {
					post("servlet/AddFolderServlet", "name=" + newNameText.value + "&parentId=" + currentFolder, function (data) {
						//添加完成
						if(data.state) {
							newNameText.parentNode.innerHTML = newNameText.value;
							newFolder.title = data.createTime;
							newFolder.id = data.id;
						}
					});
				}; 
				
				// 敲回车表示确认,跟失去焦点操作相同
				newNameText.onkeyup = function (event) {
					var e = window.event || event;
					if(e.keyCode == 13) {
						newNameText.blur();
					}
				}
		};
		
		// 页面刚加载,查询根目录下下所有资源
		loadFolder();

		contextMenu.className = "context-menu";
		contextMenu.innerHTML = "<li onclick=\"createFolder();\">新建文件夹</li> <li>上传文件</li> <li>刷新</li>";
		
		folderMenu.className = "context-menu";
		folderMenu.innerHTML = "<li onclick=\"createFolder();\">打开</li> <li>重命名</li><li>删除</li>";
		
		fileMenu.className = "context-menu";
		fileMenu.innerHTML = "<li onclick=\"createFolder();\">下载</li> <li>重命名</li> <li>删除</li>";

		document.body.appendChild(contextMenu);
		document.body.appendChild(folderMenu);
		document.body.appendChild(fileMenu);
		
	</script>

</html>

