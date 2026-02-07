/* Nikola Kováčová 4800240012 */

import javax.swing.*;

public class KalkulackaLauncher {
    public static void main (String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new KalkulackaGUI().setVisible(true);
            }

        });

    }

}
