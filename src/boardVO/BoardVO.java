package boardVO;

/**
 * Board의 VO클래스
 * @author JayAl
 *
 */
public class BoardVO {

	private String bNo;
	private String bTitle;
	private String bWriter;
	private String bDate;
	private String bContent;

	public String getbNo() {
		return bNo;
	}

	public void setbNo(String bNo) {
		this.bNo = bNo;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbWriter() {
		return bWriter;
	}

	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}

	public String getbDate() {
		return bDate;
	}

	public void setbDate(String bDate) {
		this.bDate = bDate;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	@Override
	public String toString() {
		return String.format("BoardVO [bTitle=%s, bWriter=%s, bDate=%s, bContent=%s]", bTitle, bWriter, bDate,
				bContent);
	}


}
