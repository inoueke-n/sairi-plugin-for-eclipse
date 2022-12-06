package eclipselanguageclient.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.google.gson.JsonObject;

import eclipselanguageclient.client.SendSaveEditHistoryRequestUtil;
import eclipselanguageclient.handlers.history.SendHistoryUtil;

public class SendSaveEditHistoryRequestHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		JsonObject result = SendSaveEditHistoryRequestUtil.sendRequestAndGetResult();
		SendHistoryUtil.addResultToHistory(result);
		String msg = SendSaveEditHistoryRequestUtil.getResultMessage(result);
		MessageDialog.openInformation(window.getShell(), "Manually Send", msg);
		return null;
	}
}
