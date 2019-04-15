<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="modal fade" id="goodModal">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="myModalLabel">修改</h4>
			</div>
			<div class="modal-body">

				<form id="goodForm">
					<div class="form-input">
						<div class="form-group">
							<label>goodId</label> <input class="form-control" value=""
								id="goodId" name="goodId">
						</div>
						<div class="form-group">
							<label>goodTitle</label> <input class="form-control" value=""
								id="goodTitle" name="goodTitle">
						</div>
						<div class="form-group">
							<label>sellPoint</label> <input class="form-control" value=""
								id="sellPoint"  name="sellPoint">
						</div>
						<div class="form-group">
							<label>goodPrice</label> <input class="form-control" value=""
								id="goodPrice" name="goodPrice">
						</div>
						<div class="form-group">
							<label>num</label> <input class="form-control" value=""
								id="num" name="num">
						</div>
						<div class="form-group">
							<label>cid</label> <input class="form-control" value=""
								id="cid" name="cid">
						</div>
						<div class="form-group">
							<label>status</label> <input class="form-control" value=""
								id="status" name="status">
						</div>
						<!-- <div class="form-group">
							<label>created</label> <input class="form-control" value=""
								id="created" name="created">
						</div>
						<div class="form-group">
							<label>updated</label> <input class="form-control" value=""
								id="updated" name="updated">
						</div> -->
						
					</div>

					<button class="btn btn-success" id="updateBtn" type="button">修改</button>
					<button class="btn btn-warning" id="cancelBtn" type="button">取消</button>
				</form>
			</div>
		</div>
	</div>
</div>