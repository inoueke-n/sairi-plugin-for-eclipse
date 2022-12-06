package eclipselanguageclient.handlers.autsend;

import java.util.Timer;

import eclipselanguageclient.pluginconfigration.PluginConfigration;

public class AutomaticSendUtil {
	private static Timer timer = new Timer(true);
	private static AutomaticSendTask task = null;
	private static final int autSendPeriod = PluginConfigration.automaticSendPeriod;

	public static void start() {
		if (task == null) {
			task = new AutomaticSendTask();
			timer.schedule(task, 0, autSendPeriod);
		}
	}

	public static void stop() {
		if (task != null) {
			task.cancel();
			task = null;
		}
	}

	public static boolean isAlreadyScheculed() {
		if (task != null) {
			return true;
		} else {
			return false;
		}
	}
}
