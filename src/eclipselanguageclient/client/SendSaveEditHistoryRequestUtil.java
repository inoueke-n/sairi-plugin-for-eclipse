package eclipselanguageclient.client;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.lsp4e.LanguageServersRegistry;
import org.eclipse.lsp4e.LanguageServersRegistry.LanguageServerDefinition;
import org.eclipse.lsp4e.LanguageServiceAccessor;

import com.google.gson.JsonObject;

public class SendSaveEditHistoryRequestUtil {
	private static final LanguageServerDefinition SAIRI_LS_DEFINITION = LanguageServersRegistry.getInstance()
			.getDefinition("eclipse-language-client.sairilanguageserver");

	public static JsonObject sendRequestAndGetResult() {
		// request "sairi/saveEditHistoru" and get Response
		SairiLanguageServerInterface ls = getSairiLanguageServer();
		if (ls != null) {
			try {
				JsonObject result = getSairiLanguageServer().saveEditHistory(new SaveEditHistoryParams()).get();
				return result;
			} catch (InterruptedException | java.util.concurrent.ExecutionException e) {
				// mainly when 'uid' or 'publicKey' or 'apiEndPoint' is not correct 
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}

	public static String getResultMessage(JsonObject result) {
		// create message based on result

		if (result == null) {
			return "'uid' or 'publicKey' or 'apiEndPoint' is invalid. Please check the extension configuration.";
		}

		if (result.get("success").getAsBoolean()) {
			return "sent successfully";
		} else if (!result.get("success").getAsBoolean()) {
			JsonObject reason = result.get("reason").getAsJsonObject();
			if (reason.get("msg").getAsString().equals("No edit history")) {
				return "No edit history";
			} else {
				return "Failed to save. Reason: " + reason;
			}
		} else {
			return "unknown error";
		}
	}

	private static SairiLanguageServerInterface getSairiLanguageServer() {
		List<SairiLanguageServerInterface> lsList = new ArrayList<SairiLanguageServerInterface>();

		// After getting active LanguageServers, apply a fileter to get only the SairiLanguageServer
		LanguageServiceAccessor.getActiveLanguageServers(null).stream().filter(
				server -> SAIRI_LS_DEFINITION.equals(LanguageServiceAccessor.resolveServerDefinition(server).get()))
				.forEach(ls -> lsList.add((SairiLanguageServerInterface) ls));

		if (lsList.size() == 0) {
			return null;
		} else {
			// sairiLanguageServer is singleton
			return lsList.get(0);
		}
	}
}
