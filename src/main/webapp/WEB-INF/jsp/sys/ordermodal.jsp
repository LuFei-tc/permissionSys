<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="modal fade" id="orderModal">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="myModalLabel">修改</h4>
			</div>
			<div class="modal-body">

				<form id="orderForm">
					<div class="form-input">
						<div class="form-group">
							<label>订单ID</label> <input class="form-control" value=""
								id="oid" name="oid">
						</div>
						<div class="form-group">
							<label>商品ID</label> <input class="form-control" value=""
								id="gid" name="gid">
						</div>
						<div class="form-group">
							<label>用户ID</label> <input class="form-control" value=""
								id="uid"  name="uid">
						</div>
						<div class="form-group">
							<label>购买数量</label> <input class="form-control" value=""
								id="num" name="num">
						</div>
						<div class="form-group">
							<label>状态</label> <input class="form-control" value=""
								id="status" name="status">
						</div>
				
						
					</div>

					<button class="btn btn-success" id="updateBtn" type="button">修改</button>
					<button class="btn btn-warning" id="cancelBtn" type="button">取消</button>
				</form>
			</div>
		</div>
	</div>
</div>