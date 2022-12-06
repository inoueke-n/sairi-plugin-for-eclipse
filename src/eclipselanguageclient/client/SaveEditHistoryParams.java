package eclipselanguageclient.client;

import org.eclipse.core.resources.ResourcesPlugin;

import eclipselanguageclient.pluginconfigration.PluginConfigration;

// contents of "sairi/saveEditHistory" Request
public class SaveEditHistoryParams {
	private String workspace;
	private EditorInfo editorInfo;
	private String sendTo; // "web" or "desktop"
	private String publicKey;
	private String uid;
	private String apiEndpoint;

	public SaveEditHistoryParams() {
		this.workspace = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
		this.editorInfo = new EditorInfo();
		this.sendTo = "web";
		this.publicKey = PluginConfigration.publicKey.replaceAll("/\\n/g", "\n");
		this.uid = PluginConfigration.uid;
		this.apiEndpoint = PluginConfigration.apiEndpoind;
	}

	private class EditorInfo {
		private String name;
		private String version;

		public EditorInfo() {
			name = PluginConfigration.editorName;
			version = PluginConfigration.appVersion;
		}
	}
}
