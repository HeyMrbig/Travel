package min.bbs.model;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;

public class BbsDAOImple implements BbsDAO {

	private SqlSessionTemplate sqlMap;

	public BbsDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}

	public List<BbsDTO> bbsList(int cp, int ls) {
		int startnum = (cp - 1) * ls + 1;
		int endnum = cp * ls;
		Map<String, Integer> data = new HashMap<String, Integer>();
		data.put("startnum", startnum);
		data.put("endnum", endnum);
		List<BbsDTO> list = sqlMap.selectList("bbsList", data);
		return list;
	}

	public int bbsWrite(BbsDTO dto) {
		int maxRef = getMaxRef();
		dto.setRef(maxRef + 1);
		int result = sqlMap.insert("bbsWrite", dto);
		return result;
	}

	public BbsDTO bbsContent(int idx) {

		BbsDTO dto = null;
		try {
			dto = sqlMap.selectOne("bbsContent", idx);
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
		return dto;
	}

	public int getTotalCnt() {
		int count = sqlMap.selectOne("totalCnt");
		return count == 0 ? 1 : count;
	}

	public void updatesun(int ref, int sunbun) {
		Map map = new HashMap();
		map.put("ref", ref);
		map.put("sunbun", sunbun);
		sqlMap.update("updatesun", map);
	}

	public int bbsReWrite(BbsDTO dto) {
		updatesun(dto.getRef(), dto.getSunbun() + 1);
		int result = sqlMap.insert("bbsReWrite", dto);
		return result;
	}

	public int getMaxRef() {
		int result = 0;
		try {
			result = sqlMap.selectOne("maxRef");
		} catch (Exception e) {
			return 0;
			// TODO: handle exception
		}
		return result;
	}
}
