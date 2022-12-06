package eclipselanguageclient.handlers.history;

import java.util.Date;

public class SendHistoryData {
	private Date date;
	private String resultMsg;

	public SendHistoryData(Date date, String result) {
		this.date = date;
		this.resultMsg = result;
	}

	public Date getDate() {
		return this.date;
	}

	public String getResultMsg() {
		return this.resultMsg;
	}

}
