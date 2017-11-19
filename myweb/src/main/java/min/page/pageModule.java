package min.page;

public class pageModule {
	public static String makePage(String pagename, int totalCnt, int listSize, int pageSize, int cp) {

		StringBuffer sb = new StringBuffer();

		int totalPage = totalCnt / listSize + 1; // 전체 페이지 수 = 전체 게시물 수 / 보여줄 게시물 리스트 수 + 1
		if (totalCnt % listSize == 0) {
			totalPage--;
		}

		int userGroup = cp / pageSize; // 그룹수 = 사용자의 현재 위치 / 보여줄 페이지 수
		if (cp % pageSize == 0) { // 한 그룹의 마지막 페이지 수일때는 1을 빼줘서 맞춰줌
			userGroup--;
		}

		if (userGroup != 0) {
			sb.append("<a href='");
			sb.append(pagename);
			sb.append("?cp=");
			int temp = (userGroup - 1) * pageSize + pageSize;
			sb.append(temp);
			sb.append("'>&lt;&lt;</a>");
		}

		for (int i = (userGroup * pageSize + 1); i <= (userGroup * pageSize + pageSize); i++) {
			// 한 그룹의 시작 위치 한 그룹의 마지막 위치
			sb.append("&nbsp;&nbsp;<a href='");
			sb.append(pagename);
			sb.append("?cp=");
			sb.append(i);
			sb.append("'>");
			sb.append(i);
			sb.append("</a>&nbsp;&nbsp;");

			if (i == totalPage) {
				break;
			}
		}

		if (userGroup != (totalPage / pageSize - (totalPage % pageSize == 0 ? 1 : 0))) {
			sb.append("<a href='");
			sb.append(pagename);
			sb.append("?cp=");
			int temp = (userGroup + 1) * pageSize + 1;
			sb.append(temp);
			sb.append("'>&gt;&gt;</a>");
		}

		return sb.toString();
	}
}
