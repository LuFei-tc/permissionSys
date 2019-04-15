<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="modal fade" id="permModal">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="myModalLabel">修改</h4>
			</div>
			<div class="modal-body">
				<form id="permForm">
					<div class="form-group">
						<label>name</label>
						<input class="form-control" value="" id="name" name="name">
					</div>
					<div class="form-group">
						<label>perms</label>
						<input class="form-control" value="" id="perms"  name="perms">
					</div>
					<div class="form-group">
						<label>url</label>
						<input class="form-control" value="" id="url" name="url">
					</div>
					<div class="form-group">
						<label>type</label>
						<input class="form-control" value="" id="type" name="type">
					</div>
					<div class="form-group">
						<label>orderNum</label>
						<input class="form-control" value="" id="orderNum" name="orderNum">
					</div>
					<button class="btn btn-success" id="updateBtn" type="button">修改</button>
					<button class="btn btn-warning" id="cancelBtn" type="button">取消</button>
				</form>
			</div>
		</div>
	</div>
</div>