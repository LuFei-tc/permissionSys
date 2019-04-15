<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="modal fade" id="mailModal">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="myModalLabel">邮件</h4>
			</div>
			<div class="modal-body">

				<form id="mailForm">
					    <input type="hidden" name="to" id="to"/>
						<div class="form-group">
							<label>subject</label> <input class="form-control" value=""
								id="subject" name="subject">
						</div>
						<div class="form-group">
							<label>message</label><textarea class="form-control" rows="3" id="message"
							name="message"></textarea>
						</div>
						 
					<button class="btn btn-success" id="sendBtn" type="button">发送</button>
					<button class="btn btn-warning" id="cancelSendBtn" type="button">取消</button>
				</form>
			</div>
		</div>
	</div>
</div>