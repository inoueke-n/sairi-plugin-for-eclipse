package eclipselanguageclient.handlers.history;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

public class DisplayLatestTenSendHistoryHandler extends AbstractHandler {
	private static final int displayNum = 10;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		String msg = SendHistoryUtil.makeDisplayMsg(SendHistoryUtil.getSendHistory(), displayNum);
		MessageDialog.openInformation(window.getShell(), "Send History", msg);
		return null;
	}

}
