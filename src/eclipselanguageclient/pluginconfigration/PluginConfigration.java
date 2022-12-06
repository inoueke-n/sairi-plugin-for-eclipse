package eclipselanguageclient.pluginconfigration;

public class PluginConfigration {
	// Setting usename
	public static String uid = "uid";
	// Setting API endpoint of sairi-backend
	public static final String apiEndpoind = "http://api-endpoint";
	// Setting public key for API endpoint
	public static final String publicKey = "public-key";
	// Setting automatic send period (millisecond)
	public static final int automaticSendPeriod = 60000;

	public static final String editorName = "eclipse";
	public static final String appVersion = "0.5.0";

	public static void setUid(String _uid) {
		uid = _uid;
	}
}
