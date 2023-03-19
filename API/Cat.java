package API;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class Cat {
    public static void main(String[] args) {

        try {
            URL Url = new URL("https://cataas.com/cat/gif");
            URLConnection conn = Url.openConnection();
            InputStream is = conn.getInputStream();

            File file = new File("/Users/sho/Downloads/cat.gif");
            FileOutputStream fos = new FileOutputStream(file);
            int len = 1024;
            byte[] buf = new byte[len];
            while ((len = is.read(buf, 0, len)) != -1) {
                System.out.println(len);
                fos.write(buf, 0, len);
            }
            fos.close();
            is.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String url = "/Users/sho/Downloads/cat.gif";
        Desktop desktop = Desktop.getDesktop();
        desktop.browseFileDirectory(new File(url));
    }
}
