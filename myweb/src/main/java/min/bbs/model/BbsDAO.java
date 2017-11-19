package min.bbs.model;

import java.util.*;

public interface BbsDAO {
	public List<BbsDTO> bbsList(int cp, int ls);
	public int bbsWrite(BbsDTO dto);
	public BbsDTO bbsContent(int idx);
	public int getTotalCnt();
	public void updatesun(int ref, int sunbun);
	public int bbsReWrite(BbsDTO dto);
	public int getMaxRef();
}
