<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="modal fade" id="userModal">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="myModalLabel">修改</h4>
			</div>
			<div class="modal-body">

				<form id="userForm">
					<div class="form-input">
						<div class="form-group">
							<label>username</label> <input class="form-control" value=""
								id="username" name="user.username">
						</div>
						<div class="form-group">
							<label>password</label> <input class="form-control" value=""
								id="password" type="password" name="user.password">
						</div>
						<div class="form-group">
							<label>email</label> <input class="form-control" value=""
								id="email" name="user.email">
						</div>
						<div class="form-group">
							<label>mobile</label> <input class="form-control" value=""
								id="mobile" name="user.mobile">
						</div>
						<div class="form-group">
							<label>status</label> <input class="form-control" value=""
								id="status" name="user.status">
						</div>
						<a class="btn btn-link" id="nextBtn">下一步</a>
					</div>

					<div class="form-check">
						<div class="checks"></div>
						<a class="btn btn-link" id="preBtn">上一步</a>
					</div>
					<button class="btn btn-success" id="updateBtn" type="button">修改</button>
					<button class="btn btn-warning" id="cancelBtn" type="button">取消</button>
				</form>
			</div>
		</div>
	</div>
</div>