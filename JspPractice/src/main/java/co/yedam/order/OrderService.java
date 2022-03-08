package co.yedam.order;

import java.util.List;

public interface OrderService {
	public List<OrderVO> selectOrderList();
	public int insertOrder(OrderVO vo);
	public int deleteOrder(OrderVO vo);
	public int updateOrder(OrderVO vo);
	public List<OrderVO> selectOrder(String type, String text);
	public List<OrderVO> selectOrder(OrderVO vo);
}
