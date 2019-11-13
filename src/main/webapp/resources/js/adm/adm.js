var adm = adm || {}
adm = (()=>{
	const WHEN_ERR = '호출하는 JS 파일을 찾지 못했습니다.'
	let _,js,css,img,navi_vue_js
	let init = ()=>{
		_=$.ctx()
		js=$.js()
		css=$.css()
		img=$.img()
		navi_vue_js=js+'/vue/navi_vue.js'
	}
	let onCreate=()=>{
		init()
		$.when(
			$.getScript(navi_vue_js)	
		).done(()=>{
			setContentView()
		}).fail(()=>{
			alert(WHEN_ERR)
		})
	}
	let setContentView=()=>{
		$('body').empty()
		$(navi_vue.nav())
		.appendTo('body')
		$('<table id="tab"><tr></tr></table>')
		.css({border: '1px solid black', width: '80%',height: '90%', 'margin': '0 auto'})
		.appendTo('body')
		$.each(
			[{id : 'left', width : '20%'},
			{id : 'right', width : '80%'}],
			(i,j)=>{
			$('<td id="'+j.id+'"></td>')
			.css({border: '2px solid black', width: j.width, 'vertical-align': 'top'})
			.appendTo('#tab tr')
		})
		$.each([
			{txt: '웹크롤링', name: 'web_crawl'},
			{txt: '고객관리', name: 'cust_mgmt'},
			{txt: '커뮤니티관리', name: 'comm_mgmt'},
			{txt: '상품조회', name: 'item_srch'},
			{txt: '상품수정', name: 'item_mod'},
			{txt: '상품삭제', name: 'item_del'}],
			(i,j)=>{
				$('<div name="'+j.name+'">'+j.txt+'</div>')
				.css({border: '2px solid black', margin: 'auto 0', 'line-height': '50px'})
				.appendTo('#left')
				.click(function(){
					$(this).addClass('active')
					$(this).siblings().removeClass('active')
					switch($(this).attr('name')){
					case 'web_crawl':
						webCrawl()
						break;
					case 'cust_mgmt':
						cust_mgmt()
						break;
					case 'comm_mgmt':
						comm_mgmt()				
						break;
					case 'item_srch':
						
						break;
					case 'item_mod':
						
						break;
					case 'item_del':
						
						break;
					}
				})
		})
		
		
		
	}
	let webCrawl=()=>{
		$('#right').empty()
		$('</br></br></br></br></br><h2>Web Crawling</h2></br></br></br></br></br></br></br>'+
				'<form id="crawl_form" class="form-inline my-2 my-lg-0">'+
				'  <select name="site" size="1">'+
				'  </select>'+
		          '<input class="form-control mr-sm-2" type="text" value="스톤애견풀빌라" placeholder="insert URL for crawling" aria-label="Search">'+
				'</form>')
		.appendTo('#right')
		$('#crawl_form input[class="form-control mr-sm-2"]')
		.css({width:'80%'})
		$.each([{sub:'직접입력'},
			{sub:'daum.net'},
			{sub:'google.co.kr'},
			{sub:'youtube.com'},
			{sub:'naver.com'}],(i,j)=>{
			$('<option value='+j.sub+'>'+j.sub+'</option>')
			.appendTo('#crawl_form select')
		})
		$('<button class="btn btn-secondary my-2 my-sm-0" type="submit">go crawl</button>')
		.appendTo('#crawl_form')
		.click(e=>{
			e.preventDefault()
			let arr = [$('#crawl_form select[name="site"]').val(),
						$('#crawl_form input[type="text"]').val()]
			if(!$.fn.nullChecker(arr)){
				$.getJSON(_+'/tx/crawling/'+arr[0]+'/'+arr[1],d=>{
					alert(d.msg)
				})
			}
		})
	}
	let comm_mgmt=()=>{
		$('#right').empty()
		$('<a>커뮤니티 테이블 생성</a><br/>')
		.appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(_+'/articles/create/table',d=>{
				alert('테이블 생성 성공여부 :'+d.msg)
			})
		})
	}
	let cust_mgmt=()=>{
		$('#right').empty()
		$('<a>데이터베이스 생성</a><br/>')
		.appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(_+'/cmm/create/db',d=>{
				alert('데이터베이스 생성 성공여부 :'+d.msg)
			})
		})
		$('<a>고객 테이블 생성</a><br/>')
		.appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(_+'/users/create/table',d=>{
				alert('테이블 생성 성공여부 :'+d.msg)
			})
		})
		$('<a>고객 테이블 삭제</a><br/>')
		.appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(_+'/users/drop/table',d=>{
				alert('테이블 삭제 성공여부 :'+d.msg)
			})
		})
		$('<a>고객 대량정보 입력</a><br/>')
		.appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(_+'/tx/register/users',d=>{
				alert('고객 수 :'+d.userCount)
			})
		})
		$('<a>전체 고객 정보 삭제</a><br/>')
		.appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(_+'/tx/truncate/users',d=>{
				alert('고객 수 :'+d.userCount)
			})
		})
	}
	return{onCreate}
})()









