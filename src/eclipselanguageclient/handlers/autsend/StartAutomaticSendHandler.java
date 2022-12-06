package eclipselanguageclient.handlers.autsend;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

public class StartAutomaticSendHandler extends AbstractHandler {
	private static final String ALREADY_SCHEDULED = "Automatic send has already started";
	private static final String JUST_STARTED = "Automatic send started";

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		if (AutomaticSendUtil.isAlreadyScheculed()) {
			MessageDialog.openInformation(window.getShell(), "Start Automatic Send", ALREADY_SCHEDULED);
		} else {
			AutomaticSendUtil.start();
			MessageDialog.openInformation(window.getShell(), "Start Automatic Send", JUST_STARTED);
		}
		return null;
	}
}
