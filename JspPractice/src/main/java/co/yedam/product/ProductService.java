package co.yedam.product;

import java.util.List;

public interface ProductService {
	public List<ProductVO> selectProductList();
	public ProductVO selectProduct(ProductVO vo);
	public int insertProduct(ProductVO vo);
	public int updateProduct(ProductVO vo);
	public int updateProduct(String fileName,String fileRealName);
	public int deleteProduct(ProductVO vo);
	ProductVO searchImage(String thumbnail);
}
