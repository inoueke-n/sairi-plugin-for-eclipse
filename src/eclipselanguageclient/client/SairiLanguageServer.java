package eclipselanguageclient.client;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.lsp4e.server.ProcessStreamConnectionProvider;

import eclipselanguageclient.Activator;

public class SairiLanguageServer extends ProcessStreamConnectionProvider {
	public SairiLanguageServer() {
		/*
		 * Set a commnad by ProcessBuilder,
		 * and Start the SairiLanguageServer（languageserver.js) as a process
		 */
		List<String> commands = new ArrayList<>();
		//commands.add(getNodeJsLocation().getAbsolutePath());
		commands.add("node");
		try {
			URL serverFileUrl = getClass().getResource("/server/dist/languageserver.js");
			File serverFile = new File(FileLocator.toFileURL(serverFileUrl).getPath());
			commands.add(serverFile.getAbsolutePath());
			commands.add("--stdio");
			setCommands(commands);
			setWorkingDirectory(System.getProperty("user.dir"));
		} catch (IOException e) {
			Activator.getDefault().getLog().log(
					new Status(IStatus.ERROR, Activator.getDefault().getBundle().getSymbolicName(), e.getMessage(), e));
		}
	}

}
