package co.yedam.order;

import java.util.List;

public interface OrderService {
	public List<OrderVO> selectOrderList();
	public List<OrderVO> selectOrder(OrderVO vo);
	public int insertOrder(OrderVO vo);
	public int deleteOrder(OrderVO vo);
	public int updateOrder(OrderVO vo);
}
