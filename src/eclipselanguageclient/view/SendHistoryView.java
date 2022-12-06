package eclipselanguageclient.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

import eclipselanguageclient.handlers.history.SendHistoryUtil;

public class SendHistoryView extends ViewPart {
	private Label label;
	private Display display;

	@Override
	public void createPartControl(Composite parent) {
		this.display = Display.getCurrent();
		SendHistoryUtil.setSendHistoryView(this);

		ScrolledComposite scrollComposite = new ScrolledComposite(parent, SWT.V_SCROLL | SWT.H_SCROLL);
		Composite composite = new Composite(scrollComposite, SWT.NONE);
		composite.setLayout(null);

		this.label = new Label(composite, SWT.NONE);
		String msg = SendHistoryUtil.makeDisplayMsg(SendHistoryUtil.getSendHistory());
		this.label.setText(msg);
		this.label.setBounds(10, 10, 400, 400);

		scrollComposite.setExpandHorizontal(true);
		scrollComposite.setExpandVertical(true);
		scrollComposite.setContent(composite);
		scrollComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}

	@Override
	public void setFocus() {
	}

	public void update() {
		// cannot update label expect UI thread,
		// so leave updates to the UI thread
		display.asyncExec(new Runnable() {
			@Override
			public void run() {
				String msg = SendHistoryUtil.makeDisplayMsg(SendHistoryUtil.getSendHistory());
				label.setText(msg);
			}
		});

	}

}
