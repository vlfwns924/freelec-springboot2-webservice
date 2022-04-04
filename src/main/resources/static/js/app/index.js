let main = {
	init : function(){
		let _this = this;
		$('#btn-save').on('click', function(){
			_this.save();
		});
		$('#btn-update').on('click',function(){ //btn-update란 id를 가진 HTML 엘리먼트에 click이벤트가 발생할 때
			_this.update();				                //update function을 실행하도록 이벤트 등록
		});
		$('#btn-delete').on('click',function(){
			_this.delete();
		});
	},
	save : function() {
		let data = {
			title: $('#title').val(),
			author: $('#author').val(),
			content: $('#content').val()
		};
		
		$.ajax({
			type: 'POST',
			url: '/api/v1/posts',
			dataType: 'json',
			contentType:'application/json; charset=utf-8',
			data: JSON.stringify(data)
		}).done(function(){
			alert('글이 등록되었습니다.');
			window.location.href='/'; //글이 등록되면 메인페이지(/)로 이동
		}).fail(function (error){
			alert(JSON.stringify(error));
		});
	},
	update : function(){
		let data = {
			title: $('#title').val(),
			content: $('#content').val()
		};
		
		let id = $('#id').val();
		
		$.ajax({
			type: 'PUT', //생성(Create): POST, 읽기(Read): GET, 수정(Update):PUT, 삭제(Delete): DELETE
			url: '/api/v1/posts/'+id, //어느 게시글을 수정할지 URL Path를 구분하기 위해 id를 추가
			dateType: 'json',
			contentType: 'application/json; charset=utf-8',
			date: JSON.stringify(data)
		}).done(function(){
			alert('글이 수정되었습니다.');
			window.location.href='/';
		}).fail(function (error){
			alert(JSON.stringify(error));
		});
	},
	delete : function(){
		let id = $('#id').val();
		
		$.ajax({
				type: 'DELETE',
				url: '/api/v1/posts/'+id,
				dataType: 'json',
				contentType: 'application/json; charset=utf-8'
		}).done(function(){
			alert('글이 삭제되었습니다.');
			window.location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	}
};
main.init();






