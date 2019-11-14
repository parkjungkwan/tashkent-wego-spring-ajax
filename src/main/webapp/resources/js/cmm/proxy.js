"use strict"
function CheckExtension(x){
	alert('판단 들어옴')
	let flag = false
	let regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$")
	let maxSize = 5242880; // 5MB
	if(x.fsize >= maxSize){
		alert('파일사이즈 초과')
		flag = true
	}
	if(regex.test(x.fname)){
		alert('해당 종류의 파일은 업로드 할 수 없습니다.')
		flag = true
	}
	return flag
}
$.prototype.nullChecker = x =>{
	let flag = false
	let i = 0
	for ( i in x){
		if(x[i] === ''){
			flag = true
		}
	}
	return flag
}
