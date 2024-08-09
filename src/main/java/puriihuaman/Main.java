package puriihuaman;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import views.Dashboard;

public class Main {
	public static void main(String[] args) {
		nimbusUi();

		JFrame dashboard = new Dashboard();
		dashboard.setVisible(true);
		dashboard.setLocationRelativeTo(null);
	}

	private static void nimbusUi() {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException |
						 IllegalAccessException | UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		}
	}
}