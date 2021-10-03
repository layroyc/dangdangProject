<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${pageContext.request.contextPath }/front/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/front/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/front/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/front/css/shopping_vehicle.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javaScript">
			function updateCount(booKId){
				var count = $("#"+booKId).val();
				var r = /^\+?[1-9][0-9]*$/;
				if(r.test(count)){
					location.href="${pageContext.request.contextPath }/shop/update?id="+booKId+"&count="+count;
				}else{
					alert("请正确输入数量");
				}
			}
		</script>
	</head>
	<body>
		<br />
		<br />
		<div class="my_shopping">
			<img class="pic_shop" src="${pageContext.request.contextPath }/front/images/pic_myshopping.gif" />
		</div>
		
		<c:choose>
			<c:when test="${totalprice==0 || map==null}">
			<div id="div_no_choice">
				<div class="choice_title"></div>
				<div class="no_select">
					您还没有挑选商品[<a href='${pageContext.request.contextPath }/main/findAllC'> 继续挑选商品&gt;&gt;</a>]
				</div>
			</div>
			</c:when>
		<c:otherwise>
		<div id="div_choice" class="choice_merch">
			<h2 id="cart_tips">
				您已选购以下商品
			</h2>
			<div class="choice_bord">
				<table class="tabl_buy" id="tbCartItemsNormal">
					<tr class="tabl_buy_title">
						<td class="buy_td_6">
							<span>&nbsp;</span>
						</td>
						<td>
							<span class="span_w1">商品名</span>
						</td>
						<td class="buy_td_5">
							<span class="span_w2">市场价</span>
						</td>
						<td class="buy_td_4">
							<span class="span_w3">当当价</span>
						</td>
						<td class="buy_td_1">
							<span class="span_w2">数量</span>
						</td>
						<td class="buy_td_2">
							<span>变更数量</span>
						</td>
						<td class="buy_td_1">
							<span>删除</span>
						</td>
					</tr>
					<tr class='objhide' over="no">
						<td colspan="8">
							&nbsp;
						</td>
					</tr>
					
                      <!-- 购物列表开始 -->
                      <c:forEach items="${map}" var="s">
                      <c:if test="${s.value.stutas==1 }">
						<tr class='td_no_bord'>
							<td style='display: none'>
								9317290
							</td>
							<td class="buy_td_6">
								<span class="objhide"><img /> </span>
							</td>
							<td>
								<a href="#">${s.value.book_name}</a>
							</td>
							<td class="buy_td_5">
								<span class="c_gray">￥${s.value.original_price }</span>
							</td>
							<td class="buy_td_4">
								&nbsp;&nbsp;
								<span>￥${ s.value.discount_price}</span>
							</td>
							<td class="buy_td_1">
								&nbsp;&nbsp;${s.value.count}
							</td>

							<td >
								<input id="${s.key}" class="del_num" type="text" size="3" maxlength="4"/>
								<a href="#" onClick="updateCount('${s.key}')">变更</a>
							</td>
							<td>
								<a href="${pageContext.request.contextPath }/shop/delete?id=${s.key}">删除</a>
							</td>
						</tr>
						</c:if>
						</c:forEach>
					<!-- 购物列表结束 -->
				</table>

				<div class="choice_balance">
					<div class="select_merch">
						<a href='${pageContext.request.contextPath }/main/findAllC'> 继续挑选商品>></a>
					</div>
					<div class="total_balance">
						<div class="save_total">
							您共节省：
							<span class="c_red"> ￥<span id="total_economy">${saveprice}</span> </span>
							<span id='total_vip_economy' class='objhide'> 
								( 其中享有优惠： 
								<span class="c_red"> ￥<span id='span_vip_economy'>0.00</span> </span>
								) 
							</span>
							<span style="font-size: 14px">|</span>
							<span class="t_add">商品金额总计：</span>
							<span class="c_red_b"> ￥<span id='total_account'>${totalprice}</span>
							</span>
						</div>
						<div id="balance" class="balance">
							<a name='checkout' href='${pageContext.request.contextPath }/front/order/order_info.jsp' > 
								<img src="${pageContext.request.contextPath }/front/images/butt_balance.gif" alt="结算" border="0" title="结算" />
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		</c:otherwise>
		</c:choose>
		<!-- 用户删除恢复区 -->
		<div id="divCartItemsRemoved" class="del_merch">
			<div class="del_title">
				您已删除以下商品，如果想重新购买，请点击“恢复”
			</div>
			<table class=tabl_del id=del_table>
				<tbody>
				<c:forEach items="${map}" var="s">
                   <c:if test="${s.value.stutas==0 }">
					<tr>
						<td width="58" class=buy_td_6>
							&nbsp;
						</td>
						<td width="365" class=t2>
							<a href="#">${s.value.book_name}</a>
						</td>
						<td width="106" class=buy_td_5>
							￥${s.value.original_price }
						</td>
						<td width="134" class=buy_td_4>
							<span>￥${ s.value.discount_price}</span>
						</td>
						<td width="56" class=buy_td_1>
							<a href="${pageContext.request.contextPath }/shop/recover?id=${s.key}">恢复</a>
						</td>
						<td width="16" class=objhide>
							&nbsp;
						</td>
					</tr>
					<tr class=td_add_bord>
						<td colspan=8>
							&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
		</div>
			</c:if>
		</c:forEach>
		
		<!-- 用户删除恢复区结束 -->
		<br />
		<br />
		<br />
		<br />
		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>



