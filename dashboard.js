let content;
window.onload = function() {
	let dashboard = document.getElementById('dashboard');
	let account = document.getElementById('account');
	let logs = document.getElementById('logs');
	let report = document.getElementById('report');
	document.getElementById('menulink').onclick = function() {
		var menu = document.getElementById('menu');
		if(menu.className != 'showmenu') {
			menu.className = 'showmenu';
		}
		else {
			menu.className = 'hiddenmenu';
		}
	}
	
	account.onclick = function() {
		let rq = new XMLHttpRequest();
		rq.onreadystatechange = function() {
			if(rq.readyState == 4 && rq.status == 200) {
			content = document.getElementById('content');
			content.innerHTML = rq.responseText;
			}
		}
		rq.open("GET", "/inventoryapp/accountlist", true);
		rq.send();
	}

	dashboard.onclick = function() {
		content = document.getElementById('content');
		content.innerHTML = "DASHBOARD";
	}

	logs.onclick = function() {
		content = document.getElementById('content');
		content.innerHTML = "<h1>LOGS</h1>";
	}

	report.onclick = function() {
		content = document.getElementById('content');
		content.innerHTML = "<h1>REPORT<h1>";
	}
}
