package eclipselanguageclient.handlers.autsend;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.google.gson.JsonObject;

import eclipselanguageclient.client.SendSaveEditHistoryRequestUtil;
import eclipselanguageclient.handlers.history.SendHistoryUtil;

public class StopAutomaticSendHandler extends AbstractHandler {
	private static final String NOT_SCHEDULED = "Automatic send has not yet started";
	private static final String JUST_STOPPED = "Automatic send stopped";

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		if (AutomaticSendUtil.isAlreadyScheculed()) {
			AutomaticSendUtil.stop();
			// when stopping, send the last one
			JsonObject result = SendSaveEditHistoryRequestUtil.sendRequestAndGetResult();
			SendHistoryUtil.addResultToHistory(result);
			MessageDialog.openInformation(window.getShell(), "Stop Automatic Send", JUST_STOPPED);
		} else {
			MessageDialog.openInformation(window.getShell(), "Stop Automatic Send", NOT_SCHEDULED);
		}
		return null;
	}
}