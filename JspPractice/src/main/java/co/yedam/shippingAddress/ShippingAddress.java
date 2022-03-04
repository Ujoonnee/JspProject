package co.yedam.shippingAddress;

import java.util.List;

public interface ShippingAddress {

	public List<ShippingAddressVO> selectShippingAddressList();
	public List<ShippingAddressVO> selectShippingAddress(ShippingAddressVO vo);
	public int insertShippingAddress(ShippingAddressVO vo);
	public int deleteShippingAddress(ShippingAddressVO vo);
	public int updateShippingAddress(ShippingAddressVO vo);
	
	
}
