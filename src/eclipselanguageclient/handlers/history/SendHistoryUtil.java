package eclipselanguageclient.handlers.history;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.JsonObject;

import eclipselanguageclient.view.SendHistoryView;

public class SendHistoryUtil {
	private static List<SendHistoryData> sendHistory = new ArrayList<SendHistoryData>();
	private static SendHistoryView view;

	public static void addData(SendHistoryData data) {
		sendHistory.add(0, data);
		if (view != null) {
			view.update();
		}
	}

	public static void addResultToHistory(JsonObject result) {
		String resultMsg = makeResultMsg(result);
		SendHistoryData data = new SendHistoryData(new Date(), resultMsg);
		addData(data);
	}

	private static String makeResultMsg(JsonObject result) {
		String resultMsg;
		if (result == null) {
			resultMsg = "Failed to send";
		} else if (result.get("success").getAsBoolean()) {
			resultMsg = "Sent successfully";
		} else if (!result.get("success").getAsBoolean()) {
			// when failed, research failed reason
			JsonObject reason = result.get("reason").getAsJsonObject();
			if (reason.get("msg").getAsString().equals("No edit history")) {
				resultMsg = "No edit history";
			} else {
				resultMsg = "Failed to save. Reason: " + reason;
			}
		} else {
			resultMsg = "Failed to send";
		}

		return resultMsg;
	}

	public static List<SendHistoryData> getSendHistory() {
		return sendHistory;
	}

	public static String makeDisplayMsg(List<SendHistoryData> sendHistory) {
		String msg = "";
		for (SendHistoryData data : sendHistory) {
			msg += "[" + data.getDate() + "] " + data.getResultMsg() + "\n";
		}
		return msg;
	}

	public static String makeDisplayMsg(List<SendHistoryData> sendHistoryn, int displayNum) {
		String msg = "";
		int i = displayNum;
		for (SendHistoryData data : sendHistory) {
			i--;
			msg += "[" + data.getDate() + "] " + data.getResultMsg() + "\n";
			if (i <= 0)
				break;
		}
		return msg;
	}

	public static void setSendHistoryView(SendHistoryView _view) {
		view = _view;
	}
}
