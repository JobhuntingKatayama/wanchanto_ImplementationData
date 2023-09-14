<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="d-flex justify-content-end mb-3">
	<c:if test="${loginId != null }">
		<div class="p-2 bd-highlight">
			<button type="button" class="btn btn-outline-primary"
				onclick="location.href='ownerMypage'">マイページ</button>
		</div>
	</c:if>
	<c:if test="${loginId == null }">
		<div class="p-2 bd-highlight">
			<button type="button" class="btn btn-outline-primary"
				onclick="location.href='ownerRegistration'">新規愛犬家登録</button>
		</div>
		<div class="p-2 bd-highlight">
			<button type="button" class="btn btn-primary"
				onclick="location.href='ownerLogin'">愛犬家ログイン</button>
		</div>
	</c:if>
</div>

