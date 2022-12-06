package eclipselanguageclient.view;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import eclipselanguageclient.pluginconfigration.PluginConfigration;

public class UserIdConfigrationView extends ViewPart {

	@Override
	public void createPartControl(Composite parent) {
		GridLayout layout = new GridLayout(2, false);
		parent.setLayout(layout);

		Label label = new Label(parent, SWT.NONE);
		label.setText("Sairi User ID");
		GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gridData.horizontalSpan = 2;
		label.setLayoutData(gridData);

		Label currentLabel = new Label(parent, SWT.NONE);
		currentLabel.setText("current: ");
		Label uidLabel = new Label(parent, SWT.NONE);
		uidLabel.setText(PluginConfigration.uid);

		Label newLabel = new Label(parent, SWT.NONE);
		newLabel.setText("new: ");
		Text newUidText = new Text(parent, SWT.BORDER);

		Button button = new Button(parent, SWT.NULL);
		button.setText("reflect uid change");
		button.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				String newUid = newUidText.getText();
				String msg;
				if (newUid.equals("")) {
					msg = "Invalid User ID";
				} else {
					msg = "Sairi User ID changed to '" + newUid + "'";
					newUidText.setText("");
					PluginConfigration.setUid(newUid);
					uidLabel.setText(PluginConfigration.uid);
				}
				Shell shell = Display.getDefault().getActiveShell();
				MessageDialog.openInformation(shell, "Sairi User ID Change", msg);
			}
		});
	}

	@Override
	public void setFocus() {
	}

}
