package eclipselanguageclient.client;

import java.util.concurrent.CompletableFuture;

import org.eclipse.lsp4j.jsonrpc.services.JsonRequest;
import org.eclipse.lsp4j.services.LanguageServer;

import com.google.gson.JsonObject;

public interface SairiLanguageServerInterface extends LanguageServer {

	// Send the "sairi/saveEditHistory" Request waited by the Sairi Language Server
	@JsonRequest("sairi/saveEditHistory")
	CompletableFuture<JsonObject> saveEditHistory(SaveEditHistoryParams params);
}
