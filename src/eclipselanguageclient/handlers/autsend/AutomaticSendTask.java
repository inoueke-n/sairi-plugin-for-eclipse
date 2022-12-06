package eclipselanguageclient.handlers.autsend;

import java.util.TimerTask;

import com.google.gson.JsonObject;

import eclipselanguageclient.client.SendSaveEditHistoryRequestUtil;
import eclipselanguageclient.handlers.history.SendHistoryUtil;

public class AutomaticSendTask extends TimerTask {

	@Override
	public void run() {
		JsonObject result = SendSaveEditHistoryRequestUtil.sendRequestAndGetResult();
		SendHistoryUtil.addResultToHistory(result);
	}
}
