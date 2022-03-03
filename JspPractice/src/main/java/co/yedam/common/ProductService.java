
public interface ProductService {
	//FrontControl Product pages부분
	
	ProductVO productSelectAll(ProductVO vo);
	ProductVO productSelectOne(ProductVO vo);
	int insertNotice(ProductVO vo);
	int updateNotice(ProductVO vo);
	int deleteNotice(ProductVO vo);
}
