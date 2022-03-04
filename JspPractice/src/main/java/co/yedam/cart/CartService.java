package co.yedam.cart;

import java.util.List;

public interface CartService {

	List<CartVO> selectCartList();

	List<CartVO> selectCart(CartVO vo);

	int insertCart(CartVO vo);

	int updateCart(CartVO vo);

	int deleteCart(CartVO vo);

}
